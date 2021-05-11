package dev.luisgraciano.sockets.client.service;

import com.google.gson.Gson;

import dev.luisgraciano.sockets.client.model.ResponseDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase se encarga de escuhar todas las respuestas del servidor socket a
 * partir de un Stream. <br/>
 * <br/>
 * Creado el 11-05-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
public class SocketSeverResponseThread extends Thread {

	/**
	 * Variable Logger para crear mensajes para el seguimiento o registro de la
	 * ejecución de una aplicación.
	 */
	private static final Logger LOGGER = Logger.getLogger(SocketSeverResponseThread.class.getName());

	/**
	 * Stream de datos de entrada.<br/>
	 * Se usará para recibir información del servidor.
	 */
	private final BufferedReader in;

	/**
	 * Inicializa esta clase con el stream de datos a usar.
	 * 
	 * @param in Stream de datos de respuesta del servidor.
	 */
	public SocketSeverResponseThread(BufferedReader in) {
		super();
		this.in = in;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		String inputLine;
		try {
			Gson gson = new Gson();
			while ((inputLine = in.readLine()) != null) {
				ResponseDto responseDto = gson.fromJson(inputLine, ResponseDto.class);
				SocketServerEventManager.getInstance().callEvent(responseDto.getEvent(), inputLine);
			}
		} catch (IOException ioException) {
			LOGGER.log(Level.SEVERE, "An error occurred while reading responses from the server.", ioException);
		}
	}

}
