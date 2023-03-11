package com.droppa.services.spring.droppaclone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.droppa.services.spring.droppaclone.dto.PersonDTO;
import com.droppa.services.spring.droppaclone.models.Person;
import com.droppa.services.spring.droppaclone.models.UserAccount;
import com.droppa.services.spring.droppaclone.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/viewallusers")
	public List<UserAccount> getAllUsers() {
		return userService.getAllUsers();
	}

//	@PUT
//	@Path("/mobile/confirmation/{mobile}/{code}")
//	public Response confirmMobile(@PathParam("code") int code, @PathParam("mobile") String mobile) {
//		String resp = userService.confirmMobile(mobile, code);
//		return Response.ok(resp).build();
//	}
//
	@PutMapping("/email/confirmation/{email}")
	public ResponseEntity<String> confirmEmail(@PathVariable("email") String email,
			@RequestParam(required = true) int code) {
		String resp = userService.confirmEmail(email, code);
		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}

	@GetMapping("/getuserbyemail/{email}")
	public ResponseEntity<Person> getUserByEmail(@PathVariable("email") String email) {
		Person account = userService.getUserByEmail(email).getOwner();
		return new ResponseEntity<Person>(account, HttpStatus.OK);
	}

	@PostMapping("/createuser")
	public UserAccount createUser(@RequestBody PersonDTO person) {
		UserAccount userAcc = userService.createUserAccount(person);
		return new ResponseEntity<UserAccount>(userAcc, HttpStatus.OK).getBody();
	}

	@GetMapping("/requestPasswordReset/{email}")
	public ResponseEntity<Integer> requestPasswordReset(@PathVariable("email") String email) {
		int otp = userService.requestPasswordReset(email);
		return new ResponseEntity<Integer>(otp, HttpStatus.OK);
	}

	@PutMapping("/resetPassword/{username}")
	public ResponseEntity<UserAccount> resetPassword(@PathVariable("username") String username,
			@RequestParam(required = true) int otp, @RequestParam(required = true) String password) {
		UserAccount userAcc = userService.resetPassword(otp, username, password);
		return new ResponseEntity<UserAccount>(userAcc, HttpStatus.OK);
	}

	@PutMapping("/loadwallet/{username}")
	public ResponseEntity<UserAccount> loadWallet(@PathVariable("username") String username,
			@RequestParam(required = true) double amount) {
		UserAccount userAccount = userService.loadWallet(username, amount);
		return new ResponseEntity<UserAccount>(userAccount,HttpStatus.OK);
	}

}
