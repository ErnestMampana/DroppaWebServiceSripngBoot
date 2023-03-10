package com.droppa.services.spring.droppaclone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.droppa.services.spring.droppaclone.models.Booking;
import com.droppa.services.spring.droppaclone.services.AdminService;

@RestController
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@PutMapping("/suspenddriver/{driverId}")
	public ResponseEntity<String> suspendDriver(@PathVariable("driverId") String driverId) {
		String entity = adminService.suspendDriver(driverId);
		return new ResponseEntity<String>(entity,HttpStatus.OK);
	}

	@PutMapping("/activatedriver/{driverId}")
	public ResponseEntity<String> activateDriver(@PathVariable("driverId") String driverId) {
		String entity = adminService.confirmDriver(driverId);
		return new ResponseEntity<String>(entity,HttpStatus.OK);
	}

	@PutMapping("/assigndriver/{bookingId}/{driverId}")
	public ResponseEntity<Booking> asignBookingToDriver(@PathVariable("bookingId") String bookingId,
			@PathVariable("driverId") String driverId) {
		Booking booking = adminService.asignBookingToDriver(bookingId, driverId);
		return new ResponseEntity<Booking>(booking,HttpStatus.OK);
	}

	@DeleteMapping("/deletebooking/{bookingId}")
	public ResponseEntity<String> deleteBooking(@PathVariable("bookingId") String bokingId) {
		String message = adminService.deleteBooking(bokingId);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}

	@PutMapping("/suspenduser/{useremail}")
	public ResponseEntity<String> suspendUser(@PathVariable("useremail") String userId) {
		String message = adminService.suspendUser(userId);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@PutMapping("/activateuser/{useremail}")
	public ResponseEntity<String> activateUser(@PathVariable("useremail") String userId) {
		String message = adminService.activateUser(userId);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}
