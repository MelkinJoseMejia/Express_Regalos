package com.claro.WSCRUDSerProductosServicio.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the SER_PRODUCTOS database table.
 * 
 */
@Entity
@Table(name="SER_PRODUCTOS")
@NamedQuery(name="SerProducto.findAll", query="SELECT s FROM SerProducto s")
public class SerProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PRODUCTO")
	private long idProducto;

	@Column(name="DESCRIPCION_PRODUCTO")
	private String descripcionProducto;

	@Lob
	@Column(name="IMAGEN_PRODUCTO")
	private byte[] imagenProducto;

	@Column(name="NOMBRE_PRODUCTO")
	private String nombreProducto;

	@Column(name="UNIDADES_DISPONIBLES")
	private BigDecimal unidadesDisponibles;

	//bi-directional many-to-one association to SerCategoria
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIA")
	private SerCategoria serCategoria;

	//bi-directional many-to-one association to SerSegmento
	@ManyToOne
	@JoinColumn(name="ID_SEGMENTO")
	private SerSegmento serSegmento;

	//bi-directional many-to-one association to SerRedencione
	@OneToMany(mappedBy="serProducto")
	private List<SerRedencione> serRedenciones;

	public SerProducto() {
	}

	public long getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcionProducto() {
		return this.descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public byte[] getImagenProducto() {
		return this.imagenProducto;
	}

	public void setImagenProducto(byte[] imagenProducto) {
		this.imagenProducto = imagenProducto;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public BigDecimal getUnidadesDisponibles() {
		return this.unidadesDisponibles;
	}

	public void setUnidadesDisponibles(BigDecimal unidadesDisponibles) {
		this.unidadesDisponibles = unidadesDisponibles;
	}

	public SerCategoria getSerCategoria() {
		return this.serCategoria;
	}

	public void setSerCategoria(SerCategoria serCategoria) {
		this.serCategoria = serCategoria;
	}

	public SerSegmento getSerSegmento() {
		return this.serSegmento;
	}

	public void setSerSegmento(SerSegmento serSegmento) {
		this.serSegmento = serSegmento;
	}

	public List<SerRedencione> getSerRedenciones() {
		return this.serRedenciones;
	}

	public void setSerRedenciones(List<SerRedencione> serRedenciones) {
		this.serRedenciones = serRedenciones;
	}

	public SerRedencione addSerRedencione(SerRedencione serRedencione) {
		getSerRedenciones().add(serRedencione);
		serRedencione.setSerProducto(this);

		return serRedencione;
	}

	public SerRedencione removeSerRedencione(SerRedencione serRedencione) {
		getSerRedenciones().remove(serRedencione);
		serRedencione.setSerProducto(null);

		return serRedencione;
	}
	@Override
	public String toString() {
		return "idProducto "+ idProducto + 
				"; descripcionProducto " + descripcionProducto+
				"; nombreProducto "+ nombreProducto;
	}

}