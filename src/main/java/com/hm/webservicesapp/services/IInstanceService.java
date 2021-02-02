package com.hm.webservicesapp.services;

import java.util.List;

import com.hm.webservicesapp.dto.InstanceDTO;
import com.hm.webservicesapp.models.Instance;

public interface IInstanceService {
	
	List<Instance> getAllInstances();
	
	Instance getInstanceById(Long instanceId);
	
	Instance createInstance(InstanceDTO instanceDTO);
	
	Instance updateInstance(Long instanceId, InstanceDTO instanceDTO);
	
	void deleteInstance(Long instanceId);
}
