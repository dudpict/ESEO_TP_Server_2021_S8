package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {

	ArrayList<Ville> recupererVilleDeFrance();
	ArrayList<Ville> recupererVilleDeFranceWithNAme(String cp);
	ArrayList<Ville> recupererVilleDeFranceOrderByNom();
	void deleteVilleWithNomVille(String cp);
	void addVille(String nomVille, String cc, String cp, String libelle, String ligne, String lat, String lon);
	void updateVille(String nomToDel, String nomVille, String cc, String cp, String libelle, String ligne, String lat, String lon);
}
