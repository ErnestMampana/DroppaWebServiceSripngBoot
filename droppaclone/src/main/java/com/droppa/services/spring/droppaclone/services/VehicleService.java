/**
 * 
 */
package com.droppa.services.spring.droppaclone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return vehicleRepo.findByRegistration(vehicleReg).get();
	}

	public Vehicle registerVehicle(VehicleDTO vehicleDto) {

		Company company = companyService.getCompanyByCompanyId(vehicleDto.companyId);

		Vehicle vehicle = new Vehicle(vehicleDto.registration, vehicleDto.make, vehicleDto.make,
				vehicleDto.discExpiryDate, null, company);

		vehicleRepo.save(vehicle);

		return vehicle;
	}

}
