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
                                            <input id="deptName" type="text"   value="${department.deptName}"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    
                                   
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                        <input class="btn btn-success" type="button"  onclick="persistDepartmentRole('${department.id}');" name="submit" value="Update Department">
                                        </div>
                                    </div>
                                </form>
                                
                            </div>
                        </div>
                    </div>