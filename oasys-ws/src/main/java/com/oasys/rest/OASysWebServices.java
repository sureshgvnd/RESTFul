package com.oasys.rest;


import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.oasys.bo.OratalAdmin;
import com.oasys.bo.impl.OratalAdminImpl;
import com.oasys.model.JSONRequest;

@Path("/")

public class OASysWebServices {

	OratalAdmin _orTalAdminBO =  null;


	private static Logger logger = Logger.getLogger("OASysWebServices.class");

	@Path("/SpPolicyCommSchedDataData/{key}")
	/*@Path("/SpPolicyCommSchedDataData")*/
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SpPolicyCommSchedData(@PathParam("key") String _compPolKey) throws SQLException {
	/*public Response SpPolicyCommSchedData(JSONRequest _req) throws SQLException {*/


		logger.info("SpPolicyCommSchedData : _compPolKey " + _compPolKey);
		_orTalAdminBO = new OratalAdminImpl();
		String output =  _orTalAdminBO.SpPolicyCommSchedData(_compPolKey).toString();

		logger.info("_orTalAdminBO.SpPolicyCommSchedData(_req.get_compPolKey()).toString() : value " + output.length());

		return Response.status(200).entity(output).build();
	}

	@Path("/PolicyRiderFundData/{key}")
	/*@Path("/PolicyRiderFundData")*/
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SpPolicyRiderFundData(@PathParam("key") String _compPolKey) throws SQLException {
	/*public Response SpPolicyRiderFundData(JSONRequest _req) throws SQLException {*/


		logger.info("SpPolicyRiderFundData : _compPolKey " + _compPolKey);

		_orTalAdminBO = new OratalAdminImpl();
		String output =  _orTalAdminBO.SpPolicyRiderFundData(_compPolKey).toString();

		logger.info("_orTalAdminBO.SpPolicyRiderFundData(_req.get_compPolKey()).toString() : value " + output.length());

		return Response.status(200).entity(output).build();
	}


	@Path("/AgentProductData/{key}")
	/*@Path("/AgentProductData")*/
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SpAgentProductData(@PathParam("key") String _agencyID) throws SQLException {
	/*public Response SpAgentProductData(JSONRequest _req) throws SQLException {*/

		logger.info("SpAgentProductData : _agencyID " + _agencyID);

		_orTalAdminBO = new OratalAdminImpl();
		String output =  _orTalAdminBO.SpAgentProductData(_agencyID).toString();
		logger.info("_orTalAdminBO.SpAgentProductData(_req.get_agencyID()).toString() : value " + output.length());

		return Response.status(200).entity(output).build();
	}

	@Path("/ProductCommSchedData/{key}")
	/*@Path("/ProductCommSchedData")*/
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SpProductCommSchedData(@PathParam("key") String _cusipID) throws SQLException {
	/*public Response SpProductCommSchedData(JSONRequest _req) throws SQLException {*/

		logger.info("ProductCommSchedData : _cusipID " + _cusipID);
		_orTalAdminBO = new OratalAdminImpl();
		String proComm = _orTalAdminBO.SpProductCommSchedData(_cusipID).toString();
		logger.info("_orTalAdminBO.SpProductCommSchedData(_req.get_cusipID()).toString() : value " + proComm.length());
		return Response.status(200).entity(proComm).build();

	}

	@Path("/ProductData/{key1}/{key2}")
	/*@Path("/ProductData")*/
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SpProductData(@PathParam("key1") String _pCompany,@PathParam("key2") String _pProductCd) throws SQLException {
	/*public Response SpProductData(JSONRequest _req) throws SQLException {*/

		logger.info("ProductData : _pCompany " + _pCompany);
		logger.info("ProductData : _pProductCd " + _pProductCd);
		_orTalAdminBO = new OratalAdminImpl();
		String proData = _orTalAdminBO.SpProductData(_pCompany,_pProductCd).toString();
		logger.info("_orTalAdminBO.SpProductData(_req.get_pCompany(),_req.get_pProductCd()).toString() : value " + proData.length());
		return Response.status(200).entity(proData).build();
	}


	@Path("/ProductFeeData/{key}")
	/*@Path("/ProductFeeData")*/
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SpProductFeeData(@PathParam("key") String _cusipID) throws SQLException {
	/*public Response SpProductFeeData(JSONRequest _req) throws SQLException {*/

		logger.info("ProductFeeData : _cusipID " + _cusipID);
		_orTalAdminBO = new OratalAdminImpl();
		String prodFee = _orTalAdminBO.SpProductFeeData(_cusipID).toString();
		logger.info("_orTalAdminBO.SpProductFeeData(_req.get_cusipID()).toString() : value " + prodFee.length());
		return Response.status(200).entity(prodFee).build();
	}


	@Path("/ProductRiderFund/{key}")
	/*@Path("/ProductRiderFund")*/
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SpProductRiderFundData(@PathParam("key") String _cusipID) throws SQLException {
	/*public Response SpProductRiderFundData(JSONRequest _req) throws SQLException {*/

		logger.info("ProductRiderFund : _cusipID " + _cusipID);
		_orTalAdminBO = new OratalAdminImpl();
		String prodRiderFee = _orTalAdminBO.SpProductRiderFundData(_cusipID).toString();
		logger.info("_orTalAdminBO.SpProductRiderFundData(_req.get_cusipID()).toString() : value " + prodRiderFee.length());
		return Response.status(200).entity(prodRiderFee).build();

	}

	@Path("/SpAgent/{key}")
	/*@Path("/SpAgent")*/
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SpAgentData(@PathParam("key") String _pAgency) throws SQLException {
	/*public Response SpAgentData(JSONRequest _req) throws SQLException {*/

		logger.info("SpAgent : _pAgency " + _pAgency);
		_orTalAdminBO = new OratalAdminImpl();
		String agentData = _orTalAdminBO.SpAgentData(_pAgency).toString();
		logger.info("_orTalAdminBO.SpAgentData(_req.get_pAgency()).toString() : value " + agentData.length());
		return Response.status(200).entity(agentData).build();

	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response sayHello() {

		logger.info("Hello OASys Rest Service Invoked");

		return Response.status(200).entity("Hello OASys Rest Service").build();
	}

	@Path("/SpProductDataCUSIP/{key}")
	/*@Path("/SpProductDataCUSIP")*/
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SpProductDataCUSIP(@PathParam("key") String _cusipID) throws SQLException {
	/*public Response SpProductDataCUSIP(JSONRequest _req) throws SQLException {*/

			logger.info("SpProductDataCUSIP : _cusipID " + _cusipID);
			_orTalAdminBO = new OratalAdminImpl();
			String PrdCUSIPData = _orTalAdminBO.SpProductDataCUSIP(_cusipID).toString();
			logger.info("_orTalAdminBO.SpProductDataCUSIP(_req.get_cusipID()).toString() : value " + PrdCUSIPData.length());
			return Response.status(200).entity(PrdCUSIPData).build();

	}

}
