package com.claro.wscrudserusuariosservicio.servicio.ws.rest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.multipart.MultipartFile;

import com.claro.wscrudserusuariosservicio.dto.Constantes;
import com.claro.wscrudserusuariosservicio.dto.SerUsuarios;
import com.claro.wscrudserusuariosservicio.interfase.SerUsuariosJpaRepository;
import com.claro.wscrudserusuariosservicio.service.UsuarioService;
import com.claro.wscrudserusuariosservicio.util.configuracion.Configurador;
import com.claro.wscrudserusuariosservicio.util.configuracion.ParametrosIniciales;
import com.claro.wscrudserusuariosservicio.util.configuracion.Propiedades;
import com.claro.wscrudserusuariosservicio.util.configuracion.UtilsConstantes;
import com.claro.wscrudserusuariosservicio.utils.ExcelHelper;

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
@RequestMapping(path = "/usuario")
public class WSCRUDSerUsuariosRest {

	
	
	
	ParametrosIniciales ini;
	
	static {
		Configurador.configurar(Constantes.RUTA_ARCHIVO_PROPIEDADES, UtilsConstantes.LOGGER_PRINCIPAL,
				Constantes.APLICACION);
	}

	private static Logger logger = LogManager.getLogger(UtilsConstantes.LOGGER_PRINCIPAL);
	private static Propiedades prop = Propiedades.getInstance();
	
	private final UsuarioService usuarioService;
	
	@Autowired
	private SerUsuariosJpaRepository serUsuariosJpaRepository;
	
	
	public WSCRUDSerUsuariosRest(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping(path ="/consultar" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<SerUsuarios>> consultar(@RequestParam(name = "UUID", required = false) Long UUID){
		ini = UUID == null ? Configurador.iniciarTransaccion() : Configurador.iniciarTransaccion(UUID);
		logger.info("--- INICIO TRANSACCION ---");
		logger.info("Se inicia consumo de Búsqueda de todos los registros ");
		try {
			List<SerUsuarios> usuario  = serUsuariosJpaRepository.findAll();
			return ResponseEntity.ok(usuario);
		}finally {
			logger.info("--- FIN DE TRANSACCION ---");
			Configurador.cerrarTransaccion(ini, logger);
		}
	}
	
	@PostMapping(path ="/guardar")
	public void guardar(@RequestBody SerUsuarios usuario, @RequestHeader(name = "UUID", required = false) Long UUID) {
		ini = UUID == null ? Configurador.iniciarTransaccion() : Configurador.iniciarTransaccion(UUID);
		logger.info("--- INICIO TRANSACCION ---");
		logger.info("Se inicia consumo de inserción de segmento ");
		try {
			serUsuariosJpaRepository.save(usuario);
		}finally {
			logger.info("--- FIN DE TRANSACCION ---");
			Configurador.cerrarTransaccion(ini, logger);
		}
	}
	
	@PostMapping(path ="/actualizar")
	public void update(@RequestBody SerUsuarios usuario, @RequestHeader(name = "UUID", required = false) Long UUID) {
		ini = UUID == null ? Configurador.iniciarTransaccion() : Configurador.iniciarTransaccion(UUID);
		logger.info("--- INICIO TRANSACCION ---");
		logger.info("Se inicia consumo de ACTUALIZACION id:");
		try {
			serUsuariosJpaRepository.save(usuario);
		}finally {
			logger.info("--- FIN DE TRANSACCION ---");
			Configurador.cerrarTransaccion(ini, logger);
		}
	}
	
	@DeleteMapping(path ="/borrar")
	public void borrar(@RequestParam (name = "idUsuario") Long idUsuario, @RequestHeader(name = "UUID", required = false) Long UUID) {
		ini = UUID == null ? Configurador.iniciarTransaccion() : Configurador.iniciarTransaccion(UUID);
		logger.info("Se inicia consumo de delete: ");
		try {
			serUsuariosJpaRepository.deleteById(idUsuario);
		}finally {
			logger.info("--- FIN DE TRANSACCION ---");
			Configurador.cerrarTransaccion(ini, logger);
		}
	}
	
	
	@PostMapping("cargarUsuarios")
	public ResponseEntity<Resource> cargarUsuarios(@RequestParam("file") MultipartFile file) {
		logger.info("REST request para cargarUsuarios");

		if (!ExcelHelper.hasExcelFormat(file)) {
			throw new RuntimeException("No se pudo realizar el cargue del archivo excel: Please upload an excel file!\"");
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload an excel file!");
		}
		InputStreamResource fileDownload = null;
		try {
			ExcelHelper excelHelper = new ExcelHelper();
			excelHelper.loadFileExcel(file.getInputStream(), Constantes.NOMBRE_HOJA_EXCEL_CARGUE_USUARIOS, 1);
			Iterator<Row> rows = excelHelper.getRows();
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				String infoUsuario = excelHelper.obtenerfilaArchivo(currentRow, null);
				if(infoUsuario.equals("")) {
					break;
				}
				String result = usuarioService.cargarUsuario(infoUsuario);
		        String[] rtaInsercion = result.split("--", 2); 
		        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>"+infoUsuario);
		        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>"+result);
		        
		        excelHelper.escribirCelda(currentRow, 14, result);
		        ByteArrayInputStream in = excelHelper.getFile();
		        fileDownload = new InputStreamResource(in);
		        
		        
			}
			excelHelper.closeFileExcel();
			
		} catch (IOException e) {
			throw new RuntimeException("No se pudo realizar el cargue del archivo excel: " + e.getMessage());
		}

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+Constantes.NOMBRE_ARCHIVO_DESCARGA_CARGUE_USUARIOS )
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(fileDownload);
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
