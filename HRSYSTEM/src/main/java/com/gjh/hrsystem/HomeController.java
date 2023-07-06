package com.gjh.hrsystem;

//import java.text.DateFormat;
//import java.util.Date;
//import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController { 
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	} */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		logger.info("메인 페이지 실행");
		
		return "/home.tiles";	
	}
	
	@RequestMapping(value = "/sampleBoard", method = RequestMethod.GET)
	public String sampleBoard() {
		
		return "/sampleBoard.tiles";	
	}

	@RequestMapping(value = "/test")
	public String test() {

		logger.info("test.jsp 실행");
		
		return "/user/sharing/test.tiles";
	}	
	
	@RequestMapping(value = "/goLogin")
	public String common() {
	
		logger.info("goLogin.jsp 실행");
		
		return "/user/common/goLogin.tiles";
	}	
}