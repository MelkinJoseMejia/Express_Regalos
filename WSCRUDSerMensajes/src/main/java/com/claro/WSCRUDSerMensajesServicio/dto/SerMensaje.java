package com.claro.WSCRUDSerMensajesServicio.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the SER_MENSAJES database table.
 * 
 */
@Entity
@Table(name="SER_MENSAJES")
@NamedQuery(name="SerMensaje.findAll", query="SELECT s FROM SerMensaje s")
public class SerMensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SecuenciaMensajes", sequenceName = "ID_MENSAJE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecuenciaMensajes")
	@Column(name="ID_MENSAJE")
	private long idMensaje;

	private String asunto;

	private String cuerpo;

	@Column(name="TIPO_MENSAJE")
	private String tipoMensaje;

	public SerMensaje() {
	}

	public long getIdMensaje() {
		return this.idMensaje;
	}

	public void setIdMensaje(long idMensaje) {
		this.idMensaje = idMensaje;
	}

	public String getAsunto() {
		return this.asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getCuerpo() {
		return this.cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public String getTipoMensaje() {
		return this.tipoMensaje;
	}

	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}

}