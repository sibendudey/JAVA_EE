package com.spittr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spitter.service.CounterService;
import com.spitter.service.SpitterService;
import com.spittr.Spitter;
import com.spittr.data.SpitterRepository;

@Service
public class SpitterServiceImpl implements SpitterService{
	
	@Autowired
	public SpitterRepository spitterRepository;
	
	@Autowired
	public CounterService counterService;
	
	@Override
	public List<Spitter> fetchSpitters() {

		List<Spitter> listSpitter = spitterRepository.findAll();
		//log.info("listSpitter size is " + listSpitter.size());
		return listSpitter;

	}

	@Override
	public void saveSpitter(Spitter spitter) {
		spitter.setUserID(counterService.getSequenceID());
		spitterRepository.save(spitter);
		
	}

	@Override
	public void deleteSpitter(String spitterID) {
		spitterRepository.delete(spitterID);	
	}

	@Override
	public void updateSpitter(Spitter spitter) {
		spitterRepository.save(spitter);
	}
	

}
