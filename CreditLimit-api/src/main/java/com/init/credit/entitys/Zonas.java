package com.init.credit.entitys;

import java.util.Date;

public class Zonas {

	private int id;
	private String nombre;
	private String porcentage;
	private String fechaCambio;
	private String usuario;
	
	public Zonas(int id,String nombre,String porcentage, String fechaCambio,String usuario) {
		this.id=id;
		this.nombre=nombre;
		this.porcentage=porcentage;
		this.fechaCambio=fechaCambio;
		this.usuario=usuario;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPorcentage() {
		return porcentage;
	}
	public void setPorcentage(String porcentage) {
		this.porcentage = porcentage;
	}

	public String getFechaCambio() {
		return fechaCambio;
	}

	public void setFechaCambio(String fechaCambio) {
		this.fechaCambio = fechaCambio;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
