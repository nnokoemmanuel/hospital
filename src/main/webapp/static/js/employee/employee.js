
function persistCreateEmployee(){ 
var employeeName= document.getElementById("employeeName").value;
var employeeTel=document.getElementById('employeeTel').value;
var employeeEmail=document.getElementById('employeeEmail').value;
var employeeUserName=document.getElementById('employeeUserName').value;
var employeePassword=document.getElementById('employeePassword').value;
var employeeRole=document.getElementById('employeeRole').value;



var employeeForm = "id="+0;
employeeForm+="&employeeName="+employeeName;
employeeForm+="&employeeTel="+employeeTel;
employeeForm+="&employeeEmail="+employeeEmail;
employeeForm+="&employeeUserName="+employeeUserName;
employeeForm+="&employeePassword="+employeePassword;
employeeForm+="&employeeRole="+employeeRole;



var windowurl = window.location.href;
var baseUrl = windowurl.split('://')[1].split('/')[0]; 
var xhr = new XMLHttpRequest();
var url='http://'+baseUrl+'/hospital/employee/createpost';	

xhr.open("POST", url);
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
xhr.onreadystatechange = function(){


  if(xhr.status !== 200){
	  alert("error js");  	
      return;
  }
  if(xhr.readyState === 4 && xhr.status === 200){
	  var serverResponse = xhr.responseText;
	  if(serverResponse.indexOf("OK") > -1){
		  alert("employee successfully create");
		  return false;
	  }
	  
  }
};

xhr.send(employeeForm); //object use to send

}




function persistEditEmployee(id){ 
	var employeeName= document.getElementById("employeeName").value;
	var employeeTel=document.getElementById('employeeTel').value;
	var employeeEmail=document.getElementById('employeeEmail').value;
	var employeeUserName=document.getElementById('employeeUserName').value;
	var employeePassword=document.getElementById('employeePassword').value;
	var employeeRole=document.getElementById('employeeRole').value;




	var employeeForm = "id="+id;
	employeeForm+="&employeeName="+employeeName;
	employeeForm+="&employeeTel="+employeeTel;
	employeeForm+="&employeeEmail="+employeeEmail;
	employeeForm+="&employeeUserName="+employeeUserName;
	employeeForm+="&employeePassword="+employeePassword;
	employeeForm+="&employeeRole="+employeeRole;



var windowurl = window.location.href;
var baseUrl = windowurl.split('://')[1].split('/')[0]; 
var xhr = new XMLHttpRequest();
//var url='http://'+baseUrl+'/hospital/department/editpost';	
var url='http://'+baseUrl+'/hospital/patient/createpost';

xhr.open("POST", url);
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
xhr.onreadystatechange = function(){


  if(xhr.status !== 200){
	  alert("error js");  	
      return;
  }
  if(xhr.readyState === 4 && xhr.status === 200){
	  var serverResponse = xhr.responseText;
	  if(serverResponse.indexOf("OK") > -1){
		  alert("patient successfully updated");
		  return false;
	  }
	  
  }
};

xhr.send(employeeForm); //object use to send

}

