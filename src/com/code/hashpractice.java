package com.code;
import java.util.HashMap; 
import java.util.HashSet; 


public class hashpractice {
	
	 public static void main(String[] args) 
	    { 
		 	
	        //HASHMAP:

	        /* This is how to declare HashMap */
	        HashMap<Integer, String> hm = new HashMap<Integer, String>(); 
	  
	        /*Adding elements to HashMap*/
	        hm.put(12, "geeks"); 
	        hm.put(2, "practice"); 
	        hm.put(7, "contribute"); 
	  
	        System.out.println("\nHashMap object output :\n\n" + hm); 
	  
	        // store data with duplicate key 
	        hm.put(12, "geeks"); 
	  
	        System.out.println("\nAfter inserting duplicate key :\n\n" + hm); 
	        
			System.out.println("\n\n") ; 

	        //HASHSET: 
	        
	        HashSet<String> hs = new HashSet<String>(); 
	        // Adding elements to the HashSet 
	        hs.add("geeks"); 
	        hs.add("practice"); 
	        hs.add("contribute"); 
	; 
			System.out.println("HashSet object output \n\n") ; 
			
	        System.out.println("Before adding duplicate values \n\n" + hs); 
	  
	        // Addition of duplicate elements 
	        hs.add("geeks"); 
	        hs.add("practice"); 
	  
	        System.out.println("\nAfter adding duplicate values \n\n" + hs); 
	  
	        // Addition of null values 
	        hs.add(null); 
	        hs.add(null); 
	  
	        // Displaying HashSet elements 
	    } 
	 
}
