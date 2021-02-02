package com.hm.webservicesapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.webservicesapp.dto.InstanceDTO;
import com.hm.webservicesapp.dto.ResponseDTO;
import com.hm.webservicesapp.models.Instance;
import com.hm.webservicesapp.services.InstanceService;

@RestController
@RequestMapping("/web-services")
public class InstanceController {
	@Autowired
	private InstanceService instanceService;

	@GetMapping("/instances")
	public ResponseEntity<ResponseDTO> getAllInstances() {
		List<Instance>  instances = instanceService.getAllInstances();
		if (instances != null) {
			ResponseDTO responseDTO = new ResponseDTO(200, "OK", instances);
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		}
		ResponseDTO responseDTO = new ResponseDTO(400, "Bad Request", null);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/instances/{instance-id}")
	public ResponseEntity<ResponseDTO> getInstance(@PathVariable("instance-id") Long instanceId) {
		Instance instance =  instanceService.getInstanceById(instanceId);
		if (instance != null) {
			ResponseDTO responseDTO = new ResponseDTO(200, "OK", instance);
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		}
		ResponseDTO responseDTO = new ResponseDTO(404, "Not Found", null);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/instances")
	public ResponseEntity<ResponseDTO> createInstance(@RequestBody InstanceDTO instanceDTO) {
		Instance instance = instanceService.createInstance(instanceDTO);
		if (instance != null) {
			ResponseDTO responseDTO = new ResponseDTO(201, "Created", instance);
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		}
		ResponseDTO responseDTO = new ResponseDTO(400, "Bad Request", null);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/instances/{instance-id}")
	public ResponseEntity<ResponseDTO> updateInstance(@PathVariable("instance-id") Long instanceId, 
			@RequestBody InstanceDTO instanceDTO) {
		Instance instance = instanceService.updateInstance(instanceId, instanceDTO);
		if (instance != null) {
			ResponseDTO responseDTO = new ResponseDTO(200, "OK", instance);
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		}
		ResponseDTO responseDTO = new ResponseDTO(400, "Bad Request", null);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/instances/{instance-id}")
	public ResponseEntity<ResponseDTO> deleteInstance(@PathVariable("instance-id") Long instanceId) {
		instanceService.deleteInstance(instanceId);
		ResponseDTO responseDTO = new ResponseDTO(204, "No Content", null);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
