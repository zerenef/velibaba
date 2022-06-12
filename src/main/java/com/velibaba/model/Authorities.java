package com.velibaba.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class Authorities{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="authority")
	private KullaniciRole authority;
	
	@OneToOne
	@JoinColumn(name = "username")
	private User username;
	
	public Long getId() {
		return id;
	}

	public User getUsername() {
		return username;
	}

	public void setUsername(User username) {
		this.username = username;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public KullaniciRole getAuthority() {
		return authority;
	}

	public void setAuthority(KullaniciRole authority) {
		this.authority = authority;
	}
	
}
