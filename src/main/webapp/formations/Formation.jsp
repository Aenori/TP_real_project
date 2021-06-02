<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.formation.model.Formation" %>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
   <head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
   </head> 
   <body>
   	 <div id='main_section'>
   	  <table class="table table-striped">
   	  	<thead>
   	  		<th>id</th>
   	  		<th>date</th>
   	  		<th>sujet</th>
   	  		<th>formateur</th>
   	  		<th>paieFormateur</th>
   	  		<th>statut</th>
   	  		<th>statutFormateur</th>
   	  	</thead>
   	  	<tbody id="formation_table_body">
   	  		<% List formations = (List)request.getAttribute("formations"); %>
   	  		<% for(Object f: formations) { %>
   	  			<tr>
   	  				<td><%=((Formation)f).getId() %></td>
   	  				<td><%=((Formation)f).getDate() %></td>
   	  				<td><%=((Formation)f).getSujet().getNom() %></td>
   	  				<td><%=((Formation)f).getFormateur().getNom() %></td>
   	  				<td><%=((Formation)f).getPaieFormateur() %></td>
   	  				<td><%=((Formation)f).getStatut() %></td>
   	  				<td><%=((Formation)f).getStatutFormateur() %></td>
   	  			</tr>
   	  		<% } %> 
   	  	</tbody>
   	  </table>
   	  
      <form id="addFormationForm" action = "" method = "POST">
         Date: <input type = "text" name = "date"><br />
         Sujet: <input type = "text" name = "sujet" /><br />
         Formateur: <input type = "text" name = "formateur" /><br />
         PaieFormateur: <input type = "integer" name = "paieFormateur" /><br />
         <input type = "submit" value = "Submit" />
      </form>
      </div>
      <script>
      const ATTR_LIST = ['id', 'date', 'sujet', 'formateur', 'paieFormateur',
      	'statut', 'statutFormateur'];
      
function updateFormationTable(data){
	let new_line = "";
	
	for(let attr of ATTR_LIST) {
		let value = data[attr];
		if(attr === 'sujet' || attr === 'formateur') {
			value = value['nom'];
		}
		new_line += `<td>${value}</td>`;
	}
	
	new_line = `<tr>${new_line}</tr>\n`;
	console.log("new_line : " + new_line);
	$("#formation_table_body")[0].innerHTML += new_line;
};
      
$('#addFormationForm').submit(function(event) {
  // Prévient le comportement normal du formulaire et le rechargement de
  // la page
  event.preventDefault(); 
  
  let form = $(this);
  $.ajax({
    type: form.attr('method'),
    url: 'FormationAjax',
    data: form.serialize()
  }).done(function(data) {
  	console.log('Call to ajax worked !')
  	console.log(JSON.stringify(data));
  	updateFormationTable(data);
    // Optionally alert the user of success here...
  }).catch(function(e) {
  	console.log('Call to ajax worked !')
  	console.log(e);
  });
});        
      </script>
   </body>
</html>