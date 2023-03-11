/**
 * 
 */
package com.droppa.services.spring.droppaclone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.droppa.services.spring.droppaclone.dto.CredentialsDTO;
import com.droppa.services.spring.droppaclone.models.UserAccount;
import com.droppa.services.spring.droppaclone.services.LoginService;

/**
 * @author Ernest Mampana
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/userlogin")
	public ResponseEntity<UserAccount> userLogin(@RequestBody CredentialsDTO credentialsDto) {
		UserAccount userAcc  = loginService.userLogin(credentialsDto.username, credentialsDto.password);
		return new ResponseEntity<UserAccount>(userAcc,HttpStatus.OK);
	}

}
