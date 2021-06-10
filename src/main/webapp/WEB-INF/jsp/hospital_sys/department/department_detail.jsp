<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

	   <div style="background-color:#555; color:black">
	   
	                            <%-- <div class="col-sm-3">
									<label><span><fmt:message key="" /> street : </span></label>
									<span>${contactDetail_java.address.street}</span>
								</div> --%>
								
								<h style="color:black"><b> DEPARTMENT INFO :: </b></h>
								<br><br>
								
							     <div class="col-sm-3">
									<label><span>Department Name :  </span>  </label>
									<span> ${department.departmentName}</span>
									 <%-- <c:out value="${contactDetail_java.person.surName}"></c:out> --%>
								</div>
								
								<div class="col-sm-3">
									<label><span> Department Type : </span></label>
									<span>${department.departmentType}</span>
								</div>
								<div class="col-sm-3">
									<label><span> Department Description : </span> </label>
									<span>${department.departmentDescription}</span>
								</div>
								
	
</div>

		  



		  



