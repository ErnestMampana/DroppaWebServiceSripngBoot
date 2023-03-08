/**
 * 
 */
package com.droppa.services.spring.droppaclone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.droppa.services.spring.droppaclone.dto.CompanyDTO;
import com.droppa.services.spring.droppaclone.models.Company;
import com.droppa.services.spring.droppaclone.services.CompanyService;

import jakarta.websocket.server.PathParam;

/**
 * @author Ernest Mampana
 *
 */

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/createcompany")
	public ResponseEntity<Company> createCompany(@RequestBody CompanyDTO companyDTO) {
		Company company = companyService.createCompany(companyDTO);
		return new ResponseEntity<Company>(company,HttpStatus.OK);
	}
	
	@GetMapping("/getcompany/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable("id") String id) {
		Company company = companyService.getCompanyByCompanyId(id);
		return new ResponseEntity<Company>(company,HttpStatus.OK);
	}
	
//	@GET
//	@Path("/viewallcompanies")
//	public Response viewAllCompanies() {
//		List<Company> company = companyService.viewAllCompanies();
//		return Response.ok().entity(company).build();
//	}

}
