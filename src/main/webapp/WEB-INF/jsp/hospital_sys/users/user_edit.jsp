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
                                            <input id="userSurName" type="text" placeholder="Johnathan Doe"  value="${user.userSurName}"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Given name</label>
                                        <div class="col-md-12">
                                            <input id="userGivenName" type="text" placeholder="Johnathan Doe"   value="${user.userGivenName}"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Address</label>
                                        <div class="col-md-12">
                                            <input id="userAddress"type="text" placeholder="Johnathan Doe"   value="${user.userAddress}"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="example-email" class="col-md-12">Email</label>
                                        <div class="col-md-12">
                                            <input id="userEmail" type="email" placeholder="johnathan@admin.com"   value="${user.userEmail}"
                                                class="form-control form-control-line" name="example-email"
                                                id="example-email">
                                        </div>  
                                    </div>
                                     <div class="form-group">
                                        <label class="col-md-12">User name</label>
                                        <div class="col-md-12">
                                            <input id="userName" type="text" placeholder="Johnathan Doe" value="${user.userName}"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Password</label>
                                        <div class="col-md-12">
                                            <input id="userPassword" type="text"  value="${user.userPassword}"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Dob</label>
                                        <div class="col-md-12">
                                            <input id="userDob" type="text"  value="${user.userDob}"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                      <div class="form-group">
                                        <label class="col-sm-12">Select Role</label>
                                        <div class="col-sm-12">
                                                <c:forEach var="role"  items="${userRoles}">
                                                <input type="checkbox"  id="role" class="userRole" name="role" value="${role.id}" checked>
                                             	 <label for="${role.id}"> ${role.roleDesc}</label><br>
                                                </c:forEach>
                                                 <c:forEach var="role"  items="${remainingRoles}">
                                                <input type="checkbox"  id="role" class="userRole" name="role" value="${role.id}" >
                                             	 <label for="${role.id}"> ${role.roleDesc}</label><br>
                                                </c:forEach>
                                        </div>
                                    </div>
                                   
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                        <input class="btn btn-success" type="button"  onclick="persistEditUser('${user.id}');" name="submit" value="Update user">
                                        </div>
                                    </div>
                                </form>
                                
                            </div>
                        </div>
                    </div>