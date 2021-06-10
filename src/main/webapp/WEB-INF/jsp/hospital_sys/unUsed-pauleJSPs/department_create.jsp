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
                                        <label class="col-md-12">Department Name</label>
                                        <div class="col-md-12">
                                            <input id="deptName" type="text" placeholder="DENTAL DEPARTMENT"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                   
                                   
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                        <input class="btn btn-success" type="button"  onclick="persistCreateDepartment();" name="submit" value="Create Department">
                                        </div>
                                    </div>
                                </form>
                                
                            </div>
                        </div>
                    </div>