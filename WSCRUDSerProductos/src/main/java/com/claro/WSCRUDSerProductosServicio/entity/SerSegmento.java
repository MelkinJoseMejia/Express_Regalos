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
 * The persistent class for the SER_SEGMENTOS database table.
 * 
 */
@Entity
@Table(name="SER_SEGMENTOS")
@NamedQuery(name="SerSegmento.findAll", query="SELECT s FROM SerSegmento s")
public class SerSegmento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_SEGMENTO")
	private long idSegmento;

	@Column(name="NOMBRE_SEGMENTO")
	private String nombreSegmento;

	//bi-directional many-to-one association to SerProducto
	@OneToMany(mappedBy="serSegmento")
	private List<SerProducto> serProductos;

	//bi-directional many-to-one association to SerUsuario
	@OneToMany(mappedBy="serSegmento")
	private List<SerUsuario> serUsuarios;

	public SerSegmento() {
	}

	public long getIdSegmento() {
		return this.idSegmento;
	}

	public void setIdSegmento(long idSegmento) {
		this.idSegmento = idSegmento;
	}

	public String getNombreSegmento() {
		return this.nombreSegmento;
	}

	public void setNombreSegmento(String nombreSegmento) {
		this.nombreSegmento = nombreSegmento;
	}

	public List<SerProducto> getSerProductos() {
		return this.serProductos;
	}

	public void setSerProductos(List<SerProducto> serProductos) {
		this.serProductos = serProductos;
	}

	public SerProducto addSerProducto(SerProducto serProducto) {
		getSerProductos().add(serProducto);
		serProducto.setSerSegmento(this);

		return serProducto;
	}

	public SerProducto removeSerProducto(SerProducto serProducto) {
		getSerProductos().remove(serProducto);
		serProducto.setSerSegmento(null);

		return serProducto;
	}

	public List<SerUsuario> getSerUsuarios() {
		return this.serUsuarios;
	}

	public void setSerUsuarios(List<SerUsuario> serUsuarios) {
		this.serUsuarios = serUsuarios;
	}

	public SerUsuario addSerUsuario(SerUsuario serUsuario) {
		getSerUsuarios().add(serUsuario);
		serUsuario.setSerSegmento(this);

		return serUsuario;
	}

	public SerUsuario removeSerUsuario(SerUsuario serUsuario) {
		getSerUsuarios().remove(serUsuario);
		serUsuario.setSerSegmento(null);

		return serUsuario;
	}

}
