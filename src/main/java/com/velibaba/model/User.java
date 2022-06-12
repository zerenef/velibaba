package com.velibaba.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class User{

	@Id
	@NotNull
	@NotEmpty(message = "E-mail boş bırakılamaz.")
	@Column(name = "username")
	private String username; //email
	
	@NotNull
	@NotEmpty(message = "Parola boş bırakılamaz.")
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Column(name = "enabled")
	private Boolean enabled;

	@NotNull
	@NotEmpty(message = "Adınız boş bıraklımaz.")
	@Column(name = "ad")
	private String ad;
	
	@NotNull
	@NotEmpty(message = "Soyadınız boş bırakılamaz.")
	@Column(name="soyad")
	private String soyad;
	
	@Column(name="adres_1")
	private String adres1;
	
	@Column(name="adres_2")
	private String adres2;
	
	@Column(name="tel")
	private String tel;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getAdres1() {
		return adres1;
	}

	public void setAdres1(String adres1) {
		this.adres1 = adres1;
	}

	public String getAdres2() {
		return adres2;
	}

	public void setAdres2(String adres2) {
		this.adres2 = adres2;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
