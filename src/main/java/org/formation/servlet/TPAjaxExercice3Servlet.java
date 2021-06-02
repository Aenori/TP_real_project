package org.formation.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
			"It does not do well to dwell on dreams and forget to live.",
			"To the well-organized mind, death is but the next great adventure.",
			"You're a little scary sometimes, you know that? Brilliant ... but scary.",
			"It takes a great deal of bravery to stand up to our enemies, but just as much to stand up to our friends.",
			"The truth. It is a beautiful and terrible thing, and should therefore be treated with great caution.'",
			"Dobby is free."
	};
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException,ServletException {    			
		Map<String, String> helloMap = new HashMap<String, String>();
		helloMap.put("message", "Hello world !");
	    String citationHP = citations[(new Random()).nextInt(citations.length)];
		helloMap.put("citation", citationHP);
	    String helloJson = this.gson.toJson(helloMap);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(helloJson);
        out.flush();   
	}
}
