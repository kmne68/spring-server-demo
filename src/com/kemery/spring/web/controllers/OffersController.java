package com.kemery.spring.web.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kemery.spring.web.dao.Offer;
import com.kemery.spring.web.service.OffersService;

@Controller
public class OffersController {
	
	private OffersService offersService;

	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	@RequestMapping("/")
	public String showHome(Model model) {
		
		List<Offer> offers = offersService.getCurrent();
		
		//model.addAttribute("name", "Treebeard");
		model.addAttribute("name", "<b>Fangorn</b");
		model.addAttribute("offers", offers);
		return "home";
	}
	
/*	@RequestMapping("/")
	public ModelAndView showHome() {
		
		ModelAndView mv = new ModelAndView("home");
		Map<String, Object> model = mv.getModel();
		model.put("name", "<b>Faramir</b>");
		
		return mv;
	} */
/*	public String showHome(HttpSession session) {
			session.setAttribute("name", "Gandalf");
			return "home";
	} */
}
