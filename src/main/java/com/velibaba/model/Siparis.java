package com.velibaba.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.velibaba.model.urunModel.Urunler;

@Entity
@Table(name="siparis")
public class Siparis extends BaseEntity{
	
	@Column(name="satin_alma_zamani")
	@Temporal(TemporalType.TIMESTAMP)
	private Date satinAlmaZamani;
	
	@Column(name="satin_alinan_fiyat")
	private double satinAlinanFiyat;
	
	@Column(name = "alinan_adet")
	private int alinanAdet;
	
	@ManyToOne
	@JoinColumn(name = "kullanici_id")
	private User kullanici;

	@OneToOne
	@JoinColumn(name = "urun_id")
	private Urunler urun;

	public Date getSatinAlmaZamani() {
		return satinAlmaZamani;
	}

	public void setSatinAlmaZamani(Date satinAlmaZamani) {
		this.satinAlmaZamani = satinAlmaZamani;
	}

	public double getSatinAlinanFiyat() {
		return satinAlinanFiyat;
	}

	public void setSatinAlinanFiyat(int satinAlinanFiyat) {
		this.satinAlinanFiyat = satinAlinanFiyat;
	}

	public User getKullanici() {
		return kullanici;
	}

	public void setKullanici(User kullanici) {
		this.kullanici = kullanici;
	}

	public int getAlinanAdet() {
		return alinanAdet;
	}

	public void setAlinanAdet(int alinanAdet) {
		this.alinanAdet = alinanAdet;
	}

	public Urunler getUrun() {
		return urun;
	}

	public void setUrun(Urunler urun) {
		this.urun = urun;
	}

	public void setSatinAlinanFiyat(double satinAlinanFiyat) {
		this.satinAlinanFiyat = satinAlinanFiyat;
	}

	@Override
	public String toString() {
		return "Siparis [satinAlmaZamani=" + satinAlmaZamani + ", satinAlinanFiyat=" + satinAlinanFiyat
				+ ", alinanAdet=" + alinanAdet + ", kullanici=" + kullanici + ", urun=" + urun + "]";
	}

}
