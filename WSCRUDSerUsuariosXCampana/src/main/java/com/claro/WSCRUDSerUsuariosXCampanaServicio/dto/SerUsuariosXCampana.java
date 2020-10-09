package com.claro.WSCRUDSerUsuariosXCampanaServicio.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SER_USUARIOS_X_CAMPANA database table.
 * 
 */
@Entity
@Table(name="SER_USUARIOS_X_CAMPANA")
@NamedQuery(name="SerUsuariosXCampana.findAll", query="SELECT s FROM SerUsuariosXCampana s")
public class SerUsuariosXCampana implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SecuenciaUsuariosXCampana", sequenceName = "ID_USUARIOS_X_CAMPANA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecuenciaUsuariosXCampana")
	@Column(name="ID_USUARIOS_X_CAMPANA")
	private long idUsuariosXCampana;

	@Column(name="URL")
	private String url;
	
	@Column(name="ID_CAMPANA")
	private long idCampana;
	
	@Column(name="ID_USUARIO")
	private long idUsuario;
	
/*
	//bi-directional many-to-one association to SerRedencione
	@OneToMany(mappedBy="serUsuariosXCampana")
	private List<SerRedencione> serRedenciones;

	//bi-directional many-to-one association to SerCampana
	@ManyToOne
	@JoinColumn(name="ID_CAMPANA")
	@Column(name="ID_CAMPANA")
	private SerCampana serCampana;

	//bi-directional many-to-one association to SerUsuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private SerUsuario serUsuario;
*/
	public SerUsuariosXCampana() {
	}

	public long getIdUsuariosXCampana() {
		return this.idUsuariosXCampana;
	}

	public void setIdUsuariosXCampana(long idUsuariosXCampana) {
		this.idUsuariosXCampana = idUsuariosXCampana;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getIdCampana() {
		return idCampana;
	}

	public void setIdCampana(long idCampana) {
		this.idCampana = idCampana;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	

/*	public List<SerRedencione> getSerRedenciones() {
		return this.serRedenciones;
	}

	public void setSerRedenciones(List<SerRedencione> serRedenciones) {
		this.serRedenciones = serRedenciones;
	}

	public SerRedencione addSerRedencione(SerRedencione serRedencione) {
		getSerRedenciones().add(serRedencione);
		serRedencione.setSerUsuariosXCampana(this);

		return serRedencione;
	}

	public SerRedencione removeSerRedencione(SerRedencione serRedencione) {
		getSerRedenciones().remove(serRedencione);
		serRedencione.setSerUsuariosXCampana(null);

		return serRedencione;
	}

	public SerCampana getSerCampana() {
		return this.serCampana;
	}

	public void setSerCampana(SerCampana serCampana) {
		this.serCampana = serCampana;
	}

	public SerUsuario getSerUsuario() {
		return this.serUsuario;
	}

	public void setSerUsuario(SerUsuario serUsuario) {
		this.serUsuario = serUsuario;
	}
*/
}