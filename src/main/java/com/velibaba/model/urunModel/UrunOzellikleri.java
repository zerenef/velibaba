package com.velibaba.model.urunModel;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.velibaba.model.BaseEntity;

@Entity
@Table(name = "urun_ozellikleri")
public class UrunOzellikleri extends BaseEntity{
	
	@Column(name="ozellikler")
	private HashMap<String, String> ozellikler = new HashMap<String, String>();
	
	@Lob
	@Column(name = "urun_aciklama")
	private String urunAciklama;
	
	@OneToOne
	@JoinColumn(name = "urun_id")
	private Urunler urun;

	public Map<String, String> getOzellikler() {
		return ozellikler;
	}

	public void setOzellikler(HashMap<String, String> ozellikler) {
		this.ozellikler = ozellikler;
	}

	public Urunler getUrun() {
		return urun;
	}

	public void setUrun(Urunler urun) {
		this.urun = urun;
	}

	public String getUrunAciklama() {
		return urunAciklama;
	}

	public void setUrunAciklama(String urunAciklama) {
		this.urunAciklama = urunAciklama;
	}

	@Override
	public String toString() {
		return "UrunOzellikleri [ozellikler=" + ozellikler + ", urunAciklama=" + urunAciklama + ", urun=" + urun + "]";
	}
	
}
