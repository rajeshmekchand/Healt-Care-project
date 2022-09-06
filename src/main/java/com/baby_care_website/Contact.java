package com.baby_care_website;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Contact {
	@Id
	@GeneratedValue
	private int id;
	private String fullname;
	private String email;
	private String subject;
	private String message;
	@Override
	public String toString() {
		return "Contact [id=" + id + ", fullname=" + fullname + ", email=" + email + ", subject=" + subject
				+ ", message=" + message + ", getId()=" + getId() + ", getFullname()=" + getFullname() + ", getEmail()="
				+ getEmail() + ", getSubject()=" + getSubject() + ", getMessage()=" + getMessage() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

}
