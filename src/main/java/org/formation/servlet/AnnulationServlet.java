package org.formation.servlet;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.formation.bean.AnnulationBean;
import org.formation.bean.FormationBean;
import org.formation.model.Formation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.PushBuilder;

@WebServlet("/Annulation")
public class AnnulationServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException,ServletException {   
		List<Formation> formationsAnnulees = AnnulationBean.selectAnnulation();
		List<Formation> autresFormations = Formation.getAll();
		for (Formation f : formationsAnnulees) {
			int i = 0;
			for (Formation a : autresFormations) {
				if(f.getId()== a.getId()) {autresFormations.remove(i);}
				i++;
			}
			System.out.println(f.getId());
			System.out.println(autresFormations.size());
		}
		request.setAttribute("annulees", formationsAnnulees);
		request.setAttribute("formations", autresFormations);
		request.getRequestDispatcher("/formations/Annulation.jsp").forward(request, resp);
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws IOException,ServletException {    			
		String date = request.getParameter("date");
		String nomSujet = request.getParameter("sujet");
		String nomFormateur = request.getParameter("formateur");
		String paieFormateur = request.getParameter("paieFormateur");
		
		FormationBean.addNewFormation(date, nomSujet, nomFormateur, paieFormateur);	
	}
}