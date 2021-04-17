package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
public class VilleController {

	@Autowired
	VilleBLO villeBLOSercice;

//	public String appelGet() {
//		System.out.println("Appel GET");
//		String result = "List ville : \n";
//		
//		ArrayList<VilleBLO> listVille = villedaoimpl.recupererVilleDeFrance();
//		
//		for (VilleBLO currentVille : listVille) {
//			result = result + currentVille.getNomCommune() + " " +currentVille.getCodePostal() +"\n";
//		}
//		
//		return result;
//	}

	// methode GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(required = false, value = "nom") String nom,
			@RequestParam(required = false, value = "orderByNom") String orderByNom) {
		System.out.println("Appel get");
		System.out.println("Nom de la ville a récupérer :  " + nom);
		System.out.println("orderByNom : " + orderByNom);
		ArrayList<Ville> villeList;

		if (nom != null) {
			System.out.println("Nom récupéré : " + nom);
			villeList = villeBLOSercice.getInfoVille(nom);
		}
		if (orderByNom != null && orderByNom.equals("yes")) {
			System.out.println("OrderByNom récupéré");
			villeList = villeBLOSercice.getInfoVilleOrderByNom();
		}

		else {
			villeList = villeBLOSercice.getInfoVille(nom);
		}

		return villeList;
	}

	@RequestMapping(value = "/ville", method = RequestMethod.DELETE)
	@ResponseBody
	public void appelDelete(@RequestParam(required = false, value = "nomVille") String nomVille) {
		System.out.println("Appel delete");

		villeBLOSercice.deleteVille(nomVille);

	}

	@RequestMapping(value = "/ville", method = RequestMethod.POST)
	@ResponseBody
	public void appelPost(@RequestParam(required = false, value = "nom") String nomVille,
			@RequestParam(required = false, value = "codeCommune") String cc,
			@RequestParam(required = false, value = "codePostal") String cp,
			@RequestParam(required = false, value = "libelle") String libelle,
			@RequestParam(required = false, value = "ligne") String ligne,
			@RequestParam(required = false, value = "latitude") String lat,
			@RequestParam(required = false, value = "longitude") String lon) {

		System.out.println("Appel post");
		System.out.println("Nom de la ville : " + nomVille + " code commune : " + cc + " code postal : " + cp
				+ " libelle : " + libelle + " ligne : " + ligne + " longitude : " + lon + " latitude : " + lat);

		villeBLOSercice.addVille(nomVille, cc, cp, libelle, ligne, lat, lon);
	}

	@RequestMapping(value = "/ville", method = RequestMethod.PUT)
	@ResponseBody
	public void appelPut(@RequestParam(required = false, value = "nomToDel") String nomToDel,
			@RequestParam(required = false, value = "nom") String nomVille,
			@RequestParam(required = false, value = "codeCommune") String cc,
			@RequestParam(required = false, value = "codePostal") String cp,
			@RequestParam(required = false, value = "libelle") String libelle,
			@RequestParam(required = false, value = "ligne") String ligne,
			@RequestParam(required = false, value = "latitude") String lat,
			@RequestParam(required = false, value = "longitude") String lon) {
		System.out.println("Appel put");
		System.out.println("Ville à modifier : " + nomToDel + "Nom de la ville : " + nomVille + " code commune : " + cc + " code postal : " + cp
				+ " libelle : " + libelle + " ligne : " + ligne + " longitude : " + lon + " latitude : " + lat);
		villeBLOSercice.updateVille(nomToDel,nomVille, cc, cp, libelle, ligne, lat, lon);
	}
}
