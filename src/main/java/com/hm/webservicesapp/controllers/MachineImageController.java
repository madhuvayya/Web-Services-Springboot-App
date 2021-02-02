package com.hm.webservicesapp.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.webservicesapp.dto.MachineImageDTO;

@RestController
@RequestMapping("/web-services")
public class MachineImageController {

	@GetMapping("/machine-image")
	public String getAllMachineImages() {
		return "All machine Images";
	}
	
	@GetMapping("/machine-image/{machine-image-id}")
	public String getMachineImage(@PathVariable("machine-image-id") Long machineImageId) {
		return "Machine Image with id: "+ machineImageId;
	}
	
	@PostMapping("/machine-image")
	public String createMachineImage(@RequestBody MachineImageDTO machineImageDTO) {
		return "Created Machine Image "+ machineImageDTO.toString();
	}
	
	@PutMapping("/machine-image/{machine-image-id}")
	public String updateMachineImage(@PathVariable("machine-image-id") Long machineImageId) {
		return "Updated Machine Image with id: "+ machineImageId;
	}
	
	@DeleteMapping("/machine-image/{machine-image-id}")
	public String deleteMachineImage(@PathVariable("machine-image-id") Long machineImageId) {
		return "Deleted Machine Image with id: "+ machineImageId;
	}
}
