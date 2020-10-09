package com.init.credit.entitys;

import java.util.Date;

public class Notificaciones {
	private int id;
	private String porcentage;
	private String fechaCambio;
	private String usuario;
	
	public Notificaciones(int id,String porcentage, String fechaCambio,String usuario) {
		this.id=id;
		this.porcentage=porcentage;
		this.fechaCambio=fechaCambio;
		this.usuario=usuario;
	}
	
	public Notificaciones() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
