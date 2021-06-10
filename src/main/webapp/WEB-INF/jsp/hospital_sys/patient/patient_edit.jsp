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
                                            <input id="patientName" type="text" placeholder="FirstName SecondName" value="${patient.patientName}"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Patient Tel</label>
                                        <div class="col-md-12">
                                            <input id="patientTel" type="text" placeholder="677777777"  value="${patient.patientTel}"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Patient Address</label>
                                        <div class="col-md-12">
                                            <input id="patientAddress"type="text" placeholder="Limbe"  value="${patient.patientAddress}"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                     <div class="form-group">
                                        <label class="col-md-12">Patient Contact</label>
                                        <div class="col-md-12">
                                            <input id="patientContact"type="text" placeholder="699999999"  value="${patient.patientContact}"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                     <div class="form-group">
                                        <label class="col-md-12">Patient NextOfKin</label>
                                        <div class="col-md-12">
                                            <input id="patientNextOfKin"type="text" placeholder="NextOfKin"  value="${patient.patientNextOfKin}"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                     <div class="form-group">
                                        <label class="col-md-12">Patient Consultations</label>
                                        <div class="col-md-12">
                                            <input id="patientConsultations"type="text" placeholder="Patient Consultations info"  value="${patient.patientConsultations}"
                                                class="form-control form-control-line">
                                        </div>
                                    </div>
                                    
                                   
                                   
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                        <input class="btn btn-success" type="button"  onclick="persistEditPatient('${patient.id}');" name="submit" value="Update patient">
                                        </div>
                                    </div>
                                </form>
                                
                            </div>
                        </div>
                    </div>