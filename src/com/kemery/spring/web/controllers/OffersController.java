package com.kemery.spring.web.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET )
	public String showTest(Model model, @RequestParam("id")String id) {
		
		System.out.println("ID is: " + id);
		return "home";
	}
	

	@RequestMapping("/offers")
	public String showOffers(Model model) {
		
		List<Offer> offers = offersService.getCurrent();
		
		model.addAttribute("offers", offers);
		
		return "offers";
	}
	
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {

		model.addAttribute("offer", new Offer());
		return "createoffer";
	}
	
	
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {

		if(result.hasErrors()) {
			// If form doesn't validate, stay on page
			return "createoffer";			
		}	
		
		offersService.create(offer);
		
		return "offerCreated";
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
