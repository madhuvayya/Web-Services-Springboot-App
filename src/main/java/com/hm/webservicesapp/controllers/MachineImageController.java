package com.hm.webservicesapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.webservicesapp.dto.MachineImageDTO;
import com.hm.webservicesapp.models.MachineImage;
import com.hm.webservicesapp.services.MachineImageService;

@RestController
@RequestMapping("/web-services")
public class MachineImageController {
	
	@Autowired
	private MachineImageService machineImageService;

	@GetMapping("/machine-image")
	public List<MachineImage> getAllMachineImages() {
		return machineImageService.getAllMachineImagesData();
	}
	
	@GetMapping("/machine-image/{machine-image-id}")
	public MachineImage getMachineImage(@PathVariable("machine-image-id") Long machineImageId) {
		return machineImageService.getMachineImageDataById(machineImageId); 
	}
	
	@PostMapping("/machine-image")
	public String createMachineImage(@RequestBody MachineImageDTO machineImageDTO) {
		return "Created Machine Image "+ machineImageDTO.toString();
	}
	
	@PutMapping("/machine-image/{machine-image-id}")
	public MachineImage updateMachineImage(@PathVariable("machine-image-id") Long machineImageId, 
									@RequestBody MachineImageDTO machineImageDTO) {
		return machineImageService.updateMachineImageData(machineImageId, machineImageDTO);
	}
	
	@DeleteMapping("/machine-image/{machine-image-id}")
	public void deleteMachineImage(@PathVariable("machine-image-id") Long machineImageId) {
		machineImageService.deleteMachineImageData(machineImageId);
	}
}
