package com.miage.urd8;

import java.util.ArrayList;

public class User {

	// PROPERTIES
	
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	
	private ArrayList<RDV> lesRDV;
	private ArrayList<RDV> lesRDVConcerned;
	private ArrayList<Repas> lesRepas;
	private ArrayList<Repas> lesRepasConcerned;
	private ArrayList<Courses> lesCourses;
	private ArrayList<Courses> lesCoursesConcerned;
	
	
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<RDV> getLesRDV() {
		return lesRDV;
	}
	public void setLesRDV(ArrayList<RDV> lesRDV) {
		this.lesRDV = lesRDV;
	}
	public ArrayList<RDV> getLesRDVConcerned() {
		return lesRDVConcerned;
	}
	public void setLesRDVConcerned(ArrayList<RDV> lesRDVConcerned) {
		this.lesRDVConcerned = lesRDVConcerned;
	}
	public ArrayList<Repas> getLesRepas() {
		return lesRepas;
	}
	public void setLesRepas(ArrayList<Repas> lesRepas) {
		this.lesRepas = lesRepas;
	}
	public ArrayList<Repas> getLesRepasConcerned() {
		return lesRepasConcerned;
	}
	public void setLesRepasConcerned(ArrayList<Repas> lesRepasConcerned) {
		this.lesRepasConcerned = lesRepasConcerned;
	}
	public ArrayList<Courses> getLesCourses() {
		return lesCourses;
	}
	public void setLesCourses(ArrayList<Courses> lesCourses) {
		this.lesCourses = lesCourses;
	}
	public ArrayList<Courses> getLesCoursesConcerned() {
		return lesCoursesConcerned;
	}
	public void setLesCoursesConcerned(ArrayList<Courses> lesCoursesConcerned) {
		this.lesCoursesConcerned = lesCoursesConcerned;
	}
	
	

}
