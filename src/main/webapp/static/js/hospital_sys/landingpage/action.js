
/**
 08-February-2021
 */

"use strict";

function openNav() {
	//alert("openNav");
    //document.getElementById("overlay").style.width = "100%";
    document.getElementById("myNav").style.width = "100%";

}

function openNav1() {
	//alert("openNav");
    //document.getElementById("overlay").style.width = "100%";
    document.getElementById("myNav1").style.width = "100%";

}

/* Close when someone clicks on the "x" symbol inside the overlay */
function closeNav() {
	//alert("closeNav");
    //document.getElementById("overlay").style.width = "0%";
	document.getElementById("myNav").style.width = "0%";
}

/* Close when someone clicks on the "x" symbol inside the overlay */
function closeNav1() {
	//alert("closeNav");
    //document.getElementById("overlay").style.width = "0%";
	document.getElementById("myNav1").style.width = "0%";
}




function doDelete(id){
var windowurl = window.location.href;
var baseUrl = windowurl.split('://')[1].split('/')[0]; 
var url='http://'+baseUrl+'/hospital/user/delete/' + id;
		swal({
			title:'Are you Sure?',
			text:"Are you want to Delete this User?",
			type:'warning',
			buttons:{
				confirm: {
					text : 'Yes',
					className : 'btn btn success'
				},
				cancel : {
					text : 'No',
					className: 'btn btn danger'
				},
			}
		}).then((confirm)=> {
			if (confirm){
				var xhr = new XMLHttpRequest();
				xhr.open("GET", url);
				xhr.send(url); //object use to send
				xhr.onreadystatechange = function(){
					  if(xhr.status !== 200){
						  alert("error js");  	
					      return;
					  }
					  if(xhr.readyState === 4 && xhr.status === 200){
						  swal("Deleted!");
						  setTimeout(function(){
							  document.getElementsByClassName("swal2-modal swal2-show")[0].style.display = "none"; 
							  document.getElementsByClassName("swal2-container swal2-fade swal2-in")[0].style.backgroundColor = "transparent";  
							  
							  },3000);

						  return;  
					  }
					};
				
				
			}else{
				swal("cancelled", "Delete Action Cancelled :)", "error");
			}
		  });

}

function doDeleteDepartment(id){
	var windowurl = window.location.href;
	var baseUrl = windowurl.split('://')[1].split('/')[0]; 
	var url='http://'+baseUrl+'/hospital/department/delete/' + id;
			swal({
				title:'Are you Sure?',
				text:"Are you want to Delete this Department?",
				type:'warning',
				buttons:{
					confirm: {
						text : 'Yes',
						className : 'btn btn success'
					},
					cancel : {
						text : 'No',
						className: 'btn btn danger'
					},
				}
			}).then((confirm)=> {
				if (confirm){
					var xhr = new XMLHttpRequest();
					xhr.open("GET", url);
					xhr.send(url); //object use to send
					xhr.onreadystatechange = function(){
						  if(xhr.status !== 200){
							  alert("error js");  	
						      return;
						  }
						  if(xhr.readyState === 4 && xhr.status === 200){
							  swal("Deleted!");
							  setTimeout(function(){
								  document.getElementsByClassName("swal2-modal swal2-show")[0].style.display = "none"; 
								  document.getElementsByClassName("swal2-container swal2-fade swal2-in")[0].style.backgroundColor = "transparent";  
								  
								  },3000);

							  return;  
						  }
						};
					
					
				}else{
					swal("cancelled", "Delete Action Cancelled :)", "error");
				}
			  });

	}

function doDeleteRole(id){
	var windowurl = window.location.href;
	var baseUrl = windowurl.split('://')[1].split('/')[0]; 
	var url='http://'+baseUrl+'/hospital/role/delete/' + id;
			swal({
				title:'Are you Sure?',
				text:"Are you want to Delete this Role?",
				type:'warning',
				buttons:{
					confirm: {
						text : 'Yes',
						className : 'btn btn success'
					},
					cancel : {
						text : 'No',
						className: 'btn btn danger'
					},
				}
			}).then((confirm)=> {
				if (confirm){
					var xhr = new XMLHttpRequest();
					xhr.open("GET", url);
					xhr.send(url); //object use to send
					xhr.onreadystatechange = function(){
						  if(xhr.status !== 200){
							  alert("error js");  	
						      return;
						  }
						  if(xhr.readyState === 4 && xhr.status === 200){
							  swal("Deleted!");
							  setTimeout(function(){
								  document.getElementsByClassName("swal2-modal swal2-show")[0].style.display = "none"; 
								  document.getElementsByClassName("swal2-container swal2-fade swal2-in")[0].style.backgroundColor = "transparent";  
								  
								  },3000);

							  return;  
						  }
						};
					
					
				}else{
					swal("cancelled", "Delete Action Cancelled :)", "error");
				}
			  });

	}

function doDeleteEmployee(id){
	var windowurl = window.location.href;
	var baseUrl = windowurl.split('://')[1].split('/')[0]; 
	var url='http://'+baseUrl+'/hospital/employee/delete/' + id;
			swal({
				title:'Are you Sure?',
				text:"Are you want to Delete this Employee?",
				type:'warning',
				buttons:{
					confirm: {
						text : 'Yes',
						className : 'btn btn success'
					},
					cancel : {
						text : 'No',
						className: 'btn btn danger'
					},
				}
			}).then((confirm)=> {
				if (confirm){
					var xhr = new XMLHttpRequest();
					xhr.open("GET", url);
					xhr.send(url); //object use to send
					xhr.onreadystatechange = function(){
						  if(xhr.status !== 200){
							  alert("error js");  	
						      return;
						  }
						  if(xhr.readyState === 4 && xhr.status === 200){
							  swal("Deleted!");
							  setTimeout(function(){
								  document.getElementsByClassName("swal2-modal swal2-show")[0].style.display = "none"; 
								  document.getElementsByClassName("swal2-container swal2-fade swal2-in")[0].style.backgroundColor = "transparent";  
								  
								  },3000);

							  return;  
						  }
						};
					
					
				}else{
					swal("cancelled", "Delete Action Cancelled :)", "error");
				}
			  });

	}
function doDeleteCashier(id){
	var windowurl = window.location.href;
	var baseUrl = windowurl.split('://')[1].split('/')[0]; 
	var url='http://'+baseUrl+'/hospital/cashier/delete/' + id;
			swal({
				title:'Are you Sure?',
				text:"Are you want to Delete this Cashier?",
				type:'warning',
				buttons:{
					confirm: {
						text : 'Yes',
						className : 'btn btn success'
					},
					cancel : {
						text : 'No',
						className: 'btn btn danger'
					},
				}
			}).then((confirm)=> {
				if (confirm){
					var xhr = new XMLHttpRequest();
					xhr.open("GET", url);
					xhr.send(url); //object use to send
					xhr.onreadystatechange = function(){
						  if(xhr.status !== 200){
							  alert("error js");  	
						      return;
						  }
						  if(xhr.readyState === 4 && xhr.status === 200){
							  swal("Deleted!");
							  setTimeout(function(){
								  document.getElementsByClassName("swal2-modal swal2-show")[0].style.display = "none"; 
								  document.getElementsByClassName("swal2-container swal2-fade swal2-in")[0].style.backgroundColor = "transparent";  
								  
								  },3000);

							  return;  
						  }
						};
					
					
				}else{
					swal("cancelled", "Delete Action Cancelled :)", "error");
				}
			  });

	}

function doDeletePatient(id){
	var windowurl = window.location.href;
	var baseUrl = windowurl.split('://')[1].split('/')[0]; 
	var url='http://'+baseUrl+'/hospital/patient/delete/' + id;
			swal({
				title:'Are you Sure?',
				text:"Are you want to Delete this Patient?",
				type:'warning',
				buttons:{
					confirm: {
						text : 'Yes',
						className : 'btn btn success'
					},
					cancel : {
						text : 'No',
						className: 'btn btn danger'
					},
				}
			}).then((confirm)=> {
				if (confirm){
					var xhr = new XMLHttpRequest();
					xhr.open("GET", url);
					xhr.send(url); //object use to send
					xhr.onreadystatechange = function(){
						  if(xhr.status !== 200){
							  alert("error js");  	
						      return;
						  }
						  if(xhr.readyState === 4 && xhr.status === 200){
							  swal("Deleted!");
							  setTimeout(function(){
								  document.getElementsByClassName("swal2-modal swal2-show")[0].style.display = "none"; 
								  document.getElementsByClassName("swal2-container swal2-fade swal2-in")[0].style.backgroundColor = "transparent";  
								  
								  },3000);

							  return;  
						  }
						};
					
					
				}else{
					swal("cancelled", "Delete Action Cancelled :)", "error");
				}
			  });

	}


