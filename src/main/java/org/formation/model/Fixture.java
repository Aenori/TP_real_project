package org.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Fixture {
	private static List<Sujet> sujetFixture = null;
	private static List<Formation> formationFixture = null;
	private static List<Formateur> formateurFixture = null;
	
	public static List<Sujet> getSujetList() {
		if( sujetFixture == null ) initAll();
		return sujetFixture;
	}
	
	public static List<Formation> getFormationList() {
		if( formationFixture == null ) initAll();
		return formationFixture;
	}

	public static List<Formateur> getFormateurList() {
		if( formateurFixture == null ) initAll();
		return formateurFixture;
	}
	
	private static void initAll() {
		sujetFixture = new ArrayList<Sujet>();
		formationFixture = new ArrayList<Formation>();
		formateurFixture = new ArrayList<Formateur>();
		
		Sujet alchimie = addSujet("Alchimie", 1);
		Sujet divination = addSujet("Divination", 2);
		Sujet dfo = addSujet("Defense forces obscures", 3);

		Formateur rogue = addFormateur("Rogue", 1);
		rogue.getSujets().add(alchimie);
		rogue.getSujets().add(dfo);
				
		Formateur dumbledore = addFormateur("Dumbledore", 2);
		rogue.getSujets().add(dfo);		
		dumbledore.setSolde(2000);
		
		Formateur siriusBlack = addFormateur("Sirius Black", 3);
		rogue.getSujets().add(alchimie);	
		rogue.getSujets().add(divination);	
		rogue.getSujets().add(dfo);
		
		Formateur trelawney = addFormateur("Trelawney", 4);
		
		Formation dfoFormation = addFormation(
				"20210608",
				dfo,
				dumbledore,
				500,
				"Active",
				"Original",
				1
		);
		
		Formation alchimieFormation = addFormation(
				"20211031",
				alchimie,
				rogue,
				300,
				"Active",
				"Original",
				2
		);
		
		Formation divinationFormation = addFormation(
				"20211031",
				divination,
				trelawney,
				300,
				"Fusionnee",
				"Original",
				2
		);
	}
	
	private static Formation addFormation(
			String date, 
			Sujet sujet,
			Formateur dumbledore, 
			int paieFormateur, 
			String statut, 
			String statutFormateur,
			int id) {
		Formation formation = new Formation(
			date, 
			sujet, 
			dumbledore, 
			paieFormateur, 
			statut, 
			statutFormateur,
			id
		);
		formationFixture.add(formation);
		
		return formation;
	}

	private static Sujet addSujet(String nom, Integer id) {
		Sujet newSujet = new Sujet(nom, id);
		sujetFixture.add(newSujet);
		
		return newSujet;
	}
	
	private static Formateur addFormateur(String nom, Integer id) {
		Formateur newFormateur = new Formateur(nom, id);
		formateurFixture.add(newFormateur);
		
		return newFormateur;
	}
}
