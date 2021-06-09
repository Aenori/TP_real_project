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
   	  <div>
	  	<button type="button" onclick="exercice1()">Exercice 1</button>
	  	<br>
	  	<button type="button" onclick="exercice2()">Exercice 2</button>
	  	<br>
	  	<button type="button" onclick="exercice3()">Exercice 3</button>
	  	<div id="citations_Harry_Potter">
	  	</div>
	  	<br>
	  	<!-- Form for exercice 4 -->
	  	<form id="addFormationForm" action="" method="POST" onsubmit="exercice4(event)">
			Nom: <input type="text" name="nom"><br /> 
			<input type="submit" value="Exercice 4 - Submit" />
		</form>
	  	<br>
	  	<button type="button" onclick="exercice5()">Exercice 5</button>
	  </div> 	
      <script>
      	function exercice1() {
   	  		$.ajax({
   	    		type: 'GET',
   	    		url: 'Exercice1'
   	  		}).done(function(exercice1Result) {
   	  			console.log('Call to ajax exercice 1 worked !') ;  	  			
   	  			alert(exercice1Result['message']);
   	  		})
      	};
      	
      	function exercice2() {
   	  		$.ajax({
   	    		type: 'GET',
   	    		url: 'Exercice2'
   	  		}).done(function(exercice2Result) {
   	  			console.log('Call to ajax exercice 1 worked !') ;  	  			
   	  			alert(exercice2Result['time']);
   	  		})
      	};
      	
      	function exercice3() {
   	  		$.ajax({
   	    		type: 'GET',
   	    		url: 'Exercice3'
   	  		}).done(function(exercice3Result) {
   	  			console.log('Call to ajax exercice 3 worked !') ;  	  			
   	  			document.getElementById("citations_Harry_Potter").innerHTML += `<p class="citation">${exercice3Result['citation']}</p>`;
   	  		})
      	};
      	
      	function exercice4(event) {
      		event.preventDefault(); 
      	    
   	  		$.ajax({
   	    		type: 'GET',
   	    		url: 'Exercice4',
   	    		data: $(this).serialize()
   	  		}).done(function(exercice4Result) {
   	  			console.log('Call to ajax exercice 4 worked !') ;  	  			
   	  			alert(exercice4Result['message']);
   	  		})
      	}; 
      	
      	function exercice5() {
   	  		$.ajax({
   	    		type: 'GET',
   	    		url: 'Exercice5'
   	  		}).done(function(exercice5Result) {
   	  			console.log('Call to ajax exercice 5 worked !') ;  	  			
   	  			alert(exercice1Result['time']);
   	  		})
      	}; 
      </script>
   </body>
</html>