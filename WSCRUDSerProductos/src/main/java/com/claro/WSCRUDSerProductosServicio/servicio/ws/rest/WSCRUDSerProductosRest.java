package com.claro.WSCRUDSerProductosServicio.servicio.ws.rest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.claro.WSCRUDSerProductosServicio.dto.Constantes;
import com.claro.WSCRUDSerProductosServicio.dto.ProductoDTO;
import com.claro.WSCRUDSerProductosServicio.dto.SerProductos;
import com.claro.WSCRUDSerProductosServicio.interfase.SerProductosJpaRepository;
import com.claro.WSCRUDSerProductosServicio.service.ProductoService;
import com.claro.WSCRUDSerProductosServicio.util.configuracion.Configurador;
import com.claro.WSCRUDSerProductosServicio.util.configuracion.ParametrosIniciales;
import com.claro.WSCRUDSerProductosServicio.util.configuracion.Propiedades;
import com.claro.WSCRUDSerProductosServicio.util.configuracion.UtilsConstantes;
import com.claro.WSCRUDSerProductosServicio.utils.ExcelHelper;

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
@RequestMapping(path = "/productos")
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
	private final ProductoService productoService;
	
	public WSCRUDSerProductosRest(ProductoService productoService) {
		this.productoService = productoService;
	}
	
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
	
	@GetMapping(value ="/consultarProductosXUsuario/{objetivoConsulta}")
	public ResponseEntity<List<ProductoDTO>> consultarProductosXUsuario(@PathVariable (value = "objetivoConsulta") String objetivoConsulta,
			@RequestParam (value = "nit", required = false) String nit,
			@RequestParam (value = "nombreCampania", required = false) String nombreCampania) {

		logger.info("REST request para consultarProductosPorUsuario: " + nit + " nombreCampania: "
				+ nombreCampania + " objetivoConsulta: " + objetivoConsulta);
		List<ProductoDTO> result = this.productoService.consultarProductosPorEmpresa(nit, nombreCampania,objetivoConsulta);

		return ResponseEntity.ok(result);
	}
	
	
	@GetMapping("/redimirProducto/{nit}/{nombreProducto}")
	public ResponseEntity<String> redimirProducto(@PathVariable(required = true, name = "nit") String nit,
			@PathVariable(required = true, name = "nombreProducto") String nombreProducto,
			@RequestParam(required = false, name = "cantidadRedimir") Integer cantidadRedimir,
			@RequestParam(required = false, name = "fechaRedencion") Date fechaRedencion) {
		logger.info("REST request para redimirProducto" + nit, nombreProducto, cantidadRedimir, fechaRedencion);
		String result = this.productoService.redimirProducto(nit, nombreProducto, cantidadRedimir, fechaRedencion);

		return ResponseEntity.ok(result);
	}
	
	
	@PostMapping("cargarProductos")
	public ResponseEntity<Resource> cargarProductos(@RequestParam("file") MultipartFile file) {
		logger.info("REST request para cargarProductos");

		if (!ExcelHelper.hasExcelFormat(file)) {
			throw new RuntimeException("No se pudo realizar el cargue del archivo excel: Please upload an excel file!\"");
		}
		InputStreamResource fileDownload = null;
		try {
			ExcelHelper excelHelper = new ExcelHelper();
			excelHelper.loadFileExcel(file.getInputStream(), Constantes.NOMBRE_HOJA_EXCEL_CARGUE_PRODUCTOS, 1);
			Iterator<Row> rows = excelHelper.getRows();
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				String cadenaTexto = excelHelper.obtenerfilaArchivo(currentRow, 5);
				if(cadenaTexto.equals("")) {
					break;
				}
				String img = excelHelper.obtenerValorCelda(currentRow, 5);
				String result = productoService.cargarProducto(cadenaTexto, img);
				logger.info(">>>>>>>>>>>>>>>>>>>>>>>> "+cadenaTexto+" - "+img);
		        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>"+result);
		        
		        excelHelper.escribirCelda(currentRow, 7, result);
		        ByteArrayInputStream in = excelHelper.getFile();
		        fileDownload = new InputStreamResource(in);
			}
			excelHelper.closeFileExcel();
			
		} catch (IOException e) {
			throw new RuntimeException("No se pudo realizar el cargue del archivo excel: " + e.getMessage());
		}

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+Constantes.NOMBRE_ARCHIVO_DESCARGA_RESULTADO_CARGUE_PR )
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
