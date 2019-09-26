package com.hititcs.intern.repository;

import java.util.List;
import java.util.Map;

public interface IProje {

	Map<String, Object> getir(int idsi);

	void projeEkle(int idsi, String ad, String derece, String sinif, String tarih);

	List<Map<String, Object>> projeListele(int id);
	
	List<Map<String, Object>> calisanListele(int id);

	void sil(int idsi);

	void guncelle(int idsi, String ad);

	Map<String, Object> proje_getir(int idsi);




	

	

}
