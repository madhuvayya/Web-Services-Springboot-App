package com.hm.webservicesapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.webservicesapp.dto.InstanceDTO;
import com.hm.webservicesapp.exceptions.InstanceException;
import com.hm.webservicesapp.models.Instance;
import com.hm.webservicesapp.repositories.InstanceRepository;

@Service
public class InstanceService implements IInstanceService {
	
	@Autowired
	private InstanceRepository instanceRepository;

	@Override
	public List<Instance> getAllInstances() {
		return instanceRepository.findAll();
	}

	@Override
	public Instance getInstanceById(Long instanceId) {
		return instanceRepository.findById(instanceId)
				.orElseThrow( () -> new InstanceException("Instance with id" + instanceId + " does not exists...!!!"));
	}

	@Override
	public Instance createInstance(InstanceDTO instanceDTO) {
		Instance instance = new Instance(instanceDTO);
		return instanceRepository.save(instance);
	}

	@Override
	public Instance updateInstance(Long instanceId, InstanceDTO instanceDTO) {
		Instance instance = this.getInstanceById(instanceId);
		instance.updateInstance(instanceDTO);
		return instanceRepository.save(instance);
	}

	@Override
	public void deleteInstance(Long instanceId) {
		Instance instance = this.getInstanceById(instanceId);
		instanceRepository.delete(instance);
	}

}
