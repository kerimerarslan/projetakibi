package com.hititcs.intern.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hititcs.intern.domain.Calisan;
import com.hititcs.intern.domain.ProjeEntity;

public interface ProjeRepository extends CrudRepository<ProjeEntity, Integer> {


	Object findAllById(int idsi);

	List<Calisan> findById(int id);

	List<ProjeEntity> findAllByCalisan(Calisan calisan);
}
