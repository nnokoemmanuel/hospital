
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.Date"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link href="${pageContext.request.contextPath}/css/contacts/create.css" rel="stylesheet">
	
	<title>CREATECONTACT</title>
	
</head>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<body>
 <input id="contactId" type="hidden" value="">
 <!-- <input id="userId" type="hidden" value="${contactForm.id}">  == UPDATE-->

			<div id="responsive-form" class="clearfix">
			
			<div class="form-row" id="n">
			 <h5>Person <i class="fa fa-user-circle-o"></i></h5>
			<div class="column-half">
			<label for="surName"><i class="fa fa-user-circle-o"></i></label>
			<input type="text" id="surName" name="surName" placeholder="SurName" required>
			</div>
			
			<div class="column-half">
			<label for="surName"><i class="fa fa-user-circle-o"></i></label>
			 <input type="text" id="givenName" name="givenName" placeholder="GivenName" required>
			 </div>
			
			<div class="column-full" >
			<label for="surName"><i class="fa fa-email-o"></i></label>
			 <input type="text" id="email" name="email" placeholder="your@email.com" required>
			 </div>
			
			</div>
			
			<p>
			
			<div class="form-row">
			 <h5>Contact <i class="fa fa-phone"></i> </h5>
			 <div class="column-half">
			  <label for="surName"></label>
			  <input type="text" id="phoneNumber1" name="phoneNumber1" placeholder="Phone Number" required>
			 </div>
			
			 <div class="column-half">
			   <label for="surName"><i class="fa fa-phone"></i></label>
			   <input type="text" id="phoneNumber2" name="surName" placeholder="Alternative Phone Number" required>
			  </div>
			</div>
			
			<div class="form-row">
			 <br>
			 <h5>Address </h5>
			 <div class="column-full" id="a">
			  <label for="surName"><i class="fa fa-flag"></i></label>
			  <input type="text" id="country" name="country" placeholder="Country" required></div>
			</div>
			
			<div class="form-row">
			 <div class="column-half">
			  <label for="surName"><i class="fa fa-institution"></i></label>
			  <input type="text" id="town" name="town" placeholder="Town" required>
			 </div>
			
			 <div class="column-half">
			   <label for="surName"><i class="fa fa-road"></i></label>
			   <input type="text" id="street" name="street" placeholder="Street" required>
			  </div>
			</div>
			
			
			  <button type="button" onclick="processFormData(), getTable();">Create</button>
			
			</div><!--end responsive-form-->
			
					
             <script src="${pageContext.request.contextPath}/js/contacts/create.js"></script>
             <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
		  
		</body>
</html>

