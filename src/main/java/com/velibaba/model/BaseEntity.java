package com.velibaba.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Version
	@Column(name = "version", columnDefinition = "bigint default 0")
	private Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
