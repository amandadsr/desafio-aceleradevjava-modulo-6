package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public User findById(@PathVariable("id") Long userId) {

		return userService.findById(userId).orElse(new User());
	}

	@GetMapping
	public List<User> findByAccelerationNameOrCompanyId(@RequestParam(name = "accelerationName", required = false) String accelerationName,
														@RequestParam(name = "companyId", required = false) Long companyId) {
		
		if (!accelerationName.equals(null) || !accelerationName.isEmpty()) {
			return userService.findByAccelerationName(accelerationName);
		} else
			return userService.findByCompanyId(companyId);

	}
}
