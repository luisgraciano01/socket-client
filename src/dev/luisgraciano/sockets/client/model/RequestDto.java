package dev.luisgraciano.sockets.client.model;

import java.io.Serializable;

/**
 * Definición de una petición base por parte del cliente hacia el servidor.<br/>
 * <b>NOTA:</b> Extender está clase en caso de necesitar más propiedades. <br/>
 * <br/>
 * Creado el 10-05-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
public class RequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Nombre del evento asociado a la petición.
	 */
	private final String event;

	/**
	 * Incializa la respuesta con el nombre del evento.
	 * 
	 * @param event Nombre del evento asociado a esta petición.
	 */
	public RequestDto(String event) {
		this.event = event;
	}

	/**
	 * Retorna el valor de la propiedad {@link RequestDto#event}<br/>
	 * <br/>
	 * Creado el 10-05-2021
	 *
	 * @return {@link String}, con el valor de la propiedad {@link RequestDto#event}
	 */
	public String getEvent() {
		return event;
	}

}
