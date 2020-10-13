package com.claro.wscrudserproductosservicio.dto;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;



/**
 * The persistent class for the SER_PRODUCTOS database table.
 * 
 */
@Entity
@Table(name="SER_PRODUCTOS")
@NamedQuery(name="SerProductos.findAll", query="SELECT s FROM SerProductos s")
public class SerProductos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SecuenciaSerProductos", sequenceName = "ID_PRODUCTO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecuenciaSerProductos")
	@Column(name="ID_PRODUCTO")   
	private Long idProducto;

	@Column(name="NOMBRE_PRODUCTO")
	private String nombreProducto;

	@Column(name="DESCRIPCION_PRODUCTO")
	private String descripcionProducto;
        
	@Column(name="IMAGEN_PRODUCTO")
	private Date imagenProducto;

	@Column(name="UNIDADES_DISPONIBLES")
	private Integer unidadesDisponibles;
        
	@Column(name="ID_CATEGORIA")
	private Long idCategoria;

	@Column(name="ID_SEGMENTO")
	private Long IdSegmento; 
        
	public SerProductos() {
	}

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Date getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(Date imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public Integer getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(Integer unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdSegmento() {
        return IdSegmento;
    }

    public void setIdSegmento(Long IdSegmento) {
        this.IdSegmento = IdSegmento;
    }

    
}