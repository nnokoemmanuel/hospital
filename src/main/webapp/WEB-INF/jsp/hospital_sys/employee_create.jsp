<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!-- Column -->
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
<!--                               <form class="form-horizontal form-material"> -->
                                   <form class="form-horizontal form-material" method="post">
                                    <div class="form-group">
                                        <label class="col-md-12">Surname</label>
                                        <div class="col-md-12">
                                            <input id="userSurName" type="text" placeholder="Johnathan Doe"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Given name</label>
                                        <div class="col-md-12">
                                            <input id="userGivenName" type="text" placeholder="Johnathan Doe"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Address</label>
                                        <div class="col-md-12">
                                            <input id="userAddress" name="userAddress" type="text" placeholder="Johnathan Doe"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="example-email" class="col-md-12">Email</label>
                                        <div class="col-md-12">
                                            <input id="userEmail" type="email" placeholder="johnathan@admin.com"
                                                class="form-control form-control-line" name="userEmail"
                                                id="example-email">
                                        </div>  
                                    </div>
                                    <div class="form-group">
                                        <label for="example-email" class="col-md-12">Phone number</label>
                                        <div class="col-md-12">
                                            <input id="employeeTel" type="text" placeholder="691111111"
                                                class="form-control form-control-line" name="employeeTel"
                                                id="example-email">
                                        </div>  
                                    </div>
                                     <div class="form-group">
                                        <label class="col-md-12">User name</label>
                                        <div class="col-md-12">
                                            <input id="userName" type="text" placeholder="Johnathan Doe"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Password</label>
                                        <div class="col-md-12">
                                            <input id="userPassword" type="text" 
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Dob</label>
                                        <div class="col-md-12">
                                            <input id="userDob" type="text" 
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                      <div class="form-group">
                                        <label class="col-sm-12">Select Employee Department</label>
                                        <div class="col-sm-12">
                                                <select id="employeeDepartment">
                                                    <c:forEach var="department"  items="${departments}">
												    	<option value="${department.id}">${department.deptName}</option>
													</c:forEach>
										       </select>
                                        </div>
                                    </div>
                                    
                                      <div class="form-group">
                                        <label class="col-sm-12">Select Roles</label>
                                        <div class="col-sm-12">
                                                <c:forEach var="role"  items="${allRoles}">
                                                <input type="checkbox"  id="role" class="userRole" name="role" value="${role.id}">
                                             	 <label for="${role.id}"> ${role.roleDesc}</label><br>
                                                </c:forEach>
                                        </div>
                                    </div>
                                   
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                        <input class="btn btn-success" type="button"  onclick="persistCreateUser();" name="submit" value="Create user">
                                        </div>
                                    </div>
                                </form>
                                
                            </div>
                        </div>
                    </div>