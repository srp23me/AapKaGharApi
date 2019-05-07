package com.aap.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class PropertyDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int propertyNo;
	private String SurvayNo;
	private String ConstructionType;
	private String Area_in_Sqft;
	private String LandAddress;
	private String AadharNo;
	private String PanCardNo;
	private byte Adhar_Proof;
	private byte Pan_Proof;
	private int status;
	// private int customerNo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerNo")
	@JsonBackReference
	private CustomerDetails customerDetails;

	public String getSurvayNo() {
		return SurvayNo;
	}

	public void setSurvayNo(String survayNo) {
		SurvayNo = survayNo;
	}

	public String getConstructionType() {
		return ConstructionType;
	}

	public void setConstructionType(String constructionType) {
		ConstructionType = constructionType;
	}

	public String getArea_in_Sqft() {
		return Area_in_Sqft;
	}

	public void setArea_in_Sqft(String area_in_Sqft) {
		Area_in_Sqft = area_in_Sqft;
	}

	public String getLandAddress() {
		return LandAddress;
	}

	public void setLandAddress(String landAddress) {
		LandAddress = landAddress;
	}

	public String getAadharNo() {
		return AadharNo;
	}

	public void setAadharNo(String aadharNo) {
		AadharNo = aadharNo;
	}

	public String getPanCardNo() {
		return PanCardNo;
	}

	public void setPanCardNo(String panCardNo) {
		PanCardNo = panCardNo;
	}

	public byte getAdhar_Proof() {
		return Adhar_Proof;
	}

	public void setAdhar_Proof(byte adhar_Proof) {
		Adhar_Proof = adhar_Proof;
	}

	public byte getPan_Proof() {
		return Pan_Proof;
	}

	public void setPan_Proof(byte pan_Proof) {
		Pan_Proof = pan_Proof;
	}

	public int getPropertyNo() {
		return propertyNo;
	}

	public void setPropertyNo(int propertyNo) {
		this.propertyNo = propertyNo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	/*
	 * public int getCustomerNo() { return customerNo; } public void
	 * setCustomerNo(int customerNo) { this.customerNo = customerNo; }
	 */
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

}
