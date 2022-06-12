package com.velibaba.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.velibaba.model.urunModel.UrunOzellikleri;
import com.velibaba.model.urunModel.Urunler;
import com.velibaba.service.ServiceAltKategori;
import com.velibaba.service.ServiceKategori;
import com.velibaba.service.ServiceUrunOzellikleri;
import com.velibaba.service.ServiceUrunler;
import com.velibaba.service.ServiceUstKategori;

@Controller
public class ControllerUrunOzellikleri {
	
	@Autowired
	private ServiceUstKategori ustKategoriService;
	@Autowired
	private ServiceKategori kategoriService;
	@Autowired
	private ServiceAltKategori altKategoriService;
	@Autowired
	private ServiceUrunler urunlerService;
	@Autowired
	private ServiceUrunOzellikleri urunOzellikleriService;
	
	public ModelAndView mav(String title) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("ust", ustKategoriService.getAllKategori());
		mav.addObject("orta", kategoriService.getAllKategori());
		mav.addObject("alt", altKategoriService.getAllKategori());
		mav.addObject("title", title);
		return mav;
	}
	
	@RequestMapping(value = "/urun-detay{url}", method = RequestMethod.GET) //urun-detay?url=hp-dizustu-150
	public ModelAndView elektronikOzellikler(@RequestParam String url) {

		String[] urlIdBul = url.split("-"); 
		
		Long urunId = Long.valueOf(urlIdBul[urlIdBul.length-1]);
		
		Urunler urun = urunlerService.getById(urunId);
		
		ModelAndView mav = mav(urun.getUrunAdi());
		
		mav.addObject("urunBilgisi", urun);
		
		UrunOzellikleri uo = urunOzellikleriService.getOzellikUrun(urun);
		
		mav.addObject("urunAciklama", uo.getUrunAciklama());
		mav.addObject("ozellikler", uo.getOzellikler());
		
		mav.setViewName("urunDetay");
		return mav;
	}
	
}
