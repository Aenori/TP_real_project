package org.formation.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.formation.model.Formateur;
import org.formation.model.Formation;
import org.formation.model.Sujet;

public class FormationBean {

	public static void addNewFormation(String date, String nomSujet, String nomFormateur, String paieFormateur) {
		Sujet sujet = null;
		List<Sujet> sujets = Sujet.getAll();
		for(Sujet s: sujets) {
			if(s.getNom().equals(nomSujet)) {
				sujet = s;
				break;
			}
		}
		
		if(sujet == null) { sujet = new Sujet(nomSujet); }
		
		Formateur formateur = null;
		List<Formateur> formateurs = Formateur.getAll();
		
		for(Formateur f: formateurs) {
			if(f.getNom().equals(nomSujet)) {
				formateur = f;
				break;
			}
		}
		
		if(formateur == null) { formateur = new Formateur(); }
	}
	
	// NRO-example : stream & lambda function
	public static List<Formation> getAllActiveFormations() {
		return Formation.getAll()
				// NRO : important !
				.stream()
				// NRO : Pour ceux qui voulaient voir les lambda fonctions
				.filter(s -> s.getStatut() == "Active")
				.collect(Collectors.toList());
	}
}
