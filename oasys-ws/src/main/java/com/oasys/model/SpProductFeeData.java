package com.oasys.model;

public class SpProductFeeData {

	String COMPANY; 
	String FEE_ID; 
	String PROD_CUSIP; 
	String REC_TYPE; 
	String START_DT;
	String END_DT;
	String FEE_DESC; 
	String FEE_GEN_MSG; 
	String FEE_TYPE_CAT; 
	String FEE_PRESENT_IN;
	String SYSTEM_ID; 
	String COMPANY_ALPHA;
	
	/*@Override
	public String toString() {
		return "{COMPANY = " + COMPANY  + 
	", FEE_ID = " + FEE_ID  + 
	", PROD_CUSIP = " + PROD_CUSIP  + 
	", REC_TYPE = " + REC_TYPE  + 
	", START_DT = " + START_DT + 
	", END_DT = " + END_DT + 
	", FEE_DESC = " + FEE_DESC  + 
	", FEE_GEN_MSG = " + FEE_GEN_MSG  + 
	", FEE_TYPE_CAT = " + FEE_TYPE_CAT  + 
	", FEE_PRESENT_IN = " + FEE_PRESENT_IN + 
	", SYSTEM_ID = " + SYSTEM_ID  + 
	", COMPANY_ALPHA = " + COMPANY_ALPHA + "}";
	}*/

	
	public String getCOMPANY() {
		return COMPANY;
	}
	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}
	public String getFEE_ID() {
		return FEE_ID;
	}
	public void setFEE_ID(String fEE_ID) {
		FEE_ID = fEE_ID;
	}
	public String getPROD_CUSIP() {
		return PROD_CUSIP;
	}
	public void setPROD_CUSIP(String pROD_CUSIP) {
		PROD_CUSIP = pROD_CUSIP;
	}
	public String getREC_TYPE() {
		return REC_TYPE;
	}
	public void setREC_TYPE(String rEC_TYPE) {
		REC_TYPE = rEC_TYPE;
	}
	public String getSTART_DT() {
		return START_DT;
	}
	public void setSTART_DT(String sTART_DT) {
		START_DT = sTART_DT;
	}
	public String getEND_DT() {
		return END_DT;
	}
	public void setEND_DT(String eND_DT) {
		END_DT = eND_DT;
	}
	public String getFEE_DESC() {
		return FEE_DESC;
	}
	public void setFEE_DESC(String fEE_DESC) {
		FEE_DESC = fEE_DESC;
	}
	public String getFEE_GEN_MSG() {
		return FEE_GEN_MSG;
	}
	public void setFEE_GEN_MSG(String fEE_GEN_MSG) {
		FEE_GEN_MSG = fEE_GEN_MSG;
	}
	public String getFEE_TYPE_CAT() {
		return FEE_TYPE_CAT;
	}
	public void setFEE_TYPE_CAT(String fEE_TYPE_CAT) {
		FEE_TYPE_CAT = fEE_TYPE_CAT;
	}
	public String getFEE_PRESENT_IN() {
		return FEE_PRESENT_IN;
	}
	public void setFEE_PRESENT_IN(String fEE_PRESENT_IN) {
		FEE_PRESENT_IN = fEE_PRESENT_IN;
	}
	public String getSYSTEM_ID() {
		return SYSTEM_ID;
	}
	public void setSYSTEM_ID(String sYSTEM_ID) {
		SYSTEM_ID = sYSTEM_ID;
	}
	public String getCOMPANY_ALPHA() {
		return COMPANY_ALPHA;
	}
	public void setCOMPANY_ALPHA(String cOMPANY_ALPHA) {
		COMPANY_ALPHA = cOMPANY_ALPHA;
	}

	
}
