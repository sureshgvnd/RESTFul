package com.oasys.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JSONRequest {	
	

	String _pAgency;
	String _agencyID;
	String _cusipID;
	String _pCompany;
	String _pProductCd;
	String _compPolKey;
	
	public JSONRequest(){
		
	}

	public JSONRequest(String _pAgency,String _agencyID){
		this._pAgency = _pAgency;	
		this._agencyID = _agencyID;
	}
	
	public String get_pAgency() {
		return _pAgency;
	}

	public void set_pAgency(String _pAgency) {
		this._pAgency = _pAgency;
	}

	public String get_agencyID() {
		return _agencyID;
	}

	public void set_agencyID(String _agencyID) {
		this._agencyID = _agencyID;
	}

	public String get_cusipID() {
		return _cusipID;
	}

	public void set_cusipID(String _cusipID) {
		this._cusipID = _cusipID;
	}

	public String get_pCompany() {
		return _pCompany;
	}

	public void set_pCompany(String _pCompany) {
		this._pCompany = _pCompany;
	}

	public String get_pProductCd() {
		return _pProductCd;
	}

	public void set_pProductCd(String _pProductCd) {
		this._pProductCd = _pProductCd;
	}

	public String get_compPolKey() {
		return _compPolKey;
	}

	public void set_compPolKey(String _compPolKey) {
		this._compPolKey = _compPolKey;
	}	
	

}
