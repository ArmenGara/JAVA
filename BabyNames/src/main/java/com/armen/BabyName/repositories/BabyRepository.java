package com.armen.BabyName.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.armen.BabyName.models.Baby;

@Repository
public interface BabyRepository extends CrudRepository<Baby, Long> {
	List<Baby> findAll();

}
