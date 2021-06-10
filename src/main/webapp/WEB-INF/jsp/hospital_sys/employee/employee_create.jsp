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
                                        <label class="col-md-12">Employee Name</label>
                                        <div class="col-md-12">
                                            <input id="employeeName" type="text" placeholder="employee-FName employee-SName"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Employee Tel</label>
                                        <div class="col-md-12">
                                            <input id="employeeTel" type="text" placeholder="677777777"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Employee Email</label>
                                        <div class="col-md-12">
                                            <input id="employeeEmail"type="text" placeholder="johnathan@admin.com"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                     <div class="form-group">
                                        <label class="col-md-12">Employee UserName</label>
                                        <div class="col-md-12">
                                            <input id="employeeUserName"type="text" placeholder="Johnathan"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                     <div class="form-group">
                                        <label class="col-md-12">Employee Password</label>
                                        <div class="col-md-12">
                                            <input id="employeePassword"type="text" placeholder="employeePassword"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                     <div class="form-group">
                                        <label class="col-md-12">Employee Role</label>
                                        <div class="col-md-12">
                                            <input id="employeeRole"type="text" placeholder="employee Role"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    
                                   
                                   
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                        <input class="btn btn-success" type="button"  onclick="persistCreateEmployee();" name="submit" value="Create Employee">
                                        </div>
                                    </div>
                                </form>
                                
                            </div>
                        </div>
                    </div>