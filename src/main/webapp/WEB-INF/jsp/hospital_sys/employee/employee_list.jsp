<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


                <div class="row page-titles" id="page-content-title">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">Patient</h3>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="javascript:void(0)">Home</a></li>
                            <li class="breadcrumb-item active">List Of Employee</li>
                        </ol>
                    </div>
                    <div class="col-md-7 align-self-center">
                        <a 
                            class="btn waves-effect waves-light btn btn-info pull-right hidden-sm-down" onclick="doGet('${pageContext.request.contextPath}/employee/create', 'page-content-element');">CREATE AN EMPLOYEE</a>
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
                                                <th>EMPLOYEE NAME</th>
                                                <th>EMPLOYEE TELEPHONE</th>
                                                <th>EMPLOYEE EMAIL</th>
                                                <th>EMPLOYEE USERNAME</th>
                                                <th>EMPLOYEE PASSWORD</th>
                                                <th>EMPLOYEE USER_ROLE</th>
                                                <th>ACTION</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                          <c:set var = "i"  value = "1"/>
                                           <c:forEach var="employee"  items="${employee}">
                                            <tr>
                                                <td><c:out value = "${i}"/></td>
                                                <td>${employee.employeeName}</td>
                                                <td>${employee.employeeTel}</td>
                                                <td>${employee.employeeEmail}</td>
                                                <td>${employee.employeeUserName}</td>
                                                <td>${employee.employeePassword}</td>
                                                <td>${employee.employeeRole}</td>
                                                <%--  <td>${employee.employeeRole}</td> --%>
                                                
						                         <td>
						                          <select onchange="list_action(this.value,'${employee.id}');"> 
<%--   onClick="doGet('${pageContext.request.contextPath}/user/detail?id=${user.id}')" --%>
												    
										              <option value="action">Action</option>
										              <option value="detail" 
										           onClick="doGet('${pageContext.request.contextPath}/employee/detail?id=${employee.id}','page-content-element')"
										                >Detail</option>
						                           
						                               <option value="update" 
						                            				                             
						                                   onClick="doGet('${pageContext.request.contextPath}/employee/edit/?id=${employee.id}','page-content-element')">Edit</option>
													
													   <option value="delete"
													
													      onClick="doDeleteEmployee('${employee.id}')">Delete</option>	
										           
										   
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
		
   