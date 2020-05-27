package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private CandidateMapper candidateMapper;
	
	@GetMapping("/{userId}/{companyId}/{accelerationId}")
	public CandidateDTO findById(@PathVariable("userId") Long userId, 
								@PathVariable("companyId") Long companyId, 
								@PathVariable("accelerationId") Long accelerationId) {
		
		return candidateMapper.map(candidateService.findById(userId, companyId, accelerationId).orElse(new Candidate()));
	}
	
	@GetMapping
	public List<CandidateDTO> findByCompanyIdOrAccelerationId(@RequestParam(name="companyId", required=false) Long companyId,
																@RequestParam(name="accelerationId", required=false) Long accelerationId){
		if(!companyId.equals(null)) {
		return candidateMapper.map(candidateService.findByCompanyId(companyId));
		}else 
			return candidateMapper.map(candidateService.findByAccelerationId(accelerationId));
		
		
	}
}
