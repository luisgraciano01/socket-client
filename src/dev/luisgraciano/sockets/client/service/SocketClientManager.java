package dev.luisgraciano.sockets.client.service;

import com.google.gson.Gson;

import dev.luisgraciano.sockets.client.model.RequestDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Clase que gestiona el cliente de un socket. <br/>
 * <br/>
 * Creado el 10-05-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
public class SocketClientManager {

	/**
	 * Conexión de socket actual.
	 */
	private Socket clientSocket;

	/**
	 * Stream de datos de salida.<br/>
	 * Se usará para enviar información al servidor.
	 */
	private PrintWriter out;

	/**
	 * Stream de datos de entrada.<br/>
	 * Se usará para recibir información del servidor.
	 */
	private BufferedReader in;

	/**
	 * Hilo asociado a la conexión de socket actual. <br/>
	 * Este hilo se encarga de leer las respuestas del servidor.
	 */
	private SocketSeverResponseThread socketClientThread;

	/**
	 * Incializa una conexión a un servidor socket.
	 * 
	 * @param ip   Dirección ip del servidor socket.
	 * @param port Puerto en el que se expone el servidor socket.
	 * @throws IOException En caso de que haya algún error al momento de abrir los
	 *                     Stream de datos.
	 */
	public void startConnection(String ip, int port) throws IOException {
		clientSocket = new Socket(ip, port);
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		socketClientThread = new SocketSeverResponseThread(in);
		socketClientThread.start();
	}

	/**
	 * Cierra la conexión con el servidor.
	 * 
	 * @throws IOException En caso de que haya algún error al momento de cerrar los
	 *                     Stream de datos.
	 */
	public void stopConnection() throws IOException {
		socketClientThread.interrupt();
		in.close();
		out.close();
		clientSocket.close();
	}

	/**
	 * Realiza el envío de una petición al servidor socket.
	 * 
	 * @param requestDto Datos de la petición a realizar.
	 */
	public void sendRequest(RequestDto requestDto) {
		Gson gson = new Gson();
		String mensaje = gson.toJson(requestDto);
		System.out.println("Enviando mensaje: " + mensaje);
		out.println(mensaje);
	}

}
