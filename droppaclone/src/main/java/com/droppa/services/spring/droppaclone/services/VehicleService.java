/**
 * 
 */
package com.droppa.services.spring.droppaclone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.droppa.services.spring.droppaclone.common.ClientException;
import com.droppa.services.spring.droppaclone.dto.VehicleDTO;
import com.droppa.services.spring.droppaclone.models.Company;
import com.droppa.services.spring.droppaclone.models.Vehicle;
import com.droppa.services.spring.droppaclone.repositories.VehicleRepository;

/**
 * @author Ernest Mampana
 *
 */
@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepo;

	@Autowired
	private CompanyService companyService;

	public Vehicle getVehicleByRegistration(String vehicleReg) {
		Optional<Vehicle> vehicleOptional = vehicleRepo.findByRegistration(vehicleReg);
		
		if(vehicleOptional.isPresent()) {
			return vehicleOptional.get();
		}else {
			throw new ClientException("Vehicle not found");
		}
		
	}

	public Vehicle registerVehicle(VehicleDTO vehicleDto) {

		Company company = companyService.getCompanyByCompanyId(vehicleDto.companyId);
		
		Optional<Vehicle> vehicleOptional = vehicleRepo.findByRegistration(vehicleDto.registration);
		
		if(vehicleOptional.isPresent()) {
			throw new ClientException("This vehicle is already registered.");
		}

		Vehicle vehicle = new Vehicle(vehicleDto.registration, vehicleDto.make, vehicleDto.type,
				vehicleDto.discExpiryDate, null, company);

		vehicleRepo.save(vehicle);

		return vehicle;
	}

	public List<Vehicle> getAllVehicles() {
		return vehicleRepo.findAll();
	}
	

}
