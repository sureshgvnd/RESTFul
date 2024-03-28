package com.oasys.bo.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import com.oasys.bo.OratalAdmin;
import com.oasys.dao.OratalAdminDAO;
import com.oasys.dao.impl.OratalAdminDAOImpl;
import com.oasys.model.SpAgent;
import com.oasys.model.SpAgentProductData;
import com.oasys.model.SpPolicyCommSched;
import com.oasys.model.SpPolicyRiderFund;
import com.oasys.model.SpProductCommSched;
import com.oasys.model.SpProductData;
import com.oasys.model.SpProductFeeData;
import com.oasys.model.SpProductRiderFund;
import com.oasys.model.SpProductDataCUSIP;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class OratalAdminImpl implements OratalAdmin {

	OratalAdminDAO _orTalAdmin = null;

	private static final Logger logger = Logger.getLogger(OratalAdminImpl.class);
	
	StringBuffer sb = null;

	@Override
	public StringBuffer SpPolicyCommSchedData(String _compPolKey) {

		_orTalAdmin = new OratalAdminDAOImpl();
		sb = new StringBuffer();

		try {

			List<SpPolicyCommSched> _spPolCommDataLst = _orTalAdmin.SpPolicyCommSched(_compPolKey);
			logger.info("_spPolCommDataLst : size " + _spPolCommDataLst.size());
			/*ObjectMapper mapperObj = new ObjectMapper();
			sb.append(mapperObj.writeValueAsString(_spPolCommDataLst));*/
			sb.append(javaObjectToJSON(_spPolCommDataLst));		

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (JsonGenerationException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return sb;
	}

	@Override
	public StringBuffer SpPolicyRiderFundData(String _compPolKey) {

		_orTalAdmin = new OratalAdminDAOImpl();

		sb = new StringBuffer();

		try {

			List<SpPolicyRiderFund> _spPolRiderDataLst = _orTalAdmin.SpPolicyRiderFund(_compPolKey);
			logger.info("_spPolRiderDataLst : size " + _spPolRiderDataLst.size());
			/*ObjectMapper mapperObj = new ObjectMapper();
			sb.append(mapperObj.writeValueAsString(_spPolRiderDataLst));*/
			sb.append(javaObjectToJSON(_spPolRiderDataLst));

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (JsonGenerationException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return sb;
	}

	@Override
	public StringBuffer SpAgentProductData(String _agencyID) {

		_orTalAdmin = new OratalAdminDAOImpl();

		sb = new StringBuffer();

		try {

			List<SpAgentProductData> _spAgntDataLst = _orTalAdmin.SpAgentProductData(_agencyID);
			logger.info("_spAgntDataLst : size " + _spAgntDataLst.size());
			/*ObjectMapper mapperObj = new ObjectMapper();
			sb.append(mapperObj.writeValueAsString(_spAgntDataLst));*/
			sb.append(javaObjectToJSON(_spAgntDataLst));
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (JsonGenerationException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return sb;
	}

	@Override
	public StringBuffer SpProductCommSchedData(String _cusipID) {

		_orTalAdmin = new OratalAdminDAOImpl();

		sb = new StringBuffer();

		try {

			List<SpProductCommSched> _spProdCommDataLst = _orTalAdmin.SpProductCommSchedData(_cusipID);
			logger.info("_spProdCommDataLst : size " + _spProdCommDataLst.size());
			/*ObjectMapper mapperObj = new ObjectMapper();
			sb.append(mapperObj.writeValueAsString(_spProdCommDataLst));*/
			sb.append(javaObjectToJSON(_spProdCommDataLst));

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (JsonGenerationException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return sb;
	}

	@Override
	public StringBuffer SpProductData(String _pCompany, String _pProductCd) {
		_orTalAdmin = new OratalAdminDAOImpl();

		sb = new StringBuffer();

		try {

			List<SpProductData> _spProdDataLst = _orTalAdmin.SpProductData(_pCompany, _pProductCd);
			logger.info("_spProdDataLst : size " + _spProdDataLst.size());
			/*ObjectMapper mapperObj = new ObjectMapper();
			sb.append(mapperObj.writeValueAsString(_spProdDataLst));*/			
			sb.append(javaObjectToJSON(_spProdDataLst));

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (JsonGenerationException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return sb;
	}

	@Override
	public StringBuffer SpProductFeeData(String _cusipID) {

		_orTalAdmin = new OratalAdminDAOImpl();

		sb = new StringBuffer();

		try {

			List<SpProductFeeData> _spPrdFeeDataLst = _orTalAdmin.SpProductFeeData(_cusipID);
			logger.info("_spPrdFeeDataLst : size " + _spPrdFeeDataLst.size());
			/*ObjectMapper mapperObj = new ObjectMapper();
			sb.append(mapperObj.writeValueAsString(_spPrdFeeDataLst));*/
			sb.append(javaObjectToJSON(_spPrdFeeDataLst));

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (JsonGenerationException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return sb;
	}

	@Override
	public StringBuffer SpProductRiderFundData(String _cusipID) {
		_orTalAdmin = new OratalAdminDAOImpl();

		sb = new StringBuffer();

		try {

			List<SpProductRiderFund> _spPrdRdrFndDataLst = _orTalAdmin.SpProductRiderFundData(_cusipID);
			logger.info("_spPrdRdrFndDataLst : size " + _spPrdRdrFndDataLst.size());
			/*ObjectMapper mapperObj = new ObjectMapper();
			sb.append(mapperObj.writeValueAsString(_spPrdRdrFndDataLst));*/
			sb.append(javaObjectToJSON(_spPrdRdrFndDataLst));

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (JsonGenerationException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return sb;
	}

	@Override
	public StringBuffer SpAgentData(String _pAgency) {

		_orTalAdmin = new OratalAdminDAOImpl();

		sb = new StringBuffer();

		try {

			List<SpAgent> _spAgentLst = _orTalAdmin.SpAgentData(_pAgency);
			logger.info("_spAgentLst : size " + _spAgentLst.size());
			/*ObjectMapper mapperObj = new ObjectMapper();
			sb.append(mapperObj.writeValueAsString(_spAgentLst));*/
			sb.append(javaObjectToJSON(_spAgentLst));

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (JsonGenerationException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return sb;
	}

	@Override
	public StringBuffer SpProductDataCUSIP(String _cusipID) {

		_orTalAdmin = new OratalAdminDAOImpl();

		sb = new StringBuffer();

		try {

			List<SpProductDataCUSIP> _spPrdCusipLst = _orTalAdmin.SpProductDataCUSIP(_cusipID);
			logger.info("_spPrdCusipLst : size " + _spPrdCusipLst.size());
			/*ObjectMapper mapperObj = new ObjectMapper();
			sb.append(mapperObj.writeValueAsString(_spPrdCusipLst));*/
			
			sb.append(javaObjectToJSON(_spPrdCusipLst));

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (JsonGenerationException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return sb;
	}
	
	public String javaObjectToJSON(List _lst) throws JsonGenerationException, JsonMappingException, IOException{		
		ObjectMapper mapperObj = new ObjectMapper();			
		return mapperObj.writeValueAsString(_lst);		
	}

}

