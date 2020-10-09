package com.claro.WSCRUDSerMensajesXCampanaServicio.dto;

import java.io.Serializable;
import javax.persistence.*;


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
	@SequenceGenerator(name = "SecuenciaMensajes", sequenceName = "ID_MENSAJE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecuenciaMensajes")
	@Column(name="ID_MENSAJES_X_CAMPANA")
	private long idMensajesXCampana;
	
	@Column(name="ID_MENSAJE")
	private long idMensaje;
	
	@Column(name="ID_CAMPANA")
	private long idCampana;
/*
	//bi-directional many-to-one association to SerCampana
	@ManyToOne
	@JoinColumn(name="ID_CAMPANA")
	private SerCampana serCampana;

	//bi-directional many-to-one association to SerMensaje
	@ManyToOne
	@JoinColumn(name="ID_MENSAJE")
	private SerMensaje serMensaje;
*/
	public SerMensajesXCampana() {
	}

	public long getIdMensajesXCampana() {
		return this.idMensajesXCampana;
	}

	public void setIdMensajesXCampana(long idMensajesXCampana) {
		this.idMensajesXCampana = idMensajesXCampana;
	}

	public long getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(long idMensaje) {
		this.idMensaje = idMensaje;
	}

	public long getIdCampana() {
		return idCampana;
	}

	public void setIdCampana(long idCampana) {
		this.idCampana = idCampana;
	}
	
	
/*
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
*/
}