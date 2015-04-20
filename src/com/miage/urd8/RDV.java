package com.miage.urd8;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RDV {

	private static int nb = 0;
	public static List<RDV> allRDV = new ArrayList<RDV>();

	private int id;
	private String libelle;
	private String content;
	private String lieu;
	private Calendar dateDeb;
	private Calendar dateFin;
	private Calendar heureDeb;
	private Calendar heureFin;
	private boolean journeeEntiere;
	private int position;
	private boolean important;

	public RDV(String libelle, String content, String lieu, Calendar dateDeb,
			Calendar dateFin, Calendar heureDeb, Calendar heureFin, boolean journeeEntiere, boolean important) {
		this.id = nb + 1;
		this.libelle = libelle;
		this.content = content;
		this.lieu = lieu;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.important = important;
		
		if (journeeEntiere)
		{
			this.heureDeb = null;
			this.heureFin = null;
		}
		else
		{
			this.heureDeb = heureDeb;
			this.heureFin = heureFin;
		}
		this.journeeEntiere = journeeEntiere;
		this.position = allRDV.size() - 1;
	}

	@Override
	public String toString() {

		SimpleDateFormat formatHeure = new SimpleDateFormat("kk:mm");
		SimpleDateFormat formatDate = new SimpleDateFormat("EEEE dd MMM. yyyy");

		return "RDV [id=" + id + ", libelle=" + libelle + ", content="
				+ content + ", lieu=" + lieu + ", dateDeb="
				+ formatDate.format(dateDeb.getTime()) + ", dateFin="
				+ formatDate.format(dateFin.getTime()) + ", heureDeb="
				+ formatHeure.format(heureDeb.getTime()) + ", heureFin="
				+ formatHeure.format(heureFin.getTime()) + "]";
	}
	

	public boolean isJourneeEntiere() {
		return journeeEntiere;
	}

	public void setJourneeEntiere(boolean journeeEntiere) {
		this.journeeEntiere = journeeEntiere;
	}

	public static List<RDV> getAllRDV() {
		return allRDV;
	}

	public static void setAllRDV(ArrayList<RDV> allRDV) {
		RDV.allRDV = allRDV;
	}

	public static int getNb() {
		return nb;
	}

	public static void setNb(int nb) {
		RDV.nb = nb;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Calendar getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Calendar dateDeb) {
		this.dateDeb = dateDeb;
	}

	public Calendar getDateFin() {
		return dateFin;
	}

	public void setDateFin(Calendar dateFin) {
		this.dateFin = dateFin;
	}

	public Calendar getHeureDeb() {
		return heureDeb;
	}

	public void setHeureDeb(Calendar heureDeb) {
		this.heureDeb = heureDeb;
	}

	public Calendar getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Calendar heureFin) {
		this.heureFin = heureFin;
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	
	public boolean isImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
	}

	public static void generateRDV(int nbRDV) {
		
		Calendar dateAleatoire;
		
		for (int i = 1; i < nbRDV; i++) {
			dateAleatoire = Calendar.getInstance();
			dateAleatoire.add(Calendar.DATE, i+6);
			dateAleatoire.add(Calendar.HOUR, 3);
			RDV unRDV = new RDV("Libelle" + i, "details" + i, "lieu" + i, dateAleatoire, dateAleatoire, dateAleatoire, dateAleatoire, true, false);
			allRDV.add(unRDV);
		}
	}
	
	public static RDV getRDV(int i)
	{
		return allRDV.get(i); 
	}

}
