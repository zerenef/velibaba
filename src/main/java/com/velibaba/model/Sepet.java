package com.velibaba.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.velibaba.model.urunModel.Urunler;

@Entity
@Table(name="sepet")
public class Sepet extends BaseEntity{

	@Column(name="giris_yapti_mi")  //silinmesi gerekiyor
	private boolean girisYaptiMi;
	
	@Column(name = "alinan_adet")
	private int alinanAdet;
	
	@OneToOne
	@JoinColumn(name = "kullanici_id")
	private User kullanici;
	
	@OneToOne
	@JoinColumn(name = "urun_id")
	private Urunler urun;

	public boolean isGirisYaptiMi() {
		return girisYaptiMi;
	}

	public void setGirisYaptiMi(boolean girisYaptiMi) {
		this.girisYaptiMi = girisYaptiMi;
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

	@Override
	public String toString() {
		return "Sepet [girisYaptiMi=" + girisYaptiMi + ", alinanAdet=" + alinanAdet + ", kullanici=" + kullanici
				+ ", urun=" + urun + "]";
	}
	
}
