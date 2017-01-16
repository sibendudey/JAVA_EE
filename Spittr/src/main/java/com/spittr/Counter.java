package com.spittr;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="spittercounter")
public class Counter {
	private String name;
	private long counter;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCounter() {
		return counter;
	}
	public void setCounter(long counter) {
		this.counter = counter;
	}
	
	
}
