/**
 * 
 */
package com.droppa.services.spring.droppaclone.models;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @author Ernest Mampana
 *
 */
@Entity
public class VehicleDriver {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String name;
	private String surname;
	private long celphone;
	private byte[] driverLicence;

	public VehicleDriver() {
		super();
	}
	
	

	public VehicleDriver(String email, String name, String surname, long celphone, byte[] driverLicence) {
		super();
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.celphone = celphone;
		this.driverLicence = driverLicence;
	}



	public VehicleDriver(int id, String email, String name, String surname, long celphone, byte[] driverLicence) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.celphone = celphone;
		this.driverLicence = driverLicence;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public long getCelphone() {
		return celphone;
	}

	public void setCelphone(long celphone) {
		this.celphone = celphone;
	}

	public byte[] getDriverLicence() {
		return driverLicence;
	}

	public void setDriverLicence(byte[] driverLicence) {
		this.driverLicence = driverLicence;
	}

	@Override
	public String toString() {
		return "VehicleDriver [id=" + id + ", email=" + email + ", name=" + name + ", surname=" + surname
				+ ", celphone=" + celphone + ", driverLicence=" + Arrays.toString(driverLicence) + ", vehicles=" + "]";
	}

}
