package com.hititcs.intern.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hititcs.intern.repository.ICalisanlar;
import com.hititcs.intern.repository.IProje;

@Controller
public class CalisanController {

	@Autowired
	private ICalisanlar calisanlar;
	@Autowired
	private IProje proje;

	@GetMapping("/formgoster")
	public String main(Model model) {

		model.addAttribute("calisanlar", calisanlar.listele());
		return "welcome";
	}

	@RequestMapping(value = "/calisanYeni", method = RequestMethod.GET)
	public String ekleSayfasi() {

		return "calisan-ekle";

	}

	@RequestMapping("/calisan-ekle")
	public String getEkleSayfasi( HttpServletRequest request, Model model) {

		@NotNull
		String ad = request.getParameter("ad");
		@NotNull
		@Size(min=3, message="boş birakilamaz")
		String soyad = request.getParameter("soyad");
		@Email
		String email = request.getParameter("email");

		calisanlar.ekle(ad, soyad, email);
		model.addAttribute("calisanlar", calisanlar.listele());
		return "welcome";
	}

	@RequestMapping("/calisan-sil")
	public String silSayfasi(HttpServletRequest request, Model model) {

		String id = request.getParameter("sil");
		int idsi = Integer.parseInt(id);
		calisanlar.sil(idsi);

		model.addAttribute("calisanlar", calisanlar.listele());
		return "welcome";
	}

	@RequestMapping(value = "/calisanGuncelle", method = RequestMethod.GET)
	public String getguncelleSayfasi(HttpServletRequest request, Model model) {

		String id = request.getParameter("id");
		int idsi = Integer.parseInt(id);
		Map<String, Object> getir = proje.getir(idsi);

		model.addAttribute("calisan", getir);

		return "calisan-guncelle";

	}

	@RequestMapping("/calisan-guncelle")
	public String guncelleSayfasi(HttpServletRequest request, Model model) {

		String id = request.getParameter("id");
		String ad = request.getParameter("ad");
		String soyad = request.getParameter("soyad");
		String email = request.getParameter("email");
		int idsi = Integer.parseInt(id);

		calisanlar.guncelle(idsi, ad, soyad, email);

		model.addAttribute("calisanlar", calisanlar.listele());
		return "welcome";

	}
}
