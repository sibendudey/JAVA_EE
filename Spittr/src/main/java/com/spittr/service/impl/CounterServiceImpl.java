package com.spittr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.spitter.service.CounterService;
import com.spittr.Counter;

@Service
public class CounterServiceImpl implements CounterService {

	private static final String SPITTR_COUNTER_USER_NAME = "userID";

	MongoTemplate mongoTemplate = null;

	@Autowired
	public CounterServiceImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public long incrementCounter(String spittrCounterName) {
		Query query = new Query(Criteria.where("name").is(spittrCounterName));
		Update update = new Update().inc("counter", 1);
		Counter counter = mongoTemplate.findAndModify(query, update, Counter.class);
		//mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), entityClass)
		return counter.getCounter();
	}

	@Override
	public long getSequenceID() {
		return incrementCounter(SPITTR_COUNTER_USER_NAME);
	}

}
