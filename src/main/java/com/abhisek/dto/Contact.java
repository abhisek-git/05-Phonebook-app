package com.abhisek.dto;

import java.math.BigInteger;
import java.util.Date;

import lombok.Data;

@Data
public class Contact {
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private BigInteger contactNumber;
	private Date createdDate;
	private Date updatedDate;

}
