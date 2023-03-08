package com.droppa.services.spring.droppaclone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.droppa.services.spring.droppaclone.services.AdminService;

@RestController
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

//	@PutMapping("/suspenddriver/{driverId}")
//	public Response suspendDriver(@PathParam("driverId") String driverId) {
//		String entity = adminService.suspendDriver(driverId);
//		return Response.ok().entity(entity).build();
//	}
//
//	@PUT
//	@Path("/activatedriver/{driverId}")
//	public Response activateDriver(@PathParam("driverId") String driverId) {
//		String entity = adminService.confirmDriver(driverId);
//		return Response.ok().entity(entity).build();
//	}
//
//	@PUT
//	@Path("/assigndriver/{bookingId}/{driverId}")
//	public Response asignBookingToDriver(@PathParam("bookingId") String bookingId,
//			@PathParam("driverId") String driverId) {
//		Booking booking = adminService.asignBookingToDriver(bookingId, driverId);
//		return Response.ok(booking, MediaType.APPLICATION_JSON).build();
//	}
//
//	@DELETE
//	@Path("/deletebooking/{bookingId}")
//	public Response deleteBooking(@PathParam("bookingId") String bbokingId) {
//		String message = adminService.deleteBooking(bbokingId);
//		return Response.ok().entity(message).build();
//	}

	@PutMapping("/suspenduser/{useremail}")
	public ResponseEntity<String> suspendUser(@PathVariable("useremail") String userId) {
		String message = adminService.suspendUser(userId);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}
