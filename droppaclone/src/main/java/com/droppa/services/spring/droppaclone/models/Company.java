/**
 * 
 */
package com.droppa.services.spring.droppaclone.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * @author Ernest Mampana
 *
 */
@Entity
@Table
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String companyId;
	private String companyName;
	@OneToOne
	private Person owner;
	private String location;

	public Company() {
		super();
	}

	public Company(String companyId, String companyName, Person owner, String location) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.owner = owner;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyId=" + companyId + ", companyName=" + companyName + ", owner=" + owner
				+ ", location=" + location + "]";
	}

}
