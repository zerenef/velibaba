package com.velibaba.model.urunModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.velibaba.model.BaseEntity;
import com.velibaba.model.functions.KategoriFunctions;

@Entity
@Table(name = "urunler")
public class Urunler extends BaseEntity{

	@Column(name="urun_adi")
	private String urunAdi;
	
	@Column(name="marka")
	private String marka;
	
	@Column(name="fiyat")
	private double fiyat;
	
	@Column(name="indirim")
	private int indirim;
	
	@Column(name="resim_yolu")
	// ilişki
	private String resimYolu;
	
	@Column(name="satis_miktari")
	private int satisMiktari; //kaç tane satıldığı
	
	@Column(name = "stok")
	private int stok;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "urun_aktifmi")
	private Boolean urunAktifmi;
	
	@ManyToOne
	@JoinColumn(name = "alt_kategori_id")
	private AltKategori altKategori;
	
	@ManyToOne
	@JoinColumn(name = "kategori_id")
	private Kategori kategori;

	public String getUrunAdi() {
		return urunAdi;
	}

	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public double getFiyat() {
		return fiyat;
	}

	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}

	public int getIndirim() {
		return indirim;
	}

	public void setIndirim(int indirim) {
		this.indirim = indirim;
	}

	public String getResimYolu() {
		return resimYolu;
	}

	public void setResimYolu(String resimYolu) {
		this.resimYolu = resimYolu;
	}

	public int getSatisMiktari() {
		return satisMiktari;
	}

	public void setSatisMiktari(int satisMiktari) {
		this.satisMiktari = satisMiktari;
	}

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}

	public AltKategori getAltKategori() {
		return altKategori;
	}

	public void setAltKategori(AltKategori altKategori) {
		this.altKategori = altKategori;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl() {
		String urunName = KategoriFunctions.createUrl(getUrunAdi());
		this.url = KategoriFunctions.createUrl("urun-detay?url="+urunName+"-"+getId()); // urun-detay?url=hp-dizustu-150
	}

	public boolean isUrunAktifmi() {
		return urunAktifmi;
	}

	public void setUrunAktifmi(Boolean urunAktifmi) {
		this.urunAktifmi = urunAktifmi;
	}

	public Kategori getKategori() {
		return kategori;
	}

	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}

	public Boolean getUrunAktifmi() {
		return urunAktifmi;
	}

	@Override
	public String toString() {
		return "Urunler [urunAdi=" + urunAdi + ", marka=" + marka + ", fiyat=" + fiyat + ", indirim=" + indirim
				+ ", resimYolu=" + resimYolu + ", satisMiktari=" + satisMiktari + ", stok=" + stok + ", url=" + url
				+ ", urunAktifmi=" + urunAktifmi + ", altKategori=" + altKategori + ", kategori=" + kategori + "]";
	}

}
