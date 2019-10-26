package com.hititcs.intern.repository;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.repository.CrudRepository;

import com.hititcs.intern.domain.Calisan;

public interface CalisanRepository extends CrudRepository<Calisan, Integer>{
	List<Calisan> findByAd(String ad);
	List<Calisan> findBySoyadAndAd(String xx, String yy);
	List<Calisan> findById(int id);
	Object findAllById(int idsi);
	
}
