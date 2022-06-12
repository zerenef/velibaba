package com.velibaba.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.velibaba.dao.RepositoryUrunlerSayfalama;
import com.velibaba.model.urunModel.Urunler;
import com.velibaba.service.ServiceAltKategori;
import com.velibaba.service.ServiceKategori;

@Service
public class ImplServiceUrunlerSayfalama{
	@Autowired
	RepositoryUrunlerSayfalama urunlerSayfalamaRepository;
	@Autowired
	ServiceAltKategori altKategoriService;
	@Autowired
	ServiceKategori kategoriService;
	
	//Integer pageSize = 1;
	int sayfaSayisi;
	
	public int getSayfaSayisi() {
		return sayfaSayisi;
	}
	
	public void setSayfaSayisi(int sayfaSayisi) {
		this.sayfaSayisi = sayfaSayisi;
	}
	

	public List<Urunler> getAllUrunler(Long id, Integer pageNo, String sortBy)
    {
		if(pageNo < 0) {
			pageNo = 0;
		}
		
		Sort siralama = Sort.by("id").ascending();
		if(sortBy.equals("indirim")) {
			siralama = Sort.by("indirim").descending();
		}else if(sortBy.equals("artan")) {
			siralama = Sort.by("fiyat").ascending();
		}else if(sortBy.equals("azalan")) {
			siralama = Sort.by("fiyat").descending();
		}else if(sortBy.equals("en-cok-satilan")) {
			siralama = Sort.by("satisMiktari").descending();
		}
		
        Pageable paging = PageRequest.of(pageNo, 20, siralama);
        Page<Urunler> pagedResult = urunlerSayfalamaRepository.findAllByAltKategoriAndUrunAktifmiAndStokGreaterThan(
        			altKategoriService.getAltKategori(id), true, 0, paging); //dizüstü bil.
        
        setSayfaSayisi(pagedResult.getTotalPages());
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Urunler>();
        }
    }

}
