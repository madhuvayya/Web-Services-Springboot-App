package com.hm.webservicesapp.services;

import java.util.List;

import com.hm.webservicesapp.dto.MachineImageDTO;
import com.hm.webservicesapp.models.MachineImage;

public interface IMachineImageService {
	
	List<MachineImage> getAllMachineImagesData();
	
	MachineImage getMachineImageDataById(Long machineImageId);
	
	MachineImage createMachineImageData(MachineImageDTO machineImageDTO);
	
	MachineImage updateMachineImageData(Long machineImageId, MachineImageDTO machineImageDTO);
	
	void deleteMachineImageData(Long machineImageId);
}
