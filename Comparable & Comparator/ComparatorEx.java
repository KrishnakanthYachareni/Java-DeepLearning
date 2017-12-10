package com.java.deeplearning;

/* @author
Krishnakanth Yacahreni 
Date : 10/12/2017 */
//A Java program to demonstrate Comparator interface
import java.io.*;
import java.util.*;

//A class 'Students' that implements Comparable
class Students {
	private int rollNo;
	private String name;
	private int marks;

	// Constructor
	public Students(String name, int rollNo, int marks) {
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;
	}

	// Getter methods for accessing private data
	public int getrollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public int getmarks() {
		return marks;
	}
}

// Class to compare Students by rollNo
class rollNoCompare implements Comparator<Students> {
	public int compare(Students m1, Students m2) {
		if (m1.getrollNo() < m2.getrollNo())
			return -1;
		if (m1.getrollNo() > m2.getrollNo())
			return 1;
		else
			return 0;
	}
}

// Class to compare Studentss by name
class NameCompare implements Comparator<Students> {
	public int compare(Students m1, Students m2) {
		return m1.getName().compareTo(m2.getName());
	}
}

// Driver class
class ComparatorEx {
	public static void main(String[] args) {
		ArrayList<Students> list = new ArrayList<Students>();
		list.add(new Students("Krishnakanth", 516, 969));
		list.add(new Students("Abhinav", 502, 972));
		list.add(new Students("VishnuPrasad", 558, 945));
		list.add(new Students("Saikumar", 538, 954));

		// Sort by rollNo : (1) Create an object of rollNoCompare
		// (2) Call Collections.sort
		// (3) Print Sorted list
		System.out.println("Sorted by rollNo");
		rollNoCompare rollNoCompare = new rollNoCompare();
		Collections.sort(list, rollNoCompare);
		for (Students Students : list)
			System.out.println(Students.getrollNo() + " " + Students.getName() + " " + Students.getmarks());

		// Call overloaded sort method with rollNoCompare
		// (Same three steps as above)
		System.out.println("\nSorted by name");
		NameCompare nameCompare = new NameCompare();
		Collections.sort(list, nameCompare);
		for (Students Students : list)
			System.out.println(Students.getName() + " " + Students.getrollNo() + " " + Students.getmarks());
	}
}