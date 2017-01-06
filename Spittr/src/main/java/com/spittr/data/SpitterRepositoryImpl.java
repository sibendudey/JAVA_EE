package com.spittr.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spittr.Spitter;

@Service
public class SpitterRepositoryImpl implements SpitterRepository {

	List<Spitter> spitterList;
	
	public SpitterRepositoryImpl() {
		spitterList = new ArrayList<>();
	}
	
	@Override
	public void save(Spitter spitter) {
		spitterList.add(spitter);
	}

	@Override
	public Spitter findByUserName(String userName) {
		return null;
	}

	@Override
	public Spitter findByUserId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
