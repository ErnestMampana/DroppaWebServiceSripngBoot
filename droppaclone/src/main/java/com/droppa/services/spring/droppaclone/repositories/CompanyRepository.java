/**
 * 
 */
package com.droppa.services.spring.droppaclone.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.droppa.services.spring.droppaclone.models.Company;

/**
 * @author Ernest Mampana
 *
 */
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	Optional<Company> findByCompanyId(String companyId);
}
