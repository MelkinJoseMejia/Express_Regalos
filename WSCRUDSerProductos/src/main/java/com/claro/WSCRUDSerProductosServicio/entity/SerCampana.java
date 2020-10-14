package com.claro.WSCRUDSerProductosServicio.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the SER_CAMPANAS database table.
 * 
 */
@Entity
@Table(name="SER_CAMPANAS")
@NamedQuery(name="SerCampana.findAll", query="SELECT s FROM SerCampana s")
public class SerCampana implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CAMPANA")
	private long idCampana;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_FINAL")
	private Date fechaFinal;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_INICIO")
	private Date fechaInicio;

	@Column(name="NOMBRE_CAMPANA")
	private String nombreCampana;

	//bi-directional many-to-one association to SerCategoria
	@OneToMany(mappedBy="serCampana")
	private List<SerCategoria> serCategorias;

	//bi-directional many-to-one association to SerMensajesXCampana
	@OneToMany(mappedBy="serCampana")
	private List<SerMensajesXCampana> serMensajesXCampanas;

	//bi-directional many-to-one association to SerUsuariosXCampana
	@OneToMany(mappedBy="serCampana")
	private List<SerUsuariosXCampana> serUsuariosXCampanas;

	public SerCampana() {
	}

	public long getIdCampana() {
		return this.idCampana;
	}

	public void setIdCampana(long idCampana) {
		this.idCampana = idCampana;
	}

	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getNombreCampana() {
		return this.nombreCampana;
	}

	public void setNombreCampana(String nombreCampana) {
		this.nombreCampana = nombreCampana;
	}

	public List<SerCategoria> getSerCategorias() {
		return this.serCategorias;
	}

	public void setSerCategorias(List<SerCategoria> serCategorias) {
		this.serCategorias = serCategorias;
	}

	public SerCategoria addSerCategoria(SerCategoria serCategoria) {
		getSerCategorias().add(serCategoria);
		serCategoria.setSerCampana(this);

		return serCategoria;
	}

	public SerCategoria removeSerCategoria(SerCategoria serCategoria) {
		getSerCategorias().remove(serCategoria);
		serCategoria.setSerCampana(null);

		return serCategoria;
	}

	public List<SerMensajesXCampana> getSerMensajesXCampanas() {
		return this.serMensajesXCampanas;
	}

	public void setSerMensajesXCampanas(List<SerMensajesXCampana> serMensajesXCampanas) {
		this.serMensajesXCampanas = serMensajesXCampanas;
	}

	public SerMensajesXCampana addSerMensajesXCampana(SerMensajesXCampana serMensajesXCampana) {
		getSerMensajesXCampanas().add(serMensajesXCampana);
		serMensajesXCampana.setSerCampana(this);

		return serMensajesXCampana;
	}

	public SerMensajesXCampana removeSerMensajesXCampana(SerMensajesXCampana serMensajesXCampana) {
		getSerMensajesXCampanas().remove(serMensajesXCampana);
		serMensajesXCampana.setSerCampana(null);

		return serMensajesXCampana;
	}

	public List<SerUsuariosXCampana> getSerUsuariosXCampanas() {
		return this.serUsuariosXCampanas;
	}

	public void setSerUsuariosXCampanas(List<SerUsuariosXCampana> serUsuariosXCampanas) {
		this.serUsuariosXCampanas = serUsuariosXCampanas;
	}

	public SerUsuariosXCampana addSerUsuariosXCampana(SerUsuariosXCampana serUsuariosXCampana) {
		getSerUsuariosXCampanas().add(serUsuariosXCampana);
		serUsuariosXCampana.setSerCampana(this);

		return serUsuariosXCampana;
	}

	public SerUsuariosXCampana removeSerUsuariosXCampana(SerUsuariosXCampana serUsuariosXCampana) {
		getSerUsuariosXCampanas().remove(serUsuariosXCampana);
		serUsuariosXCampana.setSerCampana(null);

		return serUsuariosXCampana;
	}

}
