package com.baby_care_website;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baby_care_website.Contact;


@Controller
public class HomeController {
	@Autowired
	DAO dao;
	@Autowired
	DAO dao2;
@RequestMapping("/")
	public ModelAndView f1() {
		ModelAndView mv=new ModelAndView("index");
		return mv;
	}

	@RequestMapping("/contact")
	public ModelAndView f2(Contact mod) {
		ModelAndView mv= new ModelAndView();
		dao.save(mod);
		mv.addObject("key","data saved");
	    mv.setViewName("contact");
		return mv;

	}
	@RequestMapping("/doctors")
	public ModelAndView f3(Doctors mo) {
		ModelAndView mc= new ModelAndView();
		dao2.save(mo);
		mc.addObject("key","data saved");
		mc.setViewName("doctors");
		return mc;
	}





}
