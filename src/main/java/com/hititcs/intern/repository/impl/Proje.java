package com.hititcs.intern.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hititcs.intern.repository.IProje;

@Repository
public class Proje implements IProje {

	@Autowired
	JdbcTemplate template;

	
	public List<Map<String, Object>> projeListele(int id) {

		List<Map<String, Object>> queryForList = template.queryForList("select * from proje where calisan_id=?", id);

		return queryForList;
	}
	
	public List<Map<String, Object>> calisanListele(int id) {

		List<Map<String, Object>> queryForList = template.queryForList("select * from calisanlar where id=?", id);

		return queryForList;
	}
	

	public void sil(int id) {

		template.update("delete from proje where id=?", id);

	}

	public void guncelle(int id, String proje_1) {

		template.update("update proje SET proje_1=? where id=?", proje_1, id);
	}

	public void projeEkle(int idsi, String ad, String derece, String sinif, String tarih) {
		template.update("insert into proje (proje_1,calisan_id,derece,sinif,tarih_son) values (?,?,?,?,?)", ad, idsi, derece, sinif, tarih);

	}
	
	public Map<String, Object> getir(int idsi) {
		return template.queryForMap("select * from calisanlar where id=?",idsi);
		
		
		
	}
	public Map<String, Object> proje_getir(int idsi) {
		return template.queryForMap("select * from proje where id=?",idsi);
		
		
		
	}




}
