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
	 			<br><br>
	 			
           <div> 
		      <a class="tablink"  onclick="getURL(),openPage('News', this, 'green');"> +Add Contact </a> 
		  </div>
		  
		  	 			    	
			    <table id="myTable"  class="sortable w3-table-all w3-hoverable" >
					  <tr>
					    <th onclick="sortTable(0)" >SurName</th>
					    <th onclick="sortTable(1)" >GivenName</th>
					    <th onclick="sortTable(3)">Email</th>
					    <th onclick="sortTable(2)" >phoneNo</th>
					    <th onclick="sortTable(3)">Alt-phoneNo</th>
					    <th onclick="sortTable(4)">Country</th>
					    <th onclick="sortTable(5)">Town</th>
					    <th onclick="sortTable(6)">Street</th>
					     <th>Action</th>
			  </tr>
			  
		 <tbody>
		 
  <c:set var = "i"  value = "1"/>
        
	 <c:forEach var="list_contacts_jsp"  items="${list_contacts_jsp}">
		
                              <tr id="${contact.id}" role="row"
                                 <c:if test ="${i%2==1}"> class="odd clear-odd" </c:if>
                                 <c:if test ="${i%2==0}"> class="even dark-even" </c:if> 
                                >
                                        <td tabindex="0" class="sorting_1">
                                        	<c:out value = "${i}"/>
                                        </td>
								    <td>${contacts_jsp.person.surName} </td>
								    <td>${contacts_jsp.person.givenName} </td>
								    <td>${contacts_jsp.person.email} </td> 
								   
								    <td>${contacts_jsp.phoneNumber1} </td>
								    <td>${contacts_jsp.phoneNumber2} </td>   
								    
								    <td>${contacts_jsp.address.country} </td>
								    <td>${contacts_jsp.address.town} </td>
								    <td>${contacts_jsp.address.street} </td>	 
								    
								    
									    <td> <!--alt detail can move from jsp directly to controller || from jsp-js-controller -->
								           <select onchange="list_action(this.value,'${list_contacts_jsp.id}');">
												    <option value="action">Action</option>
													<option value="detail" onClick="doGet('${pageContext.request.contextPath}/contacts/detail?id=${list_contacts_jsp.id}')">Detail</option>
						                            <option value="update" onClick="doGet('${pageContext.request.contextPath}/contacts/update?id=${list_contacts_jsp.id}')">Edit</option>
													<!-- <option value="Edit"   onClick="getURL_updateContact('${contacts_jsp.id}');">Edit</option> -->
													<option value="Delete">Delete</option>	
										   </select>
										</td>		 
		                    </tr>
                       <%--  </c:if> --%>
				          <c:set var = "i"  value = "${i+1}"/>
					   </c:forEach> 
		
				</tbody>
					  
				</table>
			
			
<%--  <c:set var = "value"  value = "detail"/>			
<c:if test="${value == 'detail' || value.equals('detail') }"> --%>
				
				
				
		<!-- start openNav overlay -->
		 
		 <!-- The overlay -->
		<div id="myNav" class="overlay">
		
			  <!-- Button to close the overlay navigation -->
			  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
			
			  <!-- Overlay content -->
			  <div class="overlay-content">
			  
			              <jsp:include page="details.jsp" />
			       
			  </div>
		
		</div>
		<!-- end openNav overlay -->
<%-- 		
</c:if>
		
<c:if test=	"${ value != 'detail' || !value.equals('detail') }"> --%>	
		<!-- start openNav overlay -->
		 
		 <!-- The overlay -->
		<div id="myNav1" class="overlay">
		
			  <!-- Button to close the overlay navigation -->
			  <a href="javascript:void(0)" class="closebtn" onclick="closeNav1()">&times;</a>
			
			  <!-- Overlay content -->
			  <div class="overlay-content">
			  
			              <jsp:include page="update.jsp" /> 
			       
			  </div>
		
		</div>
		<!-- end openNav overlay -->
		
<%-- </c:if>	 --%>
		
			
	</body>
</html>
