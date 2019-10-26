package com.hititcs.intern.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hititcs.intern.domain.Calisan;
import com.hititcs.intern.service.CalisanService;


@Controller
public class CalisanController {

	@Autowired
	private CalisanService calisanService;
	
	

	@GetMapping("/formgoster")
	public String main(Model model) {
		model.addAttribute("calisanlar", calisanService.findAll());
		return "welcome";
	}

	@RequestMapping(value = "/calisanYeni", method = RequestMethod.GET)
	public String ekleSayfasi() {

		return "calisan-ekle";

	}

	@RequestMapping("/calisan-ekle")
	public String getEkleSayfasi( HttpServletRequest request, Model model) {

		String ad = request.getParameter("ad");
		String soyad = request.getParameter("soyad");
		String email = request.getParameter("email");
		
		Calisan calisan= new Calisan();
		calisan.setAd(ad);
		calisan.setSoyad(soyad);
		calisan.setEmail(email);
		calisanService.save(calisan);
//		calisanlar.ekle(ad, soyad, email);
		model.addAttribute("calisanlar", calisanService.findAll());
		return "welcome";
	}

	@RequestMapping("/calisan-sil")
	public String silSayfasi(HttpServletRequest request, Model model) {

		String id = request.getParameter("sil");
		int idsi = Integer.parseInt(id);
		calisanService.deleteById(idsi);
//		calisanlar.sil(idsi);

		model.addAttribute("calisanlar", calisanService.findAll());
		return "welcome";
	}

	@RequestMapping(value = "/calisanGuncelle", method = RequestMethod.GET)
	public String getguncelleSayfasi(HttpServletRequest request, Model model) {

		String id = request.getParameter("id");
		int idsi = Integer.parseInt(id);
//		Map<String, Object> getir = proje.getir(idsi);
		

		model.addAttribute("calisan", calisanService.findAllById(idsi));

		return "calisan-guncelle";

	}

	@RequestMapping("/calisan-guncelle")
	public String guncelleSayfasi(HttpServletRequest request, Model model) {

		String id = request.getParameter("id");
		String ad = request.getParameter("ad");
		String soyad = request.getParameter("soyad");
		String email = request.getParameter("email");
		int idsi = Integer.parseInt(id);
		
		Calisan calisan= new Calisan( idsi, ad, soyad, email);
		calisanService.save(calisan);
		
//		calisanlar.guncelle(idsi, ad, soyad, email);

		model.addAttribute("calisanlar", calisanService.findAll());
		return "welcome";

	}
}
