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
                                        <label class="col-md-12">Patient Name</label>
                                        <div class="col-md-12">
                                            <input id="patientName" type="text" placeholder="FirstName SecondName"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Patient Tel</label>
                                        <div class="col-md-12">
                                            <input id="patientTel" type="text" placeholder="677777777"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Patient Address</label>
                                        <div class="col-md-12">
                                            <input id="patientAddress"type="text" placeholder="Limbe"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                     <div class="form-group">
                                        <label class="col-md-12">Patient Contact</label>
                                        <div class="col-md-12">
                                            <input id="patientContact"type="text" placeholder="699999999"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                     <div class="form-group">
                                        <label class="col-md-12">Patient NextOfKin</label>
                                        <div class="col-md-12">
                                            <input id="patientNextOfKin"type="text" placeholder="NextOfKin"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                     <div class="form-group">
                                        <label class="col-md-12">Patient Consultations</label>
                                        <div class="col-md-12">
                                            <input id="patientConsultations"type="text" placeholder="Patient Consultations info"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    
                                   
                                   
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                        <input class="btn btn-success" type="button"  onclick="persistCreatePatient();" name="submit" value="Create patient">
                                        </div>
                                    </div>
                                </form>
                                
                            </div>
                        </div>
                    </div>