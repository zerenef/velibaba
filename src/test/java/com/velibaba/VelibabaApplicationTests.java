package com.velibaba;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.velibaba.model.Authorities;
import com.velibaba.model.KullaniciRole;
import com.velibaba.model.User;
import com.velibaba.model.urunModel.AltKategori;
import com.velibaba.model.urunModel.Kategori;
import com.velibaba.model.urunModel.UrunOzellikleri;
import com.velibaba.model.urunModel.Urunler;
import com.velibaba.model.urunModel.UstKategori;
import com.velibaba.service.ServiceAltKategori;
import com.velibaba.service.ServiceAuthorities;
import com.velibaba.service.ServiceKategori;
import com.velibaba.service.ServiceUrunOzellikleri;
import com.velibaba.service.ServiceUrunler;
import com.velibaba.service.ServiceUser;
import com.velibaba.service.ServiceUstKategori;

@SpringBootTest
class VelibabaApplicationTests {

	@Autowired 
	private ServiceUser kullanicilarService;
	
	@Autowired 
	private ServiceAuthorities authoritiesService;
	
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
	
	
	@Test
	void contextLoads() {
	}

	@Test
	public void createUser() {
		  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
		  User user = new User(); 
		  user.setEnabled(true);
		  user.setUsername("kadirirpik17@gmail.com"); 
		  user.setPassword(passwordEncoder.encode("1453")); 
		  user.setAd("Kadir");
		  user.setSoyad("İrpik");
		  
		  Authorities authorities = new Authorities();
		  authorities.setAuthority(KullaniciRole.USER);
		  authorities.setUsername(user);
		  
		  kullanicilarService.createKullanici(user);
		  authoritiesService.createAuthorities(authorities);
	}
	
	public UstKategori createMenuUstKategori(String kategoriAdi) { 
		UstKategori kategori = new UstKategori(); 
		kategori.setUstKategoriAdi(kategoriAdi); 
		return kategori; 
	}
	
	public Kategori createMenuKategori(String kategoriAdi, String ustKategoriAdi) {
		Kategori kategori = new Kategori(); 
		kategori.setKategoriAdi(kategoriAdi); 
		kategori.setUstKategori(ustKategoriService.getByName(ustKategoriAdi));
		return kategori; 
	}
	
	public AltKategori createMenuAltKategori(String kategoriAdi, String UstKategoriAdi) { 
		AltKategori kategori = new AltKategori(); 
		kategori.setAltKategoriAdi(kategoriAdi); 
		kategori.setKategori(kategoriService.getByName(UstKategoriAdi));
		kategori.setUrl(kategori.getId());
		return kategori; 
	}
	
	@Test
	public void createUstMenu() {
		  ustKategoriService.createKategori(createMenuUstKategori("Elektronik"));
		  ustKategoriService.createKategori(createMenuUstKategori("Spor"));
		  ustKategoriService.createKategori(createMenuUstKategori("Kişisel Bakım, Kozmetik"));
		  ustKategoriService.createKategori(createMenuUstKategori("Kitap, Film, Müzik"));
		  ustKategoriService.createKategori(createMenuUstKategori("Moda"));

	}
	
	@Test
	public void createMenu() {
		kategoriService.createKategori(createMenuKategori("Bilgisayar", "Elektronik"));
		Kategori k = kategoriService.getByName("Bilgisayar");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Tablet", "Elektronik"));
		k = kategoriService.getByName("Tablet");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Telefon", "Elektronik"));
		k = kategoriService.getByName("Telefon");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("TV", "Elektronik"));
		k = kategoriService.getByName("TV");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Yazıcı", "Elektronik"));
		k = kategoriService.getByName("Yazıcı");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Beyaz Eşya", "Elektronik"));
		k = kategoriService.getByName("Beyaz Eşya");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		
		kategoriService.createKategori(createMenuKategori("Spor Giyim", "Spor"));
		k = kategoriService.getByName("Spor Giyim");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Spor Ayakkabı", "Spor"));
		k = kategoriService.getByName("Spor Ayakkabı");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Kamp Malzemeleri", "Spor"));
		k = kategoriService.getByName("Kamp Malzemeleri");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Balıkçılık Malzemeleri", "Spor"));
		k = kategoriService.getByName("Balıkçılık Malzemeleri");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Spor Aksesuar", "Spor"));
		k = kategoriService.getByName("Spor Aksesuar");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Fitness-Kondisyon", "Spor"));
		k = kategoriService.getByName("Fitness-Kondisyon");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		
		kategoriService.createKategori(createMenuKategori("Parfüm", "Kişisel Bakım, Kozmetik"));
		k = kategoriService.getByName("Parfüm");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Makyaj", "Kişisel Bakım, Kozmetik"));
		k = kategoriService.getByName("Makyaj");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Cilt Bakımı", "Kişisel Bakım, Kozmetik"));
		k = kategoriService.getByName("Cilt Bakımı");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Saç Bakımı", "Kişisel Bakım, Kozmetik"));
		k = kategoriService.getByName("Saç Bakımı");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Güneş Bakım", "Kişisel Bakım, Kozmetik"));
		k = kategoriService.getByName("Güneş Bakım");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		
		kategoriService.createKategori(createMenuKategori("Kitap", "Kitap, Film, Müzik"));
		k = kategoriService.getByName("Kitap");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Film", "Kitap, Film, Müzik"));
		k = kategoriService.getByName("Film");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Müzik", "Kitap, Film, Müzik"));
		k = kategoriService.getByName("Müzik");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		
		kategoriService.createKategori(createMenuKategori("Kadın Giyim", "Moda"));
		k = kategoriService.getByName("Kadın Giyim");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Erkek Giyim", "Moda"));
		k = kategoriService.getByName("Erkek Giyim");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Çocuk Giyim", "Moda"));
		k = kategoriService.getByName("Çocuk Giyim");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Kadın Ayakkabı", "Moda"));
		k = kategoriService.getByName("Kadın Ayakkabı");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Erkek Ayakkabı", "Moda"));
		k = kategoriService.getByName("Erkek Ayakkabı");
		k.setUrl();
		kategoriService.updateKategori(k);
		
		kategoriService.createKategori(createMenuKategori("Çocuk Ayakkabı", "Moda"));
		k = kategoriService.getByName("Çocuk Ayakkabı");
		k.setUrl();
		kategoriService.updateKategori(k);
	}
	
	@Test
	public void createAltMenu() {
		  altKategoriService.createKategori(createMenuAltKategori("Tablet", "Bilgisayar"));
		  AltKategori a = altKategoriService.getByName("Tablet");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  /*
		  altKategoriService.createKategori(createMenuAltKategori("Masaüstü Bilgisayar", "Bilgisayar"));
		  a = altKategoriService.getByName("Masaüstü Bilgisayar");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Bilgisayar Bileşenleri", "Bilgisayar"));
		  a = altKategoriService.getByName("Bilgisayar Bileşenleri");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Çevre Birimler", "Bilgisayar"));
		  a = altKategoriService.getByName("Çevre Birimler");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Aksesuarlar", "Bilgisayar"));
		  a = altKategoriService.getByName("Aksesuarlar");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Veri Depolama", "Bilgisayar"));
		  a = altKategoriService.getByName("Veri Depolama");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Apple", "Tablet"));
		  a = altKategoriService.getByName("Apple");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Samsung", "Tablet"));
		  a = altKategoriService.getByName("Samsung");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Lenovo", "Tablet"));
		  a = altKategoriService.getByName("Lenovo");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Huawei", "Tablet"));
		  a = altKategoriService.getByName("Huawei");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Cep Telefonu", "Telefon"));
		  a = altKategoriService.getByName("Cep Telefonu");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Akıllı Saatler", "Telefon"));
		  a = altKategoriService.getByName("Akıllı Saatler");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Powerbank", "Telefon"));
		  a = altKategoriService.getByName("Powerbank");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Kulaklık", "Telefon"));
		  a = altKategoriService.getByName("Kulaklık");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Kılıflar", "Telefon"));
		  a = altKategoriService.getByName("Kılıflar");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  
		  altKategoriService.createKategori(createMenuAltKategori("Televizyon", "TV"));
		  a = altKategoriService.getByName("Televizyon");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Ev Sinema Sistemleri", "TV"));
		  a = altKategoriService.getByName("Ev Sinema Sistemleri");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Müzik Sistemleri", "TV"));
		  a = altKategoriService.getByName("Müzik Sistemleri");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Projeksiyon Sistemleri", "TV"));
		  a = altKategoriService.getByName("Projeksiyon Sistemleri");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  
		  altKategoriService.createKategori(createMenuAltKategori("Yazıcılar", "Yazıcı"));
		  a = altKategoriService.getByName("Yazıcılar");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Sarf Malzemeleri", "Yazıcı"));
		  a = altKategoriService.getByName("Sarf Malzemeleri");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  
		  altKategoriService.createKategori(createMenuAltKategori("Çamaşır Makineleri", "Beyaz Eşya"));
		  a = altKategoriService.getByName("Çamaşır Makineleri");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Buzdolapları", "Beyaz Eşya"));
		  a = altKategoriService.getByName("Buzdolapları");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Bulaşık Makineleri", "Beyaz Eşya"));
		  a = altKategoriService.getByName("Bulaşık Makineleri");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Kurutma Makineleri", "Beyaz Eşya"));
		  a = altKategoriService.getByName("Kurutma Makineleri");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Ocaklar", "Beyaz Eşya"));
		  a = altKategoriService.getByName("Ocaklar");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Fırınlar", "Beyaz Eşya"));
		  a = altKategoriService.getByName("Fırınlar");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  //***********************
		  altKategoriService.createKategori(createMenuAltKategori("T-Shirt", "Spor Giyim"));
		  a = altKategoriService.getByName("T-Shirt");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Sweatshirt", "Spor Giyim"));
		  a = altKategoriService.getByName("Sweatshirt");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Eşofman Takımı", "Spor Giyim"));
		  a = altKategoriService.getByName("Eşofman Takımı");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Şort-Kapri", "Spor Giyim"));
		  a = altKategoriService.getByName("Şort-Kapri");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Sneaker", "Spor Ayakkabı"));
		  a = altKategoriService.getByName("Sneaker");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Koşu Ayakkabısı", "Spor Ayakkabı"));
		  a = altKategoriService.getByName("Koşu Ayakkabısı");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Kranpon", "Spor Ayakkabı"));
		  a = altKategoriService.getByName("Kranpon");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Basketbol Ayakkabısı", "Spor Ayakkabı"));
		  a = altKategoriService.getByName("Basketbol Ayakkabısı");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Çadır", "Kamp Malzemeleri"));
		  a = altKategoriService.getByName("Çadır");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Kamp Sandalyesi", "Kamp Malzemeleri"));
		  a = altKategoriService.getByName("Kamp Sandalyesi");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Kamp Masası", "Kamp Malzemeleri"));
		  a = altKategoriService.getByName("Kamp Masası");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Fenerler", "Kamp Malzemeleri"));
		  a = altKategoriService.getByName("Fenerler");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Uyku Tulumu", "Kamp Malzemeleri"));
		  a = altKategoriService.getByName("Uyku Tulumu");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Olta-Kamış Takımlar", "Balıkçılık Malzemeleri"));
		  a = altKategoriService.getByName("Olta-Kamış Takımlar");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Olta Makineleri", "Balıkçılık Malzemeleri"));
		  a = altKategoriService.getByName("Olta Makineleri");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Takım Çantaları", "Balıkçılık Malzemeleri"));
		  a = altKategoriService.getByName("Takım Çantaları");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Spor Çantası", "Spor Aksesuar"));
		  a = altKategoriService.getByName("Spor Çantası");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Ekipman Çantaları", "Spor Aksesuar"));
		  a = altKategoriService.getByName("Ekipman Çantaları");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Çorap", "Spor Aksesuar"));
		  a = altKategoriService.getByName("Çorap");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Şapka", "Spor Aksesuar"));
		  a = altKategoriService.getByName("Şapka");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Koşu Bandı", "Fitness-Kondisyon"));
		  a = altKategoriService.getByName("Koşu Bandı");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Kondisyon Bisikleti", "Fitness-Kondisyon"));
		  a = altKategoriService.getByName("Kondisyon Bisikleti");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Dambıl ve Ağırlık Plakaları", "Fitness-Kondisyon"));
		  a = altKategoriService.getByName("Dambıl ve Ağırlık Plakaları");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		//***********************
		  
		  altKategoriService.createKategori(createMenuAltKategori("Kadın Parfüm", "Parfüm"));
		  a = altKategoriService.getByName("Kadın Parfüm");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Erkek Parfüm", "Parfüm"));
		  a = altKategoriService.getByName("Erkek Parfüm");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Çocuk Parfüm", "Parfüm"));
		  a = altKategoriService.getByName("Çocuk Parfüm");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Maskara", "Makyaj"));
		  a = altKategoriService.getByName("Maskara");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Göz Farı", "Makyaj"));
		  a = altKategoriService.getByName("Göz Farı");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Fondöten", "Makyaj"));
		  a = altKategoriService.getByName("Fondöten");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Eyeliner", "Makyaj"));
		  a = altKategoriService.getByName("Eyeliner");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Ruj", "Makyaj"));
		  a = altKategoriService.getByName("Ruj");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Yüz Bakımı", "Cilt Bakımı"));
		  a = altKategoriService.getByName("Yüz Bakımı");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Dudak Bakımı", "Cilt Bakımı"));
		  a = altKategoriService.getByName("Dudak Bakımı");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("El Bakımı", "Cilt Bakımı"));
		  a = altKategoriService.getByName("El Bakımı");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Maske", "Cilt Bakımı"));
		  a = altKategoriService.getByName("Maske");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Şampuan", "Saç Bakımı"));
		  a = altKategoriService.getByName("Şampuan");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Saç Kremi", "Saç Bakımı"));
		  a = altKategoriService.getByName("Saç Kremi");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Saç Köpüğü", "Saç Bakımı"));
		  a = altKategoriService.getByName("Saç Köpüğü");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Saç Spreyi", "Saç Bakımı"));
		  a = altKategoriService.getByName("Saç Spreyi");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Saç Boyası", "Saç Bakımı"));
		  a = altKategoriService.getByName("Saç Boyası");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Güneş Kremi ve Losyonlar", "Güneş Bakım"));
		  a = altKategoriService.getByName("Güneş Kremi ve Losyonlar");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Güneş Sonrası Ürünler", "Güneş Bakım"));
		  a = altKategoriService.getByName("Güneş Sonrası Ürünler");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		//***********************
		  
		  altKategoriService.createKategori(createMenuAltKategori("Edebiyat", "Kitap"));
		  a = altKategoriService.getByName("Edebiyat");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Çocuk", "Kitap"));
		  a = altKategoriService.getByName("Çocuk");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Eğitim", "Kitap"));
		  a = altKategoriService.getByName("Eğitim");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Yabancı Film", "Film"));
		  a = altKategoriService.getByName("Yabancı Film");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Yerli Film", "Film"));
		  a = altKategoriService.getByName("Yerli Film");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Belgesel", "Film"));
		  a = altKategoriService.getByName("Belgesel");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Animasyon", "Film"));
		  a = altKategoriService.getByName("Animasyon");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Albümler", "Müzik"));
		  a = altKategoriService.getByName("Albümler");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Poster", "Müzik"));
		  a = altKategoriService.getByName("Poster");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Aksesuar ve Müzikal Hediyelik", "Müzik"));
		  a = altKategoriService.getByName("Aksesuar ve Müzikal Hediyelik");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		//***********************
		  
		  altKategoriService.createKategori(createMenuAltKategori("Elbise", "Kadın Giyim"));
		  a = altKategoriService.getByName("Elbise");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);

		  altKategoriService.createKategori(createMenuAltKategori("Triko ve Kazak", "Kadın Giyim"));
		  a = altKategoriService.getByName("Triko ve Kazak");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Mont ve Kaban", "Kadın Giyim"));
		  a = altKategoriService.getByName("Mont ve Kaban");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);

		  altKategoriService.createKategori(createMenuAltKategori("Gömlek", "Kadın Giyim"));
		  a = altKategoriService.getByName("Gömlek");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Pantolon", "Kadın Giyim"));
		  a = altKategoriService.getByName("Pantolon");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Mont ve Kaban", "Erkek Giyim"));
		  a = altKategoriService.getByName("Mont ve Kaban");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Triko ve Kazak", "Erkek Giyim"));
		  a = altKategoriService.getByName("Triko ve Kazak");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Gömlek", "Erkek Giyim"));
		  a = altKategoriService.getByName("Gömlek");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Pantolon", "Erkek Giyim"));
		  a = altKategoriService.getByName("Pantolon");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Ceket", "Erkek Giyim"));
		  a = altKategoriService.getByName("Ceket");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Kız Çocuk", "Çocuk Giyim"));
		  a = altKategoriService.getByName("Kız Çocuk");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Erkek Çocuk", "Çocuk Giyim"));
		  a = altKategoriService.getByName("Erkek Çocuk");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Bebek", "Çocuk Giyim"));
		  a = altKategoriService.getByName("Bebek");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);	  
		  
		  altKategoriService.createKategori(createMenuAltKategori("Günlük Ayakkabı", "Kadın Ayakkabı"));
		  a = altKategoriService.getByName("Günlük Ayakkabı");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Spor Ayakkabı", "Kadın Ayakkabı"));
		  a = altKategoriService.getByName("Spor Ayakkabı");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Klasik Ayakkabı", "Kadın Ayakkabı"));
		  a = altKategoriService.getByName("Klasik Ayakkabı");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Topuklu Ayakkabı", "Kadın Ayakkabı"));
		  a = altKategoriService.getByName("Topuklu Ayakkabı");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Günlük Ayakkabı", "Erkek Ayakkabı"));
		  a = altKategoriService.getByName("Günlük Ayakkabı");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Spor Ayakkabı", "Erkek Ayakkabı"));
		  a = altKategoriService.getByName("Spor Ayakkabı");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Klasik Ayakkabı", "Erkek Ayakkabı"));
		  a = altKategoriService.getByName("Klasik Ayakkabı");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Bot", "Erkek Ayakkabı"));
		  a = altKategoriService.getByName("Bot");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Kız Çocuk Ayakkabı", "Çocuk Ayakkabı"));
		  a = altKategoriService.getByName("Kız Çocuk Ayakkabı");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		
		  altKategoriService.createKategori(createMenuAltKategori("Erkek Çocuk Ayakkabı", "Çocuk Ayakkabı"));
		  a = altKategoriService.getByName("Erkek Çocuk Ayakkabı");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  
		  altKategoriService.createKategori(createMenuAltKategori("Bebek Ayakkabısı", "Çocuk Ayakkabı"));
		  a = altKategoriService.getByName("Bebek Ayakkabısı");
		  a.setUrl(a.getId());
		  altKategoriService.updateKategori(a);
		  */
		  //***********************
		  
	}
	
	@Test
	public void createBilgisayar() {
		for (int i = 0; i < 8; i++) {
			
		String marka[] = {"Bambi","Ella Shoes", "Nine West", "Flo", "Luvi","Fox Shoes","Mio Gusto","Rovigo","Pembe Potin"};
		String resim[] = {"/images/bambi.jpg","/images/ella-shoes.jfif","/images/nine-west.jfif","/images/luvi.jpg",
				"/images/fox-shoes.jpg","/images/mio-gusto.jfif","/images/rovigo.jfif","/images/pembe-potin.jfif"};
 		Urunler urun = new Urunler();
		urun.setAltKategori(altKategoriService.getByName("Topuklu Ayakkabı"));
		urun.setFiyat(1000);
		urun.setIndirim(25);
		urun.setMarka(marka[i]);
		urun.setResimYolu(resim[i]);
		urun.setStok(1100);
		urun.setUrunAdi(marka[i] + " Kadın Topuklu Ayakkabı");	
		urun.setUrunAktifmi(true);
		urun.setKategori(kategoriService.getKategori(30L));
		
		urunlerService.createUrun(urun);
		
		urun.setUrl();
		urunlerService.updateUrun(urun);
		
		UrunOzellikleri urunOzellikleri = new UrunOzellikleri();
		urunOzellikleri.setUrun(urun);
		urunOzellikleri.setUrunAciklama(marka[i] + "Kadın Topuklu Ayakkabı");
		urunOzellikleri.getOzellikler().put("Renk", "Siyah");
		urunOzellikleri.getOzellikler().put("Taban Malzemesi", "Microlight");
		urunOzellikleri.getOzellikler().put("Topuk Boyu", "9 cm");
		urunOzellikleri.getOzellikler().put("Tema", "Romantic");
		urunOzellikleri.getOzellikler().put("Ürün Malzemesi", "Poliüretan-Tekstil");
		
		urunOzellikleriService.addUrunOzellik(urunOzellikleri);}
	}
	
	@Test
	public void createTablet() {
		Urunler urun = new Urunler();
		urun.setAltKategori(altKategoriService.getByName("Apple"));
		urun.setFiyat(5000);
		urun.setIndirim(2);
		urun.setMarka("Apple");
		urun.setResimYolu("/path");
		urun.setStok(1000);
		urun.setUrunAdi("Apple Tablet");	
		urun.setUrunAktifmi(true);
		urun.setKategori(kategoriService.getKategori(8L));
		
		urunlerService.createUrun(urun);
		
		urun.setUrl();
		urunlerService.updateUrun(urun);
		
		UrunOzellikleri urunOzellikleri = new UrunOzellikleri();
		urunOzellikleri.setUrun(urun);
		urunOzellikleri.getOzellikler().put("Ekran Boyutu", "10");
		urunOzellikleri.getOzellikler().put("Ram", "3GB");
		urunOzellikleri.getOzellikler().put("İşlemci", "Snapdragon");
		urunOzellikleri.getOzellikler().put("Batarya", "3000mA");
		
		urunOzellikleriService.addUrunOzellik(urunOzellikleri);
	}
	
	@Test
	public void urunUrl() {
		List<Urunler> urunler = urunlerService.getAllUrunler();
		for (Urunler urunler2 : urunler) {
			urunler2.setUrl();
			urunlerService.updateUrun(urunler2);
		}
	}
	
	@Test
	public void updateUrun() {
		List<Urunler> urunler = urunlerService.getAllUrunler();
		for (Urunler urunler2 : urunler) {
			urunler2.setUrunAktifmi(true);
			urunlerService.updateUrun(urunler2);
		}
	}
	
	@Test
	public void updateUrunÖzellik() {
		UrunOzellikleri urun = urunOzellikleriService.getIdUrunOzellikleri(83L);
		urun.setUrunAciklama("Apple Tablet 10'' ekran 3Gb Ram Snpadragon 2.6Ghz İşlemci");
		urunOzellikleriService.updateUrunOzellik(urun);
	}
	
	@Test
	public void getOzellik() {
		System.out.println(urunOzellikleriService.getIdUrunOzellikleri(450L));
	}
	
	@Test
	public void altkategoriUrlUpdate() {
		AltKategori a = altKategoriService.getByName("Masaüstü Bilgisayar");
		//a.setUrl("");
		altKategoriService.updateKategori(a);
	}
	
	
}
