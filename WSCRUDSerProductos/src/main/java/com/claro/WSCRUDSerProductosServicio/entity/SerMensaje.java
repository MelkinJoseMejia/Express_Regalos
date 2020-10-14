package com.claro.WSCRUDSerProductosServicio.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
	@Column(name="ID_MENSAJE")
	private long idMensaje;

	private String asunto;

	private String cuerpo;

	@Column(name="TIPO_MENSAJE")
	private String tipoMensaje;

	//bi-directional many-to-one association to SerMensajesXCampana
	@OneToMany(mappedBy="serMensaje")
	private List<SerMensajesXCampana> serMensajesXCampanas;

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

	public List<SerMensajesXCampana> getSerMensajesXCampanas() {
		return this.serMensajesXCampanas;
	}

	public void setSerMensajesXCampanas(List<SerMensajesXCampana> serMensajesXCampanas) {
		this.serMensajesXCampanas = serMensajesXCampanas;
	}

	public SerMensajesXCampana addSerMensajesXCampana(SerMensajesXCampana serMensajesXCampana) {
		getSerMensajesXCampanas().add(serMensajesXCampana);
		serMensajesXCampana.setSerMensaje(this);

		return serMensajesXCampana;
	}

	public SerMensajesXCampana removeSerMensajesXCampana(SerMensajesXCampana serMensajesXCampana) {
		getSerMensajesXCampanas().remove(serMensajesXCampana);
		serMensajesXCampana.setSerMensaje(null);

		return serMensajesXCampana;
	}

}
