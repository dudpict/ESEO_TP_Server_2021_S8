package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.dto.Ville;

@Service
public class VilleDAOImpl implements VilleDAO {
	
	private Connection connexion;
	  
    public ArrayList<Ville> recupererVilleDeFrance() {
    	ArrayList<Ville> villeDeFrances = new ArrayList<Ville>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT * FROM `twic-s8`.ville_france;");

            // Récupération des données
            while (resultat.next()) {
                String codePostal = resultat.getString("Code_postal");
                String nomCommune = resultat.getString("Nom_commune");
                
                Ville cuurentVille = new Ville();
                cuurentVille.setNomCommune(nomCommune);
                cuurentVille.setCodePostal(codePostal);
                
                villeDeFrances.add(cuurentVille);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
        
        return villeDeFrances;
    }
    
    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/twic-s8", "root", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
