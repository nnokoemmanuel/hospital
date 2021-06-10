
function persistCreatePatient(){ 
var patientName= document.getElementById("patientName").value;
var patientTel=document.getElementById('patientTel').value;
var patientAddress=document.getElementById('patientAddress').value;
var patientContact=document.getElementById('patientContact').value;
var patientNextOfKin=document.getElementById('patientNextOfKin').value;
var patientConsultations=document.getElementById('patientConsultations').value;



var patientForm = "id="+0;
patientForm+="&patientName="+patientName;
patientForm+="&patientTel="+patientTel;
patientForm+="&patientAddress="+patientAddress;
patientForm+="&patientContact="+patientContact;
patientForm+="&patientNextOfKin="+patientNextOfKin;
patientForm+="&patientConsultations="+patientConsultations;



var windowurl = window.location.href;
var baseUrl = windowurl.split('://')[1].split('/')[0]; 
var xhr = new XMLHttpRequest();
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
		  alert("patient successfully create");
		  return false;
	  }
	  
  }
};

xhr.send(patientForm); //object use to send

}




function persistEditPatient(id){ 
	var patientName= document.getElementById("patientName").value;
	var patientTel=document.getElementById('patientTel').value;
	var patientAddress=document.getElementById('patientAddress').value;
	var patientContact=document.getElementById('patientContact').value;
	var patientNextOfKin=document.getElementById('patientNextOfKin').value;
	var patientConsultations=document.getElementById('patientConsultations').value;




	var patientForm = "id="+id;
	patientForm+="&patientName="+patientName;
	patientForm+="&patientTel="+patientTel;
	patientForm+="&patientAddress="+patientAddress;
	patientForm+="&patientContact="+patientContact;
	patientForm+="&patientNextOfKin="+patientNextOfKin;
	patientForm+="&patientConsultations="+patientConsultations;



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

xhr.send(patientForm); //object use to send

}

