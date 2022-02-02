package com.springboot;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity                  //To make simple java class as a JPA Entity
@Data                    //To reduce boilerplate codes
@Table (name="emp")   //Table name in the DataBase 
public class Employee {
	@Id                     //Primary key for the Table
	@GeneratedValue(strategy=GenerationType.IDENTITY)  //Generation strategies for the values of Primary keys
	private long id;
	private String firstName;
	private String lastName;
	private String email;

}

