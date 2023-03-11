package com.droppa.services.spring.droppaclone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.droppa.services.spring.droppaclone.common.ClientException;
import com.droppa.services.spring.droppaclone.dto.PersonDTO;
import com.droppa.services.spring.droppaclone.enums.AccountStatus;
import com.droppa.services.spring.droppaclone.models.Person;
import com.droppa.services.spring.droppaclone.models.UserAccount;
import com.droppa.services.spring.droppaclone.repositories.PersonRepository;
import com.droppa.services.spring.droppaclone.repositories.UserAccountRepository;

@Service
public class UserService {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Autowired
	private PartyService partyService;

	@Autowired
	private PersonRepository personRepository;

	public List<UserAccount> getAllUsers() {
		return userAccountRepository.findAll();
	}

	public UserAccount createUserAccount(PersonDTO person) {

		Optional<UserAccount> userAccount = userAccountRepository.findByEmail(person.email);

		Optional<Person> pers = personRepository.findByEmail(person.email);

		if (userAccount.isPresent())
			throw new ClientException("User already Exist");

		if (pers.isPresent()) {
			if (pers.get().getEmail().equals(person.email))
				throw new ClientException("person exist");
		}

		int otp = partyService.generateOTP(person.celphone);

		String token = partyService.generateToken();

		Person owner = new Person(person.userName, person.surname, person.celphone, 00.0, person.email);

		UserAccount acc = new UserAccount(owner.getEmail(), owner, false, otp, AccountStatus.AWAITING_CONFIRMATION,
				person.password, token);

		personRepository.save(owner);
		userAccountRepository.save(acc);

		return acc;

	}

	@Transactional
	public String confirmEmail(String email, int code) {

		String message = "User " + "'" + email + "'" + " was not found";
		UserAccount user = userAccountRepository.findByEmail(email)
				.orElseThrow(() -> new ClientException("Account not found"));

		if (user.getStatus().equals(AccountStatus.ACTIVE)) {
			message = "Account already active";
			throw new ClientException(message);
		}

		if (user.getOtp() == code) {

			user.setOtp(0);
			user.setConfirmed(true);
			user.setStatus(AccountStatus.ACTIVE);

			message = "Account Activated";

			return message;
		} else {
			message = "invalid otp";
			throw new ClientException(message);
		}

	}

	public UserAccount getUserByEmail(String email) {

		Optional<UserAccount> userOptional = userAccountRepository.findByEmail(email);

		if (userOptional.isPresent()) {
			UserAccount user = userOptional.get();
			return user;
		} else {
			throw new ClientException("User not fond");
		}

	}

	@Transactional
	public int requestPasswordReset(String email) {
		int otp = 0;

		UserAccount userAccount = getUserByEmail(email);

		if (userAccount.getEmail().equals(email)) {
			otp = partyService.generateOTP(userAccount.getOwner().getCelphone());
			userAccount.setOtp(otp);
			userAccount.setStatus(AccountStatus.AWAITING_PWD_RESET);
		} else {
			throw new ClientException("User not found");
		}

		return otp;
	}

	@Transactional
	public UserAccount resetPassword(int otp, String username, String password) {
		UserAccount userAcc = getUserByEmail(username);
		if (userAcc.getStatus().equals(AccountStatus.AWAITING_PWD_RESET)) {
			if (userAcc.getOtp() == otp) {
				userAcc.setOtp(0);
				userAcc.setPassword(password);
				userAcc.setStatus(AccountStatus.ACTIVE);
			}
		}
		return userAcc;
	}

	@Transactional
	public UserAccount loadWallet(String username, double amount) {

		UserAccount userAccount = getUserByEmail(username);
		if (userAccount.getStatus().equals(AccountStatus.ACTIVE)) {
			userAccount.getOwner().setWalletBalance(userAccount.getOwner().getWalletBalance() + amount);
			return userAccount;
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

}
