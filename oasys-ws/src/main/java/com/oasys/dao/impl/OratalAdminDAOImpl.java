package com.oasys.dao.impl;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

import com.oasys.bo.impl.OratalAdminImpl;

import com.oasys.dao.OratalAdminDAO;
import com.oasys.model.SpAgentProductData;
import com.oasys.model.SpProductData;
import com.oasys.model.SpProductFeeData;
import com.oasys.model.SpProductRiderFund;
import com.oasys.model.SpAgent;
import com.oasys.model.SpProductCommSched;
import com.oasys.model.SpProductDataCUSIP;
import com.oasys.model.SpPolicyRiderFund;
import com.oasys.model.SpPolicyCommSched;

import oracle.jdbc.OracleTypes;


public class OratalAdminDAOImpl implements OratalAdminDAO{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//private static final Logger logger = LoggerFactory.getLogger(OratalAdminDAOImpl.class);
	Connection _dBCon = null;
	CallableStatement callableStatement = null;
	ResultSet rs = null;

	DBConnection con = new DBConnection();


	@Override
	public List<com.oasys.model.SpPolicyCommSched> SpPolicyCommSched(String _compPolKey) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<SpPolicyCommSched> SpPolCommSchList = new ArrayList<SpPolicyCommSched>();

		try {

			String storedProcQuery = "BEGIN PORTAL_ADMIN.sp_Policy_Comm_Sched(?,?); END;";

			_dBCon = con.getConnection();
			//_dBCon = DBConnection.getDBConnection();

		    callableStatement = _dBCon.prepareCall (storedProcQuery);
		    callableStatement.setString (1, _compPolKey);
		    callableStatement.registerOutParameter (2, OracleTypes.CURSOR);

		    callableStatement.execute ();

		    rs = (ResultSet)callableStatement.getObject (2);

			while (rs.next ()) {

				SpPolicyCommSched _spPolCommSchData = new SpPolicyCommSched();

				_spPolCommSchData.setCOMPANY(_nullToString(rs.getString("COMPANY")));
				_spPolCommSchData.setCUSIP(_nullToString(rs.getString("CUSIP")));
				_spPolCommSchData.setPRODUCT_CD(_nullToString(rs.getString("PRODUCT_CD")));
				_spPolCommSchData.setSCHED_ID(_nullToString(rs.getString("SCHED_ID")));
				_spPolCommSchData.setEFF_DT(_nullToString(rs.getString("EFF_DT")));
				_spPolCommSchData.setAGENCY(_nullToString(rs.getString("AGENCY")));
				_spPolCommSchData.setMAX_AGE(_nullToString(rs.getString("MAX_AGE")));
				_spPolCommSchData.setMONEY_TYPE(_nullToString(rs.getString("MONEY_TYPE")));
				_spPolCommSchData.setQUAL_IND(_nullToString(rs.getString("QUAL_IND")));
				_spPolCommSchData.setST_CODE(_nullToString(rs.getString("ST_CODE")));
				_spPolCommSchData.setPREM_MAX(_nullToString(rs.getString("PREM_MAX")));
				_spPolCommSchData.setPOLICY_AGE(_nullToString(rs.getString("POLICY_AGE")));
				_spPolCommSchData.setMIN_AGE(_nullToString(rs.getString("MIN_AGE")));
				_spPolCommSchData.setEND_DT(_nullToString(rs.getString("END_DT")));
				_spPolCommSchData.setCOMM_TYPE(_nullToString(rs.getString("COMM_TYPE")));
				_spPolCommSchData.setUP_COMM_RT(_nullToString(rs.getString("UP_COMM_RT")));
				_spPolCommSchData.setTSA_UP_COMM_RT(_nullToString(rs.getString("TSA_UP_COMM_RT")));
				_spPolCommSchData.setQUAL_REN_COMM_RT(_nullToString(rs.getString("QUAL_REN_COMM_RT")));
				_spPolCommSchData.setNQUAL_REN_COMM_RT(_nullToString(rs.getString("NQUAL_REN_COMM_RT")));
				_spPolCommSchData.setMGA_RT(_nullToString(rs.getString("MGA_RT")));
				_spPolCommSchData.setSMGA_1_RT(_nullToString(rs.getString("SMGA_1_RT")));
				_spPolCommSchData.setSMGA_2_RT(_nullToString(rs.getString("SMGA_2_RT")));
				_spPolCommSchData.setSMGA_3_RT(_nullToString(rs.getString("SMGA_3_RT")));
				_spPolCommSchData.setOVERRIDE_RT(_nullToString(rs.getString("OVERRIDE_RT")));
				_spPolCommSchData.setREDUCED_COMM_RT(_nullToString(rs.getString("REDUCED_COMM_RT")));
				_spPolCommSchData.setTOT_COMM_RT(_nullToString(rs.getString("TOT_COMM_RT")));
				_spPolCommSchData.setTRAIL_PAY_SCHED(_nullToString(rs.getString("TRAIL_PAY_SCHED")));
				_spPolCommSchData.setTRAIL_ST_PD_1(_nullToString(rs.getString("TRAIL_ST_PD_1")));
				_spPolCommSchData.setTRAIL_DUR_1(_nullToString(rs.getString("TRAIL_DUR_1")));
				_spPolCommSchData.setQUAL_TR_COMM_RT_1(_nullToString(rs.getString("QUAL_TR_COMM_RT_1")));
				_spPolCommSchData.setNQUAL_TR_COMM_RT_1(_nullToString(rs.getString("NQUAL_TR_COMM_RT_1")));
				_spPolCommSchData.setTRAIL_ST_PD_2(_nullToString(rs.getString("TRAIL_ST_PD_2")));
				_spPolCommSchData.setTRAIL_DUR_2(_nullToString(rs.getString("TRAIL_DUR_2")));
				_spPolCommSchData.setQUAL_TR_COMM_RT_2(_nullToString(rs.getString("QUAL_TR_COMM_RT_2")));
				_spPolCommSchData.setNQUAL_TR_COMM_RT_2(_nullToString(rs.getString("NQUAL_TR_COMM_RT_2")));
				_spPolCommSchData.setTRAIL_ST_PD_3(_nullToString(rs.getString("TRAIL_ST_PD_3")));
				_spPolCommSchData.setTRAIL_DUR_3(_nullToString(rs.getString("TRAIL_DUR_3")));
				_spPolCommSchData.setQUAL_TR_COMM_RT_3(_nullToString(rs.getString("QUAL_TR_COMM_RT_3")));
				_spPolCommSchData.setNQUAL_TR_COMM_RT_3(_nullToString(rs.getString("NQUAL_TR_COMM_RT_3")));
				_spPolCommSchData.setTRAIL_ST_PD_4(_nullToString(rs.getString("TRAIL_ST_PD_4")));
				_spPolCommSchData.setTRAIL_DUR_4(_nullToString(rs.getString("TRAIL_DUR_4")));
				_spPolCommSchData.setQUAL_TR_COMM_RT_4(_nullToString(rs.getString("QUAL_TR_COMM_RT_4")));
				_spPolCommSchData.setNQUAL_TR_COMM_RT_4(_nullToString(rs.getString("NQUAL_TR_COMM_RT_4")));
				_spPolCommSchData.setTRAIL_ST_PD_5(_nullToString(rs.getString("TRAIL_ST_PD_5")));
				_spPolCommSchData.setTRAIL_DUR_5(_nullToString(rs.getString("TRAIL_DUR_5")));
				_spPolCommSchData.setQUAL_TR_COMM_RT_5(_nullToString(rs.getString("QUAL_TR_COMM_RT_5")));
				_spPolCommSchData.setNQUAL_TR_COMM_RT_5(_nullToString(rs.getString("NQUAL_TR_COMM_RT_5")));
				_spPolCommSchData.setCALC_METHOD(_nullToString(rs.getString("CALC_METHOD")));
				_spPolCommSchData.setCOMPANY_ALPHA(_nullToString(rs.getString("COMPANY_ALPHA")));
				_spPolCommSchData.setSYSTEM_ID(_nullToString(rs.getString("SYSTEM_ID")));
				_spPolCommSchData.setBLC(_nullToString(rs.getString("BLC")));
				_spPolCommSchData.setCOMP_POL_KEY(_nullToString(rs.getString("COMP_POL_KEY")));
				_spPolCommSchData.setPOL_ISS_DT(_nullToString(rs.getString("POL_ISS_DT")));
				_spPolCommSchData.setISSUE_AGE(_nullToString(rs.getString("ISSUE_AGE")));
				_spPolCommSchData.setISS_STATE(_nullToString(rs.getString("ISS_STATE")));				
				_spPolCommSchData.setCOMMISSION_OPTION(_nullToString(rs.getString("COMMISSION_OPTION")));

				SpPolCommSchList.add(_spPolCommSchData);
			}

			//logger.info("SpAgntProdList DAO : " + SpAgntProdList.size());
			System.out.println("SpPolCommSchList DAO : " + SpPolCommSchList.size());

		} catch (SQLException e) {

			System.out.println(e.getMessage());


		} finally {

			if (rs != null) {
				rs.close();
			}

			if (callableStatement != null) {
				callableStatement.close();
			}

			if (_dBCon != null) {
				_dBCon.close();
			}

		}
		return SpPolCommSchList;
	}


	@Override
	public List<com.oasys.model.SpPolicyRiderFund> SpPolicyRiderFund(String _compPolKey) throws SQLException {
		// TODO Auto-generated method stub

		ArrayList<SpPolicyRiderFund> SpPolRiderFundList = new ArrayList<SpPolicyRiderFund>();

		try {

			String storedProcQuery = "BEGIN PORTAL_ADMIN.sp_Policy_Rider_Fund(?,?); END;";

			_dBCon = con.getConnection();
			//_dBCon = DBConnection.getDBConnection();

		    callableStatement = _dBCon.prepareCall (storedProcQuery);
		    callableStatement.setString (1, _compPolKey);
		    callableStatement.registerOutParameter (2, OracleTypes.CURSOR);

		    callableStatement.execute ();

		    rs = (ResultSet)callableStatement.getObject (2);

			while (rs.next ()) {

				SpPolicyRiderFund _spPolRiderFndData = new SpPolicyRiderFund();

				_spPolRiderFndData.setCOMPANY(_nullToString(rs.getString("COMPANY")));
				_spPolRiderFndData.setFEE_ID(_nullToString(rs.getString("FEE_ID")));
				_spPolRiderFndData.setPROD_CUSIP(_nullToString(rs.getString("PROD_CUSIP")));
				_spPolRiderFndData.setREC_TYPE(_nullToString(rs.getString("REC_TYPE")));
				_spPolRiderFndData.setSTART_DT(_nullToString(rs.getString("START_DT")));
				_spPolRiderFndData.setEND_DT(_nullToString(rs.getString("END_DT")));
				_spPolRiderFndData.setPROD_DESC_CD(_nullToString(rs.getString("PROD_DESC_CD")));
				_spPolRiderFndData.setFEE_NAME(_nullToString(rs.getString("FEE_NAME")));
				_spPolRiderFndData.setFEE_MODE(_nullToString(rs.getString("FEE_MODE")));
				_spPolRiderFndData.setPPFA_FEAT_CD(_nullToString(rs.getString("PPFA_FEAT_CD")));
				_spPolRiderFndData.setPPFA_CARR_FACING_DESC(_nullToString(rs.getString("PPFA_CARR_FACING_DESC")));
				_spPolRiderFndData.setFEAT_OPT_CD(_nullToString(rs.getString("FEAT_OPT_CD")));
				_spPolRiderFndData.setFEAT_OPT_NAME(_nullToString(rs.getString("FEAT_OPT_NAME")));
				_spPolRiderFndData.setSCHED_YRS(_nullToString(rs.getString("SCHED_YRS")));
				_spPolRiderFndData.setFEAT_SCHED(_nullToString(rs.getString("FEAT_SCHED")));
				_spPolRiderFndData.setFEE_PCT(_nullToString(rs.getString("FEE_PCT")));
				_spPolRiderFndData.setMIN_PCT(_nullToString(rs.getString("MIN_PCT")));
				_spPolRiderFndData.setMAX_PCT(_nullToString(rs.getString("MAX_PCT")));
				_spPolRiderFndData.setMIN_PREM_AMT(_nullToString(rs.getString("MIN_PREM_AMT")));
				_spPolRiderFndData.setMAX_PREM_AMT(_nullToString(rs.getString("MAX_PREM_AMT")));
				_spPolRiderFndData.setMIN_YR(_nullToString(rs.getString("MIN_YR")));
				_spPolRiderFndData.setMAX_YR(_nullToString(rs.getString("MAX_YR")));
				_spPolRiderFndData.setFEE_BASED_ON(_nullToString(rs.getString("FEE_BASED_ON")));
				_spPolRiderFndData.setSTATE_APPR(_nullToString(rs.getString("STATE_APPR")));
				_spPolRiderFndData.setSTATUS(_nullToString(rs.getString("STATUS")));
				_spPolRiderFndData.setWEB_MSG(_nullToString(rs.getString("WEB_MSG")));
				_spPolRiderFndData.setSYSTEM_ID(_nullToString(rs.getString("SYSTEM_ID")));
				_spPolRiderFndData.setCOMPANY_ALPHA(_nullToString(rs.getString("COMPANY_ALPHA")));
				_spPolRiderFndData.setComp_pol_key(_nullToString(rs.getString("comp_pol_key")));
				_spPolRiderFndData.setPol_iss_dt(_nullToString(rs.getString("pol_iss_dt")));
				_spPolRiderFndData.setIss_state(_nullToString(rs.getString("iss_state")));

				SpPolRiderFundList.add(_spPolRiderFndData);
			}

			//logger.info("SpAgntProdList DAO : " + SpAgntProdList.size());
			System.out.println("SpPolicyRiderFund DAO : " + SpPolRiderFundList.size());

		} catch (SQLException e) {

			System.out.println(e.getMessage());


		} finally {

			if (rs != null) {
				rs.close();
			}

			if (callableStatement != null) {
				callableStatement.close();
			}

			if (_dBCon != null) {
				_dBCon.close();
			}

		}
		return SpPolRiderFundList;

	}


	@Override
	public List<SpAgentProductData> SpAgentProductData(String _agencyID) throws SQLException{

		//String storedProcQuery = "BEGIN portal_admin.sp_agent_product(?,?); END;";

		ArrayList<SpAgentProductData> SpAgntProdList = new ArrayList<SpAgentProductData>();

		try {

				String storedProcQuery = "BEGIN PORTAL_ADMIN.sp_Agent_Product(?,?); END;";

				_dBCon = con.getConnection();
				//_dBCon = DBConnection.getDBConnection();

			    callableStatement = _dBCon.prepareCall (storedProcQuery);
			    callableStatement.setString (1, _agencyID);
			    callableStatement.registerOutParameter (2, OracleTypes.CURSOR);

			    callableStatement.execute ();

			    rs = (ResultSet)callableStatement.getObject (2);

				while (rs.next ()) {

									SpAgentProductData _spAgntData = new SpAgentProductData();

									_spAgntData.setCOMPANY(_nullToString(rs.getString("COMPANY")));
									_spAgntData.setCOMPANY_ALPHA(_nullToString(rs.getString("COMPANY_ALPHA")));
									_spAgntData.setAGENCY(_nullToString(rs.getString("AGENCY")));
									_spAgntData.setSUB_AGENT(_nullToString(rs.getString("SUB_AGENT")));
									_spAgntData.setCUSIP(_nullToString(rs.getString("CUSIP")));
									_spAgntData.setREC_START_DT(_nullToString(rs.getString("REC_START_DT")));
									_spAgntData.setEND_DT(_nullToString(rs.getString("END_DT")));
									_spAgntData.setSALE_QUAL(_nullToString(rs.getString("SALE_QUAL")));
									_spAgntData.setSALE_N_QUAL(_nullToString(rs.getString("SALE_N_QUAL")));
									_spAgntData.setSERVICE_QUAL(_nullToString(rs.getString("SERVICE_QUAL")));
									_spAgntData.setSERVICE_N_QUAL(_nullToString(rs.getString("SERVICE_N_QUAL")));
									_spAgntData.setPRODUCT_CD(_nullToString(rs.getString("PRODUCT_CD")));
									_spAgntData.setREC_EFF_DT_NINES_COMPLEMENT(_nullToString(rs.getString("REC_EFF_DT_NINES_COMPLEMENT")));
									_spAgntData.setEFF_DT(_nullToString(rs.getString("EFF_DT")));
									_spAgntData.setPRODUCT_DESC(_nullToString(rs.getString("PRODUCT_DESC")));
									_spAgntData.setPRODUCT_TYPE(_nullToString(rs.getString("PRODUCT_TYPE")));
									_spAgntData.setFIN_PPGA_IND(_nullToString(rs.getString("FIN_PPGA_IND")));
									_spAgntData.setRETAIL_PROPRIETARY_IND(_nullToString(rs.getString("RETAIL_PROPRIETARY_IND")));
									_spAgntData.setM2AB_FIN_RPT_IND(_nullToString(rs.getString("M2AB_FIN_RPT_IND")));
									_spAgntData.setROLLING_SURR_CHRG_IND(_nullToString(rs.getString("ROLLING_SURR_CHRG_IND")));
									_spAgntData.setMVA_IND(_nullToString(rs.getString("MVA_IND")));
									_spAgntData.setSTEPUP_IND(_nullToString(rs.getString("STEPUP_IND")));
									_spAgntData.setHAS_GUAR_PCT_REC_IND(_nullToString(rs.getString("HAS_GUAR_PCT_REC_IND")));
									_spAgntData.setMULT_GUAR_TERMS_IND(_nullToString(rs.getString("MULT_GUAR_TERMS_IND")));
									_spAgntData.setGUAR_TERM_YRS_1(_nullToString(rs.getString("GUAR_TERM_YRS_1")));
									_spAgntData.setGUAR_TERM_YRS_2(_nullToString(rs.getString("GUAR_TERM_YRS_2")));
									_spAgntData.setGUAR_TERM_YRS_3(_nullToString(rs.getString("GUAR_TERM_YRS_3")));
									_spAgntData.setGUAR_TERM_YRS_4(_nullToString(rs.getString("GUAR_TERM_YRS_4")));
									_spAgntData.setGUAR_TERM_YRS_5(_nullToString(rs.getString("GUAR_TERM_YRS_5")));
									_spAgntData.setGUAR_TERM_YRS_6(_nullToString(rs.getString("GUAR_TERM_YRS_6")));
									_spAgntData.setGUAR_TERM_YRS_7(_nullToString(rs.getString("GUAR_TERM_YRS_7")));
									_spAgntData.setGUAR_TERM_YRS_8(_nullToString(rs.getString("GUAR_TERM_YRS_8")));
									_spAgntData.setGUAR_TERM_YRS_9(_nullToString(rs.getString("GUAR_TERM_YRS_9")));
									_spAgntData.setGUAR_TERM_YRS_10(_nullToString(rs.getString("GUAR_TERM_YRS_10")));
									_spAgntData.setM27B_FIN_RPT_IND(_nullToString(rs.getString("M27B_FIN_RPT_IND")));
									_spAgntData.setOWN_AGE_IND(_nullToString(rs.getString("OWN_AGE_IND")));
									_spAgntData.setPAY_NET_ISS_GROSS_IND(_nullToString(rs.getString("PAY_NET_ISS_GROSS_IND")));
									_spAgntData.setNET_COMM_IND(_nullToString(rs.getString("NET_COMM_IND")));
									_spAgntData.setCOMM_PREM_TTLS_IND(_nullToString(rs.getString("COMM_PREM_TTLS_IND")));
									_spAgntData.setAGENCY_NEW_POL_CARD_IND(_nullToString(rs.getString("AGENCY_NEW_POL_CARD_IND")));
									_spAgntData.setROLLING_CHARGEBACK_IND(_nullToString(rs.getString("ROLLING_CHARGEBACK_IND")));
									_spAgntData.setAPA_IND(_nullToString(rs.getString("APA_IND")));
									_spAgntData.setCASH_VAL_CALC(_nullToString(rs.getString("CASH_VAL_CALC")));
									_spAgntData.setUSE_APA_YIELD_IND(_nullToString(rs.getString("USE_APA_YIELD_IND")));
									_spAgntData.setMONTH_INCOME_RT_GRP(_nullToString(rs.getString("MONTH_INCOME_RT_GRP")));
									_spAgntData.setMONTH_INCOME_GRP(_nullToString(rs.getString("MONTH_INCOME_GRP")));
									_spAgntData.setWACHOVIA_IND(_nullToString(rs.getString("WACHOVIA_IND")));
									_spAgntData.setULTRA_MYG_IND(_nullToString(rs.getString("ULTRA_MYG_IND")));
									_spAgntData.setSRA_IND(_nullToString(rs.getString("SRA_IND")));
									_spAgntData.setCONSTELLATION_IND(_nullToString(rs.getString("CONSTELLATION_IND")));
									_spAgntData.setSTERLING_IND(_nullToString(rs.getString("STERLING_IND")));
									_spAgntData.setIDX_ANNUITY_IND(_nullToString(rs.getString("IDX_ANNUITY_IND")));
									_spAgntData.setSPIA_SUPP_CON_IND(_nullToString(rs.getString("SPIA_SUPP_CON_IND")));
									_spAgntData.setSTATUTORY_TAX_SPEC_RT_IND(_nullToString(rs.getString("STATUTORY_TAX_SPEC_RT_IND")));
									_spAgntData.setPRT_QTR_END_SURR_VAL_IND(_nullToString(rs.getString("PRT_QTR_END_SURR_VAL_IND")));
									_spAgntData.setSAP_PRODUCT_CD(_nullToString(rs.getString("SAP_PRODUCT_CD")));
									_spAgntData.setCOMP_AGT_KEY(_nullToString(rs.getString("COMP_AGT_KEY")));
									_spAgntData.setSYSTEM_ID(_nullToString(rs.getString("SYSTEM_ID")));

									SpAgntProdList.add(_spAgntData);


				}

				//logger.info("SpAgntProdList DAO : " + SpAgntProdList.size());
				System.out.println("SpAgntProdList DAO : " + SpAgntProdList.size());

		} catch (SQLException e) {

			System.out.println(e.getMessage());


		} finally {

			if (rs != null) {
				rs.close();
			}

			if (callableStatement != null) {
				callableStatement.close();
			}

			if (_dBCon != null) {
				_dBCon.close();
			}

		}

		return SpAgntProdList;
	}



	@Override
	public List<SpProductCommSched> SpProductCommSchedData(String _cusipID) throws SQLException {

		ArrayList<SpProductCommSched> SpAgntPrdCommList = new ArrayList<SpProductCommSched>();

		try {

			String storedProcQuery = "BEGIN PORTAL_ADMIN.sp_product_comm_sched(?,?); END;";
			_dBCon = con.getConnection();
			// _dBCon = DBConnection.getDBConnection();

			callableStatement = _dBCon.prepareCall(storedProcQuery);
			callableStatement.setString(1, _cusipID);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

			callableStatement.execute();

			rs = (ResultSet) callableStatement.getObject(2);

			/*
			 * if(_dBCon.isClosed()){
			 *
			 * logger.info("SpAgentProductData : OASys DB Connection Closed ");
			 * }
			 */

			while (rs.next()) {

				SpProductCommSched _spAgntPrdCommData = new SpProductCommSched();

				_spAgntPrdCommData.setCOMPANY(_nullToString(rs.getString("COMPANY")));
				_spAgntPrdCommData.setCUSIP(_nullToString(rs.getString("CUSIP")));
				_spAgntPrdCommData.setPRODUCT_CD(_nullToString(rs.getString("PRODUCT_CD")));
				_spAgntPrdCommData.setSCHED_ID(_nullToString(rs.getString("SCHED_ID")));
				_spAgntPrdCommData.setEFF_DT(_nullToString(rs.getDate("EFF_DT").toString()));
				_spAgntPrdCommData.setAGENCY(_nullToString(rs.getString("AGENCY")));
				_spAgntPrdCommData.setMAX_AGE(_nullToString(rs.getString("MAX_AGE")));
				_spAgntPrdCommData.setMONEY_TYPE(_nullToString(rs.getString("MONEY_TYPE")));
				_spAgntPrdCommData.setQUAL_IND(_nullToString(rs.getString("QUAL_IND")));
				_spAgntPrdCommData.setST_CODE(_nullToString(rs.getString("ST_CODE")));
				_spAgntPrdCommData.setPREM_MAX(_nullToString(rs.getString("PREM_MAX")));
				_spAgntPrdCommData.setPOLICY_AGE(_nullToString(rs.getString("POLICY_AGE")));
				_spAgntPrdCommData.setMIN_AGE(_nullToString(rs.getString("MIN_AGE")));
				_spAgntPrdCommData.setEND_DT(_nullToString(rs.getDate("END_DT").toString()));
				_spAgntPrdCommData.setCOMM_TYPE(_nullToString(rs.getString("COMM_TYPE")));
				_spAgntPrdCommData.setUP_COMM_RT(_nullToString(rs.getString("UP_COMM_RT")));
				_spAgntPrdCommData.setTSA_UP_COMM_RT(_nullToString(rs.getString("TSA_UP_COMM_RT")));
				_spAgntPrdCommData.setQUAL_REN_COMM_RT(_nullToString(rs.getString("QUAL_REN_COMM_RT")));
				_spAgntPrdCommData.setNQUAL_REN_COMM_RT(_nullToString(rs.getString("NQUAL_REN_COMM_RT")));
				_spAgntPrdCommData.setMGA_RT(_nullToString(rs.getString("MGA_RT")));
				_spAgntPrdCommData.setSMGA_1_RT(_nullToString(rs.getString("SMGA_1_RT")));
				_spAgntPrdCommData.setSMGA_2_RT(_nullToString(rs.getString("SMGA_2_RT")));
				_spAgntPrdCommData.setSMGA_3_RT(_nullToString(rs.getString("SMGA_3_RT")));
				_spAgntPrdCommData.setOVERRIDE_RT(_nullToString(rs.getString("OVERRIDE_RT")));
				_spAgntPrdCommData.setREDUCED_COMM_RT(_nullToString(rs.getString("REDUCED_COMM_RT")));
				_spAgntPrdCommData.setTOT_COMM_RT(_nullToString(rs.getString("TOT_COMM_RT")));
				_spAgntPrdCommData.setTRAIL_PAY_SCHED(_nullToString(rs.getString("TRAIL_PAY_SCHED")));
				_spAgntPrdCommData.setTRAIL_ST_PD_1(_nullToString(rs.getString("TRAIL_ST_PD_1")));
				_spAgntPrdCommData.setTRAIL_DUR_1(_nullToString(rs.getString("TRAIL_DUR_1")));
				_spAgntPrdCommData.setQUAL_TR_COMM_RT_1(_nullToString(rs.getString("QUAL_TR_COMM_RT_1")));
				_spAgntPrdCommData.setNQUAL_TR_COMM_RT_1(_nullToString(rs.getString("NQUAL_TR_COMM_RT_1")));
				_spAgntPrdCommData.setTRAIL_ST_PD_2(_nullToString(rs.getString("TRAIL_ST_PD_2")));
				_spAgntPrdCommData.setTRAIL_DUR_2(_nullToString(rs.getString("TRAIL_DUR_2")));
				_spAgntPrdCommData.setQUAL_TR_COMM_RT_2(_nullToString(rs.getString("QUAL_TR_COMM_RT_2")));
				_spAgntPrdCommData.setNQUAL_TR_COMM_RT_2(_nullToString(rs.getString("NQUAL_TR_COMM_RT_2")));
				_spAgntPrdCommData.setTRAIL_ST_PD_3(_nullToString(rs.getString("TRAIL_ST_PD_3")));
				_spAgntPrdCommData.setTRAIL_DUR_3(_nullToString(rs.getString("TRAIL_DUR_3")));
				_spAgntPrdCommData.setQUAL_TR_COMM_RT_3(_nullToString(rs.getString("QUAL_TR_COMM_RT_3")));
				_spAgntPrdCommData.setNQUAL_TR_COMM_RT_3(_nullToString(rs.getString("NQUAL_TR_COMM_RT_3")));
				_spAgntPrdCommData.setTRAIL_ST_PD_4(_nullToString(rs.getString("TRAIL_ST_PD_4")));
				_spAgntPrdCommData.setTRAIL_DUR_4(_nullToString(rs.getString("TRAIL_DUR_4")));
				_spAgntPrdCommData.setQUAL_TR_COMM_RT_4(_nullToString(rs.getString("QUAL_TR_COMM_RT_4")));
				_spAgntPrdCommData.setNQUAL_TR_COMM_RT_4(_nullToString(rs.getString("NQUAL_TR_COMM_RT_4")));
				_spAgntPrdCommData.setTRAIL_ST_PD_5(_nullToString(rs.getString("TRAIL_ST_PD_5")));
				_spAgntPrdCommData.setTRAIL_DUR_5(_nullToString(rs.getString("TRAIL_DUR_5")));
				_spAgntPrdCommData.setQUAL_TR_COMM_RT_5(_nullToString(rs.getString("QUAL_TR_COMM_RT_5")));
				_spAgntPrdCommData.setNQUAL_TR_COMM_RT_5(_nullToString(rs.getString("NQUAL_TR_COMM_RT_5")));
				_spAgntPrdCommData.setCALC_METHOD(_nullToString(rs.getString("CALC_METHOD")));
				_spAgntPrdCommData.setCOMPANY_ALPHA(_nullToString(rs.getString("COMPANY_ALPHA")));
				_spAgntPrdCommData.setSYSTEM_ID(_nullToString(rs.getString("SYSTEM_ID")));
				_spAgntPrdCommData.setBLC(_nullToString(rs.getString("BLC")));
				_spAgntPrdCommData.setCOMMISSION_OPTION(_nullToString(rs.getString("COMMISSION_OPTION")));

				SpAgntPrdCommList.add(_spAgntPrdCommData);

			}

			// logger.info(" SpAgntPrdCommList.size() DAO " +
			// SpAgntPrdCommList.size());
			System.out.println(" SpAgntPrdCommList.size() DAO " + SpAgntPrdCommList.size());

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (rs != null) {
				rs.close();
			}

			if (callableStatement != null) {
				callableStatement.close();
			}

			if (_dBCon != null) {
				_dBCon.close();
			}

		}

		return SpAgntPrdCommList;
	}


	@Override
	public List<com.oasys.model.SpProductData> SpProductData(String _pCompany,String _pProductCd) throws SQLException {

		ArrayList<SpProductData> SpPrdDataList = new ArrayList<SpProductData>();

		try {

				String storedProcQuery = "BEGIN PORTAL_ADMIN.sp_product_data(?,?,?); END;";
				_dBCon = con.getConnection();

			    callableStatement = _dBCon.prepareCall (storedProcQuery);
			    callableStatement.setString (1, _pCompany);
			    callableStatement.setString (2, _pProductCd);
			    callableStatement.registerOutParameter (3, OracleTypes.CURSOR);

			    callableStatement.execute ();

			    rs = (ResultSet)callableStatement.getObject (3);

				while (rs.next ()) {


					SpProductData _spPrdData = new SpProductData();
					_spPrdData.setCOMPANY(_nullToString(rs.getString("COMPANY")));
					_spPrdData.setPRODUCT_CD(_nullToString(rs.getString("PRODUCT_CD")));
					_spPrdData.setREC_EFF_DT_NINES_COMPLEMENT(_nullToString(rs.getString("REC_EFF_DT_NINES_COMPLEMENT")));
					_spPrdData.setEFF_DT(_nullToString(rs.getDate("EFF_DT").toString()));
					_spPrdData.setPRODUCT_DESC(_nullToString(rs.getString("PRODUCT_DESC")));
					_spPrdData.setPRODUCT_TYPE(_nullToString(rs.getString("PRODUCT_TYPE")));
					_spPrdData.setFIN_PPGA_IND(_nullToString(rs.getString("FIN_PPGA_IND")));
					_spPrdData.setRETAIL_PROPRIETARY_IND(_nullToString(rs.getString("RETAIL_PROPRIETARY_IND")));
					_spPrdData.setM2AB_FIN_RPT_IND(_nullToString(rs.getString("M2AB_FIN_RPT_IND")));
					_spPrdData.setROLLING_SURR_CHRG_IND(_nullToString(rs.getString("ROLLING_SURR_CHRG_IND")));
					_spPrdData.setMVA_IND(_nullToString(rs.getString("MVA_IND")));
					_spPrdData.setSTEPUP_IND(_nullToString(rs.getString("STEPUP_IND")));
					_spPrdData.setHAS_GUAR_PCT_REC_IND(_nullToString(rs.getString("HAS_GUAR_PCT_REC_IND")));
					_spPrdData.setMULT_GUAR_TERMS_IND(_nullToString(rs.getString("MULT_GUAR_TERMS_IND")));
					_spPrdData.setGUAR_TERM_YRS_1(_nullToString(rs.getString("GUAR_TERM_YRS_1")));
					_spPrdData.setGUAR_TERM_YRS_2(_nullToString(rs.getString("GUAR_TERM_YRS_2")));
					_spPrdData.setGUAR_TERM_YRS_3(_nullToString(rs.getString("GUAR_TERM_YRS_3")));
					_spPrdData.setGUAR_TERM_YRS_4(_nullToString(rs.getString("GUAR_TERM_YRS_4")));
					_spPrdData.setGUAR_TERM_YRS_5(_nullToString(rs.getString("GUAR_TERM_YRS_5")));
					_spPrdData.setGUAR_TERM_YRS_6(_nullToString(rs.getString("GUAR_TERM_YRS_6")));
					_spPrdData.setGUAR_TERM_YRS_7(_nullToString(rs.getString("GUAR_TERM_YRS_7")));
					_spPrdData.setGUAR_TERM_YRS_8(_nullToString(rs.getString("GUAR_TERM_YRS_8")));
					_spPrdData.setGUAR_TERM_YRS_9(_nullToString(rs.getString("GUAR_TERM_YRS_9")));
					_spPrdData.setGUAR_TERM_YRS_10(_nullToString(rs.getString("GUAR_TERM_YRS_10")));
					_spPrdData.setM27B_FIN_RPT_IND(_nullToString(rs.getString("M27B_FIN_RPT_IND")));
					_spPrdData.setOWN_AGE_IND(_nullToString(rs.getString("OWN_AGE_IND")));
					_spPrdData.setPAY_NET_ISS_GROSS_IND(_nullToString(rs.getString("PAY_NET_ISS_GROSS_IND")));
					_spPrdData.setNET_COMM_IND(_nullToString(rs.getString("NET_COMM_IND")));
					_spPrdData.setCOMM_PREM_TTLS_IND(_nullToString(rs.getString("COMM_PREM_TTLS_IND")));
					_spPrdData.setAGENCY_NEW_POL_CARD_IND(_nullToString(rs.getString("AGENCY_NEW_POL_CARD_IND")));
					_spPrdData.setROLLING_CHARGEBACK_IND(_nullToString(rs.getString("ROLLING_CHARGEBACK_IND")));
					_spPrdData.setAPA_IND(_nullToString(rs.getString("APA_IND")));
					_spPrdData.setCASH_VAL_CALC(_nullToString(rs.getString("CASH_VAL_CALC")));
					_spPrdData.setUSE_APA_YIELD_IND(_nullToString(rs.getString("USE_APA_YIELD_IND")));
					_spPrdData.setMONTH_INCOME_RT_GRP(_nullToString(rs.getString("MONTH_INCOME_RT_GRP")));
					_spPrdData.setMONTH_INCOME_GRP(_nullToString(rs.getString("MONTH_INCOME_GRP")));
					_spPrdData.setWACHOVIA_IND(_nullToString(rs.getString("WACHOVIA_IND")));
					_spPrdData.setULTRA_MYG_IND(_nullToString(rs.getString("ULTRA_MYG_IND")));
					_spPrdData.setSRA_IND(_nullToString(rs.getString("SRA_IND")));
					_spPrdData.setCONSTELLATION_IND(_nullToString(rs.getString("CONSTELLATION_IND")));
					_spPrdData.setSTERLING_IND(_nullToString(rs.getString("STERLING_IND")));
					_spPrdData.setIDX_ANNUITY_IND(_nullToString(rs.getString("IDX_ANNUITY_IND")));
					_spPrdData.setSPIA_SUPP_CON_IND(_nullToString(rs.getString("SPIA_SUPP_CON_IND")));
					_spPrdData.setSTATUTORY_TAX_SPEC_RT_IND(_nullToString(rs.getString("STATUTORY_TAX_SPEC_RT_IND")));
					_spPrdData.setPRT_QTR_END_SURR_VAL_IND(_nullToString(rs.getString("PRT_QTR_END_SURR_VAL_IND")));
					_spPrdData.setSAP_PRODUCT_CD(_nullToString(rs.getString("SAP_PRODUCT_CD")));
					_spPrdData.setCOMPANY_ALPHA(_nullToString(rs.getString("COMPANY_ALPHA")));
					_spPrdData.setSYSTEM_ID(_nullToString(rs.getString("SYSTEM_ID")));
					_spPrdData.setCUSIP(_nullToString(rs.getString("CUSIP")));

					SpPrdDataList.add(_spPrdData);


				}

				//logger.info(" SpPrdDataList.size() DAO" + SpPrdDataList.size());
				System.out.println(" SpPrdDataList.size() DAO" + SpPrdDataList.size());



		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (rs != null) {
				rs.close();
			}

			if (callableStatement != null) {
				callableStatement.close();
			}

			if (_dBCon != null) {
				_dBCon.close();
			}

		}

		return SpPrdDataList;
	}



	private String _nullToString(String sInString)
	  {
	    if(sInString == null)
	    {
	      return "";
	    }
	    return sInString;
	  }



	@Override
	public List<com.oasys.model.SpProductFeeData> SpProductFeeData(String _cusipID) throws SQLException {

		ArrayList<SpProductFeeData> SpPrdFeeDataList = new ArrayList<SpProductFeeData>();

		try {

				String storedProcQuery = "BEGIN PORTAL_ADMIN.sp_product_fee(?,?); END;";
				_dBCon = con.getConnection();
				//_dBCon = DBConnection.getDBConnection();

			    callableStatement = _dBCon.prepareCall (storedProcQuery);
			    callableStatement.setString (1, _cusipID);
			    callableStatement.registerOutParameter (2, OracleTypes.CURSOR);

			    callableStatement.execute ();

			    rs = (ResultSet)callableStatement.getObject (2);

				while (rs.next ()) {


					SpProductFeeData _spPrdFeeData = new SpProductFeeData();

					_spPrdFeeData.setCOMPANY(_nullToString(rs.getString("COMPANY")));
					_spPrdFeeData.setFEE_ID(_nullToString(rs.getString("FEE_ID")));
					_spPrdFeeData.setPROD_CUSIP(_nullToString(rs.getString("PROD_CUSIP")));
					_spPrdFeeData.setREC_TYPE(_nullToString(rs.getString("REC_TYPE")));
					_spPrdFeeData.setSTART_DT(_nullToString(rs.getDate("START_DT").toString()));
					_spPrdFeeData.setEND_DT(_nullToString(rs.getDate("END_DT").toString()));
					_spPrdFeeData.setFEE_DESC(_nullToString(rs.getString("FEE_DESC")));
					_spPrdFeeData.setFEE_GEN_MSG(_nullToString(rs.getString("FEE_GEN_MSG")));
					_spPrdFeeData.setFEE_TYPE_CAT(_nullToString(rs.getString("FEE_TYPE_CAT")));
					_spPrdFeeData.setFEE_PRESENT_IN(_nullToString(rs.getString("FEE_PRESENT_IN")));
					_spPrdFeeData.setSYSTEM_ID(_nullToString(rs.getString("SYSTEM_ID")));
					_spPrdFeeData.setCOMPANY_ALPHA(_nullToString(rs.getString("COMPANY_ALPHA")));

					SpPrdFeeDataList.add(_spPrdFeeData);


				}

				//logger.info(" SpPrdFeeDataList.size() DAO" + SpPrdFeeDataList.size());
				System.out.println(" SpPrdFeeDataList.size() DAO" + SpPrdFeeDataList.size());



		} catch (SQLException e) {

			System.out.println(e.getMessage());


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (rs != null) {
				rs.close();
			}

			if (callableStatement != null) {
				callableStatement.close();
			}

			if (_dBCon != null) {
				_dBCon.close();
			}

		}

		return SpPrdFeeDataList;
	}



	@Override
	public List<SpProductRiderFund> SpProductRiderFundData(String _cusipID) throws SQLException {

			ArrayList<SpProductRiderFund> SpPrdRdrFndDataList = new ArrayList<SpProductRiderFund>();

		try {

				String storedProcQuery = "BEGIN PORTAL_ADMIN.sp_product_rider_fund(?,?); END;";
				_dBCon = con.getConnection();
				//_dBCon = DBConnection.getDBConnection();

			    callableStatement = _dBCon.prepareCall (storedProcQuery);
			    callableStatement.setString (1, _cusipID);
			    callableStatement.registerOutParameter (2, OracleTypes.CURSOR);

			    callableStatement.execute ();

			    rs = (ResultSet)callableStatement.getObject (2);
				while (rs.next ()) {


					SpProductRiderFund _spPrdRdrFnd = new SpProductRiderFund();

					_spPrdRdrFnd.setCOMPANY(_nullToString(rs.getString("COMPANY")));
					_spPrdRdrFnd.setFEE_ID(_nullToString(rs.getString("FEE_ID")));
					_spPrdRdrFnd.setPROD_CUSIP(_nullToString(rs.getString("PROD_CUSIP")));
					_spPrdRdrFnd.setREC_TYPE(_nullToString(rs.getString("REC_TYPE")));
					_spPrdRdrFnd.setSTART_DT(_nullToString(rs.getDate("START_DT").toString()));
					_spPrdRdrFnd.setEND_DT(_nullToString(rs.getDate("END_DT").toString()));
					_spPrdRdrFnd.setPROD_DESC_CD(_nullToString(rs.getString("PROD_DESC_CD")));
					_spPrdRdrFnd.setFEE_NAME(_nullToString(rs.getString("FEE_NAME")));
					_spPrdRdrFnd.setFEE_MODE(_nullToString(rs.getString("FEE_MODE")));
					_spPrdRdrFnd.setPPFA_FEAT_CD(_nullToString(rs.getString("PPFA_FEAT_CD")));
					_spPrdRdrFnd.setPPFA_CARR_FACING_DESC(_nullToString(rs.getString("PPFA_CARR_FACING_DESC")));
					_spPrdRdrFnd.setFEAT_OPT_CD(_nullToString(rs.getString("FEAT_OPT_CD")));
					_spPrdRdrFnd.setFEAT_OPT_NAME(_nullToString(rs.getString("FEAT_OPT_NAME")));
					_spPrdRdrFnd.setSCHED_YRS(_nullToString(rs.getString("SCHED_YRS")));
					_spPrdRdrFnd.setFEAT_SCHED(_nullToString(rs.getString("FEAT_SCHED")));
					_spPrdRdrFnd.setFEE_PCT(_nullToString(rs.getString("FEE_PCT")));
					_spPrdRdrFnd.setMIN_PCT(_nullToString(rs.getString("MIN_PCT")));
					_spPrdRdrFnd.setMAX_PCT(_nullToString(rs.getString("MAX_PCT")));
					_spPrdRdrFnd.setMIN_PREM_AMT(_nullToString(rs.getString("MIN_PREM_AMT")));
					_spPrdRdrFnd.setMAX_PREM_AMT(_nullToString(rs.getString("MAX_PREM_AMT")));
					_spPrdRdrFnd.setMIN_YR(_nullToString(rs.getString("MIN_YR")));
					_spPrdRdrFnd.setMAX_YR(_nullToString(rs.getString("MAX_YR")));
					_spPrdRdrFnd.setFEE_BASED_ON(_nullToString(rs.getString("FEE_BASED_ON")));
					_spPrdRdrFnd.setSTATE_APPR(_nullToString(rs.getString("STATE_APPR")));
					_spPrdRdrFnd.setSTATUS(_nullToString(rs.getString("STATUS")));
					_spPrdRdrFnd.setWEB_MSG(_nullToString(rs.getString("WEB_MSG")));
					_spPrdRdrFnd.setSYSTEM_ID(_nullToString(rs.getString("SYSTEM_ID")));
					_spPrdRdrFnd.setCOMPANY_ALPHA(_nullToString(rs.getString("COMPANY_ALPHA")));

					SpPrdRdrFndDataList.add(_spPrdRdrFnd);

				}

				//logger.info(" SpPrdRdrFndDataList.size() DAO" + SpPrdRdrFndDataList.size());
				System.out.println(" SpPrdRdrFndDataList.size() DAO" + SpPrdRdrFndDataList.size());


		} catch (SQLException e) {

			System.out.println(e.getMessage());


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (rs != null) {
				rs.close();
			}

			if (callableStatement != null) {
				callableStatement.close();
			}

			if (_dBCon != null) {
				_dBCon.close();
			}

		}

		return SpPrdRdrFndDataList;
	}



	@Override
	public List<SpAgent> SpAgentData(String _pAgency) throws SQLException {

		ArrayList<SpAgent> spAgentList = new ArrayList<SpAgent>();

		try {

				String storedProcQuery = "BEGIN portal_admin.sp_agent(?,?); END;";
				_dBCon = con.getConnection();
				//_dBCon = DBConnection.getDBConnection();

			    callableStatement = _dBCon.prepareCall (storedProcQuery);
			    callableStatement.setString (1, _pAgency);
			    callableStatement.registerOutParameter (2, OracleTypes.CURSOR);

			    callableStatement.execute ();

			    rs = (ResultSet)callableStatement.getObject (2);
				while (rs.next ()) {

					SpAgent _spAgent = new SpAgent();


					_spAgent.setCOMP_AGT_KEY(_nullToString(rs.getString("COMP_AGT_KEY")));
					_spAgent.setCOMPANY(_nullToString(rs.getString("COMPANY")));
					_spAgent.setAGENCY(_nullToString(rs.getString("AGENCY")));
					_spAgent.setAGENT(_nullToString(rs.getString("AGENT")));
					_spAgent.setAGENT_TYPE(_nullToString(rs.getString("AGENT_TYPE")));
					_spAgent.setAGENT_TYPE_2(_nullToString(rs.getString("AGENT_TYPE_2")));
					_spAgent.setREGION(_nullToString(rs.getString("REGION")));
					_spAgent.setTERRITORY(_nullToString(rs.getString("TERRITORY")));
					_spAgent.setNAME_LAST(_nullToString(rs.getString("NAME_LAST")));
					_spAgent.setNAME_FIRST(_nullToString(rs.getString("NAME_FIRST")));
					_spAgent.setNAME_MIDDLE(_nullToString(rs.getString("NAME_MIDDLE")));
					_spAgent.setNAME_2(_nullToString(rs.getString("NAME_2")));
					_spAgent.setADDR_1(_nullToString(rs.getString("ADDR_1")));
					_spAgent.setADDR_2(_nullToString(rs.getString("ADDR_2")));
					_spAgent.setADDR_3(_nullToString(rs.getString("ADDR_3")));
					_spAgent.setCITY(_nullToString(rs.getString("CITY")));
					_spAgent.setSTATE(_nullToString(rs.getString("STATE")));
					_spAgent.setZIP(_nullToString(rs.getString("ZIP")));
					_spAgent.setPHONE_NBR(_nullToString(rs.getString("PHONE_NBR")));
					_spAgent.setTAX_ID(_nullToString(rs.getString("TAX_ID")));
					_spAgent.setLIC_STATUS(_nullToString(rs.getString("LIC_STATUS")));
					_spAgent.setCOMM_STATUS(_nullToString(rs.getString("COMM_STATUS")));
					_spAgent.setMGA_AGENT_CD(_nullToString(rs.getString("MGA_AGENT_CD")));
					_spAgent.setSMGA_AGENT_CD_1(_nullToString(rs.getString("SMGA_AGENT_CD_1")));
					_spAgent.setSMGA_AGENT_CD_2(_nullToString(rs.getString("SMGA_AGENT_CD_2")));
					_spAgent.setSMGA_AGENT_CD_3(_nullToString(rs.getString("SMGA_AGENT_CD_3")));
					_spAgent.setLICENSE_DT(_nullToString(rs.getString("LICENSE_DT")));
					_spAgent.setTERM_LIC_DT(_nullToString(rs.getString("TERM_LIC_DT")));
					_spAgent.setLAST_MAINT_DT(_nullToString(rs.getString("LAST_MAINT_DT")));
					_spAgent.setRESIDENT_STATE(_nullToString(rs.getString("RESIDENT_STATE")));
					_spAgent.setTEAM_NBR(_nullToString(rs.getString("TEAM_NBR")));
					_spAgent.setBANK_LEVEL_CD(_nullToString(rs.getString("BANK_LEVEL_CD")));
					_spAgent.setPRODUCER_TYPE(_nullToString(rs.getString("PRODUCER_TYPE")));
					_spAgent.setALT_ADDR_LINE_1(_nullToString(rs.getString("ALT_ADDR_LINE_1")));
					_spAgent.setALT_ADDR_LINE_2(_nullToString(rs.getString("ALT_ADDR_LINE_2")));
					_spAgent.setALT_ADDR_LINE_3(_nullToString(rs.getString("ALT_ADDR_LINE_3")));
					_spAgent.setALT_CITY(_nullToString(rs.getString("ALT_CITY")));
					_spAgent.setALT_STATE(_nullToString(rs.getString("ALT_STATE")));
					_spAgent.setALT_ZIP(_nullToString(rs.getString("ALT_ZIP")));
					_spAgent.setALT_DOB(_nullToString(rs.getString("ALT_DOB")));
					_spAgent.setALT_1ST_ENTRY_DT(_nullToString(rs.getString("ALT_1ST_ENTRY_DT")));
					_spAgent.setALT_PHONE(_nullToString(rs.getString("ALT_PHONE")));
					_spAgent.setALT_FAX(_nullToString(rs.getString("ALT_FAX")));
					_spAgent.setALT_EMAIL(_nullToString(rs.getString("ALT_EMAIL")));
					_spAgent.setALT_EFEED_IND(_nullToString(rs.getString("ALT_EFEED_IND")));
					_spAgent.setBANK_NAME(_nullToString(rs.getString("BANK_NAME")));
					_spAgent.setMARKET_LEVEL_CD(_nullToString(rs.getString("MARKET_LEVEL_CD")));
					_spAgent.setFIN_OWNER_NBR(_nullToString(rs.getString("FIN_OWNER_NBR")));
					_spAgent.setSYSTEM_ID(_nullToString(rs.getString("SYSTEM_ID")));
					_spAgent.setCORPORATE_IND(_nullToString(rs.getString("CORPORATE_IND")));
					_spAgent.setFULL_NAME(_nullToString(rs.getString("FULL_NAME")));
					_spAgent.setNATIONAL_PROD_NBR(_nullToString(rs.getString("NATIONAL_PROD_NBR")));
					_spAgent.setEXEC_COMM_PD_QUAL(_nullToString(rs.getString("EXEC_COMM_PD_QUAL")));
					_spAgent.setEXEC_COMM_PD_NQUAL(_nullToString(rs.getString("EXEC_COMM_PD_NQUAL")));
					_spAgent.setEXEC_COMM_PD_TSA(_nullToString(rs.getString("EXEC_COMM_PD_TSA")));

					spAgentList.add(_spAgent);

				}



				//logger.info("spAgentList.size() DAO " +  spAgentList.size());
				System.out.println("spAgentList.size() DAO " +  spAgentList.size());

		} catch (SQLException e) {

			System.out.println(e.getMessage());


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (rs != null) {
				rs.close();
			}

			if (callableStatement != null) {
				callableStatement.close();
			}

			if (_dBCon != null) {
				_dBCon.close();
			}

		}

		return spAgentList;
	}

	@Override
	public List<SpProductDataCUSIP> SpProductDataCUSIP(String _cusipID) throws SQLException {

		ArrayList<SpProductDataCUSIP> spPrdDataList = new ArrayList<SpProductDataCUSIP>();

		try {

				String storedProcQuery = "BEGIN portal_admin.sp_Product_Data_CUSIP(?,?); END;";
				_dBCon = con.getConnection();
				//_dBCon = DBConnection.getDBConnection();

			    callableStatement = _dBCon.prepareCall (storedProcQuery);
			    callableStatement.setString (1, _cusipID);
			    callableStatement.registerOutParameter (2, OracleTypes.CURSOR);
			    callableStatement.execute ();
			    rs = (ResultSet)callableStatement.getObject (2);
				while (rs.next ()) {

					SpProductDataCUSIP _spPrdData = new SpProductDataCUSIP();

					_spPrdData.setCOMPANY(_nullToString(rs.getString("COMPANY")));

					_spPrdData.setPRODUCT_CD(_nullToString(rs.getString("PRODUCT_CD")));
					_spPrdData.setREC_EFF_DT_NINES_COMPLEMENT(_nullToString(rs.getString("REC_EFF_DT_NINES_COMPLEMENT")));
					_spPrdData.setEFF_DT(_nullToString(rs.getString("EFF_DT")));
					_spPrdData.setPRODUCT_DESC(_nullToString(rs.getString("PRODUCT_DESC")));
					_spPrdData.setPRODUCT_TYPE(_nullToString(rs.getString("PRODUCT_TYPE")));
					_spPrdData.setFIN_PPGA_IND(_nullToString(rs.getString("FIN_PPGA_IND")));
					_spPrdData.setRETAIL_PROPRIETARY_IND(_nullToString(rs.getString("RETAIL_PROPRIETARY_IND")));
					_spPrdData.setM2AB_FIN_RPT_IND(_nullToString(rs.getString("M2AB_FIN_RPT_IND")));
					_spPrdData.setROLLING_SURR_CHRG_IND(_nullToString(rs.getString("ROLLING_SURR_CHRG_IND")));
					_spPrdData.setMVA_IND(_nullToString(rs.getString("MVA_IND")));
					_spPrdData.setSTEPUP_IND(_nullToString(rs.getString("STEPUP_IND")));
					_spPrdData.setHAS_GUAR_PCT_REC_IND(_nullToString(rs.getString("HAS_GUAR_PCT_REC_IND")));
					_spPrdData.setMULT_GUAR_TERMS_IND(_nullToString(rs.getString("MULT_GUAR_TERMS_IND")));
					_spPrdData.setGUAR_TERM_YRS_1(_nullToString(rs.getString("GUAR_TERM_YRS_1")));
					_spPrdData.setGUAR_TERM_YRS_2(_nullToString(rs.getString("GUAR_TERM_YRS_2")));
					_spPrdData.setGUAR_TERM_YRS_3(_nullToString(rs.getString("GUAR_TERM_YRS_3")));
					_spPrdData.setGUAR_TERM_YRS_4(_nullToString(rs.getString("GUAR_TERM_YRS_4")));
					_spPrdData.setGUAR_TERM_YRS_5(_nullToString(rs.getString("GUAR_TERM_YRS_5")));
					_spPrdData.setGUAR_TERM_YRS_6(_nullToString(rs.getString("GUAR_TERM_YRS_6")));
					_spPrdData.setGUAR_TERM_YRS_7(_nullToString(rs.getString("GUAR_TERM_YRS_7")));
					_spPrdData.setGUAR_TERM_YRS_8(_nullToString(rs.getString("GUAR_TERM_YRS_8")));
					_spPrdData.setGUAR_TERM_YRS_9(_nullToString(rs.getString("GUAR_TERM_YRS_9")));
					_spPrdData.setGUAR_TERM_YRS_10(_nullToString(rs.getString("GUAR_TERM_YRS_10")));
					_spPrdData.setM27B_FIN_RPT_IND(_nullToString(rs.getString("M27B_FIN_RPT_IND")));
					_spPrdData.setOWN_AGE_IND(_nullToString(rs.getString("OWN_AGE_IND")));
					_spPrdData.setPAY_NET_ISS_GROSS_IND(_nullToString(rs.getString("PAY_NET_ISS_GROSS_IND")));
					_spPrdData.setNET_COMM_IND(_nullToString(rs.getString("NET_COMM_IND")));
					_spPrdData.setCOMM_PREM_TTLS_IND(_nullToString(rs.getString("COMM_PREM_TTLS_IND")));
					_spPrdData.setAGENCY_NEW_POL_CARD_IND(_nullToString(rs.getString("AGENCY_NEW_POL_CARD_IND")));
					_spPrdData.setROLLING_CHARGEBACK_IND(_nullToString(rs.getString("ROLLING_CHARGEBACK_IND")));
					_spPrdData.setAPA_IND(_nullToString(rs.getString("APA_IND")));
					_spPrdData.setCASH_VAL_CALC(_nullToString(rs.getString("CASH_VAL_CALC")));
					_spPrdData.setUSE_APA_YIELD_IND(_nullToString(rs.getString("USE_APA_YIELD_IND")));
					_spPrdData.setMONTH_INCOME_RT_GRP(_nullToString(rs.getString("MONTH_INCOME_RT_GRP")));
					_spPrdData.setMONTH_INCOME_GRP(_nullToString(rs.getString("MONTH_INCOME_GRP")));
					_spPrdData.setWACHOVIA_IND(_nullToString(rs.getString("WACHOVIA_IND")));
					_spPrdData.setULTRA_MYG_IND(_nullToString(rs.getString("ULTRA_MYG_IND")));
					_spPrdData.setSRA_IND(_nullToString(rs.getString("SRA_IND")));
					_spPrdData.setCONSTELLATION_IND(_nullToString(rs.getString("CONSTELLATION_IND")));
					_spPrdData.setSTERLING_IND(_nullToString(rs.getString("STERLING_IND")));
					_spPrdData.setIDX_ANNUITY_IND(_nullToString(rs.getString("IDX_ANNUITY_IND")));
					_spPrdData.setSPIA_SUPP_CON_IND(_nullToString(rs.getString("SPIA_SUPP_CON_IND")));
					_spPrdData.setSTATUTORY_TAX_SPEC_RT_IND(_nullToString(rs.getString("STATUTORY_TAX_SPEC_RT_IND")));
					_spPrdData.setPRT_QTR_END_SURR_VAL_IND(_nullToString(rs.getString("PRT_QTR_END_SURR_VAL_IND")));
					_spPrdData.setSAP_PRODUCT_CD(_nullToString(rs.getString("SAP_PRODUCT_CD")));
					_spPrdData.setCOMPANY_ALPHA(_nullToString(rs.getString("COMPANY_ALPHA")));
					_spPrdData.setSYSTEM_ID(_nullToString(rs.getString("SYSTEM_ID")));
					_spPrdData.setCUSIP(_nullToString(rs.getString("CUSIP")));

					spPrdDataList.add(_spPrdData);

				}

				//logger.info("spPrdDataList.size() DAO " +  spPrdDataList.size());
				System.out.println("spPrdDataList.size() DAO " +  spPrdDataList.size());

		} catch (SQLException e) {

			System.out.println(e.getMessage());


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (rs != null) {
				rs.close();
			}

			if (callableStatement != null) {
				callableStatement.close();
			}

			if (_dBCon != null) {
				_dBCon.close();
			}

		}

		return spPrdDataList;
	}




}
