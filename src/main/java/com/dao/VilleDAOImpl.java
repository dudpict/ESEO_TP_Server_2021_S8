package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
				String codeCommune = resultat.getString("Code_commune_INSEE");
				String lon = resultat.getString("Longitude");
				String lat = resultat.getString("Latitude");
				String ligne = resultat.getString("Ligne_5");
				String libelle = resultat.getString("Libelle_acheminement");

				Ville curentVille = new Ville();
				curentVille.setNom(nomCommune);
				curentVille.setCodePostal(codePostal);
				curentVille.setCodeCommune(codeCommune);
				curentVille.setLibelle(libelle);
				curentVille.setLigne(ligne);
				curentVille.setLatitude(lat);
				curentVille.setLongitude(lon);

				villeDeFrances.add(curentVille);
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
	
	public ArrayList<Ville> recupererVilleDeFranceOrderByNom() {
		ArrayList<Ville> villeDeFrances = new ArrayList<Ville>();
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();

		try {
			statement = connexion.createStatement();

			// Exécution de la requête
			resultat = statement.executeQuery("SELECT * FROM `twic-s8`.ville_france v ORDER BY v.Nom_commune ;");

			// Récupération des données
			while (resultat.next()) {
				String codePostal = resultat.getString("Code_postal");
				String nomCommune = resultat.getString("Nom_commune");
				String codeCommune = resultat.getString("Code_commune_INSEE");
				String lon = resultat.getString("Longitude");
				String lat = resultat.getString("Latitude");
				String ligne = resultat.getString("Ligne_5");
				String libelle = resultat.getString("Libelle_acheminement");

				Ville curentVille = new Ville();
				curentVille.setNom(nomCommune);
				curentVille.setCodePostal(codePostal);
				curentVille.setCodeCommune(codeCommune);
				curentVille.setLibelle(libelle);
				curentVille.setLigne(ligne);
				curentVille.setLatitude(lat);
				curentVille.setLongitude(lon);

				villeDeFrances.add(curentVille);
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

	public ArrayList<Ville> recupererVilleDeFranceWithNAme(String nom) {
		ArrayList<Ville> villeDeFrances = new ArrayList<Ville>();
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();

		try {
			statement = connexion.createStatement();

			
			System.out.println("juste avant de faire la requete get avec nom, voivi le nom --"+nom+"---");
			// Exécution de la requête
			resultat = statement.executeQuery("SELECT * FROM `twic-s8`.ville_france WHERE Nom_commune ='" + nom + "';");
			// Récupération des données
			while (resultat.next()) {
				String codePostal = resultat.getString("Code_postal");
				String nomCommune = resultat.getString("Nom_commune");
				String codeCommune = resultat.getString("Code_commune_INSEE");
				String lon = resultat.getString("Longitude");
				String lat = resultat.getString("Latitude");
				String ligne = resultat.getString("Ligne_5");
				String libelle = resultat.getString("Libelle_acheminement");

				Ville curentVille = new Ville();
				curentVille.setNom(nomCommune);
				curentVille.setCodePostal(codePostal);
				curentVille.setCodeCommune(codeCommune);
				curentVille.setLibelle(libelle);
				curentVille.setLigne(ligne);
				curentVille.setLatitude(lat);
				curentVille.setLongitude(lon);
				villeDeFrances.add(curentVille);

				
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

	@Override
	public void deleteVilleWithNomVille(String nomVille) {
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();

		try {
			statement = this.connexion.createStatement();
			if (nomVille == null) {
				System.out.println("Le code commune n'est pas rensigné dans la base de données");
			} else {
				String requete = "DELETE FROM `twic-s8`.ville_france WHERE Nom_commune=?";
				PreparedStatement preparedStmt = connexion.prepareStatement(requete);
				// Remplace le ? par le valeur de cc
				preparedStmt.setString(1, nomVille);
				System.out.println(nomVille);
				preparedStmt.execute();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fermeture de la connexion
			try {
				closeAllSQLFiles(resultat, statement, connexion);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void addVille(String nomVille, String cc, String cp, String libelle, String ligne, String lat, String lon) {
		// TODO Auto-generated method stub
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();

		try {
			statement = this.connexion.createStatement();
			if ((nomVille == null || cc == null || cp == null || libelle == null || ligne == null || lat == null
					|| lon == null)) {
				System.out.println("Veuillez verifier que vous n'avez oublié aucun champ");
			} else {
				String req = " INSERT into `twic-s8`.ville_france (Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5,Latitude,Longitude)"
						+ " values (?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement preparedStmt = connexion.prepareStatement(req);
				preparedStmt.setString(1, cc);
				preparedStmt.setString(2, nomVille);
				preparedStmt.setString(3, cp);
				preparedStmt.setString(4, libelle);
				preparedStmt.setString(5, ligne);
				preparedStmt.setString(6, lat);
				preparedStmt.setString(7, lon);
				preparedStmt.execute();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fermeture de la connexion
			try {
				closeAllSQLFiles(resultat, statement, connexion);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateVille(String nomToDel, String nomVille, String cc, String cp, String libelle, String ligne, String lat,
			String lon) {
		// TODO Auto-generated method stub
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();

		try {

			statement = connexion.createStatement();
			if (!(nomToDel != null && nomVille != null && cc != null && cp != null && libelle != null && ligne != null && lat != null
					&& lon != null)) {
				System.out.println("Veuillez verifier que vous n'avez oublié aucun champ");
			} else {
				
				String req = " UPDATE `twic-s8`.ville_france SET Nom_commune=?, Code_postal=?, Libelle_acheminement=?, Ligne_5=?,Latitude=?,Longitude=?,Code_commune_INSEE=? WHERE Nom_commune=?";
				PreparedStatement preparedStmt = connexion.prepareStatement(req);
				preparedStmt.setString(1, nomVille);
				preparedStmt.setString(2, cp);
				preparedStmt.setString(3, libelle);
				preparedStmt.setString(4, ligne);
				preparedStmt.setString(5, lat);
				preparedStmt.setString(6, lon);
				preparedStmt.setString(7, cc);
				preparedStmt.setString(8, nomToDel);
				preparedStmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fermeture de la connexion
			try {
				closeAllSQLFiles(resultat, statement, connexion);
			} catch (SQLException ignore) {
				ignore.printStackTrace();
			}
		}

	}

	private void loadDatabase() {
		// Chargement du driver

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/twic-s8", "root", "password");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Pris d'internet
	private static void closeAllSQLFiles(ResultSet resultat, Statement statement, Connection connexion)
			throws SQLException {
		if (resultat != null) {
			resultat.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (connexion != null) {
			connexion.close();
		}
	}

}
