<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<link href="${pageContext.request.contextPath}/css/contacts/home.css" rel="stylesheet">
			<title>HOMECONTACT</title>
	</head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="${pageContext.request.contextPath}/js/contacts/home.js"></script>
		<body>
		

 			
	 <!-- <input type="text" name="search" placeholder="Search..">  -->
	 			<br>
	 			<br>
            			    	
			    <table id="myTable"  class="sortable w3-table-all w3-hoverable" >
					  <tr>
					    <th onclick="sortTable(0)" >SurName</th>
					    <th onclick="sortTable(1)" >GivenName</th>
					    <th onclick="sortTable(3)">Email</th>
					    <th>Action</th>
					  </tr>
					  
				 <tbody>
				 
				
		          <tr>
		            <c:forEach var="person_jsp"  items="${person_jsp}">
								  
								    <td>${person_jsp.surName} </td>
								    <td>${person_jsp.givenName} </td>
								    <td>${person_jsp.email} </td> 
					</c:forEach> 
				 </tr> 
				 </tbody>
				</table>
				
				
				
				
				
				<table id="myTable"  class="sortable w3-table-all w3-hoverable" style="margin: -50px 400px">
					  <tr>
					    <th onclick="sortTable(2)" >phoneNo</th>
					    <th onclick="sortTable(3)">Alt-phoneNo</th>
					  </tr>
					  
				 <tbody>
				
					<tr>
					 <c:forEach var="contacts_jsp"  items="${contacts_jsp}">
								  
								   <%--  <td>${contacts_jsp.person.surName} </td>
								    <td>${contacts_jsp.person.givenName} </td>
								    <td>${contacts_jsp.person.email} </td> --%>
								    <td>${contacts_jsp.phoneNumber1} </td>
								    <td>${contacts_jsp.phoneNumber2} </td>  	 
					</c:forEach> 
					</tr> 
					
				 </tbody>
				</table>	
					
					
					
					
					<%-- <tr>
					<c:forEach var="address_jsp"  items="${address_jsp}">
						  
							     <td>${address_jsp.country} </td>
							     <td>${address_jsp.town} </td>
							     <td>${address_jsp.street} </td>  
					 </c:forEach> 
				  </tr>
		
				</tbody>
					  
				</table> --%>
				
				
				
				
				
				
				
			
				<div> 
		 <a class="tablink" onclick="getURL(),openPage('News', this, 'green');"> +Add Contact </a> 
						</div>	
			
	</body>
</html>

