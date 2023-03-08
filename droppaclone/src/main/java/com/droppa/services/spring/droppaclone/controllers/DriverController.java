package com.droppa.services.spring.droppaclone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.droppa.services.spring.droppaclone.dto.DriverDTO;
import com.droppa.services.spring.droppaclone.models.DriverAccount;
import com.droppa.services.spring.droppaclone.services.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	DriverService driverService = new DriverService();

	@GetMapping("/viewalldrivers")
	public List<DriverAccount> getAllUsers() {

		return driverService.getAllDrivers();
	}

	@PostMapping("/createdriver")
	public ResponseEntity<DriverAccount> createUser(DriverDTO driver) {
		DriverAccount driverAcc = driverService.createDriverAccount(driver);
		return new ResponseEntity<DriverAccount>(driverAcc,HttpStatus.OK);
	}
//	
//	@GET
//	@Path("/getdriverbyid/{driverId}")
//	public Response getDriverById(@PathParam("driverId") String driverId) {
//		DriverAccount driverAcc = driverService.getDriverById(driverId);
//		return Response.ok().entity(driverAcc).build();
//	}
}
