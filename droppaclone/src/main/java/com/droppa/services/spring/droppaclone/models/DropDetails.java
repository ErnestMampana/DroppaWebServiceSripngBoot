/**
 * 
 */
package com.droppa.services.spring.droppaclone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @author Ernest Mampana
 *
 */
@Entity
public class DropDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String pickUpName;
	private String pickUpSurname;
	private String pickUpContact;

	private String dropOffName;
	private String dropOffSurname;
	private String dropOffContact;

	public DropDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DropDetails(String pickUpName, String pickUpSurname, String pickUpContact, String dropOffName,
			String dropOffSurname, String dropOffContact) {
		super();
		this.pickUpName = pickUpName;
		this.pickUpSurname = pickUpSurname;
		this.pickUpContact = pickUpContact;
		this.dropOffName = dropOffName;
		this.dropOffSurname = dropOffSurname;
		this.dropOffContact = dropOffContact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPickUpName() {
		return pickUpName;
	}

	public void setPickUpName(String pickUpName) {
		this.pickUpName = pickUpName;
	}

	public String getPickUpSurname() {
		return pickUpSurname;
	}

	public void setPickUpSurname(String pickUpSurname) {
		this.pickUpSurname = pickUpSurname;
	}

	public String getPickUpContact() {
		return pickUpContact;
	}

	public void setPickUpContact(String pickUpContact) {
		this.pickUpContact = pickUpContact;
	}

	public String getDropOffName() {
		return dropOffName;
	}

	public void setDropOffName(String dropOffName) {
		this.dropOffName = dropOffName;
	}

	public String getDropOffSurname() {
		return dropOffSurname;
	}

	public void setDropOffSurname(String dropOffSurname) {
		this.dropOffSurname = dropOffSurname;
	}

	public String getDropOffContact() {
		return dropOffContact;
	}

	public void setDropOffContact(String dropOffContact) {
		this.dropOffContact = dropOffContact;
	}

}
