package com.droppa.services.spring.droppaclone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Adress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int pickUpStandNumber;
	private String pickUpStreetName;
	private String pickUpSuburb;
	private String pickUpProvince;
	private int pickUpPostalCode;

	private int dropOffStandNumber;
	private String dropOffStreetName;
	private String dropOffSuburb;
	private String dropOffProvince;
	private int dropOffPostalCode;

	public Adress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adress(int pickUpStandNumber, String pickUpStreetName, String pickUpSuburb, String pickUpProvince,
			int pickUpPostalCode, int dropOffStandNumber, String dropOffStreetName, String dropOffSuburb,
			String dropOffProvince, int dropOffPostalCode) {
		super();
		this.pickUpStandNumber = pickUpStandNumber;
		this.pickUpStreetName = pickUpStreetName;
		this.pickUpSuburb = pickUpSuburb;
		this.pickUpProvince = pickUpProvince;
		this.pickUpPostalCode = pickUpPostalCode;
		this.dropOffStandNumber = dropOffStandNumber;
		this.dropOffStreetName = dropOffStreetName;
		this.dropOffSuburb = dropOffSuburb;
		this.dropOffProvince = dropOffProvince;
		this.dropOffPostalCode = dropOffPostalCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPickUpStandNumber() {
		return pickUpStandNumber;
	}

	public void setPickUpStandNumber(int pickUpStandNumber) {
		this.pickUpStandNumber = pickUpStandNumber;
	}

	public String getPickUpStreetName() {
		return pickUpStreetName;
	}

	public void setPickUpStreetName(String pickUpStreetName) {
		this.pickUpStreetName = pickUpStreetName;
	}

	public String getPickUpSuburb() {
		return pickUpSuburb;
	}

	public void setPickUpSuburb(String pickUpSuburb) {
		this.pickUpSuburb = pickUpSuburb;
	}

	public String getPickUpProvince() {
		return pickUpProvince;
	}

	public void setPickUpProvince(String pickUpProvince) {
		this.pickUpProvince = pickUpProvince;
	}

	public int getPickUpPostalCode() {
		return pickUpPostalCode;
	}

	public void setPickUpPostalCode(int pickUpPostalCode) {
		this.pickUpPostalCode = pickUpPostalCode;
	}

	public int getDropOffStandNumber() {
		return dropOffStandNumber;
	}

	public void setDropOffStandNumber(int dropOffStandNumber) {
		this.dropOffStandNumber = dropOffStandNumber;
	}

	public String getDropOffStreetName() {
		return dropOffStreetName;
	}

	public void setDropOffStreetName(String dropOffStreetName) {
		this.dropOffStreetName = dropOffStreetName;
	}

	public String getDropOffSuburb() {
		return dropOffSuburb;
	}

	public void setDropOffSuburb(String dropOffSuburb) {
		this.dropOffSuburb = dropOffSuburb;
	}

	public String getDropOffProvince() {
		return dropOffProvince;
	}

	public void setDropOffProvince(String dropOffProvince) {
		this.dropOffProvince = dropOffProvince;
	}

	public int getDropOffPostalCode() {
		return dropOffPostalCode;
	}

	public void setDropOffPostalCode(int dropOffPostalCode) {
		this.dropOffPostalCode = dropOffPostalCode;
	}

}
