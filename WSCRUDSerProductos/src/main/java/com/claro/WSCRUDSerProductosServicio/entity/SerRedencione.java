package com.claro.WSCRUDSerProductosServicio.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the SER_REDENCIONES database table.
 * 
 */
@Entity
@Table(name="SER_REDENCIONES")
@NamedQuery(name="SerRedencione.findAll", query="SELECT s FROM SerRedencione s")
public class SerRedencione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_REDENCION")
	private long idRedencion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_REDENCION")
	private Date fechaRedencion;

	@Column(name="NUMERO_UNIDADES")
	private BigDecimal numeroUnidades;

	//bi-directional many-to-one association to SerProducto
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO")
	private SerProducto serProducto;

	//bi-directional many-to-one association to SerUsuariosXCampana
	@ManyToOne
	@JoinColumn(name="ID_USUARIO_X_CAMPANA")
	private SerUsuariosXCampana serUsuariosXCampana;

	public SerRedencione() {
	}

	public long getIdRedencion() {
		return this.idRedencion;
	}

	public void setIdRedencion(long idRedencion) {
		this.idRedencion = idRedencion;
	}

	public Date getFechaRedencion() {
		return this.fechaRedencion;
	}

	public void setFechaRedencion(Date fechaRedencion) {
		this.fechaRedencion = fechaRedencion;
	}

	public BigDecimal getNumeroUnidades() {
		return this.numeroUnidades;
	}

	public void setNumeroUnidades(BigDecimal numeroUnidades) {
		this.numeroUnidades = numeroUnidades;
	}

	public SerProducto getSerProducto() {
		return this.serProducto;
	}

	public void setSerProducto(SerProducto serProducto) {
		this.serProducto = serProducto;
	}

	public SerUsuariosXCampana getSerUsuariosXCampana() {
		return this.serUsuariosXCampana;
	}

	public void setSerUsuariosXCampana(SerUsuariosXCampana serUsuariosXCampana) {
		this.serUsuariosXCampana = serUsuariosXCampana;
	}

}
