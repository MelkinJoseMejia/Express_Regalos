package com.init.credit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amx.www.Schema.ConsultaPantalla.V1_0.PrcConsultaPantallaRequest;
import com.amx.www.Schema.ConsultaPantalla.V1_0.PrcConsultaPantallaResponse;
import com.amx.www.Schema.admPantallasEAF.V1_0.AdmPantallasRequest;
import com.amx.www.Schema.admParametrosEAF.V1_0.AdmParametrosRequest;
import com.amx.www.Schema.admParametrosEAF.V1_0.AdmParametrosResponse;
import com.amx.www.Schema.admPerfilesEAF.V1_0.AdmPerfilesEAF;
import com.init.credit.config.Constants;
import com.init.credit.config.SOAPConnection;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class AccessRest {

	private SOAPConnection soapConnection;
	
	public AccessRest() {
		this.soapConnection = new SOAPConnection();
	}
	
	@PostMapping("/access/consultScreens")
    public ResponseEntity<PrcConsultaPantallaResponse> loginAdmProfiles(@RequestParam("user") String user, 
    											   @RequestParam("siteId") String siteId ){
		AdmPerfilesEAF service = soapConnection.connServiceAdmPerfilesEAF();
		PrcConsultaPantallaRequest request = new PrcConsultaPantallaRequest(user, siteId, Constants.EMPTY); 
		PrcConsultaPantallaResponse response = null;
		try {
			response = service.consultaPantallaEAF(request);
		} catch (Exception e) {
			ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
}
