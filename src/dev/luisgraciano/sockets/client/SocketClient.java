package dev.luisgraciano.sockets.client;

import java.io.IOException;

import dev.luisgraciano.sockets.client.model.RequestDto;
import dev.luisgraciano.sockets.client.service.SocketClientManager;

/**
 * Clase principal por donde iniciará la ejecución de la aplicación. <br/>
 * <br/>
 * Creado el 10-05-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
public class SocketClient {

	public static void main(String[] args) {
		try {
			SocketClientManager socketClientManager = new SocketClientManager();
			socketClientManager.startConnection("127.0.0.1", 5000);
			socketClientManager.sendRequest(new RequestDto("test"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
