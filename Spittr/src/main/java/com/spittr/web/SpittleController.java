package com.spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spittr.Spittle;
import com.spittr.data.SpittleRepository;
import com.spittr.web.exceptions.DuplicateSpittleException;
import com.spittr.web.exceptions.SpittleNotFoundException;

@Controller
@RequestMapping( "/spittle")
public class SpittleController {
	SpittleRepository spittleRepository;
	private static final String LONG_MAX = "99999";
	
	/*
	@Autowired
	public SpittleController(SpittleRepository spittleRepository)	{
		this.spittleRepository = spittleRepository;
	}*/
	
	
	/*@RequestMapping(method=RequestMethod.POST)
	public String saveSpittle(SpittleForm form , Model model)	{
		spittleRepository.save( new Spittle(null, form.getMessage(), new Date() , form.getLongitude , form.getLatitude()));
		return "redirect:/spittles";
	}*/
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String spittle(Model model , @RequestParam(value="max" , defaultValue=LONG_MAX ) int max , @RequestParam(value="count" , defaultValue="20") int count){
		model.addAttribute("spittleList" , spittleRepository.findSpittles(max, count));
		return "spittles";
	}
	
	@RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
	public String showSpittle( @PathVariable("spittleId") long spittleId, Model model)	{
		Spittle spittle = spittleRepository.findOne(spittleId);
		if ( spittle == null)
			throw new SpittleNotFoundException();
		
		model.addAttribute(spittle);
		return "spittle";
	}
	
	@RequestMapping(value="/register" , method=RequestMethod.GET)
	public String showRegistrationForm()	{
		return "registerForm";
	}
	
	@ExceptionHandler(DuplicateSpittleException.class)
	public String handleDuplicateSpittle()	{
		return "error/duplicate";
	}


}
