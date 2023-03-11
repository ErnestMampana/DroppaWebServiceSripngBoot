/**
 * 
 */
package com.droppa.services.spring.droppaclone.models;

import com.droppa.services.spring.droppaclone.enums.BookingStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/**
 * @author Ernest Mampana
 *
 */
@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bookingId;
	@OneToOne
	private Adress adressDetails;
	private String userId;
	@OneToOne
	private DropDetails dropDetails;
	private String bookingDate;
	private double price;
	private String assinedDriver;
	private BookingStatus status;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(String bookingId, Adress adressDetails, String userId, DropDetails dropDetails, String bookingDate,
			double price, String assinedDriver, BookingStatus status) {
		super();
		this.bookingId = bookingId;
		this.adressDetails = adressDetails;
		this.userId = userId;
		this.dropDetails = dropDetails;
		this.bookingDate = bookingDate;
		this.price = price;
		this.assinedDriver = assinedDriver;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public Adress getAdressDetails() {
		return adressDetails;
	}

	public void setAdressDetails(Adress adressDetails) {
		this.adressDetails = adressDetails;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public DropDetails getDropDetails() {
		return dropDetails;
	}

	public void setDropDetails(DropDetails dropDetails) {
		this.dropDetails = dropDetails;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAssinedDriver() {
		return assinedDriver;
	}

	public void setAssinedDriver(String assinedDriver) {
		this.assinedDriver = assinedDriver;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

}
