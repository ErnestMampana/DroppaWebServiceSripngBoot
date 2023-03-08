/**
 * 
 */
package com.droppa.services.spring.droppaclone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.droppa.services.spring.droppaclone.common.ClientException;
import com.droppa.services.spring.droppaclone.dto.CompanyDTO;
import com.droppa.services.spring.droppaclone.enums.AccountStatus;
import com.droppa.services.spring.droppaclone.models.Company;
import com.droppa.services.spring.droppaclone.models.Person;
import com.droppa.services.spring.droppaclone.models.UserAccount;
import com.droppa.services.spring.droppaclone.repositories.CompanyRepository;

/**
 * @author Ernest Mampana
 *
 */

@Service
public class CompanyService {

	@Autowired
	private UserService userService;

	@Autowired
	private PartyService partyService;

	@Autowired
	private CompanyRepository companyRepository;

	public Company createCompany(CompanyDTO companyDto) {
		UserAccount userAccount = userService.getUserByEmail(companyDto.ownerId);
		if (userAccount.getStatus().equals(AccountStatus.ACTIVE)) {
			Person person = userAccount.getOwner();
			Company company = new Company(partyService.randomChars(10), companyDto.companyName, person,
					companyDto.location);

			companyRepository.save(company);

			return company;
		} else {
			if (userAccount.getStatus().equals(AccountStatus.AWAITING_CONFIRMATION)) {
				throw new ClientException("Please confirm your account first.");
			} else if (userAccount.getStatus().equals(AccountStatus.AWAITING_PWD_RESET)) {
				throw new ClientException("You haven't set confirmed your new password");
			} else {
				throw new ClientException(
						"Your account has been suspended please contact Droppa Clone for re-activation.");
			}
		}

	}

	public Company getCompanyByCompanyId(String companyId) {
		return companyRepository.findByCompanyId(companyId).get();
	}
}
