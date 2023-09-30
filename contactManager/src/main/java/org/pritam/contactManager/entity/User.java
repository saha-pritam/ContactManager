package org.pritam.contactManager.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name="users")
@Data
public class User {
	@Id
	@Column(name="userid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="description")
	private String description;
	@Column(name="role")
	private String role;
	@Column(name="enabled")
	private boolean enabled;
	@Column(name="imagePath")
	private String imagePath;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	List<Contact> contacts = new ArrayList<Contact>();
	
	public User(){	
	}

	public User(String firstName, String lastName, String email, String password, String description, String role,
			boolean enabled, String imagePath) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.description = description;
		this.role = role;
		this.enabled = enabled;
		this.imagePath = imagePath;
	}
}
