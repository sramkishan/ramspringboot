package com.ram.demo.spboot;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RamSpringBootApplication {
	public static HashMap<Long,Employee> hmapEmployee;
	public static void main(String[] args) {
		hmapEmployee=new HashMap<Long,Employee>();
		 
	      Employee one=new Employee("John","marketing");
	      hmapEmployee.put(new Long(one.getId()),one);
	    
		SpringApplication.run(RamSpringBootApplication.class, args);
		 Employee two=new Employee("Mark","Engineering");
	      hmapEmployee.put(new Long(two.getId()),two);
	     
	}
}
