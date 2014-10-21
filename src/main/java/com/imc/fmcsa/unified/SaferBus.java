package com.imc.fmcsa.unified;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Web Service interface for SaferBus API.
 * 
 * We are using both JAX-RS and JAX-WS annotations here. This interface will be
 * used to expose the private SOAP endpoint and consume the public REST endpoint
 * 
 * @author David Murphy
 * 
 */
@WebService
public interface SaferBus {

	@GET
	@Path("/carriers/{carrierName}")
	@Produces("application/xml")
	@Consumes("application/xml")
	public String queryByName(
			@WebParam(name = "carrierName") @PathParam("carrierName") String carrierName,
			@WebParam(name = "options") @QueryParam("") QueryParameters queryParameters);

	@GET
	@Path("/carrier/{dotnumber}")
	@Produces("application/xml")
	@Consumes("application/xml")
	public String queryByDotNumber(
			@WebParam(name = "dotnumber") @PathParam("dotnumber") String dotnumber,
			@WebParam(name = "options") @QueryParam("") QueryParameters queryParameters);

	@GET
	@Path("/carrier/{mcnumber}/mc")
	@Produces("application/xml")
	@Consumes("application/xml")
	public String queryByMcNumber(
			@WebParam(name = "mcnumber") @PathParam("mcnumber") String mcnumber,
			@WebParam(name = "options") @QueryParam("") QueryParameters queryParameters);

	@GET
	@Path("/carriers/zipcode/{zipcode}")
	@Produces("application/xml")
	@Consumes("application/xml")
	public String queryByZipcode(
			@WebParam(name = "zipcode") @PathParam("zipcode") String zipcode,
			@WebParam(name = "options") @QueryParam("") QueryParameters queryParameters);

	@GET
	@Path("/carriers/state/{statecode}")
	@Produces("application/xml")
	@Consumes("application/xml")
	public String queryByState(
			@WebParam(name = "statecode") @PathParam("statecode") String statecode,
			@WebParam(name = "options") @QueryParam("") QueryParameters queryParameters);

	@GET
	@Path("/carriers/not_allowed_to_operate")
	@Produces("application/xml")
	@Consumes("application/xml")
	public String notAllowedToOperate(
			@WebParam(name = "options") @QueryParam("") QueryParameters queryParameters);

	public static class QueryParameters {
		private Integer start;

		private Integer size;

		private String carrierType;

		public QueryParameters() {
			this(null, null, null);
		}

		public QueryParameters(Integer start, Integer size, String carrierType) {
			super();
			this.start = start;
			this.size = size;
			this.carrierType = carrierType;
		}

		public Integer getStart() {
			return start;
		}

		public void setStart(Integer start) {
			this.start = start;
		}

		public Integer getSize() {
			return size;
		}

		public void setSize(Integer size) {
			this.size = size;
		}

		public String getCarrierType() {
			return carrierType;
		}

		public void setCarrierType(String carrierType) {
			this.carrierType = carrierType;
		}

	}

}
