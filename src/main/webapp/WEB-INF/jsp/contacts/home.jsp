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
			<link rel="stylesheet" href="https://fonts.googleapis.com/css?">
			
			<link href="${pageContext.request.contextPath}/css/contacts/home.css" rel="stylesheet">
			
			<title>HOMECONTACT</title>
</head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
 
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
        
        <input type="hidden" id="baseurl" name="baseurl" value="" />
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />
        
	
			<button class="tablink" onclick="openPage('Home', this, '')"  id="defaultOpen">LIST OF RECENT CONTACTS</button>
			<button class="tablink" onclick="getURL(),openPage('News', this, 'green');">CREATE CONTACTS</button>
			<button class="tablink" onclick="openPage('Contact', this, 'blue')">MANAGE CONTACTS</button>
			<button class="tablink" onclick="openPage('About', this, 'orange')">ABOUT</button>
	

					
		<div id="Home" class="tabcontent">
				 <input type="text" name="search" placeholder="Search.."> 
			<!-- Home -->
			 <jsp:include page="list_contacts.jsp" />
		</div>
			
		<div id="News" class="tabcontent">
			<!--  News -->
			 <jsp:include page="create.jsp" />
		</div>
			
		<div id="Contact" class="tabcontent">
			 Contact
		</div>
			
		<div id="About" class="tabcontent">
			About
		</div>
		
		
		 
		    <%-- <div id="Home" class="tabcontent"> 	
				<jsp:include page="table_contacts.jsp"/>  
 		 	</div>  --%>  
 		  
		
 			 
             <script src="${pageContext.request.contextPath}/js/contacts/home.js"></script>
             <script src="${pageContext.request.contextPath}/js/contacts/create.js"></script>
             <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
             
		</body>
</html>
