package com.Ticket.utils;

import java.util.ArrayList; 
import java.util.Collections; 
import java.util.List; 

public class Utility { 

	// function to find minimum value in an unsorted 
	// list in Java using Collection 
	public static Float findMin(List<Float> list) 
	{ 

		// check list is empty or not 
		if (list == null || list.size() == 0) { 
			return Float.MAX_VALUE; 
		} 

		// return minimum value of the ArrayList 
		return Collections.min(list); 
	} 

	// function return maximum value in an unsorted 
	// list in Java using Collection 
	public static Float findMax(List<Float> list) 
	{ 

		// check list is empty or not 
		if (list == null || list.size() == 0) { 
			return Float.MIN_VALUE; 
		} 

		// return maximum value of the ArrayList 
		return Collections.max(list); 
	} 

	public static void main(String[] args) 
	{ 

		// create an ArrayList Object list 
		List<Integer> list = new ArrayList<Integer>(); 

		// add element in ArrayList object list 
		list.add(44); 
		list.add(11); 
		list.add(22); 
		list.add(33); 

		// print min amd max value of ArrayList 
//		System.out.println("Min: " + findMin(list)); 
//		System.out.println("Max: " + findMax(list)); 
	} 
} 
