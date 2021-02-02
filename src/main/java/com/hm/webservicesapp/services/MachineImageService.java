package com.hm.webservicesapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.webservicesapp.dto.MachineImageDTO;
import com.hm.webservicesapp.exceptions.MachineImageException;
import com.hm.webservicesapp.models.MachineImage;
import com.hm.webservicesapp.repositories.MachineImageRepository;

@Service
public class MachineImageService implements IMachineImageService {
	
	@Autowired
	private MachineImageRepository machineImageRepository;

	@Override
	public List<MachineImage> getAllMachineImagesData() {
		return machineImageRepository.findAll();
	}

	@Override
	public MachineImage getMachineImageDataById(Long machineImageId) {
		return machineImageRepository.findById(machineImageId)
				.orElseThrow( () -> new MachineImageException("Machine with id" + machineImageId + " does not exists...!!!"));
	}

	@Override
	public MachineImage createMachineImageData(MachineImageDTO machineImageDTO) {
		MachineImage machineImage = new MachineImage(machineImageDTO);
		return machineImageRepository.save(machineImage);
	}

	@Override
	public MachineImage updateMachineImageData(Long machineImageId, MachineImageDTO machineImageDTO) {
		MachineImage machineImage = this.getMachineImageDataById(machineImageId);
		machineImage.updateMachineImage(machineImageDTO);
		return machineImageRepository.save(machineImage); 
	}

	@Override
	public void deleteMachineImageData(Long machineImageId) {
		MachineImage machineImage = this.getMachineImageDataById(machineImageId);
		machineImageRepository.delete(machineImage);
	}

}
