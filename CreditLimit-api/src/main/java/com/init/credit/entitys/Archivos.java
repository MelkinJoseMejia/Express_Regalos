package com.init.credit.entitys;

public class Archivos {
private String Nom_arch;
private String Peso_arch;
private String cant_reg;
private String Usuario_cargue;
private String estado;
private String descripcion;
private int id_archivo;
private int id_registro;
private int cant_process;
private DetalleArchivo detalle;

public String getNombre() {
	return Nom_arch;
}
public void setNombre(String nombre) {
	this.Nom_arch = nombre;
}
public String getPeso() {
	return Peso_arch;
}
public void setPeso(String peso) {
	this.Peso_arch = peso;
}
public String getTamaño() {
	return cant_reg;
}
public void setTamaño(String tamaño) {
	this.cant_reg = tamaño;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public DetalleArchivo getDetalle() {
	return detalle;
}
public void setDetalle(DetalleArchivo detalle) {
	this.detalle = detalle;
}
public String getUsuario() {
	return Usuario_cargue;
}
public void setUsuario(String usuario) {
	this.Usuario_cargue = usuario;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public int getId_archivo() {
	return id_archivo;
}
public void setId_archivo(int id_archivo) {
	this.id_archivo = id_archivo;
}
public int getId_registro() {
	return id_registro;
}
public void setId_registro(int id_registro) {
	this.id_registro = id_registro;
}
public int getCant_process() {
	return cant_process;
}
public void setCant_process(int cant_process) {
	this.cant_process = cant_process;
}
}
