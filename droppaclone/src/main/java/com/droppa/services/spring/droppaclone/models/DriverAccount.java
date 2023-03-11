package com.droppa.services.spring.droppaclone.models;

import com.droppa.services.spring.droppaclone.enums.AccountStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class DriverAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	private boolean isConfirmed;
	@OneToOne
	private Vehicle vehicle;
	@OneToOne
	private VehicleDriver driver;
	private AccountStatus status;

	public DriverAccount() {
		super();
	}

	public DriverAccount(String email, String password, boolean isConfirmed, Vehicle vehicle, VehicleDriver driver,
			AccountStatus status) {
		super();
		this.email = email;
		this.password = password;
		this.isConfirmed = isConfirmed;
		this.vehicle = vehicle;
		this.driver = driver;
		this.status = status;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public VehicleDriver getDriver() {
		return driver;
	}

	public void setDriver(VehicleDriver driver) {
		this.driver = driver;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

}
