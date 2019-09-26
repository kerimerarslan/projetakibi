package com.hititcs.intern.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.hititcs.intern.repository.ICalisanlar;
import com.hititcs.intern.repository.IProje;

@Controller
public class ProjeController {
	
	@Autowired
	private ICalisanlar calisanlar;
	@Autowired
	private IProje proje;
	
	@GetMapping("/")
	public String main(Model model) {
		
		model.addAttribute("calisanlar", calisanlar.listele());

		return "welcome";
	}
	
	@RequestMapping(value = "/projeGoster", method = RequestMethod.GET)
	public String getprojeSayfasi(HttpServletRequest request, Model model) {

		String id = request.getParameter("id");
		int idsi = Integer.parseInt(id);
		Map<String, Object> getir = proje.getir(idsi);
		model.addAttribute("calisan", getir);
		model.addAttribute("calisanlar", proje.calisanListele(idsi));
		model.addAttribute("projeler", proje.projeListele(idsi));

		return "calisan-proje";

	}

	@RequestMapping("/calisan-proje")
	public String projeSayfasi(HttpServletRequest request, Model model) {

		String id = request.getParameter("id");
		String ad = request.getParameter("proje_adi");
		int idsi = Integer.parseInt(id);

		Map<String, Object> getir = proje.getir(idsi);
		model.addAttribute("calisan", getir);
		model.addAttribute("calisanlar", proje.calisanListele(idsi));
		model.addAttribute("projeler", proje.projeListele(idsi));
		return "calisan-proje";

	}


	@RequestMapping("/proje-sil")
	public String silProje(HttpServletRequest request, Model model) {

		String id = request.getParameter("silp");
		int idsi = Integer.parseInt(id);
		proje.sil(idsi);

		model.addAttribute("calisanlar", calisanlar.listele());
		return "welcome";

	}

	@RequestMapping(value = "/projeGuncelle", method = RequestMethod.GET)
	public String getprojeGuncelle(HttpServletRequest request, Model model) {

		String id = request.getParameter("id");
		int idsi = Integer.parseInt(id);
		Map<String, Object> getir = proje.proje_getir(idsi);
		model.addAttribute("projeler", getir);

		return "proje-guncelle";

	}

	@RequestMapping("/proje-guncelle")
	public String projeGuncelle(HttpServletRequest request, Model model) {

		String id = request.getParameter("id");
		String ad = request.getParameter("ad");
		int idsi = Integer.parseInt(id);

		proje.guncelle(idsi, ad);

		model.addAttribute("calisanlar", calisanlar.listele());
		return "welcome";

	}
	
	@RequestMapping(value = "/projeYeni", method = RequestMethod.GET)
	public String ekleProje(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		int idsi = Integer.parseInt(id);
		Map<String, Object> getir = proje.getir(idsi);
		model.addAttribute("calisan", getir);
		String[] gorev = {"A","B","C","D","E"};
		model.addAttribute("gorevler",gorev);
		return "proje-ekle";

	}

	@RequestMapping("/proje-ekle")
	public RedirectView getekleProje(HttpServletRequest request, Model model, RedirectAttributes attributes) {
		String id = request.getParameter("id");
		String ad = request.getParameter("proje_adi");
		int idsi = Integer.parseInt(id);
		
		String[] gorev = {"A","B","C","D","E"};
		
		String derece = request.getParameter("radioInline");
		
		String sinif = request.getParameter("sinif");
		
		String tarih = request.getParameter("tarih_son");
		System.out.println(tarih);
		
		proje.projeEkle(idsi, ad, derece, sinif, tarih);
		Map<String, Object> getir = proje.getir(idsi);
		model.addAttribute("calisan", getir);
		model.addAttribute("calisanlar", proje.calisanListele(idsi));
		model.addAttribute("projeler", proje.projeListele(idsi));
		
		model.addAttribute("gorevler",gorev);
		
	    attributes.addAttribute("id", id);
	    return new RedirectView("projeGoster");
	
	}

}
