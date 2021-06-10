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
                                        <label class="col-md-12">Role Name</label>
                                        <div class="col-md-12">
                                            <input id="roleName" type="text" placeholder="ROLE_ADMIN"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Role Description</label>
                                        <div class="col-md-12">
                                            <input id="roleDesc" type="text" placeholder="ROLE ADMINISTRATOR"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                   
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                        <input class="btn btn-success" type="button"  onclick="persistCreateRole();" name="submit" value="Create role">
                                        </div>
                                    </div>
                                </form>
                                
                            </div>
                        </div>
                    </div>