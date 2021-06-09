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

@WebServlet("/Exercice5")
public class TPAjaxExercice5Servlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException,ServletException {    			
		String inputNumber = request.getParameter("nombre");
		Double inputAsDouble = Double.parseDouble(inputNumber);
		Double result = Math.sqrt(inputAsDouble);
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("result", result.toString());
		String helloJson = this.gson.toJson(resultMap);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(helloJson);
        out.flush();   
	}
}
