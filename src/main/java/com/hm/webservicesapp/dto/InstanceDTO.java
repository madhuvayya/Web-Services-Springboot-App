package com.hm.webservicesapp.dto;

import lombok.ToString;

@ToString
public class InstanceDTO {
	
	public String instanceFamilyName;
	
	public String instanceType;
	
	public String numberOfVirtualCPUs;
	
	public int memory;

	public int networkStorage;

	public String networkPerformance; 	
	
	public String isFreeTier;
	
	public String ipv6Support;
	
	public String ebsOptimizable;
}
