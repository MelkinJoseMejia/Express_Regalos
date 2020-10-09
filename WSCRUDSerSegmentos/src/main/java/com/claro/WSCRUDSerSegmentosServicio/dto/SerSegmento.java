package com.claro.WSCRUDSerSegmentosServicio.dto;

import java.io.Serializable;
import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;


/**
 * The persistent class for the SER_SEGMENTOS database table.
 * 
 */
@Entity
@Table(name="SER_SEGMENTOS")
public class SerSegmento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SecuenciaSegmentos", sequenceName = "ID_SEGMENTO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecuenciaSegmentos")
	@Column(name="ID_SEGMENTO")
	@ApiModelProperty(notes = "Identificador unico de la tabla")
	private long idSegmento;

	@Column(name="NOMBRE_SEGMENTO")
	@ApiModelProperty(notes = "Nombre dado al  segmento ")
	private String nombreSegmento;
/*
	//bi-directional many-to-one association to SerProducto
	@OneToMany(mappedBy="serSegmento")
	private List<SerProducto> serProductos;

	//bi-directional many-to-one association to SerUsuario
	@OneToMany(mappedBy="serSegmento")
	private List<SerUsuario> serUsuarios;*/

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
/*
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
*/
}