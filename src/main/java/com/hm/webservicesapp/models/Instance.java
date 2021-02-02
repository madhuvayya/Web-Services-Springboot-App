package com.hm.webservicesapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.hm.webservicesapp.dto.InstanceDTO;

import lombok.Data;

@Data
@Entity
public class Instance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long instanceId;
	
	@Column(name = "instance_family_name", nullable = false)
	public String instanceFamilyName;
	
	@Column(name = "instance_type", nullable = false)
	public String instanceType;
	
	@Column(name = "number_of_virtual_cpus", nullable = false)
	public String numberOfVirtualCPUs;
	
	@Column(name = "memory", nullable = false)
	public int memory;

	@Column(name = "network_storage", nullable = false)
	public int networkStorage;

	@Column(name = "network_performance", nullable = false)
	public String networkPerformance; 	
	
	@Column(name = "is_free_tier", nullable = false)
	public String isFreeTier;
	
	@Column(name = "ipv6_support", nullable = false)
	public String ipv6Support;
	
	@Column(name = "ebs_optimizable", nullable = false)
	public String ebsOptimizable;
	
	public Instance(InstanceDTO instanceDTO) {
		this.updateInstance(instanceDTO);
	}

	public void updateInstance(InstanceDTO instanceDTO) {
		this.instanceFamilyName = instanceDTO.instanceFamilyName;
		this.instanceType = instanceDTO.instanceType;
		this.numberOfVirtualCPUs = instanceDTO.numberOfVirtualCPUs;
		this.memory = instanceDTO.memory;
		this.networkStorage = instanceDTO.networkStorage;
		this.networkPerformance = instanceDTO.networkPerformance;
		this.isFreeTier = instanceDTO.isFreeTier;
		this.ipv6Support = instanceDTO.ipv6Support;
		this.ebsOptimizable = instanceDTO.ebsOptimizable;
	}
	
}
