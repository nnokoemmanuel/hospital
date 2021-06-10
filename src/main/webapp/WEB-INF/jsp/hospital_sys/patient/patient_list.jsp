<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


                <div class="row page-titles" id="page-content-title">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">Patient</h3>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="javascript:void(0)">Home</a></li>
                            <li class="breadcrumb-item active">List Of Patient</li>
                        </ol>
                    </div>
                    <div class="col-md-7 align-self-center">
                        <a 
                            class="btn waves-effect waves-light btn btn-info pull-right hidden-sm-down" onclick="doGet('${pageContext.request.contextPath}/patient/create', 'page-content-element');">CREATE A PATIENT</a>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Sales Chart and browser state-->
                <!-- ============================================================== -->
                <div class="row" id="page-content-element">
                    <!-- Column -->
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table" id="myTable">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>PATIENT NAME</th>
                                                <th>PATIENT TELEPHONE</th>
                                                <th>PATIENT ADDRESS</th>
                                                <th>PATIENT CONTACTS</th>
                                                <th>PATIENT NEXT-OF-KIN</th>
                                                <th>PATIENT CONSULTATION-INFO</th>
                                                <th>ACTION</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                          <c:set var = "i"  value = "1"/>
                                           <c:forEach var="patient"  items="${patient}">
                                            <tr>
                                                <td><c:out value = "${i}"/></td>
                                                <td>${patient.patientName}</td>
                                                <td>${patient.patientTel}</td>
                                                <td>${patient.patientAddress}</td>
                                                <td>${patient.patientContact}</td>
                                                <td>${patient.patientNextOfKin}</td>
                                                <td>${patient.patientConsultations}</td>
                                                
						                         <td>
						                          <select onchange="list_action(this.value,'${patient.id}');"> 
<%--   onClick="doGet('${pageContext.request.contextPath}/user/detail?id=${user.id}')" --%>
												    
										              <option value="action">Action</option>
										              <option value="detail" 
										           onClick="doGet('${pageContext.request.contextPath}/patient/detail?id=${patient.id}','page-content-element')"
										                >Detail</option>
						                           
						                               <option value="update" 
						                            				                             
						                                   onClick="doGet('${pageContext.request.contextPath}/patient/edit/?id=${patient.id}','page-content-element')">Edit</option>
													
													   <option value="delete"
													
													      onClick="doDeletePatient('${patient.id}')">Delete</option>	
										           
										   
										           </select> 
                                               </td> 
                                            </tr>
                                             <c:set var = "i"  value = "${i+1}"/>
                                            </c:forEach>
                                            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                
                </div>
               
    <!--  ========================= start overlay ================================== -->
   
		 
		 <!-- The overlay -->
		<div id="myNav" class="overlay">
		
			  <!-- Button to close the overlay navigation -->
			  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
			
			  <!-- Overlay content -->
			  <div class="overlay-content">
			  
			             <%--  <jsp:include page="user_detail.jsp" />  --%>
			            <%--     <%@include file="hospital_sys/users/user_detail.jsp" %>  --%>
			       
			  </div>
		
		</div>
		
   