package com.spittr.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spitter.service.SpitterService;
import com.spittr.Spitter;
import com.spittr.data.SpitterRepository;

@RestController
@RequestMapping(value = "/spitter")
public class SpitterController {

	Logger log = Logger.getLogger("SpitterController");

	
	@Autowired
	SpitterService spitterService;
	/*
	 * public SpitterController(SpitterRepository spitterRepository) {
	 * this.spitterRepository = spitterRepository; }
	 */

	@RequestMapping(value = "/createSpitter", method = RequestMethod.GET)
	public String createSpitterForm() {
		return "createSpitterForm";
	}

	@RequestMapping(value = "/fetchSpitters", method = RequestMethod.GET, produces = "application/json")
	public List<Spitter> fetchSpitters() {
		return spitterService.fetchSpitters();
	}

	@RequestMapping(value = "/createSpitter", method = RequestMethod.POST)
	public void createSpitter(@RequestBody Spitter spitter) {

		spitterService.saveSpitter(spitter);

		// model.addAttribute("username", spitter.getUserName());
		// {username} placeholder derives its value from model map.
		//return "redirect:/spitter/{username}";
	}
	
	@RequestMapping( value = "/deleteSpitter/{spitterID}" , method = RequestMethod.GET)
	public void deleteSpitter(@PathVariable String spitterID)	{
		System.out.println("Entered deleteSpitter(): " + spitterID);
		spitterService.deleteSpitter(spitterID);
	}
	
	@RequestMapping( value = "/updateSpitter" , method = RequestMethod.POST)
	public void deleteSpitter(@RequestBody Spitter spitter)	{
		System.out.println("Request for updating spitter ID: " + spitter.getUserID());
		spitterService.updateSpitter(spitter);
	}
	
	
	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String userName, Model model) {
		return "profile";
	}
}
