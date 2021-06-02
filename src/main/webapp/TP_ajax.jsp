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
	   <button id="button1" type="button">Exercice 1</button>
		
      <script>
      	function exercice1() {
      		
      	}; 
      	
      
        $(document).on("click", "#button1", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
            $.get("Exercice1", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                alert(JSON.stringify(responseText["message"]));           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
            });
        });
    </script>
   </body>
</html>