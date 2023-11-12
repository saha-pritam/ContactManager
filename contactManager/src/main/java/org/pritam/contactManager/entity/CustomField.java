package org.pritam.contactManager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="customfields")
public class CustomField {
	@Id
	@Column(name="customfieldid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customFieldId;
	@Column(name="customfield")
	private String customField;
	@Column(name="customfieldlabel")
	private String customFieldLabel;
	@Column(name="contactid")
	private int contactId;
	
	public CustomField() {
	}
	
	public CustomField(String customField, String customFieldLabel, int contactId) {
		super();
		this.customField = customField;
		this.customFieldLabel = customFieldLabel;
		this.contactId = contactId;
	}
}
