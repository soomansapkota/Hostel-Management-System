package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.model.Hostelers;

@Repository
public interface hostelersRepository extends JpaRepository<Hostelers, Integer> {

}
