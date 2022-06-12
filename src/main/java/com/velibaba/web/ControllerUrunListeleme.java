package com.velibaba.web;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.velibaba.model.UrunFiltre;
import com.velibaba.model.urunModel.AltKategori;
import com.velibaba.model.urunModel.Kategori;
import com.velibaba.model.urunModel.Urunler;
import com.velibaba.service.ServiceAltKategori;
import com.velibaba.service.ServiceKategori;
import com.velibaba.service.ServiceUrunler;
import com.velibaba.service.ServiceUstKategori;

@Controller
public class ControllerUrunListeleme {
	
	@Autowired
	private ServiceUstKategori ustKategoriService;
	
	@Autowired
	private ServiceKategori kategoriService;
	
	@Autowired
	private ServiceAltKategori altKategoriService;
	
	@Autowired
	private ServiceUrunler urunlerService;
	
	private UrunFiltre urunFiltre;
	
	private Long tempId = -1L;

	public ModelAndView mav(String title) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("ust", ustKategoriService.getAllKategori());
		mav.addObject("orta", kategoriService.getAllKategori());
		mav.addObject("alt", altKategoriService.getAllKategori());
		mav.addObject("title", title);
		return mav;
	}
	
	@ModelAttribute
	public UrunFiltre newUrunFiltre() {
		return new UrunFiltre();
	}
	
	@RequestMapping(value = "/urun-kategori-{id}", method = RequestMethod.GET) // /urun-kategori-{id}?pageNo=0&sortBy=artan
	public ModelAndView urunListeleme(@PathVariable Long id, @RequestParam(defaultValue="0") Integer pageNo, 
									  @RequestParam(defaultValue = "id") String sortBy){
		if(tempId == -1L) {
			tempId = id;
		}
		if(id != tempId) {
			this.urunFiltre = null;
			tempId = id;
		}
		
		PageCount s = new PageCount();
		if(pageNo > s.getSayfaSayisi()-1) {
			pageNo = 0;
		}
		if(pageNo < 0) {
			pageNo = 0;
		}
		
		AltKategori ak = altKategoriService.getAltKategori(id);
		ModelAndView mav = mav(ak.getAltKategoriAdi());
		List<String> markalar = new ArrayList<>();
		for (Tuple tuple : urunlerService.getAllMarka(ak)) {
			markalar.add(tuple.get("marka").toString());
		}
		mav.addObject("markalar", markalar);
		
		if(urunFiltre != null) {	
			List<String> markaChec = new ArrayList<>();
			if(urunFiltre.getMarkalar() != null) {
				for (int i = 0; i < urunFiltre.getMarkalar().length; i++) {
					markaChec.add(urunFiltre.getMarkalar()[i]);
				}
				mav.addObject("markaChec", markaChec);
			}
			
			if(!urunFiltre.getFiyatMin().equals("")) {
				mav.addObject("minValue", urunFiltre.getFiyatMin());
			}
			if(!urunFiltre.getFiyatMax().equals("")) {
				mav.addObject("maxValue", urunFiltre.getFiyatMax());
			}
			
			if(urunFiltre.getIndirim() != null) {
				mav.addObject("indirimChec", true);
			}
		}
		
		List<Urunler> list = urunlerService.getUrunler(ak, pageNo, sortBy, urunFiltre);
		if(list.isEmpty()) {
			mav.addObject("baslik", "Bu Kategoride Ürün Bulunmuyor");
			mav.setViewName("urunYok");
			return mav;
		}
		mav.addObject("list", list);
		mav.addObject("pageNo", pageNo);
		mav.addObject("baslik", ak.getAltKategoriAdi());
		
		if(pageNo == 0 && s.getSayfaSayisi() == 1) {
			mav.addObject("begin", 0);
			mav.addObject("end", 0);
		}else if(pageNo == 0 && s.getSayfaSayisi() == 2) {
			mav.addObject("begin", 0);
			mav.addObject("end", 1);
		}else if(pageNo == 1 && s.getSayfaSayisi() == 2) {
			mav.addObject("begin", 0);
			mav.addObject("end", 1);
		}else if(pageNo == 0) {
			mav.addObject("begin", 0);
			mav.addObject("end", 2);
		}else if(s.getSayfaSayisi()-2 == pageNo){
			mav.addObject("begin", pageNo-1);
		mav.addObject("end", pageNo+1);
		}else if(s.getSayfaSayisi()-2 > pageNo) {
			mav.addObject("begin", pageNo);
			mav.addObject("end", pageNo+2);
		}else if(s.getSayfaSayisi()-1 > pageNo) {
			mav.addObject("begin", pageNo-1);
			mav.addObject("end", pageNo+1);
		}else if(s.getSayfaSayisi() > pageNo) {
			mav.addObject("begin", pageNo-2);
			mav.addObject("end", pageNo);
		}	
		mav.addObject("sayfaSayisi", s.getSayfaSayisi());
		
		mav.addObject("linkStart", "/urun-kategori-"+id+"?pageNo=");
		mav.addObject("linkEnd", "&sortBy="+sortBy);
		mav.addObject("ajaxLinkStart", "/urun-kategori-"+id+"-sirala?pageNo=0&sortBy=");
		mav.addObject("uygula", "reset");
		
		mav.setViewName("urunListele");
		return mav;
	}
	
	@RequestMapping(value = "/urun-kategori-{id}", method = RequestMethod.POST, params="uygula") // /urun-kategori-{id}?pageNo=0&sortBy=artan
	public ModelAndView urunListelemePost(@PathVariable Long id, @RequestParam(defaultValue="0") Integer pageNo, 
									  @RequestParam(defaultValue = "id") String sortBy, @ModelAttribute UrunFiltre urunFiltre){
		pageNo = 0;
		this.urunFiltre = urunFiltre;
		
		AltKategori ak = altKategoriService.getAltKategori(id);
		ModelAndView mav = mav(ak.getAltKategoriAdi());
		List<String> markalar = new ArrayList<>();
		for (Tuple tuple : urunlerService.getAllMarka(ak)) {
			markalar.add(tuple.get("marka").toString());
		}
		mav.addObject("markalar", markalar);
		
		if(urunFiltre != null) {
			List<String> markaChec = new ArrayList<>();
			if(urunFiltre.getMarkalar() != null) {
				for (int i = 0; i < urunFiltre.getMarkalar().length; i++) {
					markaChec.add(urunFiltre.getMarkalar()[i]);
				}
				mav.addObject("markaChec", markaChec);
			}
			
			if(!urunFiltre.getFiyatMin().equals("") && !urunFiltre.getFiyatMax().equals("")) {
				if(Double.valueOf(urunFiltre.getFiyatMin()) >= 0 && Double.valueOf(urunFiltre.getFiyatMax()) >= 0) {
					if(Double.valueOf(urunFiltre.getFiyatMin()) > Double.valueOf(urunFiltre.getFiyatMax())) {
						urunFiltre.setFiyatMin("");
						urunFiltre.setFiyatMax("");
						mav.addObject("fiyatError", "Hatalı Fiyat Aralığı.!");
					}
				}
			}
			if(!urunFiltre.getFiyatMin().equals("")) {
				if(Double.valueOf(urunFiltre.getFiyatMin()) >= 0) {
					mav.addObject("minValue", urunFiltre.getFiyatMin());
				}else {
					mav.addObject("fiyatError", "Minimum fiyat 0'dan küçük olamaz");
					urunFiltre.setFiyatMin("");
				}
			}
			if(!urunFiltre.getFiyatMax().equals("")) {
				if(Double.valueOf(urunFiltre.getFiyatMax()) >= 0) {
					mav.addObject("maxValue", urunFiltre.getFiyatMax());
				}else {
					mav.addObject("fiyatError", "Maksimum fiyat 0'dan küçük olamaz");
					urunFiltre.setFiyatMax("");
				}			
			}
			
			if(urunFiltre.getIndirim() != null) {
				mav.addObject("indirimChec", true);
			}
		}

		List<Urunler> list = urunlerService.getUrunler(ak, pageNo, sortBy, urunFiltre);
		if(list.isEmpty()) {
			mav.addObject("baslik", "Ürün Bulunmuyor");
			mav.addObject("sayfaNoGizle", true);
			mav.setViewName("urunListele");
			return mav;
		}
		mav.addObject("list", list);
		mav.addObject("pageNo", pageNo);
		mav.addObject("baslik", ak.getAltKategoriAdi());
		
		PageCount s = new PageCount();
		if(pageNo == 0 && s.getSayfaSayisi() == 1) {
			mav.addObject("begin", 0);
			mav.addObject("end", 0);
		}else if(pageNo == 0 && s.getSayfaSayisi() == 2) {
			mav.addObject("begin", 0);
			mav.addObject("end", 1);
		}else if(pageNo == 0) {
			mav.addObject("begin", 0);
			mav.addObject("end", 2);
		}	
		mav.addObject("sayfaSayisi", s.getSayfaSayisi());
		
		mav.addObject("linkStart", "/urun-kategori-"+id+"?pageNo=");
		mav.addObject("linkEnd", "&sortBy="+sortBy);
		mav.addObject("ajaxLinkStart", "/urun-kategori-"+id+"-sirala?pageNo=0&sortBy=");
		mav.addObject("uygula", "submit");
		
		mav.setViewName("urunListele");
		return mav;
	}
	
	@RequestMapping(value = "/urun-kategori-{id}", method = RequestMethod.POST, params="reset") // /urun-kategori-{id}?pageNo=0&sortBy=artan
	public ModelAndView urunListelemePostReset(@PathVariable Long id, @RequestParam(defaultValue="0") Integer pageNo, 
									  @RequestParam(defaultValue = "id") String sortBy, @ModelAttribute UrunFiltre urunFiltre){
		pageNo = 0;
		urunFiltre = null;
		this.urunFiltre = urunFiltre;
		
		AltKategori ak = altKategoriService.getAltKategori(id);
		ModelAndView mav = mav(ak.getAltKategoriAdi());
		List<String> markalar = new ArrayList<>();
		for (Tuple tuple : urunlerService.getAllMarka(ak)) {
			markalar.add(tuple.get("marka").toString());
		}
		mav.addObject("markalar", markalar);

		List<Urunler> list = urunlerService.getUrunler(ak, pageNo, sortBy, urunFiltre);

		
		if(list.isEmpty()) {
			mav.addObject("baslik", "Bu Kategoride Ürün Bulunmuyor");
			mav.setViewName("urunYok");
			return mav;
		}
		mav.addObject("list", list);
		mav.addObject("pageNo", pageNo);
		mav.addObject("baslik", ak.getAltKategoriAdi());
		
		PageCount s = new PageCount();
		if(pageNo == 0 && s.getSayfaSayisi() == 1) {
			mav.addObject("begin", 0);
			mav.addObject("end", 0);
		}else if(pageNo == 0 && s.getSayfaSayisi() == 2) {
			mav.addObject("begin", 0);
			mav.addObject("end", 1);
		}else if(pageNo == 0) {
			mav.addObject("begin", 0);
			mav.addObject("end", 2);
		}	
		mav.addObject("sayfaSayisi", s.getSayfaSayisi());
		
		mav.addObject("linkStart", "/urun-kategori-"+id+"?pageNo=");
		mav.addObject("linkEnd", "&sortBy="+sortBy);
		mav.addObject("ajaxLinkStart", "/urun-kategori-"+id+"-sirala?pageNo=0&sortBy=");
		mav.addObject("uygula", "reset");
		

		
		mav.setViewName("urunListele");
		return mav;
	}
	
	@RequestMapping(value = "/urun-kategori-{id}-sirala", method = RequestMethod.GET) // /urun-kategori-{id}?pageNo=0&sortBy=artan
	public ModelAndView urunListelemeAjax(@PathVariable Long id, @RequestParam(defaultValue="0") Integer pageNo, 
									  @RequestParam(defaultValue = "id") String sortBy){
		pageNo = 0;
		
		AltKategori ak = altKategoriService.getAltKategori(id);
		ModelAndView mav = mav(ak.getAltKategoriAdi());
		List<String> markalar = new ArrayList<>();
		for (Tuple tuple : urunlerService.getAllMarka(ak)) {
			markalar.add(tuple.get("marka").toString());
		}
		mav.addObject("markalar", markalar);

		List<Urunler> list = urunlerService.getUrunler(ak, pageNo, sortBy, urunFiltre);
		if(list.isEmpty()) {
			mav.addObject("baslik", "Bu Kategoride Ürün Bulunmuyor");
			mav.setViewName("urunYok");
			return mav;
		}
		mav.addObject("list", list);
		mav.addObject("pageNo", pageNo);
		mav.addObject("baslik", ak.getAltKategoriAdi());
		
		PageCount s = new PageCount();
		if(pageNo == 0 && s.getSayfaSayisi() == 1) {
			mav.addObject("begin", 0);
			mav.addObject("end", 0);
		}else if(pageNo == 0 && s.getSayfaSayisi() == 2) {
			mav.addObject("begin", 0);
			mav.addObject("end", 1);
		}else if(pageNo == 0) {
			mav.addObject("begin", 0);
			mav.addObject("end", 2);
		}
		mav.addObject("sayfaSayisi", s.getSayfaSayisi());
		
		mav.addObject("linkStart", "/urun-kategori-"+id+"?pageNo=");
		mav.addObject("linkEnd", "&sortBy="+sortBy);
		mav.addObject("ajaxLinkStart", "/urun-kategori-"+id+"-sirala?pageNo=0&sortBy=");
		
		mav.setViewName("item");
		return mav;
	}
	
	@RequestMapping(value = "/kategori-{id}", method = RequestMethod.GET) // /kategori-{id}?pageNo=0&sortBy=en-cok-satilan
	public ModelAndView enCokSatilanUrunListeleme(@PathVariable Long id){
		
		Kategori k = kategoriService.getKategori(id);
		
		ModelAndView mav = mav(k.getKategoriAdi());
		
		List<Urunler> enCokSatilan = urunlerService.getEnCokSatilan(k);
		List<Urunler> getByIndirim = urunlerService.getByIndirim(k);
		
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
			
		mav.setViewName("urunEnCokSatilan");
		return mav;
	}

}
