package com.velibaba.model;

import java.util.Arrays;

public class UrunFiltre {
	private String[] markalar;
	private String fiyatMin;
	private String fiyatMax;
	private String indirim;
	
	public String[] getMarkalar() {
		return markalar;
	}
	
	public void setMarkalar(String[] markalar) {
		this.markalar = markalar;
	}
	
	public String getFiyatMin() {
		return fiyatMin;
	}
	
	public void setFiyatMin(String fiyatMin) {
		this.fiyatMin = fiyatMin;
	}
	
	public String getFiyatMax() {
		return fiyatMax;
	}
	
	public void setFiyatMax(String fiyatMax) {
		this.fiyatMax = fiyatMax;
	}
	
	public String getIndirim() {
		return indirim;
	}
	
	public void setIndirim(String indirim) {
		this.indirim = indirim;
	}
	
	@Override
	public String toString() {
		return "UrunFiltre [markalar=" + Arrays.toString(markalar) + ", fiyatMin=" + fiyatMin + ", fiyatMax=" + fiyatMax
				+ ", indirim=" + indirim + "]";
	}

}
