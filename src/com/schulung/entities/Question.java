package com.schulung.entities;

import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Question
 *
 */


@Entity
@Table(name = "question")
public class Question {

	   
	@TableGenerator(name = "question_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "question_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "question_gen")
	private int id;   
	
	@Column(name = "text")
	private String text;
 
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}
   
}
