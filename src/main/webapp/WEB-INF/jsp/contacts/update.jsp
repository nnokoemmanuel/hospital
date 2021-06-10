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
	<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">  -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<body>
 <input id="contactId" type="hidden" value="">


	<div class="row">
	
	      <form action="" name="form"  method="post" modelAttribute="contactForm">
               <input type="hidden" id="update_contacts_id" value="${update_contacts_id}"> 
														    
	     <div class="container"> 
	   		<h1>Update Contact Form Info</h1>
   			<p>Please fill the form to create contact.</p>
 				<hr>
	   		<div class="row">
	     	<div class="col-100">
              
               <div class="form-group">
				 <label for="surName"><i class="fa fa-user-circle-o"></i> Sur Name</label>
				 <input type="text" id="surName" name="surName" placeholder="SurName"  class="form-control" value="${update_contacts_id.person.surName}"  />
				<%--  <input type="hidden" id="surName_old" name="surName_old" placeholder="SurName"  class="form-control" value="${contacts_jspId.person.SurName}"  />
			  --%>  </div>
			  
			  
			   <div class="form-group">
				 <label for="givenName"><i class="fa fa-user"></i> Given Name</label>
				 <input type="text" id="givenName" name="givenName" placeholder="GivenName"  class="form-control" value="${update_contacts_id.person.givenName}"  required/>
				 <%-- <input type="hidden" id="givenName_old" name="givenName_old" placeholder="GivenName"  class="form-control" value="${contacts_jspId.person.givenName}"  />
			   --%>
				</div>
				  
				 
				<div class="form-group"> 
				 <label for="email"><i class="fa fa-envelope"></i> Email</label>
				 <input type="text" id="email" name="email" placeholder="Email"  class="form-control" value="${update_contacts_id.person.email}" />
				 <%-- <input type="hidden" id="email_old" name="email_old" placeholder="Email"  class="form-control" value="${contacts_jspId.email}"  />
			   --%>
			     </div>
				 
				 
				 <div class="form-group"> 
				 <label for="phoneNumber1"><i class="fa fa-phone"></i> <b>Phone Number</b></label>
			     <input type="text" id="phoneNumber1" name="phoneNumber1" placeholder="phoneNumber1"  class="form-control" value="${update_contacts_id.phoneNumber1}" />
				<%--  <input type="hidden" id="phoneNumber1_old" name="phoneNumber1_old" placeholder="phoneNumber1"  class="form-control" value="${contacts_jspId.phoneNumber1}"  />
			      --%>
			      </div>
			    
			    
			     <div class="form-group">
			     <label for="phoneNumber2"><i class="fa fa-alt-phone"></i> <b>Alternative Phone Number</b></label>
			     <input type="text" id="phoneNumber2" name="phoneNumber2" placeholder="alternate phoneNumber"  class="form-control" value="${update_contacts_id.phoneNumber1}"  required/>
				<%--  <input type="hidden" id="phoneNumber2_old" name="phoneNumber2_old" placeholder="alternate phoneNumber"  class="form-control" value="${contacts_jspId.phoneNumber1}"  />
			      --%>
			      </div>
			     
		   </div>
		   </div>
			
		  <div class="col-100">
		    <h3>Address</h3>
		    <div class="form-group">
				<label for="country"><i class="fa fa-flag"></i> Country</label>
	  			<input type="text" id="country" name="country" placeholder="Country"  class="form-control" value="${update_contacts_id.address.country}" />
				<%-- <input type="hidden" id="country_old" name="country_old" placeholder="Country"  class="form-control" value="${update_contacts_id.address.country}"  />
				    --%>  
			 </div>
  		   
  		    <div class="row">
             <div class="col-50">
               <label for="town"><i class="fa fa-institution"></i>Town</label>
               <input type="text" id="town" name="town" placeholder="Town"  class="form-control" value="${update_contacts_id.address.town}" />
			   <%-- <input type="hidden" id="town_old" name="town_old" placeholder="Town"  class="form-control" value="${update_contacts_id.address.town}"  />
				  --%>    
             </div>
             <div class="col-50">
               <label for="street">Street</label>
                <input type="text" id="street" name="street" placeholder="Street"  class="form-control" value="${update_contacts_id.address.street}" />
				<%-- <input type="hidden" id="street_old" name="street_old" placeholder="Street"  class="form-control" value="${update_contacts_id.address.street}"  />
				    --%>  
              </div>
           	</div>
           	
          </div>
       
			<hr>
		<!-- 	<p>By creating a contact you agree to our <a href="#">Terms & Privacy</a>.</p> -->
		
	   <!--  <button type="button"  onclick="processFormData();">Create</button> -->
	        <button type="button" id="id_processFormData">Update</button>
 		
 		 </div>
 		 
</form>

</div>
		   
             <script src="${pageContext.request.contextPath}/js/contacts/create.js"></script>
             <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
		     
		</body>
</html>


