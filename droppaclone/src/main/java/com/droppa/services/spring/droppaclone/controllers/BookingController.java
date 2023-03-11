/**
 * 
 */
package com.droppa.services.spring.droppaclone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.droppa.services.spring.droppaclone.dto.BookingDTO;
import com.droppa.services.spring.droppaclone.enums.BookingStatus;
import com.droppa.services.spring.droppaclone.models.Booking;
import com.droppa.services.spring.droppaclone.services.BookingService;

/**
 * @author Ernest Mampana
 *
 */
@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	// @Secured
	@PostMapping("/book")
	public ResponseEntity<Booking> createBooking(@RequestBody BookingDTO bookingDto) {
		Booking book = bookingService.createBooking(bookingDto);
		return new ResponseEntity<Booking>(book, HttpStatus.OK);
	}

	@GetMapping("/bookingbystatus/{status}")
	public List<Booking> getBookingByStatus(@PathVariable("status") BookingStatus status) {
		return bookingService.getBookingsByStatus(status);
	}

	@GetMapping("/bookingbystatusforuser/{status}/{userid}")
	public List<Booking> getBookingsByStatusForUser(@PathVariable("status") BookingStatus status,
			@PathVariable("userid") String userid) {
		return bookingService.getBookingsByStatusForUser(status, userid);
	}

	@GetMapping("/getAllBokings")
	public List<Booking> getAllBookings() {
		return bookingService.getAllBookings();
	}

	@GetMapping("/bookingById/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable("id") String id) {
		Booking booking = bookingService.getBookingById(id);
		return new ResponseEntity<Booking>(booking, HttpStatus.OK);
	}

	@GetMapping("/bookingByDriverId/{id}")
	public List<Booking> getBookingByDriverId(@PathVariable("id") String id) {
		return bookingService.getBookingsByDriverId(id);
	}

	@GetMapping("/bookingByUserId/{id}")
	public List<Booking> getBookingByUserId(@PathVariable("id") String id) {
		return bookingService.getBookingByUserId(id);
	}

	@PutMapping("/cancelBooking/{bookingId}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable("bookingId") String bookingId,
			@RequestParam(required = true) String userId) {
		Booking cBooking = bookingService.cancelBooking(bookingId, userId);
		return new ResponseEntity<Booking>(cBooking, HttpStatus.OK);
	}

}
