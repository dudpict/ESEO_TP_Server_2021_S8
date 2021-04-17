package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {
	
	public ArrayList<Ville> getInfoVille(String nom);
	public void deleteVille(String nomVille);
	public ArrayList<Ville> getInfoVilleOrderByNom();
	public void addVille(String nomVille, String cc, String cp, String libelle, String ligne, String lat, String lon);
	void updateVille(String nomToDel, String nomVille, String cc, String cp, String libelle, String ligne, String lat, String lon);

}
