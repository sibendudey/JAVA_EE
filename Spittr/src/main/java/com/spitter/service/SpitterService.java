package com.spitter.service;

import java.util.List;

import com.spittr.Spitter;

public interface SpitterService {

	List<Spitter> fetchSpitters();

	void saveSpitter(Spitter spitter);
	
	void deleteSpitter(String spitterID);

	void updateSpitter(Spitter spitter);
	
	
}
