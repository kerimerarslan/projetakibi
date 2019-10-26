package com.hititcs.intern.repository.v1.impl;
 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hititcs.intern.repository.v1.ICalisanlar;

@Repository
public class Calisanlar implements ICalisanlar {

	@Autowired
	JdbcTemplate template;

	public List<Map<String, Object>> listele() {

		List<Map<String, Object>> queryForList = template.queryForList("select * from calisanlar");

		return queryForList;
	}

	public void sil(int id) {

		template.update("delete from calisanlar where id=?", id);

	}
	
	public void guncelle(int id, String ad, String soyad, String email) {
		template.update("update calisanlar SET ad=?, soyad=?, email=? where id=?" ,ad,soyad,email,id);
	}
	
	public void ekle( String ad, String soyad, String email) {
		
		template.update("insert into calisanlar (ad,soyad,email) values (?,?,?)",ad,soyad,email);
	}




}
