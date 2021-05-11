package dev.luisgraciano.sockets.client.model;

import java.io.Serializable;

/**
 * Definición de una respuesta base por parte del servidor hacia el
 * cliente.<br/>
 * <b>NOTA:</b> Extender está clase en caso de necesitar más propiedades. <br/>
 * <br/>
 * Creado el 10-05-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
public class ResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Nombre del evento a enviar al cliente.
	 */
	private String event;

	/**
	 * Determina si el proceso fue exitoso o no: <br/>
	 * <b>true</b> el proceso fue exitoso. <br/>
	 * <b>false</b> el proceso no fue exitoso. <br/>
	 */
	private boolean success;

	/**
	 * Mensaje declarativo que se le dese enviar al cliente.
	 */
	private String message;

	/**
	 * Retorna el valor de la propiedad <b>event</b><br/>
	 * <br/>
	 * Creado el 11-05-2021
	 *
	 * @return {@link String}, con el valor de la propiedad <b>event</b>
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * Asigna un valor a la propiedad <b>event</b><br/>
	 * <br/>
	 * Creado el 11-05-2021
	 *
	 * @param event Un valor de tipo {@link String} a asignar a la propiedad
	 *              <b>event</b>
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * Retorna el valor de la propiedad <b>success</b><br/>
	 * <br/>
	 * Creado el 10-05-2021
	 *
	 * @return {@link boolean}, con el valor de la propiedad <b>success</b>
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Asigna un valor a la propiedad <b>success</b><br/>
	 * <br/>
	 * Creado el 10-05-2021
	 *
	 * @param success Un valor de tipo {@link boolean} a asignar a la propiedad
	 *                <b>success</b>
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * Retorna el valor de la propiedad <b>message</b><br/>
	 * <br/>
	 * Creado el 10-05-2021
	 *
	 * @return {@link String}, con el valor de la propiedad <b>message</b>
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Asigna un valor a la propiedad <b>message</b><br/>
	 * <br/>
	 * Creado el 10-05-2021
	 *
	 * @param message Un valor de tipo {@link String} a asignar a la propiedad
	 *                <b>message</b>
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
