package com.dto;

public class Ville {
	
	String codePostal;
	String nom;
	String codeCommune;
	String libelle;
	String ligne;
	String longitude;
	String latitude;
	
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nomCommune) {
		this.nom = nomCommune;
	}
	public String getCodeCommune() {
		return codeCommune;
	}
	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getLigne() {
		return ligne;
	}
	public void setLigne(String ligne) {
		this.ligne = ligne;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
}
