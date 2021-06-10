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
                                            <input id="departmentName" type="text" placeholder="Surgical Ward, Laboratory etc"  value="${department.departmentName}"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Department Type</label>
                                        <div class="col-md-12">
                                            <input id="departmentType" type="text" placeholder="Neonatology Unit"   value="${department.departmentType}"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Department Description</label>
                                        <div class="col-md-12">
                                            <input  id="departmentDescription" type="text" placeholder="Phototherapy"   value="${department.departmentDescription}"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                   
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                        <input class="btn btn-success" type="button"  onclick="persistEditDepartment('${department.id}');" name="submit" value="Update department">
                                        </div>
                                    </div>
                                </form>
                                
                            </div>
                        </div>
                    </div>