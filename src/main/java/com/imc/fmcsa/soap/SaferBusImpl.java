package com.imc.fmcsa.soap;

import javax.jws.WebService;

import com.imc.fmcsa.unified.SaferBus;

/**
 * Web Service Implementation for SaferBus API
 * 
 * @author David Murphy
 * 
 */
// This impl is totally empty, as we are using camel to handle the routing. See
// service-routes.xml
@WebService(endpointInterface = "com.imc.fmcsa.unified.SaferBus")
public class SaferBusImpl implements SaferBus {

	@Override
	public String queryByName(String carrierName,
			QueryParameters queryParameters) {
		// dummy impl. processing handled by camel
		return null;
	}

	@Override
	public String queryByDotNumber(String dotnumber,
			QueryParameters queryParameters) {
		// dummy impl. processing handled by camel
		return null;
	}

	@Override
	public String queryByMcNumber(String mcnumber,
			QueryParameters queryParameters) {
		// dummy impl. processing handled by camel
		return null;
	}

	@Override
	public String queryByZipcode(String zipcode, QueryParameters queryParameters) {
		// dummy impl. processing handled by camel
		return null;
	}

	@Override
	public String queryByState(String statecode, QueryParameters queryParameters) {
		// dummy impl. processing handled by camel
		return null;
	}

	@Override
	public String notAllowedToOperate(QueryParameters queryParameters) {
		// dummy impl. processing handled by camel
		return null;
	}

}
