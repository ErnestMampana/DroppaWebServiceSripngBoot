/**
 * 
 */
package com.droppa.services.spring.droppaclone.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.droppa.services.spring.droppaclone.models.Vehicle;

/**
 * @author Ernest Mampana
 *
 */
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	Optional<Vehicle> findByRegistration(String registration);
}
