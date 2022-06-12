package com.velibaba.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.velibaba.model.urunModel.Urunler;

@Entity
@Table(name="degerlendirme")
public class Degerlendirme extends BaseEntity{
	
	@Column(name="yorum_metni")
	private String yorumMetni;
	
	@Column(name="puan")
	private String puan;
	
	@ManyToOne
	@JoinColumn(name = "urun_id")
	private Urunler urun;
	
	@ManyToOne
	@JoinColumn(name="kullanici_id")
	private User kullaniciId;

	public String getYorumMetni() {
		return yorumMetni;
	}

	public void setYorumMetni(String yorumMetni) {
		this.yorumMetni = yorumMetni;
	}

	public String getPuan() {
		return puan;
	}

	public void setPuan(String puan) {
		this.puan = puan;
	}

	public Urunler getUrunler() {
		return urun;
	}

	public void setUrunler(Urunler urunler) {
		this.urun = urunler;
	}

	public User getKullaniciId() {
		return kullaniciId;
	}

	public void setKullaniciId(User kullaniciId) {
		this.kullaniciId = kullaniciId;
	}

	@Override
	public String toString() {
		return "Degerlendirme [yorumMetni=" + yorumMetni + ", puan=" + puan + ", urunler=" + urun + ", kullaniciId="
				+ kullaniciId + "]";
	}
	
}
