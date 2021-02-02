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

import com.hm.webservicesapp.dto.MachineImageDTO;
import com.hm.webservicesapp.dto.ResponseDTO;
import com.hm.webservicesapp.models.MachineImage;
import com.hm.webservicesapp.services.MachineImageService;

@RestController
@RequestMapping("/web-services")
public class MachineImageController {
	
	@Autowired
	private MachineImageService machineImageService;

	@GetMapping("/machine-images")
	public ResponseEntity<ResponseDTO> getAllMachineImages() {
		List<MachineImage>  machineImagesData = machineImageService.getAllMachineImagesData();
		if (machineImagesData != null) {
			ResponseDTO responseDTO = new ResponseDTO(200, "OK", machineImagesData);
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		}
		ResponseDTO responseDTO = new ResponseDTO(400, "Bad Request", null);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/machine-images/{machine-image-id}")
	public ResponseEntity<ResponseDTO> getMachineImage(@PathVariable("machine-image-id") Long machineImageId) {
		MachineImage machineImageData =  machineImageService.getMachineImageDataById(machineImageId);
		if (machineImageData != null) {
			ResponseDTO responseDTO = new ResponseDTO(200, "OK", machineImageData);
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		}
		ResponseDTO responseDTO = new ResponseDTO(404, "Not Found", null);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/machine-images")
	public ResponseEntity<ResponseDTO> createMachineImage(@RequestBody MachineImageDTO machineImageDTO) {
		MachineImage machineImage = machineImageService.createMachineImageData(machineImageDTO);
		if (machineImage != null) {
			ResponseDTO responseDTO = new ResponseDTO(201, "Created", machineImage);
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		}
		ResponseDTO responseDTO = new ResponseDTO(400, "Bad Request", null);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/machine-images/{machine-image-id}")
	public ResponseEntity<ResponseDTO> updateMachineImage(@PathVariable("machine-image-id") Long machineImageId, 
									@RequestBody MachineImageDTO machineImageDTO) {
		MachineImage machineImage = machineImageService.updateMachineImageData(machineImageId, machineImageDTO);
		if (machineImage != null) {
			ResponseDTO responseDTO = new ResponseDTO(200, "OK", machineImage);
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		}
		ResponseDTO responseDTO = new ResponseDTO(400, "Bad Request", null);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/machine-images/{machine-image-id}")
	public ResponseEntity<ResponseDTO> deleteMachineImage(@PathVariable("machine-image-id") Long machineImageId) {
		machineImageService.deleteMachineImageData(machineImageId);
		ResponseDTO responseDTO = new ResponseDTO(204, "No Content", null);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
