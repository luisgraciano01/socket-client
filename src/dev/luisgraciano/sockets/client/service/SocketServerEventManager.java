package dev.luisgraciano.sockets.client.service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 * Esta clase gestiona los eventos que soportará para la gestión de respuestas
 * del servidor. <br/>
 * <br/>
 * Creado el 10-05-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
public class SocketServerEventManager {

	/**
	 * Variable Logger para crear mensajes para el seguimiento o registro de la
	 * ejecución de una aplicación.
	 */
	private static final Logger LOGGER = Logger.getLogger(SocketServerEventManager.class.getName());

	/**
	 * Conserva la única instancia existente de esta clase
	 */
	private static SocketServerEventManager instance;

	/**
	 * Eventos registrados. <br/>
	 * La clave del {@link Map} corresponde al nombre del evento.<br/>
	 * El valor del {@link Map} corresponde al método a ejecutar cuando el evento
	 * sea llamado.
	 */
	private final Map<String, Consumer<String>> events = new HashMap<>();

	/**
	 * Constructor privado para evitar creación de instancias desde otra clase
	 */
	private SocketServerEventManager() {
	}

	/**
	 * Obtiene la única instancia de {@link SocketServerEventManager}
	 * 
	 * @return Instancia de {@link SocketServerEventManager}
	 */
	public static SocketServerEventManager getInstance() {
		if (instance == null) {
			instance = new SocketServerEventManager();
		}

		return instance;
	}

	/**
	 * Agrega el evento a lista de eventos. <br/>
	 * 
	 * @param name   Nombre del evento agregar.
	 * @param method Método a ejecutar cuando el evento sea ejecutado. El método a
	 *               ejecutar debe recibir como único parámetro un {@link String}
	 *               que contendrá un Json
	 */
	public void addEvent(String name, Consumer<String> method) {
		if (this.events.get(name) == null) {
			this.events.put(name, method);
			LOGGER.info("An event with the name '" + name + "' has been added.");
		} else {
			LOGGER.info("An event with the name '" + name + "' already exists.");
		}
	}

	/**
	 * Elimina un evento de la lista de eventos.
	 * 
	 * @param name Nombre del evento a eliminar
	 */
	public void removeEvent(String name) {
		this.events.remove(name);
		LOGGER.info("Event '" + name + "' has been removed.");
	}

	/**
	 * Ejecuta un evento.
	 * 
	 * @param name Nombre del evento a ejecutar.
	 * @param json String con un Json que recibirá como parámetro el metódo a
	 *             ejecutar.
	 */
	public void callEvent(String name, String json) {
		if (this.events.get(name) == null) {
			LOGGER.severe("There is no event with the name '" + name + "'.");
		} else {
			LOGGER.info("Starting the execution of event '" + name + "' : " + json);
			this.events.get(name).accept(json);
			LOGGER.info("Event '" + name + "' has been executed.");
		}
	}
}
