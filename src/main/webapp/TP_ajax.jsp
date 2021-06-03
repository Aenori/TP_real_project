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
	   <button id="button1" type="button" onclick=exercice1()>Exercice 1</button>
	   <br></br>
	   <button id="button2" type="button">Exercice 2</button>
	   <br></br>
	   <button id="button3" type="button">Exercice 3</button>
	   <br></br>
	   <p id="p1"></p>
	   <br></br>
	   <form id="form1" action = "" method = "POST">
	   		name: <input type = "integer" name = "name" /><br />
	   		<input type = "submit" value = "Submit" />
	   	</form>
	   	<br></br>
	   	<p id="pExercice4"></p>
	   	<br></br>
	   	
	   	<script>
      	function exercice1() {
            $.get("Exercice1", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                alert(JSON.stringify(responseText.message));           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
            });
      	};
        
        $(document).on("click", "#button2", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
            $.get("Exercice2", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                alert("Il est : "+JSON.stringify(responseText.heure));           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
            });
        });
        
        $(document).on("click", "#button3", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
            $.get("Exercice3", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
            	document.getElementById("p1").innerHTML += JSON.stringify(responseText.citation)+"<br></br>";// Locate HTML DOM element with ID "somediv" and set its text content with the response text.
            });
        });
        
        $(document).on("submit", "#form1",function(event){
        	event.preventDefault();
        	$.post(
        			"Exercice4",
        			$("#form1").serialize(),
        			function(data){
        				$("#pExercice4").text(data);
        			}
        	);
        });
    </script>
   </body>
</html>