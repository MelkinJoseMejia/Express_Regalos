package com.claro.WSCRUDSerAsesoresComercialServicio.servicio.ws.rest;

import java.util.List;
import java.util.Optional;

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

import com.claro.WSCRUDSerAsesoresComercialServicio.dto.Constantes;
import com.claro.WSCRUDSerAsesoresComercialServicio.dto.SerAsesoresComercial;
import com.claro.WSCRUDSerAsesoresComercialServicio.interfase.SerAsesoresComercialJpaRepository;
import com.claro.WSCRUDSerAsesoresComercialServicio.util.configuracion.Configurador;
import com.claro.WSCRUDSerAsesoresComercialServicio.util.configuracion.ParametrosIniciales;
import com.claro.WSCRUDSerAsesoresComercialServicio.util.configuracion.Propiedades;
import com.claro.WSCRUDSerAsesoresComercialServicio.util.configuracion.UtilsConstantes;

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
@RequestMapping(path = "/")
public class WSCRUDSerAsesoresComercialRest {

	@Autowired
	private SerAsesoresComercialJpaRepository serAsesoresComercialJpaRepository;
	
	ParametrosIniciales ini;
	
	static {
		Configurador.configurar(Constantes.RUTA_ARCHIVO_PROPIEDADES, UtilsConstantes.LOGGER_PRINCIPAL,
				Constantes.APLICACION);
	}

	private static Logger logger = LogManager.getLogger(UtilsConstantes.LOGGER_PRINCIPAL);
	private static Propiedades prop = Propiedades.getInstance();

	
	@GetMapping(path ="/consultar" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<SerAsesoresComercial>> consultar(@RequestParam(name = "UUID", required = false) Long UUID){
		ini = UUID == null ? Configurador.iniciarTransaccion() : Configurador.iniciarTransaccion(UUID);
		logger.info("--- INICIO TRANSACCION ---");
		logger.info("Se inicia consumo de Búsqueda de todos los registros ");
		try {
			List<SerAsesoresComercial> asesor  = serAsesoresComercialJpaRepository.findAll();
			return ResponseEntity.ok(asesor);
		}finally {
			logger.info("--- FIN DE TRANSACCION ---");
			Configurador.cerrarTransaccion(ini, logger);
		}
	}
	
	@GetMapping(path ="/consultarPorId" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<SerAsesoresComercial>> consultarPorId(@RequestParam (name = "id") Long id, @RequestParam(name = "UUID", required = false) Long UUID){
		ini = UUID == null ? Configurador.iniciarTransaccion() : Configurador.iniciarTransaccion(UUID);
		logger.info("--- INICIO TRANSACCION ---");
		logger.info("Se inicia consumo de consultarPorId ");
		try {
			Optional<SerAsesoresComercial> asesor = serAsesoresComercialJpaRepository.findById(id);
			if(asesor != null) {
				return ResponseEntity.ok(asesor);
			}else {
				return ResponseEntity.noContent().build();
			}
		}finally {
			logger.info("--- FIN DE TRANSACCION ---");
			Configurador.cerrarTransaccion(ini, logger);
		}
	}
	
	@PostMapping(path ="/guardar")
	public void guardar(@RequestBody SerAsesoresComercial asesor, @RequestHeader(name = "UUID", required = false) Long UUID) {
		ini = UUID == null ? Configurador.iniciarTransaccion() : Configurador.iniciarTransaccion(UUID);
		logger.info("--- INICIO TRANSACCION ---");
		logger.info("Se inicia consumo de inserción de segmento ");
		try {
			serAsesoresComercialJpaRepository.save(asesor);
		}finally {
			logger.info("--- FIN DE TRANSACCION ---");
			Configurador.cerrarTransaccion(ini, logger);
		}
	}
	
	@PostMapping(path ="/actualizar")
	public void update(@RequestBody SerAsesoresComercial asesor, @RequestHeader(name = "UUID", required = false) Long UUID) {
		ini = UUID == null ? Configurador.iniciarTransaccion() : Configurador.iniciarTransaccion(UUID);
		logger.info("--- INICIO TRANSACCION ---");
		logger.info("Se inicia consumo de ACTUALIZACION id:");
		try {
			serAsesoresComercialJpaRepository.save(asesor);
		}finally {
			logger.info("--- FIN DE TRANSACCION ---");
			Configurador.cerrarTransaccion(ini, logger);
		}
	}
	
	@DeleteMapping(path ="/borrar")
	public void borrar(@RequestParam (name = "idAsesor") Long idAsesor, @RequestHeader(name = "UUID", required = false) Long UUID) {
		ini = UUID == null ? Configurador.iniciarTransaccion() : Configurador.iniciarTransaccion(UUID);
		logger.info("Se inicia consumo de delete: ");
		try {
			serAsesoresComercialJpaRepository.deleteById(idAsesor);
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
