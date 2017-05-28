/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpicoursework.dao;

import com.kpicoursework.model.Word;


public interface WordDAO {

	public void create(Word p);
	
	public Word readById(String id);
	
	public void update(Word p);
	
	public int deleteById(String id);
}
