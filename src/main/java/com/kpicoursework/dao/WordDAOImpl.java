/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpicoursework.dao;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.WriteResult;
import com.kpicoursework.model.Word;

public class WordDAOImpl implements WordDAO {

	private MongoOperations mongoOps;
	private static final String WORD_COLLECTION = "Person";
	
	public WordDAOImpl(MongoOperations mongoOps){
		this.mongoOps=mongoOps;
	}
	
	@Override
	public void create(Word p) {
		this.mongoOps.insert(p, WORD_COLLECTION);
	}

	@Override
	public Word readById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoOps.findOne(query, Word.class, WORD_COLLECTION);
	}

	@Override
	public void update(Word p) {
		this.mongoOps.save(p, WORD_COLLECTION);
	}

	@Override
	public int deleteById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		WriteResult result = this.mongoOps.remove(query, Word.class, WORD_COLLECTION);
		return result.getN();
	}


}
