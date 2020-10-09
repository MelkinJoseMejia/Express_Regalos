package com.init.credit.entitys;

import java.util.Date;

public class Limites {
	private String enlace;
	private double limite;
	private String fechaCambio;
	private double valorAnterior;
	private String usuario;
	public Limites() {}
	
	public Limites(String enlace,double limite,String fechaCambio,double valorAnterior,String usuario) {
		this.enlace=enlace;
		this.limite=limite;
		this.fechaCambio=fechaCambio;
		this.valorAnterior=valorAnterior;
		this.usuario=usuario;
		
	}
	public String getEnlace() {
		return enlace;
	}
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	public String getFechaCambio() {
		return fechaCambio;
	}
	public void setFechaCambio(String fechaCambio) {
		this.fechaCambio = fechaCambio;
	}
	public double getValorAnterior() {
		return valorAnterior;
	}
	public void setValorAnterior(double valorAnterior) {
		this.valorAnterior = valorAnterior;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
