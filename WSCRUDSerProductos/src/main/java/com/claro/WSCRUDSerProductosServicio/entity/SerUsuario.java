package com.claro.WSCRUDSerProductosServicio.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the SER_USUARIOS database table.
 * 
 */
@Entity
@Table(name="SER_USUARIOS")
@NamedQuery(name="SerUsuario.findAll", query="SELECT s FROM SerUsuario s")
public class SerUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	private long idUsuario;

	@Column(name="CEDULA_CLIENTE")
	private String cedulaCliente;

	@Column(name="CELULAR_CLIENTE")
	private BigDecimal celularCliente;

	@Column(name="CELULAR_EMPRESA")
	private BigDecimal celularEmpresa;

	@Column(name="DIRECCION_CLIENTE")
	private String direccionCliente;

	@Column(name="DIRECCION_ENTREGA")
	private String direccionEntrega;

	@Column(name="EMAIL_CLIENTE")
	private String emailCliente;

	private String nit;

	@Column(name="NOMBRE_CLIENTE")
	private String nombreCliente;

	@Column(name="NOMBRE_EMPRESA")
	private String nombreEmpresa;

	//bi-directional many-to-one association to SerAsesoresComercial
	@ManyToOne
	@JoinColumn(name="ID_ASESOR_COMERCIAL")
	private SerAsesoresComercial serAsesoresComercial;

	//bi-directional many-to-one association to SerSegmento
	@ManyToOne
	@JoinColumn(name="ID_SEGMENTO")
	private SerSegmento serSegmento;

	//bi-directional many-to-one association to SerUsuariosXCampana
	@OneToMany(mappedBy="serUsuario")
	private List<SerUsuariosXCampana> serUsuariosXCampanas;

	public SerUsuario() {
	}

	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCedulaCliente() {
		return this.cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public BigDecimal getCelularCliente() {
		return this.celularCliente;
	}

	public void setCelularCliente(BigDecimal celularCliente) {
		this.celularCliente = celularCliente;
	}

	public BigDecimal getCelularEmpresa() {
		return this.celularEmpresa;
	}

	public void setCelularEmpresa(BigDecimal celularEmpresa) {
		this.celularEmpresa = celularEmpresa;
	}

	public String getDireccionCliente() {
		return this.direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getDireccionEntrega() {
		return this.direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}

	public String getEmailCliente() {
		return this.emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public SerAsesoresComercial getSerAsesoresComercial() {
		return this.serAsesoresComercial;
	}

	public void setSerAsesoresComercial(SerAsesoresComercial serAsesoresComercial) {
		this.serAsesoresComercial = serAsesoresComercial;
	}

	public SerSegmento getSerSegmento() {
		return this.serSegmento;
	}

	public void setSerSegmento(SerSegmento serSegmento) {
		this.serSegmento = serSegmento;
	}

	public List<SerUsuariosXCampana> getSerUsuariosXCampanas() {
		return this.serUsuariosXCampanas;
	}

	public void setSerUsuariosXCampanas(List<SerUsuariosXCampana> serUsuariosXCampanas) {
		this.serUsuariosXCampanas = serUsuariosXCampanas;
	}

	public SerUsuariosXCampana addSerUsuariosXCampana(SerUsuariosXCampana serUsuariosXCampana) {
		getSerUsuariosXCampanas().add(serUsuariosXCampana);
		serUsuariosXCampana.setSerUsuario(this);

		return serUsuariosXCampana;
	}

	public SerUsuariosXCampana removeSerUsuariosXCampana(SerUsuariosXCampana serUsuariosXCampana) {
		getSerUsuariosXCampanas().remove(serUsuariosXCampana);
		serUsuariosXCampana.setSerUsuario(null);

		return serUsuariosXCampana;
	}

}