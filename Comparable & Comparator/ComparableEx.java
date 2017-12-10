package com.java.deeplearning;

/* @author
Krishnakanth Yacahreni 
Date : 10/12/2017 */

/*Comparable	Comparator
1) Comparable provides single sorting sequence. In other words, we can sort the collection on the basis of single element such as id or name or price etc.	Comparator provides multiple sorting sequence. In other words, we can sort the collection on the basis of multiple elements such as id, name and price etc.
2) Comparable affects the original class i.e. actual class is modified.	Comparator doesn't affect the original class i.e. actual class is not modified.
3) Comparable provides compareTo() method to sort elements.	Comparator provides compare() method to sort elements.
4) Comparable is found in java.lang package.	Comparator is found in java.util package.
5) We can sort the list elements of Comparable type by Collections.sort(List) method.	We can sort the list elements of Comparator type by Collections.sort(List,Comparator) method.
*/

//A Java program to demonstrate use of Comparable
import java.io.*;
import java.util.*;

//A class 'Student' that implements Comparable
class Student implements Comparable<Student> {
	private int rollNo;
	private String name;
	private int marks;

	// Used to sort Students by marks
	public int compareTo(Student m) {
		return m.marks - this.marks; // Descending order
		// return this.marks - m.marks; //Ascscending order
	}

	// Constructor
	public Student(String nm, int rt, int yr) {
		this.name = nm;
		this.rollNo = rt;
		this.marks = yr;
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

// Driver class
class ComparableEx {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("Krishnakanth", 516, 969));
		list.add(new Student("Abhinav", 502, 972));
		list.add(new Student("VishnuPrasad", 558, 945));
		list.add(new Student("Saikumar", 538, 954));

		Collections.sort(list);

		System.out.println("Students after sorting : \n");
		for (Student Student : list) {
			System.out.println(Student.getName() + " " + Student.getrollNo() + " " + Student.getmarks());
		}
	}
}
