package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Challenge;
import com.challenge.entity.User;
import com.challenge.service.impl.ChallengeService;
import com.challenge.service.impl.UserService;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

	@Autowired
	private  ChallengeService challengeService;
	
	@GetMapping
	public List<Challenge> findByAccelerationIdAndUserId(@RequestParam("accelerationId") Long accelerationId,
															@RequestParam("userId") Long userId){
		
		return challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
	}
	
}
