package com.kanav.assessment.fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.kanav.assessment.entity.Employee;


public class App {
   public static void main(String[] args) {

       BufferedReader br = null;
       
       //vector to store employees
       Vector<Employee> v = new Vector<Employee>();
       Map<String, Employee> m = new HashMap<>();
       
      try {
    	  br = new BufferedReader(new FileReader("emps.txt"));		

	   	  //Reading the first line which contains attributes
	   	   String contentLine = br.readLine();
	   	   
	   	   //ignore first line 
	   	   contentLine = br.readLine();
	   	   
	   	   while (contentLine != null) {
	   	      //System.out.println(contentLine);
	   	      
	   	      List<String> values = new ArrayList<String>();
	   	      
	   	      String temp = "";
	   	      
	   	      for(int i=1;i<contentLine.length();i++) {
	   	    	
	   	    	  if(contentLine.charAt(i) !='|') {
	   	    		  temp += contentLine.charAt(i);
	  
	   	    	  }
	   	    	  else {
	   	    		  values.add(temp);
	   	    		  temp="";
	   	    	  }
	   	      }
	   	      
	   	      //Convert text record to Employee Object
   	    	  Employee e = txtToObj(values);
   	    	  
   	    	  //check duplicates based on name
   	    	  addIfValid(v, m, e);
   	    	  
   	    	  //set cursor to next record
	   	      contentLine = br.readLine();
	   	   	}
      }
      catch (IOException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  		}
      
      	Scanner scanner =  new Scanner(System.in);
      	
      	System.out.println("Enter gender (F/M): ");
      	 // Character input
        char gender = scanner.next().charAt(0);
      
        if(gender=='M') {
        	// onlyMale list 
       		System.out.println("-------- only males list ----------- ");
       		List<Employee> onlyMalesList = EmployeePredicate.filterEmployees
       					(v, EmployeePredicate.onlyMale());
       		
       		onlyMalesList.forEach(System.out :: println);
        }
      
        else if(gender=='F')
        {
        	// onlyFemale list 
       		System.out.println("-------- only females list ----------- ");
       		List<Employee> onlyFemalesList = EmployeePredicate.filterEmployees
       					(v, EmployeePredicate.onlyFemale());
       		
       		onlyFemalesList.forEach(System.out :: println);
        }

      
   }

	private static void addIfValid(Vector<Employee> v, Map<String, Employee> m, Employee e) {
		if(!m.containsKey(e.getEmpName())) {
			v.add(e);
			m.put(e.getEmpName(), e);
		  }
	}

	private static Employee txtToObj(List<String> values) {
		Employee e = new Employee();
		  String[] tempArray = new String[5];
		  int i=0;
		  for(String item: values) {
			  tempArray[i] = item;
			  i++;
		  }
		  e.setEmpName(tempArray[0]);
		  e.setEmpSal(Integer.parseInt(tempArray[1]));
		  e.setEmail(tempArray[2]);
		  e.setLocation(tempArray[3]);
		  e.setGender(tempArray[4]);
		return e;
	}
   
   //create a utility static class for predicates
   static class EmployeePredicate  {
		public static Predicate<Employee> onlyMale() {
			return p -> p.getGender().equalsIgnoreCase("male");
		}
		
		public static Predicate<Employee> onlyFemale() {
			return p -> p.getGender().equalsIgnoreCase("female");
		}
			
		
		public static List<Employee> filterEmployees(List<Employee> persons, Predicate<Employee> predicate) {
			return persons.stream().filter(predicate).collect(Collectors.toList()); 
		}
		
	}
}
