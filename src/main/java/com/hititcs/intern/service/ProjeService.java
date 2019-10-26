package com.hititcs.intern.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hititcs.intern.domain.Calisan;
import com.hititcs.intern.domain.ProjeEntity;
import com.hititcs.intern.repository.CalisanRepository;
import com.hititcs.intern.repository.ProjeRepository;

@Service
public class ProjeService {

	@Autowired
	private ProjeRepository projeRepository;
//	@Autowired
//	private CalisanRepository calisanRepository;

	public Object findAllById(int idsi) {
		return projeRepository.findAllById(idsi);
	}

	public List<Calisan> findById(int id) {
		return projeRepository.findById(id);
	}

	public List<ProjeEntity> findAllByCalisan(Calisan calisan) {
		return projeRepository.findAllByCalisan(calisan);
	}

	public <S extends ProjeEntity> S save(S entity) {
		return projeRepository.save(entity);
	}

	public Iterable<ProjeEntity> findAll() {
		return projeRepository.findAll();
	}

	public Iterable<ProjeEntity> findAllById(Iterable<Integer> ids) {
		return projeRepository.findAllById(ids);
	}

	public void deleteById(Integer id) {
		projeRepository.deleteById(id);
	}

	
	
}
