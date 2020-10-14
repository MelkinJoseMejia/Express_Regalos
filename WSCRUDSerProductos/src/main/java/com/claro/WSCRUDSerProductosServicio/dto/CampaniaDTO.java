package com.claro.WSCRUDSerProductosServicio.dto;

import java.util.Date;
import java.util.List;

import com.claro.WSCRUDSerProductosServicio.entity.SerProducto;

public class CampaniaDTO {
	
	private String nombre;
	private Date fechaInicio;
	private Date fechaFinal;
	private List<SerProducto> listaProductos;
	
	public CampaniaDTO() {
		super();
	}
	
	public CampaniaDTO(String nombre, Date fechaInicio, Date fechaFinal, List<SerProducto> listaProductos) {
		super();
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.listaProductos = listaProductos;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public List<SerProducto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(List<SerProducto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	@Override
	public String toString() {
		return "nombre: "+ nombre+
				"; productos"+ listaProductos.toString();
	}

}
