package com.hm.webservicesapp.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.hm.webservicesapp.dto.MachineImageDTO;

import lombok.Data;

@Data
@Entity
public class MachineImage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long machineImageId;
	
	@Column(name = "machine_Image_name", nullable = false)
	public String machineName;
	
	@Column(columnDefinition = "text", name = "machine_image_desc")
	public String machineDescription;
	
	@Column(name = "is_free_tier", nullable = false)
	public String isFreeTier;
	
//	@Column(name = "supported_instances")
//	public List<String> instances; 
	
	public MachineImage() {}

	public MachineImage(MachineImageDTO machineImageDTO) {
		this.updateMachineImage(machineImageDTO);
	}

	public void updateMachineImage(MachineImageDTO machineImageDTO) {
		this.machineName = machineImageDTO.machineName;
		this.machineDescription = machineImageDTO.machineDescription;
		this.isFreeTier = machineImageDTO.isFreeTier;		
	}
	
}
