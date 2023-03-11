package com.droppa.services.spring.droppaclone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String surname;
	private String celphone;
	private double walletBalance;
	private String email;

	public Person() {
		super();
	}

	public Person(int id, String userName, String surname, String celphone, double walletBalance, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.surname = surname;
		this.celphone = celphone;
		this.walletBalance = walletBalance;
		this.email = email;
	}
	
	

	public Person(String userName, String surname, String celphone, double walletBalance, String email) {
		super();
		this.userName = userName;
		this.surname = surname;
		this.celphone = celphone;
		this.walletBalance = walletBalance;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCelphone() {
		return celphone;
	}

	public void setCelphone(String celphone) {
		this.celphone = celphone;
	}

	public double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", userName=" + userName + ", surname=" + surname + ", celphone=" + celphone
				+ ", walletBalance=" + walletBalance + "]";
	}
}
