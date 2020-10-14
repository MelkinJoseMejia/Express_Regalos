package com.claro.WSCRUDSerProductosServicio.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.claro.WSCRUDSerProductosServicio.dto.CampaniaDTO;
import com.claro.WSCRUDSerProductosServicio.entity.SerProducto;
import com.claro.WSCRUDSerProductosServicio.entity.SerRedencione;
import com.claro.WSCRUDSerProductosServicio.entity.SerSegmento;
import com.claro.WSCRUDSerProductosServicio.entity.SerUsuario;

public class Mapeador {

	public static SerUsuario mapearAEmpresa(ResultSet rs) {
		SerUsuario empresa = null;
		try {
			empresa = new SerUsuario();
			empresa.setNit(rs.getString("NIT"));
			empresa.setNombreEmpresa(rs.getString("NOMBRE_EMPRESA"));
			empresa.setCelularCliente(rs.getBigDecimal("CELULAR_EMPRESA"));
			empresa.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
			empresa.setCedulaCliente(rs.getString("CEDULA_CLIENTE"));
			empresa.setEmailCliente(rs.getString("EMAIL_CLIENTE"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empresa;
	}

	public static CampaniaDTO mapearACampaniaDTO(ResultSet rs) {
		CampaniaDTO campaniaDTO = new CampaniaDTO();
		try {
			campaniaDTO.setNombre(rs.getString("NOMBRE_CAMPANA"));
			campaniaDTO.setFechaInicio(rs.getDate("FECHA_INICIO"));
			campaniaDTO.setFechaFinal(rs.getDate("FECHA_FINAL"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return campaniaDTO;
	}

	public static SerProducto mapearAProducto(ResultSet rs) {
		SerProducto producto = new SerProducto();
		try {
			SerSegmento segmento = new SerSegmento();
			segmento.setNombreSegmento(rs.getString("NOMBRE_SEGMENTO"));
			producto.setSerSegmento(segmento);
			
			producto.setNombreProducto(rs.getString("NOMBRE_PRODUCTO"));
			producto.setDescripcionProducto(rs.getString("DESCRIPCION_PRODUCTO"));
			producto.setUnidadesDisponibles(rs.getBigDecimal("UNIDADES_DISPONIBLES"));
			
			SerRedencione redencion = new SerRedencione();
			redencion.setNumeroUnidades(rs.getBigDecimal("CANTIDAD_REDIMIDA"));
			redencion.setFechaRedencion(rs.getDate("ULTIMA_FECHA_REDENCION"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto;
	}
}
