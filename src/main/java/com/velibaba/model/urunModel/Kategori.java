package com.velibaba.model.urunModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.velibaba.model.BaseEntity;

@Entity
@Table(name = "kategori")
public class Kategori extends BaseEntity{
	
	@Column(name = "kategori_adi")
	private String kategoriAdi;
	
	@Column(name = "url")
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "ust_kategori_id")
	private UstKategori ustKategori;

	public String getKategoriAdi() {
		return kategoriAdi;
	}

	public void setKategoriAdi(String kategoriAdi) {
		this.kategoriAdi = kategoriAdi;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl() {
		this.url = "kategori-"+getId(); //kategori-{id}
	}

	public UstKategori getUstKategori() {
		return ustKategori;
	}

	public void setUstKategori(UstKategori ustKategori) {
		this.ustKategori = ustKategori;
	}

	@Override
	public String toString() {
		return "Kategori [kategoriAdi=" + kategoriAdi + ", ustKategori=" + ustKategori + "]";
	}
}
