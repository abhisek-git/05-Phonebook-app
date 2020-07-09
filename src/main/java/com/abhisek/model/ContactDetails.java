package com.abhisek.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CONTACT_DTLS")
public class ContactDetails implements Serializable {
	private static final long serialVersionUID = -5839384246347465307L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTACT_ID")
	private Integer contactId;
	@Column(name = "CONTACT_NAME")
	private String contactName;
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	@Column(name = "CONTACT_NUMBER")
	private BigInteger contactNumber;
	@Column(name = "CREATED_DT",updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	@Column(name = "UPDATED_DT",insertable = false)
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updatedDate;

}
