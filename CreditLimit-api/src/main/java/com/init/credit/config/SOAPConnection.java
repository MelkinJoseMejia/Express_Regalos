package com.init.credit.config;

import org.apache.axis.client.Stub;

import com.amx.www.Schema.admPerfilesEAF.V1_0.AdmPerfilesEAF;
import com.amx.www.Schema.admPerfilesEAF.V1_0.AdmPerfilesEAFProxy;

public class SOAPConnection<P, S> {

	
	
	public AdmPerfilesEAF connServiceAdmPerfilesEAF() {
		System.setProperty("http.proxyHost", "");
		System.setProperty("http.proxyPort", "");
		AdmPerfilesEAFProxy proxy = new AdmPerfilesEAFProxy(Constants.ENDPOINT_ADM_EAF);
		AdmPerfilesEAF service = proxy.getAdmPerfilesEAF();
		Stub stub = (Stub) service;
		stub.setTimeout(Integer.parseInt(Constants.TIME_OUT));
		return service;
	}
}
