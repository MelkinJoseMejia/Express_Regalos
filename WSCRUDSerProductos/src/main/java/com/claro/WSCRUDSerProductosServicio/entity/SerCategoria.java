package com.claro.WSCRUDSerProductosServicio.entity;


import java.io.Serializable;
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
 * The persistent class for the SER_CATEGORIAS database table.
 * 
 */
@Entity
@Table(name="SER_CATEGORIAS")
@NamedQuery(name="SerCategoria.findAll", query="SELECT s FROM SerCategoria s")
public class SerCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CATEGORIA")
	private long idCategoria;

	@Column(name="DESCRIPCION_CATEGORIA")
	private String descripcionCategoria;

	@Column(name="NOMBRE_CATEGORIA")
	private String nombreCategoria;

	//bi-directional many-to-one association to SerCampana
	@ManyToOne
	@JoinColumn(name="ID_CAMPANA")
	private SerCampana serCampana;

	//bi-directional many-to-one association to SerProducto
	@OneToMany(mappedBy="serCategoria")
	private List<SerProducto> serProductos;

	public SerCategoria() {
	}

	public long getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcionCategoria() {
		return this.descripcionCategoria;
	}

	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}

	public String getNombreCategoria() {
		return this.nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public SerCampana getSerCampana() {
		return this.serCampana;
	}

	public void setSerCampana(SerCampana serCampana) {
		this.serCampana = serCampana;
	}

	public List<SerProducto> getSerProductos() {
		return this.serProductos;
	}

	public void setSerProductos(List<SerProducto> serProductos) {
		this.serProductos = serProductos;
	}

	public SerProducto addSerProducto(SerProducto serProducto) {
		getSerProductos().add(serProducto);
		serProducto.setSerCategoria(this);

		return serProducto;
	}

	public SerProducto removeSerProducto(SerProducto serProducto) {
		getSerProductos().remove(serProducto);
		serProducto.setSerCategoria(null);

		return serProducto;
	}

}
