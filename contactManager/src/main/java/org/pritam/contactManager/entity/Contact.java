package org.pritam.contactManager.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="contacts")
@Data
public class Contact {
	@Id
	@Column(name="contactid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int contactid;
	@Column(name="namepreffix")
	private String namePreffix;
	@Column(name="firstname")
	private String firstName;
	@Column(name="middlename")
	private String middleName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="namesuffix")
	private String nameSuffix;
	@Column(name="company")
	private String company;
	@Column(name="phone")
	private String phone;
	@Column(name="mobile")
	private String mobile;
	@Column(name="email")
	private String email;
	@Column(name="birthday")
	private Date birthday;
	@Column(name="imagePath")
	private String imagePath;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userid", referencedColumnName = "userid")
	private User user;
	
	public Contact(){
	}

	public Contact(String namePreffix, String firstName, String middleName, String lastName, String nameSuffix,
			String company, String phone, String mobile, String email, Date birthday, String imagePath) {
		super();
		this.namePreffix = namePreffix;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.nameSuffix = nameSuffix;
		this.company = company;
		this.phone = phone;
		this.mobile = mobile;
		this.email = email;
		this.birthday = birthday;
		this.imagePath = imagePath;
	}
}
