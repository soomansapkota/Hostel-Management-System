package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.model.Owner;

@Repository
public interface ownerRepository extends JpaRepository<Owner, Integer> {
	Owner findByEmailAndPassword(String em, String psw);
}
