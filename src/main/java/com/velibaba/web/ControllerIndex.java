package com.velibaba.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.velibaba.model.urunModel.Urunler;
import com.velibaba.service.ServiceAltKategori;
import com.velibaba.service.ServiceKategori;
import com.velibaba.service.ServiceUrunler;
import com.velibaba.service.ServiceUstKategori;

@Controller
public class ControllerIndex { 
	
	@Autowired
	private ServiceUstKategori ustKategoriService;
	@Autowired
	private ServiceKategori kategoriService;
	@Autowired
	private ServiceAltKategori altKategoriService;
	@Autowired
	private ServiceUrunler urunlerService;
	
	public ModelAndView mav() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("ust", ustKategoriService.getAllKategori());
		mav.addObject("orta", kategoriService.getAllKategori());
		mav.addObject("alt", altKategoriService.getAllKategori());
		return mav;
	}

	@RequestMapping(value = {"/","index.html"}, method = RequestMethod.GET)
	public ModelAndView index() {		
		ModelAndView mav =  mav();

		List<Urunler> enCokSatilan = urunlerService.getEnCokSatilan20();
		List<Urunler> getByIndirim = urunlerService.getByIndirim20();
		
		if(enCokSatilan.isEmpty() && getByIndirim.isEmpty()) {
			mav.addObject("baslik", "Bu Kategoride Ürün Bulunmuyor");
			mav.setViewName("urunYok");
			return mav;
		}else if(!enCokSatilan.isEmpty() && getByIndirim.isEmpty()) {
			mav.addObject("baslik", "En Çok Satılan Ürünler");
			mav.addObject("enCokSatilan", enCokSatilan);
		}else if(enCokSatilan.isEmpty() && !getByIndirim.isEmpty()) {
			mav.addObject("baslik", "Fırsat Ürünleri");
			mav.addObject("getByIndirim", getByIndirim);
		}else {
			mav.addObject("baslik", "En Çok Satılan Ürünler");
			mav.addObject("enCokSatilan", enCokSatilan);
			mav.addObject("firsatUrunleri", "Fırsat Ürünleri");
			mav.addObject("getByIndirim", getByIndirim);
		}
			
		mav.setViewName("index");
		return mav;
	}

}
