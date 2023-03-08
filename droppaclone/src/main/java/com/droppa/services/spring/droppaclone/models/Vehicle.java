package com.droppa.services.spring.droppaclone.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String registration;
	private String make;
	private String type;
	private LocalDate discExpiryDate;
	@OneToOne
	private DriverAccount drivers;
	@OneToOne
	private Company company;

	public Vehicle() {
		super();
	}

	public Vehicle(String registration, String make, String type, LocalDate discExpiryDate, DriverAccount drivers,
			Company company) {
		super();
		this.registration = registration;
		this.make = make;
		this.type = type;
		this.discExpiryDate = discExpiryDate;
		this.drivers = drivers;
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getDiscExpiryDate() {
		return discExpiryDate;
	}

	public void setDiscExpiryDate(LocalDate discExpiryDate) {
		this.discExpiryDate = discExpiryDate;
	}

	public DriverAccount getDrivers() {
		return drivers;
	}

	public void setDrivers(DriverAccount drivers) {
		this.drivers = drivers;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", registration=" + registration + ", make=" + make + ", type=" + type
				+ ", discExpiryDate=" + discExpiryDate + ", drivers=" + drivers + ", company=" + company + "]";
	}

}
