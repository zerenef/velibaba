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

@Entity
@Table(name="log_mysql")
public class LogMySql extends BaseEntity{
	
	@Column(name="giris_zamani")
	@Temporal(TemporalType.TIMESTAMP)
	private Date girisZamani;
	
	@Column(name="cikis_zamani")
	@Temporal(TemporalType.TIMESTAMP)
	private Date cikisZamani;
	
	@ManyToOne
	@JoinColumn(name = "kullanici_id")
	private User kullanici;
	
	@OneToOne
	@JoinColumn(name = "siparis_id")
	private Siparis siparis;

	@OneToOne
	@JoinColumn(name="iade_id")
	private Iade iade;

	public Date getGirisZamani() {
		return girisZamani;
	}

	public void setGirisZamani(Date girisZamani) {
		this.girisZamani = girisZamani;
	}

	public Date getCikisZamani() {
		return cikisZamani;
	}

	public void setCikisZamani(Date cikisZamani) {
		this.cikisZamani = cikisZamani;
	}

	public User getKullanici() {
		return kullanici;
	}

	public void setKullanici(User kullanici) {
		this.kullanici = kullanici;
	}

	public Siparis getSiparis() {
		return siparis;
	}

	public void setSiparis(Siparis siparis) {
		this.siparis = siparis;
	}

	public Iade getIade() {
		return iade;
	}

	public void setIade(Iade iade) {
		this.iade = iade;
	}

	@Override
	public String toString() {
		return "LogMySql [girisZamani=" + girisZamani + ", cikisZamani=" + cikisZamani + ", kullanici=" + kullanici
				+ ", siparis=" + siparis + ", iade=" + iade + "]";
	}
	
}
