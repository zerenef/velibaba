package com.velibaba.model.urunModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.velibaba.model.BaseEntity;

@Entity
@Table(name = "ust_kategori")
public class UstKategori extends BaseEntity{
	
	@Column(name = "ust_kategori_adi")
	private String ustKategoriAdi;

	public String getUstKategoriAdi() {
		return ustKategoriAdi;
	}

	public void setUstKategoriAdi(String ustKategoriAdi) {
		this.ustKategoriAdi = ustKategoriAdi;
	}

	@Override
	public String toString() {
		return "UstKategori [ustKategoriAdi=" + ustKategoriAdi + "]";
	}
	
}
