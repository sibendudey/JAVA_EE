package com.spittr.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spittr.Spitter;

public interface SpitterRepository extends MongoRepository<Spitter, String>{
	/*public Spitter findByUserName(String userName);
	public Spitter findByFirstName(String firstName);
	public Spitter findByLastName(String lastName);
	public Spitter findById(String id);*/
}
