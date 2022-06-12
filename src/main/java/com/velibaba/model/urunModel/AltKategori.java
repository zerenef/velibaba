package com.velibaba.model.urunModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.velibaba.model.BaseEntity;

@Entity
@Table(name = "alt_kategori")
public class AltKategori extends BaseEntity{

	@Column(name = "alt_kategori_adi")
	private String altKategoriAdi;
	
	@Column(name = "url")
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "kategori_id")
	private Kategori kategori;

	public String getAltKategoriAdi() {
		return altKategoriAdi;
	}

	public void setAltKategoriAdi(String altKategoriAdi) {
		this.altKategoriAdi = altKategoriAdi;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(Long kId) { //
		this.url = "urun-kategori-"+kId; // urun-kategori-{id}
	}	

	public Kategori getKategori() {
		return kategori;
	}

	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}

	@Override
	public String toString() {
		return "AltKategori [altKategoriAdi=" + altKategoriAdi + ", kategori=" + kategori + "]";
	}	
}
