/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpicoursework.model;

import org.springframework.data.annotation.Id;

public class Word {

	//id will be used for storing MongoDB _id
	@Id
	private String id;
	
	private String title;
	private String transcription;
        private String meaning;
	
	public Word(){}
	public Word(String i, String t, String tr, String m){
		this.id=i;
		this.title=t;
		this.transcription=tr;
                this.meaning=m;
	}
        public Word(String t, String tr, String m){
		this.title=t;
		this.transcription=tr;
                this.meaning=m;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTranscription() {
		return transcription;
	}
	public void setTranscription(String address) {
		this.transcription = transcription;
	}
        public String getMeaning() {
		return meaning;
	}
        public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	
	@Override
	public String toString(){
		return id+"::"+title+"::"+transcription+"::"+meaning;
	}
}