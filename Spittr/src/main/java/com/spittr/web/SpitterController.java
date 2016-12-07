package com.spittr.web;

import javax.servlet.http.Part;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spittr.Spitter;
import com.spittr.data.SpitterRepository;

@Controller
@RequestMapping(value="/spitter")
public class SpitterController {
	
	private SpitterRepository spitterRepository = null;
	/*public SpitterController(SpitterRepository spitterRepository)	{
		this.spitterRepository = spitterRepository;
	}*/
	
	
	@RequestMapping( value="/register" , method = RequestMethod.GET)
	public String showRegistrationForm(Model model)	{
		model.addAttribute(new Spitter());
		return "registerForm";
	}
	
	@RequestMapping( value = "/register" , method = RequestMethod.POST)
	public String processRegistration(@RequestPart("profilePicture") Part profilePicture, @Valid Spitter spitter , Errors errors, RedirectAttributes model)	{
		
		System.out.println(spitter.getFirstName()  + "..." +  spitter.getLastName() );
		if ( errors.hasErrors())	{
			System.out.println("Has errors");
			return "registerForm";
		}
		
		spitterRepository.save(spitter);
	
		model.addAttribute("username", spitter.getUserName());
		// {username} placeholder derives its value from model map.
		return "redirect:/spitter/{username}";
	}
	
	@RequestMapping( value = "/{userName}" , method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String userName , Model model)	{
		
		//Spitter spitter = spitterRepository.findByUserName(userName);
		
		if ( !model.containsAttribute("spitter"))	{
			model.addAttribute(spitterRepository.findByUserName(userName));
		}
		return "profile";
	}
}
