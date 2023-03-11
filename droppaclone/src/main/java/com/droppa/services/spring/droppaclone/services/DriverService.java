package com.droppa.services.spring.droppaclone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.droppa.services.spring.droppaclone.common.ClientException;
import com.droppa.services.spring.droppaclone.dto.DriverDTO;
import com.droppa.services.spring.droppaclone.enums.AccountStatus;
import com.droppa.services.spring.droppaclone.models.DriverAccount;
import com.droppa.services.spring.droppaclone.models.Vehicle;
import com.droppa.services.spring.droppaclone.models.VehicleDriver;
import com.droppa.services.spring.droppaclone.repositories.DriverAccountRepository;
import com.droppa.services.spring.droppaclone.repositories.VehicleDriverRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DriverService {

	private DriverAccountRepository driverAccRepo;

	private DriverAccountRepository driverAccountRepository;

	private VehicleDriverRepository vehicleDriverRepository;

	private VehicleService vehicleService;

	public List<DriverAccount> getAllDrivers() {
		return driverAccRepo.findAll();
	}

	public DriverAccount createDriverAccount(DriverDTO driverDto) {

		Optional<DriverAccount> driverOptional = driverAccRepo.findByEmail(driverDto.email);

		if (driverOptional.isPresent())
			throw new ClientException("Driver with Email '" + driverOptional.get().getEmail() + "' already exist");

		VehicleDriver driver = new VehicleDriver(driverDto.email, driverDto.name, driverDto.surname, driverDto.celphone,
				null);

		Vehicle vehicleData = vehicleService.getVehicleByRegistration(driverDto.registration);

		DriverAccount driverAcc = new DriverAccount(driverDto.email, driverDto.password, false, vehicleData, driver,
				AccountStatus.AWAITING_CONFIRMATION);

		vehicleDriverRepository.save(driver);
		driverAccountRepository.save(driverAcc);

		return driverAcc;
	}

	public DriverAccount getDriverByEmail(String email) {
		Optional<DriverAccount> driverAccountOptional = driverAccountRepository.findByEmail(email);

		if (driverAccountOptional.isPresent()) {
			return driverAccountOptional.get();
		} else {
			throw new ClientException("Driver not found");
		}
	}

}
