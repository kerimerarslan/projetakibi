package com.hititcs.intern.repository.v1;

import java.util.List;
import java.util.Map;

public interface IProje {
	

	Map<String, Object> getir(int idsi);

	void projeEkle(int idsi, String ad, String derece, String sinif, String tarih);

	List<Map<String, Object>> projeListele(int id);
	
	List<Map<String, Object>> calisanListele(int id);

	void sil(int idsi);

	void guncelle(int idsi, String ad, String tarih, String derece, String sinif);

	Map<String, Object> proje_getir(int idsi);




	

	

}
