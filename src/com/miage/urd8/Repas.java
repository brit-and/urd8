package com.miage.urd8;

import java.util.ArrayList;
import java.util.List;

public class Repas {

	public static List<Repas> allRepas = new ArrayList<Repas>();

	private int id;
	private String libelle;
	private String recette;
	private int nbPersonnes;
	private int calories;
	private int type;
	private int position;

	public Repas(String nom, String recette, int nbPersonnes, int calories,
			int type) {
		this.libelle = nom;
		this.recette = recette;
		this.nbPersonnes = nbPersonnes;
		this.calories = calories;
		this.type = type;
		
		this.position = allRepas.size() - 1;
	}

	@Override
	public String toString() {
		return "Repas [id=" + id + ", libelle=" + libelle + ", recette="
				+ recette + ", nbPersonnes=" + nbPersonnes + ", calories="
				+ calories + ", type=" + type + ", position=" + position + "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return libelle;
	}

	public void setNom(String nom) {
		this.libelle = nom;
	}

	public String getRecette() {
		return recette;
	}

	public void setRecette(String recette) {
		this.recette = recette;
	}

	public int getNbPersonnes() {
		return nbPersonnes;
	}

	public void setNbPersonnes(int nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public static List<Repas> getAllRepas() {
		return allRepas;
	}

	public static void setAllRepas(List<Repas> allRepas) {
		Repas.allRepas = allRepas;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public static Repas getRepas(int i)
	{
		return allRepas.get(i);
	}

	

}
