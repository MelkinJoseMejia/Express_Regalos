package com.claro.WSCRUDSerMensajesServicio.dto;

/**
 * <b>Nombre: </b> Constantes </br>
 * <b>Descripci�n:</b> Clase que almacena todas las constantes de la aplicaci�n
 * </br>
 * <b>Fecha Creaci�n:</b> 22/02/2018 </br>
 * <b>Autor:</b> HITSS Nombre Ingeniero </br>
 * <b>Fecha de �ltima Modificaci�n: 08/09/2020</b></br>
 * <b>Modificado por: Melkin Jose Mejia</b></br>
 * <b>Brief: XXXX</b></br>
 */

public class Constantes {

	// Configuraci�n inicial
	//public static final String RUTA_ARCHIVO_PROPIEDADES = "/PropertiesAppWL/" + "WSApp/WSAppPlantilla.properties";
	//public static final String RUTA_ARCHIVO_PROPIEDADES = "C:/Users/administrador-pc/Documents/EAPworkspace/WSUtils/properties/WSAppPlantilla.properties";
	//public static final String RUTA_ARCHIVO_PROPIEDADES = "/applications/config/Oper/CO_Claro_EnterOper_EAP_Domain_PR/WSPlantillaEAF/WSAppPlantilla.properties";
	//public static final String RUTA_ARCHIVO_PROPIEDADES = "/applications/config/Oper/CO_Claro_FulFillOper_EAP_Domain_PR/WSPlantillaEAF/WSAppPlantilla.properties";
	public static final String RUTA_ARCHIVO_PROPIEDADES = "/Properties/WSCRUDSerMensajes/WSCRUDSerMensajes.properties";
	//public static final String RUTA_ARCHIVO_PROPIEDADES = "/Properties/WSPlantillaEAF/WSAppPlantilla.properties";
	public static final String APLICACION = "WSCRUDSerMensajes";

	// Bandera para autenticacion de usuarios
	public static final String FLAG_AUTH = "app.flag.auth";
	public static final String AUTENTICAR = "1";

	// Bases de datos
	public static final String BD1 = "app.conexion.BD1";
	public static final String TIPO_CON_BD1 = "app.tipo.conexion.BD1";

	// Consultas base de datos
	public static final String TIME_OUT = "app.sql.time.out";
	public static final String SQL_UNO = "app.sql.pl1";
	public static final String SQL_DOS = "app.sql.pl2";
	public static final String CONSULTA_UNO = "app.sql.consulta1";
	
	// Consultas servicios web
	public static final String TIME_OUT_WS1 = "app.timeout.ws.ws1";

	// Excepciones
	public static final String EXCEPTION = "app.exception.";
	public static final String _000 = "000";
	public static final String _100 = "100";
	public static final String _101 = "101";
	public static final String _102 = "102";

	// Respuestas
	public static final String CODIGO = "app.cod.";
	public static final String DESCRIPCION = "app.des.";
	public static final String MENSAJE = "app.msj.";

	public static final String PROCESO_EXITOSO = "001";
	public static final String PROCESO_EXITOSO_DOS = "002";
	public static final String ERROR_VALIDACION_3 = "100";
	public static final String ERROR_PARAMETROS_INCOMPLETOS = "900";
	public static final String ERROR_NEGOCIO = "901";
	public static final String ERROR_INESPERADO = "999";
	public static final String ERROR_AUTENTICACION = "1000";

	// Otros
	public static final String VALOR_SERVICIO = "app.valor.servicio";
	public static final String DIAS_VIGENCIA = "app.dias.vigencia";

	public static final String USSD = "USSD";
	public static final String SMS = "SMS";
}
