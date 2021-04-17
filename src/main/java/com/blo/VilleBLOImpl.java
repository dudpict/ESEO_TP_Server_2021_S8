package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAOImpl;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {
	
	@Autowired
	private VilleDAOImpl villeDAOImpl;

	public ArrayList<Ville> getInfoVille(String nom) {
		ArrayList<Ville> listeVille = null;
		
		if(nom == null ) {
			listeVille = villeDAOImpl.recupererVilleDeFrance();
		}
		else { 
			listeVille = villeDAOImpl.recupererVilleDeFranceWithNAme(nom);
		}
	
		return listeVille;
	}
	
	public ArrayList<Ville> getInfoVilleOrderByNom() {
		return villeDAOImpl.recupererVilleDeFranceOrderByNom();
	}
	
	public void deleteVille(String nomVille) {
		if(nomVille != null) {
			villeDAOImpl.deleteVilleWithNomVille(nomVille);
		}
	}
	
	public void addVille(String nomVille, String cc, String cp, String libelle, String ligne, String lat, String lon) {
		villeDAOImpl.addVille(nomVille, cc, cp, libelle, ligne, lat, lon);
	}

	@Override
	public void updateVille(String nomToDel, String nomVille, String cc, String cp, String libelle, String ligne, String lat,
			String lon) {
		villeDAOImpl.updateVille(nomToDel, nomVille, cc, cp, libelle, ligne, lat, lon);
		
	}

}
