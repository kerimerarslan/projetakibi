package com.hititcs.intern.domain;

import java.security.Timestamp;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "proje")
public class ProjeEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String proje_1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "calisan_id")
	private Calisan calisan;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tarih_bas;
	@Temporal(TemporalType.DATE)
	private Date tarih_son;
	private String derece;
	private String sinif;

	public ProjeEntity() {

	}

	public ProjeEntity(int id, String proje_1, Calisan calisanEntity, java.sql.Timestamp tarih_bas, Date tarih_son,
			String derece, String sinif, Calisan calisanid) {
		super();
		this.id = id;
		this.proje_1 = proje_1;
		this.calisan = calisanid;
		this.tarih_bas = tarih_bas;
		this.tarih_son = tarih_son;
		this.derece = derece;
		this.sinif = sinif;
	}

//	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)

	public int getId() {
		return id;
	}

	public Calisan getCalisan() {
		return calisan;
	}

	public void setCalisan(Calisan calisan) {
		this.calisan = calisan;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProje_1() {
		return proje_1;
	}

	public void setProje_1(String proje_1) {
		this.proje_1 = proje_1;
	}

	public Date getTarih_son() {
		return tarih_son;
	}

	public void setTarih_son(Date tarih_son) {
		this.tarih_son = tarih_son;
	}

	public String getDerece() {
		return derece;
	}

	public void setDerece(String derece) {
		this.derece = derece;
	}

	public String getSinif() {
		return sinif;
	}

	public void setSinif(String sinif) {
		this.sinif = sinif;
	}

	public Date getTarih_bas() {
		return tarih_bas;
	}

	public void setTarih_bas(Date tarih_bas) {
		this.tarih_bas = tarih_bas;
	}

	@Override
	public String toString() {
		return "ProjeEntity [id=" + id + ", proje_1=" + proje_1 + ", calisanid=" + calisan + ", tarih_bas=" + tarih_bas
				+ ", tarih_son=" + tarih_son + ", derece=" + derece + ", sinif=" + sinif + "]";
	}

}
