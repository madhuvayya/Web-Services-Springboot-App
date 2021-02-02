package com.hm.webservicesapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.webservicesapp.models.Instance;

public interface InstanceRepository extends JpaRepository<Instance, Long> {

}
