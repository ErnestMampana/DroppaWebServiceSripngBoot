/**
 * 
 */
package com.droppa.services.spring.droppaclone.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.droppa.services.spring.droppaclone.models.DriverAccount;

/**
 * @author Ernest Mampana
 *
 */
public interface DriverAccountRepository extends JpaRepository<DriverAccount, Integer> {
	Optional<DriverAccount> findByEmail(String email);
}
