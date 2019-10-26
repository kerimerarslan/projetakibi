package com.hititcs.intern.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.hititcs.intern.domain.Calisan;
import com.hititcs.intern.domain.ProjeEntity;
import com.hititcs.intern.service.CalisanService;
import com.hititcs.intern.service.ProjeService;

@Controller
public class ProjeController {

	@Autowired
	private CalisanService calisanService;
	@Autowired
	private ProjeService projeService;

	@GetMapping("/")
	public String main(Model model) {

		model.addAttribute("calisanlar", calisanService.findAll());

		return "welcome";
	}

	@RequestMapping(value = "/projeGoster", method = RequestMethod.GET)
	public String getprojeSayfasi(HttpServletRequest request, Model model) {

		String id = request.getParameter("id");
		int idsi = Integer.parseInt(id);
//		Map<String, Object> getir = proje.getir(idsi);

		model.addAttribute("calisan", calisanService.findAllById(idsi));
		model.addAttribute("calisanlar", calisanService.findAllById(idsi));
		Calisan temp = new Calisan();
		temp.setId(idsi);
		model.addAttribute("projeler", projeService.findAllByCalisan(temp));

		return "calisan-proje";

	}

	@RequestMapping("/calisan-proje")
	public String projeSayfasi(HttpServletRequest request, Model model) {

		String id = request.getParameter("id");
		String ad = request.getParameter("proje_adi");
		int idsi = Integer.parseInt(id);

//		Map<String, Object> getir = proje.getir(idsi);
		Calisan temp = new Calisan();
		temp.setId(idsi);
		model.addAttribute("calisan", calisanService.findAllById(idsi));
		model.addAttribute("calisanlar", calisanService.findAllById(idsi));
		model.addAttribute("projeler", projeService.findAllByCalisan(temp));
		return "calisan-proje";

	}

	@RequestMapping("/proje-sil")
	public RedirectView silProje(HttpServletRequest request, Model model, RedirectAttributes attributes) {

		String id = request.getParameter("silp");
		int idsi = Integer.parseInt(id);
		String calisan_id = request.getParameter("calisan_id");
		int calisan_idsi = Integer.parseInt(calisan_id);

		projeService.deleteById(idsi);
//		proje.sil(idsi);
		attributes.addAttribute("id", calisan_id);
		return new RedirectView("projeGoster");

	}

	@RequestMapping(value = "/projeGuncelle", method = RequestMethod.GET)
	public String getprojeGuncelle(HttpServletRequest request, Model model) {

		String id = request.getParameter("id");
		int idsi = Integer.parseInt(id);
//		Map<String, Object> getir = proje.proje_getir(idsi);
		model.addAttribute("projeler", projeService.findAllById(idsi));
		String[] gorev = { "A", "B", "C", "D", "E" };
		model.addAttribute("gorevler", gorev);
		return "proje-guncelle";

	}

	@RequestMapping("/proje-guncelle")
	public RedirectView projeGuncelle(HttpServletRequest request, Model model, RedirectAttributes attributes)
			throws ParseException {

		String id = request.getParameter("id");
		String ad = request.getParameter("ad");
		int idsi = Integer.parseInt(id);

		Calisan cali = new Calisan();

//		Map<String, Object> getir = proje.proje_getir(idsi);
		model.addAttribute("projeler", projeService.findAllById(idsi));

		String[] gorev = { "A", "B", "C", "D", "E" };
		model.addAttribute("gorevler", gorev);

		String derece = request.getParameter("radioInline");

		String sinif = request.getParameter("sinif");

		String tarih = request.getParameter("tarih_son");

//		LocalDate datet = LocalDate.parse(tarih);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date date = format.parse(tarih);

		String calisan_id = request.getParameter("calisan_id");
		int calisan_idsi = Integer.parseInt(calisan_id);

		cali.setId(calisan_idsi);

		ProjeEntity entity = new ProjeEntity();

		entity.setCalisan(cali);
		entity.setId(idsi);
		entity.setDerece(derece);
		entity.setSinif(sinif);
		entity.setTarih_son(date);
		entity.setProje_1(ad);
		projeService.save(entity);
		attributes.addAttribute("id", calisan_id);
		return new RedirectView("projeGoster");

	}

	@RequestMapping(value = "/projeYeni", method = RequestMethod.GET)
	public String ekleProje(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		int idsi = Integer.parseInt(id);
//		Map<String, Object> getir = proje.getir(idsi);
		model.addAttribute("calisan", calisanService.findAllById(idsi));
		String[] gorev = { "A", "B", "C", "D", "E" };
		model.addAttribute("gorevler", gorev);
		return "proje-ekle";

	}

	@RequestMapping("/proje-ekle")
	public RedirectView getekleProje(HttpServletRequest request, Model model, RedirectAttributes attributes)
			throws ParseException {
		String id = request.getParameter("id");
		String ad = request.getParameter("proje_adi");
		int idsi = Integer.parseInt(id);

		String[] gorev = { "A", "B", "C", "D", "E" };

		String derece = request.getParameter("radioInline");
		String sinif = request.getParameter("sinif");
		String tarih = request.getParameter("tarih_son");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date date = format.parse(tarih);

		ProjeEntity entity = new ProjeEntity();

		Calisan c = new Calisan();

		c.setId(idsi);
		
		entity.setCalisan(c);
		entity.setSinif(sinif);
		entity.setDerece(derece);
		entity.setProje_1(ad);
		entity.setTarih_son(date);
		
		projeService.save(entity);
		
		model.addAttribute("calisan", calisanService.findAllById(idsi));
		model.addAttribute("calisanlar", calisanService.findAllById(idsi));
		model.addAttribute("projeler", projeService.findAllById(idsi));

		model.addAttribute("gorevler", gorev);

		attributes.addAttribute("id", id);
		return new RedirectView("projeGoster");

	}

}
