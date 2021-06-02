package org.formation.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.formation.bean.FormationBean;
import org.formation.model.Formation;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Exercice3")
public class TPAjaxExercice3Servlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private static final String[] citations = {
			"N’aie pas pitié des morts Harry, aie pitié des vivants et en particulier de tous ceux qui vivent sans amour.",
			"La peur d’un nom ne fait qu’accroître la peur de la chose elle-même.",
			"Il faut du courage pour affronter ses ennemis mais il en faut encore plus pour affronter ses amis…",
			"- Quoi ? Mais on ne peut pas ressentir tout ça !<br>\n- Si, mais toi tu as la capacité émotionnelle d’une petite cuillère."
	};
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException,ServletException {    			
		Map<String, String> harryMap = new HashMap<String, String>();
		int random = (int)(Math.random() * 4);
		harryMap.put("citation", citations[random]);
		String harryJson = this.gson.toJson(harryMap);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(harryJson);
        out.flush();   
	}
}
