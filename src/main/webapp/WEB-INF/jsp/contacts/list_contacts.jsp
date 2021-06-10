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
<script src="${pageContext.request.contextPath}/js/contacts/create.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>


<!--________________CALL BOOTSTRAP EXTERNAL PACKAGE____________________-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">


<script src="${pageContext.request.contextPath}/js/jquery.min.js" ></script>


<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
<!--________________END BOOTSTRAP EXTERNAL PACKAGE____________________-->

		<body>
		
	
	 <!-- <input type="text" name="search" placeholder="Search..">  -->
	 			<br><br>
	 			
           <div> 
		      <a class="tablink"  onclick="getURL(),openPage('News', this, 'green');"> +Add Contact </a> 
		  </div>
		  
		  	 			    	
	    <table id="myTable"  class="sortable w3-table-all w3-hoverable" >
			  <tr>
			    <th>No</th>
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
									    <td>${list_contacts_jsp.person.surName} </td>
									    <td>${list_contacts_jsp.person.givenName} </td>
									    <td>${list_contacts_jsp.person.email} </td> 
									   
									    <td>${list_contacts_jsp.phoneNumber1} </td>
									    <td>${list_contacts_jsp.phoneNumber2} </td>   
									    
									    <td>${list_contacts_jsp.address.country} </td>
									    <td>${list_contacts_jsp.address.town} </td>
									    <td>${list_contacts_jsp.address.street} </td>	 
									    
									    <td> <!--alt detail can move from jsp directly to controller || from jsp-js-controller -->
								           <select onchange="list_action(this.value,'${list_contacts_jsp.id}');">
												    <option value="action">Action</option>
													<option value="detail" 
													
						                            class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal"
						                            
													onClick="doGet('${pageContext.request.contextPath}/contacts/detail?id=${list_contacts_jsp.id}')">Detail</option>
						                            <option value="update" onClick="doGet('${pageContext.request.contextPath}/contacts/update?id=${list_contacts_jsp.id}')">Edit</option>
													<!--method is to add new variable(field)
													 <option value="update"   onClick="getURL_updateContact('${list_contacts_jsp.id}');">Edit</option>
													  -->
													<option value="delete"
													class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal"
													 onClick="doGet('${pageContext.request.contextPath}/contacts/delete?id=${list_contacts_jsp.id}')">Delete</option>	
										   </select>
										</td>		 
		                    </tr>
                       <%--  </c:if> --%>
				          <c:set var = "i"  value = "${i+1}"/>
					   </c:forEach> 
		
				</tbody>
					  
				</table>
			
	
	
	
	<!-- Trigger the modal with a button -->
<!-- <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>
 -->
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body">
        <!-- <p>Some text in the modal.</p> -->
         <jsp:include page="details.jsp" />
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>	
		
		
			
	</body>
</html>

