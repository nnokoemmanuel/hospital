
function persistCreateUser(){ 
var userName= document.getElementById("userName").value;
var userSurName=document.getElementById('userSurName').value;
var userGivenName=document.getElementById('userGivenName').value;
var userEmail=document.getElementById('userEmail').value;
var userDob=document.getElementById('userDob').value;
var userAddress=document.getElementById('userAddress').value;
var userPassword=document.getElementById('userPassword').value;

let role=document.getElementsByClassName("userRole");
let userRole="";
for(var i=0;i<role.length;i++){
	if(role[i].checked==true) userRole+=role[i].value+",";
}



var userForm = "id="+0;
userForm+="&userName="+userName;
userForm+="&userSurName="+userSurName;
userForm+="&userGivenName="+userGivenName;
userForm+="&userEmail="+userEmail;
userForm+="&userDob="+userDob;
userForm+="&userAddress="+userAddress;
userForm+="&userPassword="+userPassword;
userForm+="&userRole="+userRole;


var windowurl = window.location.href;
var baseUrl = windowurl.split('://')[1].split('/')[0]; 
var xhr = new XMLHttpRequest();
var url='http://'+baseUrl+'/hospital/user/createpost';	

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
		  alert("user successfully create");
		  return false;
	  }
	  
  }
};

xhr.send(userForm); //object use to send

}


function persistEditUser(id){ 
var userName= document.getElementById("userName").value;
var userSurName=document.getElementById('userSurName').value;
var userGivenName=document.getElementById('userGivenName').value;
var userEmail=document.getElementById('userEmail').value;
var userDob=document.getElementById('userDob').value;
var userAddress=document.getElementById('userAddress').value;
var userPassword=document.getElementById('userPassword').value;

let role=document.getElementsByClassName("userRole");
let userRole="";
for(var i=0;i<role.length;i++){
	if(role[i].checked==true) userRole+=role[i].value+",";
}



var userForm = "id="+id;
userForm+="&userName="+userName;
userForm+="&userSurName="+userSurName;
userForm+="&userGivenName="+userGivenName;
userForm+="&userEmail="+userEmail;
userForm+="&userDob="+userDob;
userForm+="&userAddress="+userAddress;
userForm+="&userPassword="+userPassword;
userForm+="&userRole="+userRole;


var windowurl = window.location.href;
var baseUrl = windowurl.split('://')[1].split('/')[0]; 
var xhr = new XMLHttpRequest();
var url='http://'+baseUrl+'/hospital/user/createpost';	

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
		  alert("user successfully updated");
		  return false;
	  }
	  
  }
};

xhr.send(userForm); //object use to send

}

/*----------Search----------*/
function myFunction() {
	  var input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[0];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}
/*
function createUserGroup(){
	
	var group_name = document.getElementById("group_name").value;
	if(group_name === ""){
		alert("Enter the name of the group! ");
		die();
	}
	 CheckIfARoleHasBeenSelected();
	var name = ("#group_name").val();
	var url = $("#baseUrl").val()+"/marine/group/createPost?groupName="+name+"&role="+getSelectedRoleValue()+"";
	doGet(url, 'kt_content');
}

function editUserGroup(){
	
	var group_name = document.getElementById("group_name").value;
	if(group_name === ""){
		alert("Enter the name of the group! ");
		die();
	}
	CheckIfARoleHasBeenSelected();
	var name = ("#group_name").val();
	var url = $("#baseUrl").val()+"/marine/group/edit/save?groupName="+name+"&role="+getSelectedRoleValue()+"&id="+id;
	doGet(url, 'kt_content');
}

function checkIfARoleHasBeenSelected(){
	var textsinputs = document.querySelectorAll('input[type=checkbox]');
	var empty = [].filter.call(textinputs, function( el ){
		return !el.checked
	});
	
	if (textinputs.length == empty.length);
	alert("Please select a role! ");
	die();
}

function getSelectedRoleValue(){
	var tenpom=0;
	var allCheck = new Array();
	var textinputs = document.querySelectorAll('input[type=checkbox]');
	var SeletedRoleCheckbox = [].filter.call(textinputs, function( el ){
		return el.checked
	})
	  if(SeletedRoleCheckBox.length==1){
		  return SeletedRoleCheckbox[0].value; 
	  }else if(SeletedRoleCheckbox.length>1){
		  for(var i=0; i< SeletedRoleCheckbox.length ;i++){
			  tenpom= SeletedRoleCheckbox[i].value;
			  allCheck += tenpom+'/';
		  }
		  return allCheck;
	  }else{
			alert("Select at leat one role! ");
			return undefined;
	  }
	}

*/
