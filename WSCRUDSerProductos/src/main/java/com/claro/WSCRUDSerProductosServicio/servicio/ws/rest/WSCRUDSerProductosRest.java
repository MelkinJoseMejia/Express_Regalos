package com.claro.wscrudserproductosservicio.servicio.ws.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claro.wscrudserproductosservicio.dto.Constantes;
import com.claro.wscrudserproductosservicio.interfase.SerProductosJpaRepository;
import com.claro.wscrudserproductosservicio.util.configuracion.Configurador;
import com.claro.wscrudserproductosservicio.util.configuracion.ParametrosIniciales;
import com.claro.wscrudserproductosservicio.util.configuracion.Propiedades;
import com.claro.wscrudserproductosservicio.util.configuracion.UtilsConstantes;
import com.claro.wscrudserproductosservicio.dto.SerProductos;

/**
 * <b>Nombre: </b> WSAppRest </br>
 * <b>Descripci�n:</b> Clase que se encarga de desplegar el servicio REST </br>
 * <b>Fecha Creaci�n:</b> 01/10/2020 </br>
 * <b>Autor:</b> CINTE Melkin Jose Mejia </br>
 * <b>Fecha de �ltima Modificaci�n: </b></br>
 * <b>Modificado por: </b></br>
 * <b>Brief: XXXX</b></br>
 */

@RestController
@RequestMapping(path = "/mensajes")
public class WSCRUDSerProductosRest {

	@Autowired
	private SerProductosJpaRepository serProductosJpaRepository;
	
	ParametrosIniciales ini;
	
	static {
		Configurador.configurar(Constantes.RUTA_ARCHIVO_PROPIEDADES, UtilsConstantes.LOGGER_PRINCIPAL,
				Constantes.APLICACION);
	}

	private static Logger logger = LogManager.getLogger(UtilsConstantes.LOGGER_PRINCIPAL);
	private static Propiedades prop = Propiedades.getInstance();

	
	@GetMapping(path ="/consultar" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<SerProductos>> consultar(@RequestParam(name = "UUID", required = false) Long UUID){
		ini = UUID == null ? Configurador.iniciarTransaccion() : Configurador.iniciarTransaccion(UUID);
		logger.info("--- INICIO TRANSACCION ---");
		logger.info("Se inicia consumo de Búsqueda de todos los registros ");
		try {
			List<SerProductos> producto  = serProductosJpaRepository.findAll();
			return ResponseEntity.ok(producto);
		}finally {
			logger.info("--- FIN DE TRANSACCION ---");
			Configurador.cerrarTransaccion(ini, logger);
		}
	}
	
	@PostMapping(path ="/guardar")
	public void guardar(@RequestBody SerProductos producto, @RequestHeader(name = "UUID", required = false) Long UUID) {
		ini = UUID == null ? Configurador.iniciarTransaccion() : Configurador.iniciarTransaccion(UUID);
		logger.info("--- INICIO TRANSACCION ---");
		logger.info("Se inicia consumo de inserción de productos ");
		try {
			serProductosJpaRepository.save(producto);
		}finally {
			logger.info("--- FIN DE TRANSACCION ---");
			Configurador.cerrarTransaccion(ini, logger);
		}
	}
	
	@PostMapping(path ="/actualizar")
	public void update(@RequestBody SerProductos producto, @RequestHeader(name = "UUID", required = false) Long UUID) {
		ini = UUID == null ? Configurador.iniciarTransaccion() : Configurador.iniciarTransaccion(UUID);
		logger.info("--- INICIO TRANSACCION ---");
		logger.info("Se inicia consumo de ACTUALIZACION id:");
		try {
			serProductosJpaRepository.save(producto);
		}finally {
			logger.info("--- FIN DE TRANSACCION ---");
			Configurador.cerrarTransaccion(ini, logger);
		}
	}
	
	@DeleteMapping(path ="/borrar")
	public void borrar(@RequestParam (name = "idProducto") Long idProducto, @RequestHeader(name = "UUID", required = false) Long UUID) {
		ini = UUID == null ? Configurador.iniciarTransaccion() : Configurador.iniciarTransaccion(UUID);
		logger.info("Se inicia consumo de delete: ");
		try {
			serProductosJpaRepository.deleteById(idProducto);
		}finally {
			logger.info("--- FIN DE TRANSACCION ---");
			Configurador.cerrarTransaccion(ini, logger);
		}
	}
	
	@GetMapping(path ="/resetPropiedades" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> resetPropiedades() {
		logger.info("--- INICIO TRANSACCION ---");
		logger.info("Se inicia reinicio de propiedades");
		String respuesta = Configurador.resetPropiedades(Constantes.RUTA_ARCHIVO_PROPIEDADES, UtilsConstantes.LOGGER_PRINCIPAL,
				Constantes.APLICACION);
		logger.info("--- FIN DE TRANSACCION ---");
		return ResponseEntity.ok(respuesta);
	}

}
