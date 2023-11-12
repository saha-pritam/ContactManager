package org.pritam.contactManager.entity;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="contacts")
@Data
public class Contact {
	@Id
	@Column(name="contactid")
	@JsonProperty("")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int contactid;
	
	@JsonProperty("namePrefix")
	@Column(name="nameprefix")
	private String namePrefix;
	
	@JsonProperty("firstName")
	@Column(name="firstname")
	private String firstName;
	
	@JsonProperty("middleName")
	@Column(name="middlename")
	private String middleName;
	
	@JsonProperty("surname")
	@Column(name="surname")
	private String surname;
	
	@JsonProperty("nameSuffix")
	@Column(name="namesuffix")
	private String nameSuffix;
	
	@JsonProperty("phoneticSurname")
	@Column(name="phoneticsurname")
	private String phoneticSurname;
	
	@JsonProperty("phoneticMiddleName")
	@Column(name="phoneticmiddlename")
	private String phoneticMiddleName;
	
	@JsonProperty("phoneticFirstName")
	@Column(name="phoneticfirstname")
	private String phoneticFirstName;
	
	@JsonProperty("nickname")
	@Column(name="nickname")
	private String nickname;
	
	@JsonProperty("fileAs")
	@Column(name="fileas")
	private String fileAs;
	
	@JsonProperty("company")
	@Column(name="company")
	private String company;
	
	@JsonProperty("department")
	@Column(name="department")
	private String department;
	
	@JsonProperty("title")
	@Column(name="title")
	private String title;
	
	@JsonProperty("phone")
	@Column(name="phone")
	private String phone;
	
	@JsonProperty("phoneLabel")
	@Column(name="phonelabel")
	private String phoneLabel;
	
	@JsonProperty("email")
	@Column(name="email")
	private String email;
	
	@JsonProperty("emailLabel")
	@Column(name="emaillabel")
	private String emailLabel;
	
	@JsonProperty("address")
	@Column(name="address")
	private String address;
	
	@JsonProperty("addressLabel")
	@Column(name="addresslabel")
	private String addressLabel;
	
	@JsonProperty("website")
	@Column(name="website")
	private String website;
	
	@JsonProperty("significantDate")
	@Column(name="significantdate")
	private String significantDate;
	
	@JsonProperty("significantDateLabel")
	@Column(name="significantdatelabel")
	private String significantDateLabel;
	
	@JsonProperty("relatedPerson")
	@Column(name="relatedperson")
	private String relatedPerson;
	
	@JsonProperty("relatedPersonLabel")
	@Column(name="relatedpersonlabel")
	private String relatedPersonLabel;
	
	@JsonProperty("sip")
	@Column(name="sip")
	private String sip;
	
	@JsonProperty("notes")
	@Column(name="notes")
	private String notes;
	
	@JsonProperty("userId")
	@Column(name="userid")
	private int userId;
	
	@Column(name="imagename")
	private String imageName;
	
	public String toNullIfEmpty(String s) {
		if(s.length()==0)
			return null;
		return s;
	}
	
	public Contact(){
	}

	public Contact(Map<String, String> map, int userId) {
		this.namePrefix = toNullIfEmpty(map.get("namePrefix"));
		this.firstName = toNullIfEmpty(map.get("firstName"));
		this.middleName = toNullIfEmpty(map.get("middleName"));
		this.surname = toNullIfEmpty(map.get("surname"));
		this.nameSuffix = toNullIfEmpty(map.get("nameSuffix"));
		this.phoneticSurname = toNullIfEmpty(map.get("phoneticSurname"));
		this.phoneticMiddleName = toNullIfEmpty(map.get("phoneticMiddleName"));
		this.phoneticFirstName = toNullIfEmpty(map.get("phoneticFirstName"));
		this.nickname = toNullIfEmpty(map.get("nickname"));
		this.fileAs = toNullIfEmpty(map.get("fileAs"));
		this.company = toNullIfEmpty(map.get("company"));
		this.department = toNullIfEmpty(map.get("department"));
		this.title = toNullIfEmpty(map.get("title"));
		this.phone = toNullIfEmpty(map.get("phone"));
		this.phoneLabel = toNullIfEmpty(map.get("phoneLabel"));
		this.email = toNullIfEmpty(map.get("email"));
		this.emailLabel = toNullIfEmpty(map.get("emailLabel"));
		this.address = toNullIfEmpty(map.get("address"));
		this.addressLabel = toNullIfEmpty(map.get("addressLabel"));
		this.website = toNullIfEmpty(map.get("website"));
		this.significantDate = toNullIfEmpty(map.get("significantDate"));
		this.significantDateLabel = toNullIfEmpty(map.get("significantDateLabel"));
		this.relatedPerson = toNullIfEmpty(map.get("relatedPerson"));
		this.relatedPersonLabel = toNullIfEmpty(map.get("relatedPersonLabel"));
		this.sip = toNullIfEmpty(map.get("sip"));
		this.notes = toNullIfEmpty(map.get("notes"));
		this.userId=userId;
	}
}
