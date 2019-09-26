package com.hititcs.intern.domain;

/**
 * TODO - kerim - Spring data konularına bak
 * TODO - kerim - Spring data Crud repository bak
 * TODO - kerim - Spring data entity bak
 * @author staj_kerim.erarslan
 *
 */
public class Calisan {

	private int id;
	private String ad;
	private String soyad;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
