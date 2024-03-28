package com.oasys.dao;

import java.sql.SQLException;
import java.util.List;
import com.oasys.model.SpAgentProductData;
import com.oasys.model.SpProductCommSched;
import com.oasys.model.SpProductData;
import com.oasys.model.SpProductFeeData;
import com.oasys.model.SpProductRiderFund;
import com.oasys.model.SpAgent;
import com.oasys.model.SpProductDataCUSIP;
import com.oasys.model.SpPolicyRiderFund;
import com.oasys.model.SpPolicyCommSched;

public interface OratalAdminDAO {

	List<SpAgentProductData> SpAgentProductData(String _agencyID) throws SQLException;
	List<SpProductCommSched> SpProductCommSchedData(String _cusipID)throws SQLException;
	List<SpProductData> SpProductData(String _pCompany,String _pProductCd)throws SQLException;
	List<SpProductFeeData> SpProductFeeData(String _cusipID)throws SQLException;
	List<SpProductRiderFund> SpProductRiderFundData(String _cusipID)throws SQLException;
	List<SpAgent> SpAgentData(String _pAgency)throws SQLException;
	List<SpProductDataCUSIP> SpProductDataCUSIP(String _cusipID)throws SQLException;	
	List<SpPolicyRiderFund> SpPolicyRiderFund(String _compPolKey)throws SQLException;	
	List<SpPolicyCommSched> SpPolicyCommSched(String _compPolKey)throws SQLException;
	
}
