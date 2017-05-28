package com.kpicoursework.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.kpicoursework.model.Word;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import java.net.UnknownHostException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class GlossaryApplication {
//        public static final String WORD_COLLECTION = "words";
        
	public static void main(String[] args) throws UnknownHostException{
//
//                ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoDBConfiguration.class);
//                MongoOperations mongoOperation = (MongoOperations)ctx.getBean("getMongoTemplate");
//
//                Word p = new Word("juice2", "dzuise", "some product, made from fruits");
//                mongoOperation.insert(p, WORD_COLLECTION);
//
//                Word p1 = mongoOperation.findOne(
//                                new Query(Criteria.where("title").is("go")),
//                                Word.class, WORD_COLLECTION);
//
//                System.out.println(p1);

	}
}
