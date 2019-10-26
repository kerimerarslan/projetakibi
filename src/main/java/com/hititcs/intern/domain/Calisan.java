package com.hititcs.intern.domain;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "calisanlar")
public class Calisan {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String ad;
	private String soyad;
	private String email;

	@OneToMany(mappedBy = "calisan", fetch = FetchType.LAZY)
	private Set<ProjeEntity> projeEntities = new HashSet<>();
//	private java.util.List<ProjeEntity> projeEntities = new ArrayList<>();

	public Calisan() {
	}

	public Calisan(int id, String ad, String soyad, String email) {
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.email = email;
	}

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

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString();
//	}

	public Set<ProjeEntity> getProjeEntities() {
		return projeEntities;
	}

	public void setProjeEntities(Set<ProjeEntity> projeEntities) {
		this.projeEntities = projeEntities;
	}

	@Override
	public String toString() {
		return "Calisan [id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", email=" + email + ", projeEntities="
				+ projeEntities + "]";
	}

}
