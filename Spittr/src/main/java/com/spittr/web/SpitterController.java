package com.spittr.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.spittr.Spitter;
import com.spittr.data.SpitterRepository;

@RestController
@RequestMapping(value = "/spitter")
public class SpitterController {

	Logger log = Logger.getLogger("SpitterController");

	@Autowired
	public SpitterRepository spitterRepository;

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

		List<Spitter> listSpitter = spitterRepository.findAll();
		log.info("listSpitter size is " + listSpitter.size());
		return listSpitter;

	}

	@RequestMapping(value = "/createSpitter", method = RequestMethod.POST)
	public String createSpitter(@RequestBody Spitter spitter) {

		/*
		 * if ( errors.hasErrors()) { System.out.println("Has errors"); return
		 * "registerForm"; }
		 */

		spitterRepository.save(spitter);

		// model.addAttribute("username", spitter.getUserName());
		// {username} placeholder derives its value from model map.
		return "redirect:/spitter/{username}";
	}

	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String userName, Model model) {

		// Spitter spitter = spitterRepository.findByUserName(userName);

		/*
		 * if ( !model.containsAttribute("spitter")) {
		 * model.addAttribute(spitterRepository.findByUserName(userName)); }
		 */
		return "profile";
	}
}
