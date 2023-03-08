package com.droppa.services.spring.droppaclone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.droppa.services.spring.droppaclone.common.ClientException;
import com.droppa.services.spring.droppaclone.enums.AccountStatus;
import com.droppa.services.spring.droppaclone.models.UserAccount;

@Service
public class AdminService {

	@Autowired
	private UserService userService;

	@Transactional
	public String suspendUser(String userId) {

		String message = "User not found";

		UserAccount userAccount = userService.getUserByEmail(userId);

		if (userAccount.getStatus() == AccountStatus.SUSPENDED) {
			message = "User " + userAccount.getId() + " is already suspended";
			throw new ClientException("User " + userAccount.getId() + " is already suspended");
		}

		if (userAccount.getStatus().equals(AccountStatus.AWAITING_CONFIRMATION))
			throw new ClientException("User '" + userAccount.getId() + "' not avtivated");

		userAccount.setStatus(AccountStatus.SUSPENDED);

		message = "User '" + userAccount.getId() + "' has been Suspended";

		return message;
	}

}
