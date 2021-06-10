
function persistCreateDepartment(){ 
var departmentName= document.getElementById("departmentName").value;
var departmentType=document.getElementById('departmentType').value;
var departmentDescription=document.getElementById('departmentDescription').value;




var departmentForm = "id="+0;
departmentForm+="&departmentName="+departmentName;
departmentForm+="&departmentType="+departmentType;
departmentForm+="&departmentDescription="+departmentDescription;



var windowurl = window.location.href;
var baseUrl = windowurl.split('://')[1].split('/')[0]; 
var xhr = new XMLHttpRequest();
var url='http://'+baseUrl+'/hospital/department/createpost';	

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
		  alert("department successfully create");
		  return false;
	  }
	  
  }
};

xhr.send(departmentForm); //object use to send

}




function persistEditDepartment(id){ 
	var departmentName= document.getElementById("departmentName").value;
	var departmentType=document.getElementById('departmentType').value;
	var departmentDescription=document.getElementById('departmentDescription').value;




	var departmentForm = "id="+id;
	departmentForm+="&departmentName="+departmentName;
	departmentForm+="&departmentType="+departmentType;
	departmentForm+="&departmentDescription="+departmentDescription;



var windowurl = window.location.href;
var baseUrl = windowurl.split('://')[1].split('/')[0]; 
var xhr = new XMLHttpRequest();
//var url='http://'+baseUrl+'/hospital/department/editpost';	
var url='http://'+baseUrl+'/hospital/department/createpost';

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
		  alert("department successfully updated");
		  return false;
	  }
	  
  }
};

xhr.send(departmentForm); //object use to send

}

