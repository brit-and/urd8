package com.miage.urd8;

public class Produit {

	private int i;
	private String libelle;

	public Produit(int i, String libelle, int type) {
		this.i = i;
		this.libelle = libelle;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


}
