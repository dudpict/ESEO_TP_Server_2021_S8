package com.dao;

public class DaoFactory {
	VilleDAO villeDAO;

	public void DAOFactory() {
		//Initialize
		this.villeDAO = getVilleDao();
	}

	public VilleDAO getVilleDao() {
		return new VilleDAOImpl();
	}
}
