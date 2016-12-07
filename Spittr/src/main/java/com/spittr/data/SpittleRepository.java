package com.spittr.data;

import java.util.List;

import com.spittr.Spittle;
import com.spittr.web.exceptions.DuplicateSpittleException;

public interface SpittleRepository {
	List<Spittle> findSpittles(long max , int count);

	Spittle findOne(long spittleId);
	
	public void save(Spittle spittle) throws DuplicateSpittleException;
	
}
