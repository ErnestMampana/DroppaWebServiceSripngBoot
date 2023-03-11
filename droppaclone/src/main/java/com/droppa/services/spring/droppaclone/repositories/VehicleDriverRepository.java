/**
 * 
 */
package com.droppa.services.spring.droppaclone.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.droppa.services.spring.droppaclone.models.VehicleDriver;

/**
 * @author Ernest Mampana
 *
 */
public interface VehicleDriverRepository extends JpaRepository<VehicleDriver, Integer> {

	Optional<VehicleDriver> findByEmail(String email);

}
