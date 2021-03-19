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

	//methode GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
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
	
	public ArrayList<Ville> appelGet(@RequestParam(required = false, value="codePostal") String codePostal) {
		System.out.println("Appel get");
		System.out.println("code postal " + codePostal);
		
		ArrayList<Ville> villeList = villeBLOSercice.getInfoVille(codePostal);
		
		return villeList;
	}
}
