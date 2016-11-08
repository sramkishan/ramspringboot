package com.ram.demo.spboot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest/employee/v1")
public class EmployeeService {
	@RequestMapping(value="/",method = RequestMethod.GET)
	   public HashMap<Long,Employee> getAllEmployees(){
		System.out.println("inside my getAllEmployees");
	      return RamSpringBootApplication.hmapEmployee;
	   }
	
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public Employee addEmployee(@RequestParam(value="name") String name ,@RequestParam(value="department",defaultValue = "unknown") String department) throws Exception{
	 
		Employee empl=new Employee(name,department);
		Collection<Employee> collectionValues = RamSpringBootApplication.hmapEmployee.values();
		for(Employee empls: collectionValues){
			if (empls.getName().equalsIgnoreCase(name)&&empls.getDepartment().equalsIgnoreCase(department)){
				throw new Exception("Duplicate Employee");
			}
		}	
		RamSpringBootApplication.hmapEmployee.put(new Long(empl.getId()),empl);
	   return empl;
	 
	}
	
	@RequestMapping(value="/{name}",method = RequestMethod.GET)
	public Employee getEmployeeByName(@PathVariable String name) throws Exception{
	
		 
		Collection<Employee> collectionValues = RamSpringBootApplication.hmapEmployee.values();
		for(Employee empl: collectionValues){
			if (empl.getName().equalsIgnoreCase(name)){
				return empl;
			}
		}	
		
		 throw new Exception ("Employee not found");
	 
	}
	
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public Employee updateStudent(@RequestBody Employee empl) throws Exception{	 
		
		Collection<Employee> collectionValues = RamSpringBootApplication.hmapEmployee.values();
		for(Employee empls: collectionValues){
			if (empls.getName().equalsIgnoreCase(empl.getName())){
				empls.setDepartment(empl.getDepartment());
			}
		}	
		
	   return empl;
	 
	}
	
	
}
