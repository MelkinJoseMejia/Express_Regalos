package com.claro.WSCRUDSerAsesoresComercialServicio.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@SequenceGenerator(name = "SecuenciaAsesoresComercial", sequenceName = "ID_ASESOR_COMERCIAL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecuenciaAsesoresComercial")
	@Column(name="ID_ASESOR_COMERCIAL")
	private long idAsesorComercial;

	@Column(name="EMAIL_ASESOR")
	private String emailAsesor;

	@Column(name="NOMBRE_ASESOR")
	private String nombreAsesor;

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

}