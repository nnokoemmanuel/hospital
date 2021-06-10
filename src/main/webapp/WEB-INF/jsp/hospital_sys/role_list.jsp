<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

                
                 <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <p>
                <div class="row page-titles" id="page-content-title">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">Roles</h3>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="javascript:void(0)">Home</a></li>
                            <li class="breadcrumb-item active">List Of Roles</li>
                        </ol>
                    </div>
                    <div class="col-md-7 align-self-center">
                        <a 
                            class="btn waves-effect waves-light btn btn-info pull-right hidden-sm-down" onclick="doGet('${pageContext.request.contextPath}/user/create', 'page-content-element');">CREATE A USER</a>
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
                                                <th>NAME</th>
                                                <th>ROLE DESCRIPTION</th>
                                                <th>ACTION</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                          <c:set var = "i"  value = "1"/>
                                           <c:forEach var="role"  items="${roles}">
                                            <tr>
                                                <td><c:out value = "${i}"/></td>
                                                <td>${role.roleName}</td>
                                                <td>${role.roleDesc}</td>
                                                
						                         <td>
						                          <select onchange="list_action_role(this.value,'${role.id}');"> 
<%--   onClick="doGet('${pageContext.request.contextPath}/user/detail?id=${user.id}')" --%>
												    
										              <option value="action">Action</option>
										              <option value="detail" 
										           onClick="doGet('${pageContext.request.contextPath}/role/detail?id=${role.id}','page-content-element')"
										                >Detail</option>
						                           
						                               <option value="update" 
						                            				                             
						                                   onClick="doGet('${pageContext.request.contextPath}/role/edit/?id=${role.id}','page-content-element')">Edit</option>
													
													   <option value="delete"
													
													      onClick="doDeleteRole('${role.id}')">Delete</option>	
										           
										   
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
                <!-- ============================================================== -->
                <!-- End Sales Chart -->
                <!-- ============================================================== -->
               
                <!-- ============================================================== -->
                <!-- End Page Content -->
                <!-- ============================================================== -->
             