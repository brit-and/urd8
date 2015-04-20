package com.miage.urd8;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Courses {

	// PROPERTIES

	public static List<Courses> allCourses = new ArrayList<Courses>();

	private int id;
	private String nom;
	private String lesProduits;
	private Calendar date;
	private int position;

	// CONSTRUCTEUR

	public Courses(String nom, String lesProduits) {
		this.nom = nom;
		this.lesProduits = lesProduits;
		this.position = allCourses.size() - 1;
		this.date = Calendar.getInstance();
	}

	// GETTERS SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLesProduits() {
		return lesProduits;
	}

	public void setLesProduits(String lesProduits) {
		this.lesProduits = lesProduits;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
	
	public static Courses getCourse(int i)
	{
		return allCourses.get(i);
	}

}
