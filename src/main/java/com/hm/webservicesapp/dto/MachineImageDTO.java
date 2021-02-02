package com.hm.webservicesapp.dto;

import java.util.List;

import lombok.ToString;

@ToString
public class MachineImageDTO {

	public String machineName;
	
	public String machineDescription;
	
	public String isFreeTier;
	
	public List<String> instances; 
}
