package com.oasys.bo;

public interface OratalAdmin {

	StringBuffer SpAgentProductData(String _agencyID);
	StringBuffer SpProductCommSchedData(String _cusipID);
	StringBuffer SpProductData(String _pCompany,String _pProductCd);
	StringBuffer SpProductFeeData(String _cusipID);
	StringBuffer SpProductRiderFundData(String _cusipID);
	StringBuffer SpAgentData(String _pAgency);
	StringBuffer SpProductDataCUSIP(String _cusipID);	
	StringBuffer SpPolicyRiderFundData(String _compPolKey);
	StringBuffer SpPolicyCommSchedData(String _compPolKey);
}
