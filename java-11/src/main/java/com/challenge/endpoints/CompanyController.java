package com.challenge.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping("/{id}")
	public Company findById(@PathVariable("id") Long id) {
		
			return companyService.findById(id).orElse(new Company());
	}

	@GetMapping
	public List<Company> findByAccelerationIdOrUserId(@RequestParam(name = "accelerationId", required = false) Long accelerationId,
														@RequestParam(name = "userId", required = false) Long userId) {
		
		if (!accelerationId.equals(null)) {
			return companyService.findByAccelerationId(accelerationId);
		} else if(!userId.equals(null)) {
			return companyService.findByUserId(userId);
		}else
			return new ArrayList<>();
	}

}
