package com.velibaba.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.velibaba.model.urunModel.Urunler;

@Entity
@Table(name="favoriler")
public class Favoriler {
	
	@Embeddable
	public class FavorilerId implements Serializable {
		
		@ManyToOne
		@JoinColumn(name = "kullanici_id")
		private User kullanicilar;

		@ManyToOne
		@JoinColumn(name = "urun_id")
		private Urunler urunler;

		public User getKullanicilar() {
			return kullanicilar;
		}

		public void setKullanicilar(User kullanicilar) {
			this.kullanicilar = kullanicilar;
		}

		public Urunler getUrunler() {
			return urunler;
		}

		public void setUrunler(Urunler urunler) {
			this.urunler = urunler;
		}
		
	}
	
	@Id
	private FavorilerId id;

	public FavorilerId getId() {
		return id;
	}

	public void setId(FavorilerId id) {
		this.id = id;
	}
	
}
