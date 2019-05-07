package com.aap.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class CustomerDetails {
	 @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private int customerNo;
	private String firstName;
	private String middleName;
	private String  lastName;
	private String firstAdress;
	private String secondAdress;
	private String gender;
	private Date dateOfBirth;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	private String primaryContact;
	private String sceondaryContact;
	private String email;
	private Date createdOn;
	private Date modifiedOn;
	

	@JsonManagedReference
	@OneToMany(mappedBy= "customerDetails",cascade= CascadeType.ALL)
	private List<PropertyDetails> propertyDetails;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstAdress() {
		return firstAdress;
	}
	public void setFirstAdress(String firstAdress) {
		this.firstAdress = firstAdress;
	}
	public String getSecondAdress() {
		return secondAdress;
	}
	public void setSecondAdress(String secondAdress) {
		this.secondAdress = secondAdress;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPrimaryContact() {
		return primaryContact;
	}
	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}
	public String getSceondaryContact() {
		return sceondaryContact;
	}
	public void setSceondaryContact(String sceondaryContact) {
		this.sceondaryContact = sceondaryContact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public List<PropertyDetails> getPropertyDetails() {
		return propertyDetails;
	}
	public void setPropertyDetails(List<PropertyDetails> propertyDetails) {
		this.propertyDetails = propertyDetails;
	}
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	
	
	
}
