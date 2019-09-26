package com.hititcs.intern.repository;

public interface CalisanGuncelle {
	public void sil(int id);

	public void guncelle(int id, String ad, String soyad, String email);

	public void ekle(String ad, String soyad, String email);
}
