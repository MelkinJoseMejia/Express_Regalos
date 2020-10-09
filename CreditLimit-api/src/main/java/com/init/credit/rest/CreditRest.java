package com.init.credit.rest;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.credit.entitys.Limites;
import com.init.credit.entitys.Notificaciones;
import com.init.credit.entitys.Response;
import com.init.credit.entitys.Zonas;

@RestController
@RequestMapping(path = "/")
public class CreditRest {

	@GetMapping(path ="/zone" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<Zonas>> getZone(@RequestHeader Map<String, String> headers){
		Zonas zone;
		ArrayList<Zonas> zonas=new ArrayList<Zonas>();
		if(!headers.isEmpty()) {
			for (int i = 0; i < headers.size(); i++) { 
				System.out.println("Todos los headers :"+headers);
			}
			if(headers.containsKey("bad")) {
				HttpHeaders headersResponse = new HttpHeaders();
				headersResponse.add("Bienvenida", "Te invitamos a ingresar los datos correctos");
				return new ResponseEntity<>(zonas,HttpStatus.BAD_REQUEST);
			}
		}
		else {
			zonas.add(zone=new Zonas(1,"R1","60%","01/01/2020","ICM0683A")); 
			zonas.add(zone=new Zonas(1,"R2","70%","01/01/2020","ICM0683A"));
			zonas.add(zone=new Zonas(1,"R3","65%","01/01/2020","ICM0683A"));
			zonas.add(zone=new Zonas(1,"R4","78%","01/01/2020","ICM0683A"));
		}
		return ResponseEntity.ok(zonas);
	}

	@GetMapping(path ="/zone/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Zonas> getZoneByid(@RequestHeader Map<String, String> headers,@PathVariable Long id){
		Zonas zone;
		ArrayList<Zonas> zonas=new ArrayList<Zonas>();
		System.out.println("Ingresa a buscar zona por id");
		zonas.add(zone=new Zonas(1,"R1","60%","01/01/2020","ICM0683A")); 
		zonas.add(zone=new Zonas(1,"R2","70%","01/01/2020","ICM0683A"));
		zonas.add(zone=new Zonas(1,"R3","65%","01/01/2020","ICM0683A"));
		zonas.add(zone=new Zonas(1,"R4","78%","01/01/2020","ICM0683A"));
		zonas.stream()
		.filter(zona ->zona.getId() == id)
		.forEach(System.out::println);;
		
		if(!headers.isEmpty()) {
			for (int i = 0; i < headers.size(); i++) { 
				System.out.println("Todos los headers :"+headers);
			}
			if(headers.containsKey("bad")) {
				HttpHeaders headersResponse = new HttpHeaders();
				headersResponse.add("Bienvenida", "Te invitamos a ingresar los datos correctos");
				return new ResponseEntity<>(zone,HttpStatus.BAD_REQUEST);
			}
		}
		
		return ResponseEntity.ok(zone);
	}
	@PostMapping(path="/updateZone")
	public ResponseEntity<Response> updateZone(@RequestBody Zonas zone , 
			@RequestHeader Map<String, String> headers){
		Response resp=new Response();
		if(!headers.isEmpty()) {
			System.out.println(headers.values()); 
			if(headers.containsKey("bad")) {
				resp.setCodigo(-2);
				resp.setDescipcion("Error durante el procesamiento");
				return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
			}
			resp.setCodigo(0);
			resp.setDescipcion("Exitoso");
			return ResponseEntity.ok(resp);
		}
		resp.setCodigo(-1);
		resp.setDescipcion("Error General");
		return ResponseEntity.ok(resp);
	}

	@GetMapping(path ="/limit" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<Limites>> getLimit(@RequestHeader Map<String, String> headers){
		Limites limit= new Limites();
		ArrayList<Limites> limites=new ArrayList<Limites>();

		if(!headers.isEmpty()) {
			for (int i = 0; i < headers.size(); i++) { 
				System.out.println("Todos los headers :"+headers);
			}
			if(headers.containsKey("bad")) {
				HttpHeaders headersResponse = new HttpHeaders();
				headersResponse.add("Bienvenida", "Te invitamos a ingresar los datos correctos");
				return new ResponseEntity<>(limites,HttpStatus.BAD_REQUEST);
			}
			else {
				limites.add(new Limites("IML001",200000,"01/01/2020",0,"icm0683a"));
				limites.add(new Limites("IML002",250000,"01/01/2020",0,"icm0683a"));
				limites.add(new Limites("IML003",270000,"01/01/2020",0,"icm0683a"));
				limites.add(new Limites("IML004",280000,"01/01/2020",0,"icm0683a"));
			}
		}
		return ResponseEntity.ok(limites);
	}

	@PostMapping(path="/updateLimit")
	public ResponseEntity<Response> updateLimit(@RequestBody Limites limit , 
			@RequestHeader Map<String, String> headers){
		Response resp=new Response();
		if(!headers.isEmpty()) {
			System.out.println(headers.values()); 
			if(headers.containsKey("bad")) {
				resp.setCodigo(-2);
				resp.setDescipcion("Error durante el procesamiento");
				return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
			}
			resp.setCodigo(0);
			resp.setDescipcion("Exitoso");
			return ResponseEntity.ok(resp);
		}
		return ResponseEntity.ok(resp);
	}

	@GetMapping(path ="/notification" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<Notificaciones>> getNotification(@RequestHeader Map<String, String> headers){
		Notificaciones notification= new Notificaciones();
		ArrayList<Notificaciones> notifications=new ArrayList<Notificaciones>();
		if(!headers.isEmpty()) {
			for (int i = 0; i < headers.size(); i++) { 
				System.out.println("Todos los headers :"+headers);
			}
			if(headers.containsKey("bad")) {
				return new ResponseEntity<>(notifications,HttpStatus.BAD_REQUEST);
			}
			else {
				notifications.add(new Notificaciones(1,"50%","01/09/2020","ICM0683A"));
				notifications.add(new Notificaciones(1,"50%","01/09/2020","ICM0683A"));
				notifications.add(new Notificaciones(1,"50%","01/09/2020","ICM0683A"));
				notifications.add(new Notificaciones(1,"50%","01/09/2020","ICM0683A"));}
		}
		return ResponseEntity.ok(notifications);
	}
	@PostMapping(path="/updateNotification")
	public ResponseEntity<Response> updateNotification(@RequestBody Limites limit , 
			@RequestHeader Map<String, String> headers){
		Response resp=new Response();
		if(!headers.isEmpty()) {
			System.out.println(headers.values()); 
			if(headers.containsKey("bad")) {
				resp.setCodigo(-2);
				resp.setDescipcion("Error durante el procesamiento");
				return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
			}
			resp.setCodigo(0);
			resp.setDescipcion("Exitoso");
			return ResponseEntity.ok(resp);
		}
		return ResponseEntity.ok(resp);
	}


}
