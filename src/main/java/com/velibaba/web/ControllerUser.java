package com.velibaba.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.velibaba.model.Authorities;
import com.velibaba.model.KullaniciRole;
import com.velibaba.model.User;
import com.velibaba.service.ServiceAltKategori;
import com.velibaba.service.ServiceAuthorities;
import com.velibaba.service.ServiceKategori;
import com.velibaba.service.ServiceUser;
import com.velibaba.service.ServiceUstKategori;

@Controller
public class ControllerUser {

	@Autowired
	private ServiceUser userService;
	@Autowired
	private ServiceAuthorities authoritiesService;
	@Autowired
	private ServiceUstKategori ustKategoriService;
	@Autowired
	private ServiceKategori kategoriService;
	@Autowired
	private ServiceAltKategori altKategoriService;
	
	public ModelAndView mav(String title) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("ust", ustKategoriService.getAllKategori());
		mav.addObject("orta", kategoriService.getAllKategori());
		mav.addObject("alt", altKategoriService.getAllKategori());
		mav.addObject("title", title);
		return mav;
	}
	
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = mav("Giriş Yap");
		mav.setViewName("login");
		return mav;
	}
	
	
	@RequestMapping(value = "/register.html", method = RequestMethod.GET)
	public ModelAndView kayitOl() {
		ModelAndView mav = mav("Kayıt Ol");
		mav.setViewName("register");
		return mav;
	}
	
	@ModelAttribute  
	public User initModel() { 
		User u = new User();
		u.setEnabled(true);
		return u;
	}
	
	@RequestMapping(value = "/register.html", method = RequestMethod.POST)
	public ModelAndView kayit(@ModelAttribute @Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		ModelAndView mav = mav("Giriş Yap");
		
		if(bindingResult.hasErrors()) {  
			mav.setViewName("register");	
			return mav;
		}
		
		try	{	
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		Authorities authorities = new Authorities();
		authorities.setAuthority(KullaniciRole.USER);
		authorities.setUsername(user);
		
		userService.createKullanici(user);
		authoritiesService.createAuthorities(authorities);
		
		mav.addObject("message", "Hesap Oluşturuldu: " +user.getUsername());
		
		}catch (DataIntegrityViolationException e) {
			mav.addObject("message", "Kayıtlı Kullanıcı: " + user.getUsername());
			mav.setViewName("register");
			return mav;
		}catch (Exception e) {
			mav.addObject("message", "Hesap Oluşturulamadı: " + user.getUsername());
			mav.setViewName("register");
			return mav;
		} 
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value = "/kullanici-bilgilerim", method = RequestMethod.GET)
	public ModelAndView kullaniciBilgilerim() {
		ModelAndView mav = mav("Kullanıcı Profili");
		mav.setViewName("userProfile");
		return mav;
	}
	
}
