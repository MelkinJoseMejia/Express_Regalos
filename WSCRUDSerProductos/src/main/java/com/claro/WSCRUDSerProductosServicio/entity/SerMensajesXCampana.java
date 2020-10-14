package com.claro.WSCRUDSerProductosServicio.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the SER_MENSAJES_X_CAMPANA database table.
 * 
 */
@Entity
@Table(name="SER_MENSAJES_X_CAMPANA")
@NamedQuery(name="SerMensajesXCampana.findAll", query="SELECT s FROM SerMensajesXCampana s")
public class SerMensajesXCampana implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MENSAJES_X_CAMPANA")
	private long idMensajesXCampana;

	//bi-directional many-to-one association to SerCampana
	@ManyToOne
	@JoinColumn(name="ID_CAMPANA")
	private SerCampana serCampana;

	//bi-directional many-to-one association to SerMensaje
	@ManyToOne
	@JoinColumn(name="ID_MENSAJE")
	private SerMensaje serMensaje;

	public SerMensajesXCampana() {
	}

	public long getIdMensajesXCampana() {
		return this.idMensajesXCampana;
	}

	public void setIdMensajesXCampana(long idMensajesXCampana) {
		this.idMensajesXCampana = idMensajesXCampana;
	}

	public SerCampana getSerCampana() {
		return this.serCampana;
	}

	public void setSerCampana(SerCampana serCampana) {
		this.serCampana = serCampana;
	}

	public SerMensaje getSerMensaje() {
		return this.serMensaje;
	}

	public void setSerMensaje(SerMensaje serMensaje) {
		this.serMensaje = serMensaje;
	}

}
