/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpicoursework.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
 
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.MongoOperations;
 
@Configuration
public class SpringMongoDBConfiguration {
        
        public static final String DB_NAME = "glossary";
	public static final String MONGO_HOST = "ds143201.mlab.com";
	public static final int MONGO_PORT = 43201;
 
	public @Bean MongoDbFactory getMongoDbFactory() throws Exception {
                MongoCredential journaldevAuth = MongoCredential.createCredential("root", DB_NAME, "root".toCharArray());
                List<MongoCredential> auths = new ArrayList<MongoCredential>();
                auths.add(journaldevAuth);
                ServerAddress serverAddress = new ServerAddress(MONGO_HOST, MONGO_PORT);
                MongoClient mongo = new MongoClient(serverAddress,auths);
                
		return new SimpleMongoDbFactory(mongo, DB_NAME);
	}

	public @Bean MongoTemplate getMongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(getMongoDbFactory());
		return mongoTemplate;
	}
}