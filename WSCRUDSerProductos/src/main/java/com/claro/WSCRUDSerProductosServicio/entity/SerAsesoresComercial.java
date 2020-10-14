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
 * The persistent class for the SER_ASESORES_COMERCIAL database table.
 * 
 */
@Entity
@Table(name="SER_ASESORES_COMERCIAL")
@NamedQuery(name="SerAsesoresComercial.findAll", query="SELECT s FROM SerAsesoresComercial s")
public class SerAsesoresComercial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ASESOR_COMERCIAL")
	private long idAsesorComercial;

	@Column(name="EMAIL_ASESOR")
	private String emailAsesor;

	@Column(name="NOMBRE_ASESOR")
	private String nombreAsesor;

	//bi-directional many-to-one association to SerUsuario
	@OneToMany(mappedBy="serAsesoresComercial")
	private List<SerUsuario> serUsuarios;

	public SerAsesoresComercial() {
	}

	public long getIdAsesorComercial() {
		return this.idAsesorComercial;
	}

	public void setIdAsesorComercial(long idAsesorComercial) {
		this.idAsesorComercial = idAsesorComercial;
	}

	public String getEmailAsesor() {
		return this.emailAsesor;
	}

	public void setEmailAsesor(String emailAsesor) {
		this.emailAsesor = emailAsesor;
	}

	public String getNombreAsesor() {
		return this.nombreAsesor;
	}

	public void setNombreAsesor(String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}

	public List<SerUsuario> getSerUsuarios() {
		return this.serUsuarios;
	}

	public void setSerUsuarios(List<SerUsuario> serUsuarios) {
		this.serUsuarios = serUsuarios;
	}

	public SerUsuario addSerUsuario(SerUsuario serUsuario) {
		getSerUsuarios().add(serUsuario);
		serUsuario.setSerAsesoresComercial(this);

		return serUsuario;
	}

	public SerUsuario removeSerUsuario(SerUsuario serUsuario) {
		getSerUsuarios().remove(serUsuario);
		serUsuario.setSerAsesoresComercial(null);

		return serUsuario;
	}

}
