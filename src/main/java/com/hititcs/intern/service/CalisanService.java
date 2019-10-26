package com.hititcs.intern.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hititcs.intern.domain.Calisan;
import com.hititcs.intern.repository.CalisanRepository;

@Service
public class CalisanService {

	@Autowired
	private CalisanRepository calisanRepository;

	public List<Calisan> findByAd(String ad) {
		return calisanRepository.findByAd(ad);
	}

	public List<Calisan> findById(int id) {
		return calisanRepository.findById(id);
	}

	public Object findAllById(int idsi) {
		return calisanRepository.findAllById(idsi);
	}

	public <S extends Calisan> S save(S entity) {
		return calisanRepository.save(entity);
	}

	public Iterable<Calisan> findAll() {
		return calisanRepository.findAll();
	}

	public void deleteById(Integer id) {
		calisanRepository.deleteById(id);
	}

	public void delete(Calisan entity) {
		calisanRepository.delete(entity);
	}

}
