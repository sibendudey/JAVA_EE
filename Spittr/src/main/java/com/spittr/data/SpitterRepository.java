package com.spittr.data;

import org.springframework.stereotype.Service;

import com.spittr.Spitter;

@Service
public interface SpitterRepository {
	public void save(Spitter spitter);

	public Spitter findByUserName(String userName);

	public Spitter findByUserId( String id);
}
