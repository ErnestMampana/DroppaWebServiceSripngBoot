package com.droppa.services.spring.droppaclone.models;

import com.droppa.services.spring.droppaclone.enums.AccountStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	@OneToOne
	private Person person;
	private boolean confirmed;
	private int otp;
	private AccountStatus status;
	private String password;
	private String token;

	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAccount(int id, String email, Person person, boolean confirmed, int otp, AccountStatus status,
			String password, String token) {
		super();
		this.id = id;
		this.email = email;
		this.person = person;
		this.confirmed = confirmed;
		this.otp = otp;
		this.status = status;
		this.password = password;
		this.token = token;
	}

	public UserAccount(String email, Person person, boolean confirmed, int otp, AccountStatus status, String password,
			String token) {
		super();
		this.email = email;
		this.person = person;
		this.confirmed = confirmed;
		this.otp = otp;
		this.status = status;
		this.password = password;
		this.token = token;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Person getOwner() {
		return person;
	}

	public void setOwner(Person person) {
		this.person = person;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}