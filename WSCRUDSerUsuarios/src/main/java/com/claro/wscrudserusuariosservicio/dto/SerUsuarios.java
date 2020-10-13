package com.claro.wscrudserusuariosservicio.dto;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SER_USUARIOS database table.
 *
 */
@Entity
@Table(name = "SER_USUARIOS")
@NamedQuery(name = "SerUsuarios.findAll", query = "SELECT s FROM SerUsuarios s")
public class SerUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SecuenciaSerUsuarios", sequenceName = "ID_USUARIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecuenciaSerUsuarios")
    @Column(name = "ID_USUARIO")
    private long idUsuario;

    @Column(name = "NIT")
    private String nit;

    @Column(name = "NOMBRE_EMPRESA")
    private String nombreEmpresa;

    @Column(name = "CELULAR_EMPRESA")
    private long celularEmpresa;

    @Column(name = "NOMBRE_CLIENTE")
    private String nombreCliente;

    @Column(name = "CEDULA_CLIENTE")
    private String cedulaCliente;

    @Column(name = "EMAIL_CLIENTE")
    private String emailCliente;

    @Column(name = "CELULAR_CLIENTE")
    private long celularCliente;

    @Column(name = "DIRECCION_CLIENTE")
    private String direccionCliente;

    @Column(name = "DIRECCION_ENTREGA")
    private String direccionEntrega;

    @Column(name = "ID_ASESOR_COMERCIAL")
    private long idAsesorComercial;

    @Column(name = "ID_SEGMENTO")
    private long idSegmento;

    public SerUsuarios() {
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public long getCelularEmpresa() {
        return celularEmpresa;
    }

    public void setCelularEmpresa(long celularEmpresa) {
        this.celularEmpresa = celularEmpresa;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public long getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(long celularCliente) {
        this.celularCliente = celularCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public long getIdAsesorComercial() {
        return idAsesorComercial;
    }

    public void setIdAsesorComercial(long idAsesorComercial) {
        this.idAsesorComercial = idAsesorComercial;
    }

    public long getIdSegmento() {
        return idSegmento;
    }

    public void setIdSegmento(long idSegmento) {
        this.idSegmento = idSegmento;
    }

}
