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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.droppa.services.spring.droppaclone.dto.VehicleDTO;
import com.droppa.services.spring.droppaclone.models.Vehicle;
import com.droppa.services.spring.droppaclone.services.VehicleService;


/**
 * @author Ernest Mampana
 *
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	@Autowired
	VehicleService vehicleService;

	@PostMapping("/registervehicle")
	public ResponseEntity<Vehicle> registerVegicle(@RequestBody VehicleDTO vehicleDto) {
		Vehicle vehicle =  vehicleService.registerVehicle(vehicleDto);
		return new ResponseEntity<Vehicle>(vehicle,HttpStatus.OK);
	}
	
	@GetMapping("/viewallvehicles")
	public List<Vehicle> viewAllVehicles() {
		List<Vehicle> vehicles = vehicleService.getAllVehicles();
		return vehicles;
	}
	
	@GetMapping("/getvehicle/{registration}")
	public ResponseEntity<Vehicle> getVehicleByRegistration(@PathVariable("registration") String registration){
		Vehicle vehicle = vehicleService.getVehicleByRegistration(registration);
		return new ResponseEntity<Vehicle>(vehicle,HttpStatus.OK);
	}
}
