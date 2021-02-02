package com.hm.webservicesapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.webservicesapp.models.MachineImage;

public interface MachineImageRepository extends JpaRepository<MachineImage, Long> {

}
