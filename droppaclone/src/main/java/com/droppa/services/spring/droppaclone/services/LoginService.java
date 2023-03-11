/**
 * 
 */
package com.droppa.services.spring.droppaclone.services;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.droppa.services.spring.droppaclone.common.ClientException;
import com.droppa.services.spring.droppaclone.enums.AccountStatus;
import com.droppa.services.spring.droppaclone.models.DriverAccount;
import com.droppa.services.spring.droppaclone.models.UserAccount;

import lombok.RequiredArgsConstructor;

/**
 * @author Ernest Mampana
 *
 */
@Service
@RequiredArgsConstructor
public class LoginService {

	private UserService userService;

	private DriverService driverService;

	private static final Logger logger = Logger.getLogger(LoginService.class.getName());

	public UserAccount userLogin(String username, String password) {
		UserAccount extractedAccount = null;
		try {
			UserAccount userAcc = userService.getUserByEmail(username);
			if (userAcc.getEmail().equals(username) && userAcc.getPassword().equals(password)) {
				if (userAcc.isConfirmed()) {
					if (userAcc.getStatus().equals(AccountStatus.ACTIVE)) {
						logger.info("Useraccount Logged In ================= " + userAcc.getEmail());
						logger.info("Useraccount Logged In ================= " + userAcc.getOwner().getUserName() + " "
								+ userAcc.getOwner().getSurname());

						extractedAccount = userAcc;

					} else {
						if (userAcc.getStatus().equals(AccountStatus.DELETED)) {
							throw new ClientException(
									"This account has been deleted, please contact Droppa Clone for re-activation.");
						} else if (userAcc.getStatus().equals(AccountStatus.AWAITING_PWD_RESET)) {
							throw new ClientException("User awaiting password reset.");
						} else {
							throw new ClientException(
									"This account has been suspended, please contact Droppa Clone for re-activation.");
						}
					}
				} else {
					throw new ClientException("Account not confirmed");
				}

			} else {
				throw new ClientException("Username and password do not match");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return extractedAccount;

	}

	public DriverAccount driverLogin(String username, String password) {

		DriverAccount driverAccount = driverService.getDriverByEmail(username);
		if (driverAccount.getEmail().equals(username) && driverAccount.getPassword().equals(password)) {
			if (driverAccount.isConfirmed()) {
				if (driverAccount.getStatus().equals(AccountStatus.ACTIVE)) {
					logger.info("DriverAccount Logged In ================= " + driverAccount.getEmail());
					logger.info("DriverAccount Logged In ================= " + driverAccount.getDriver().getName() + " "
							+ driverAccount.getDriver().getSurname());

				} else {
					if (driverAccount.getStatus().equals(AccountStatus.DELETED)) {
						throw new ClientException(
								"This account has been deleted, please contact Droppa Clone for re-activation.");
					} else if (driverAccount.getStatus().equals(AccountStatus.AWAITING_PWD_RESET)) {
						throw new ClientException("Driver awaiting password reset.");
					} else {
						throw new ClientException(
								"This account has been suspended, please contact Droppa Clone for re-activation.");
					}
				}
			} else {
				throw new ClientException("Account not confirmed");
			}

		} else {
			throw new ClientException("Username and password do not match");
		}

		return driverAccount;

	}
}
