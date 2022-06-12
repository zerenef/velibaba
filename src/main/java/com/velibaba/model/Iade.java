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
@Table
public class Iade extends BaseEntity{
	
	@Column(name="iade_tarihi")
	@Temporal(TemporalType.TIMESTAMP)
	private Date iadeTarihi;
	
	@ManyToOne
	@JoinColumn(name = "kullanici_id")
	private User kullanici;

	@OneToOne
	@JoinColumn(name = "siparis_id")
	private Siparis siparis;

	public Date getIadeTarihi() {
		return iadeTarihi;
	}

	public void setIadeTarihi(Date iadeTarihi) {
		this.iadeTarihi = iadeTarihi;
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

	@Override
	public String toString() {
		return "Iade [iadeTarihi=" + iadeTarihi + ", kullanici=" + kullanici + ", siparis=" + siparis + "]";
	}

}
