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

	public ArrayList<Ville> getInfoVille(String monParam) {
		ArrayList<Ville> listeVille = null;
		
		if(monParam == null ) {
			listeVille = villeDAOImpl.recupererVilleDeFrance();
		}
		else { 
			listeVille = villeDAOImpl.recupererVilleDeFrance();
		}
	
		return listeVille;
	}

}
