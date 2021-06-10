// alert("I'm Active");


/* open-tab from navbar*/
function openPage(pageName,elmnt,color) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].style.backgroundColor = "";
  }
  document.getElementById(pageName).style.display = "block";
  elmnt.style.backgroundColor = color;
}

//Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();


/*Search filter table*/
function myFunction() {
	  // Declare variables
	  var input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");

	  // Loop through all table rows, and hide those who don't match the search query
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

/*sort*/
function sortTable(n) {
	  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
	  table = document.getElementById("myTable");
	  switching = true;
	  
	  //Set the sorting direction to ascending:
	  dir = "asc"; 
	 
	  /*Make a loop that will continue until
	  no switching has been done:*/
	  while (switching) {
	    
		  //start by saying: no switching is done:
	    switching = false;
	    rows = table.rows;
	   
	    /*Loop through all table rows (except the
	    first, which contains table headers):*/
	  for (i = 1; i < (rows.length - 1); i++) {
	     
		  //start by saying there should be no switching:
	      shouldSwitch = false;
	      
	      /*Get the two elements you want to compare,
	      one from current row and one from the next:*/
	      x = rows[i].getElementsByTagName("TD")[n];
	      y = rows[i + 1].getElementsByTagName("TD")[n];
	      
	      /*check if the two rows should switch place,
	      based on the direction, asc or desc:*/
	      if (dir == "asc") {
	        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
	         
	        	//if so, mark as a switch and break the loop:
	          shouldSwitch= true;
	          break;
	        }
	      } else if (dir == "desc") {
	        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
	          //if so, mark as a switch and break the loop:
	          shouldSwitch = true;
	          break;
	        }
	      }
	    }
	  
	    if (shouldSwitch) {
	     
	    	/*If a switch has been marked, make the switch
	      and mark that a switch has been done:*/
	      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
	      switching = true;
	     
	      //Each time a switch is done, increase this count by 1:
	      switchcount ++;      
	    } else {
	     
	    	/*If no switching has been done AND the direction is "asc",
	      set the direction to "desc" and run the while loop again.*/
	      if (switchcount == 0 && dir == "asc") {
	        dir = "desc";
	        switching = true;
	      }
	    }
	  }
	}



/*CALLS CONTROLLER VIA THIS JAVASCRIPT*/

function getTable() {
	var windowurl = window.location.href;
	var baseUrl = windowurl.split('://')[1].split('/')[0]; //function to split string
	//var baseurl = document.getElementById('baseurl').value;
	var xhr = new XMLHttpRequest();
	var url='http://'+baseUrl+'/rouge/listContacts';
	xhr.open("GET", url);
	xhr.send(); //object use to send
	xhr.onreadystatechange=function() {
		if(xhr.readyState==4 && this.status==200){
	/*console.log(xhr.responseText); //the response of the request*/		
	document.getElementById("Home").innerHTML = xhr.responseText;
		}
	  }
    }


/*ADD BUTTON  - CREATE CONTACT :: GET  */
function getURL() {

	var windowurl = window.location.href;
	var baseUrl = windowurl.split('://')[1].split('/')[0]; 
	//alert("baseUrl=="+baseUrl);
  
	var xhr = new XMLHttpRequest();
	var url='http://'+baseUrl+'/rouge/createContacts';
	xhr.open("GET", url);
	xhr.send(url); //object use to send
	//alert("url=="+url);


	/*	xhr.onreadystatechange=function() {
		if(xhr.readyState==4 && this.status==200){
		//console.log(xhr.responseText); //the response of the request
				
	         //document.getElementById("Home").innerHTML = xhr.responseText;
			
			document.getElementById("News").innerHTML = xhr.responseText;
			
		}
	 }*/
	
}



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





/* DEFINE AJAX */
/**
 * Define ajax fxn 
 */
function getXMLHttp(){
	var xmlHttp = false;
	try{
		//try to get request object for IE 5 or later
		xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
	}catch(e){
		//get request object for earlier versions of IE.
		try{
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}catch(e){
			
		}
	}	
	
	if(!xmlHttp && typeof XMLHttpRequest !== 'undefined'){
		xmlHttp = new XMLHttpRequest();
	}
	
	return xmlHttp;
}





/**
 * DoGet for all GET ajax
 */
function doGet(url){
    //function doGet(url, idResultContener){
	//displayLoading(idResultContener)
    var xmlHttp     =   getXMLHttp();
    xmlHttp.open("GET", url, false);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    xmlHttp.setRequestHeader("X-Requested-With", "XMLHttpRequest");
    xmlHttp.onreadystatechange = function(){
      //return error page if status code is not 200
      if(xmlHttp.status !== 200){
      	console.log("ERROR!");
      	alert("ERROR!");
      //	$("#"+idResultContener).html(xmlHttp.responseText);
      //	$("#"+idResultContener).removeClass("deactivate");
      	
          return;
      }
      if(xmlHttp.readyState === 4 && xmlHttp.status === 200){
      	//$("#loading").addClass("hide");
      //	$("#"+idResultContener).html(xmlHttp.responseText);
      //	$("#"+idResultContener).removeClass("deactivate");
    	    console.log("SUCCESS!");
    		//alert("SUCCESS!");
      	     
      }else{
    	 // $("#"+idResultContener).html("ERROR 202");
    	 
    	  
      }
  };
  xmlHttp.send(null);
}






function list_action(value,id){
	//alert("list_action");
	
	switch(value){
	
	case "action": 
		return;
    		
	case "detail":
		alert("detail");
		//openNav();
		
		var windowurl = window.location.href;
		var baseUrl = windowurl.split('://')[1].split('/')[0]; 
		alert("baseUrl ="+baseUrl);
		
		var xhr = new XMLHttpRequest();
		var url='http://'+baseUrl+'/rouge/contacts/detail?id=' + id;
		
		xhr.open("GET", url);
		xhr.send(url); //object use to send
		alert("url ="+url);
		
		break;
		
		
		
	case "update":
		alert("update");
		//openNav1();
		
		var windowurl = window.location.href;
		var baseUrl = windowurl.split('://')[1].split('/')[0]; 
		//alert("baseUrl ="+baseUrl);
		
		var xhr = new XMLHttpRequest();
		//var url='http://'+baseUrl+'/contacts/update/' + id;
		var url='http://'+baseUrl+'/rouge/contacts/update?id=' + id;
		
		xhr.open("GET", url);
		xhr.send(url); //object use to send
		alert("url ="+url);
		
		break;
		
		
	case "delete":
		alert("delete");
		openNav1();
		
		var windowurl = window.location.href;
		var baseUrl = windowurl.split('://')[1].split('/')[0]; 
		//alert("baseUrl ="+baseUrl);
		
		var xhr = new XMLHttpRequest();
		//var url='http://'+baseUrl+'/contacts/update/' + id;
		var url='http://'+baseUrl+'/rouge/contacts/delete?id=' + id;
		
		xhr.open("GET", url);
		xhr.send(url); //object use to send
		alert("url ="+url);
		
		break;
		
		
	default:
	   return;
	}
	
	
}








/**
 * DoGet for all POST ajax
 */
function doPost(url, idResultContener){
	displayLoading(idResultContener)
	
	//$("#"+idResultContener).html("Loaging...");
	var xmlHttp     =   getXMLHttp();
    xmlHttp.open("POST", url, true);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    xmlHttp.setRequestHeader("X-Requested-With", "XMLHttpRequest");
    xmlHttp.onreadystatechange = function(){
      //return error page if status code is not 200
      if(xmlHttp.status !== 200){
      	console.log("ERROR!");
      	$("#"+idResultContener).html(xmlHttp.responseText);
          return;
      }
      if(xmlHttp.readyState === 4 && xmlHttp.status === 200){
      	//$("#loading").addClass("hide");
    	  $("#"+idResultContener).html(xmlHttp.responseText);
        	$("#"+idResultContener).removeClass("deactivate");
      }else{
    	  $("#"+idResultContener).html("ERROR 202");
      }
  };
  xmlHttp.send(null);
}

//================================== UN-USED JS FXN MODULE

function getManage() {

	var windowurl = window.location.href;
	var baseUrl = windowurl.split('://')[1].split('/')[0]; //function to split string

	var xhr = new XMLHttpRequest();
	var url='http://'+baseUrl+'/mmm';
	xhr.open("GET", url);
	xhr.send(); //object use to send

	xhr.onreadystatechange=function() {
	if(xhr.readyState==4 && this.status==200){
  // console.log(xhr.responseText); //the response of the request
	 document.getElementById("Home").innerHTML = xhr.responseText;
	 }
    }
  }

function getAbout() {

	var windowurl = window.location.href;
	var baseUrl = windowurl.split('://')[1].split('/')[0]; //function to split string

	var xhr = new XMLHttpRequest();
	var url='http://'+baseUrl+'/uuu';
	xhr.open("GET", url);
	xhr.send(); //object use to send

	xhr.onreadystatechange=function() {
	if(xhr.readyState==4 && this.status==200){
	//console.log(xhr.responseText); //the response of the request
	 document.getElementById("Home").innerHTML = xhr.responseText;
	  }
    }
  }


//var baseurl = document.getElementById('baseurl').value;


function list_action_role(value,id){
	//alert("list_action");
	
	switch(value){
	
	case "action": 
		return;
    		
	case "detail":
		alert("detail");
		//openNav();
		
		var windowurl = window.location.href;
		var baseUrl = windowurl.split('://')[1].split('/')[0]; 
		alert("baseUrl ="+baseUrl);
		
		var xhr = new XMLHttpRequest();
		var url='http://'+baseUrl+'/rouge/contacts/detail?id=' + id;
		
		xhr.open("GET", url);
		xhr.send(url); //object use to send
		alert("url ="+url);
		
		break;
		
		
		
	case "update":
		alert("update");
		//openNav1();
		
		var windowurl = window.location.href;
		var baseUrl = windowurl.split('://')[1].split('/')[0]; 
		//alert("baseUrl ="+baseUrl);
		
		var xhr = new XMLHttpRequest();
		//var url='http://'+baseUrl+'/contacts/update/' + id;
		var url='http://'+baseUrl+'/rouge/contacts/update?id=' + id;
		
		xhr.open("GET", url);
		xhr.send(url); //object use to send
		alert("url ="+url);
		
		break;
		
		
	case "delete":
		alert("delete");
		openNav1();
		
		var windowurl = window.location.href;
		var baseUrl = windowurl.split('://')[1].split('/')[0]; 
		//alert("baseUrl ="+baseUrl);
		
		var xhr = new XMLHttpRequest();
		//var url='http://'+baseUrl+'/contacts/update/' + id;
		var url='http://'+baseUrl+'/rouge/contacts/delete?id=' + id;
		
		xhr.open("GET", url);
		xhr.send(url); //object use to send
		alert("url ="+url);
		
		break;
		
		
	default:
	   return;
	}
	
	
}

function list_action_department(value,id){
	//alert("list_action");
	
	switch(value){
	
	case "action": 
		return;
    		
	case "detail":
		alert("detail");
		//openNav();
		
		var windowurl = window.location.href;
		var baseUrl = windowurl.split('://')[1].split('/')[0]; 
		alert("baseUrl ="+baseUrl);
		
		var xhr = new XMLHttpRequest();
		var url='http://'+baseUrl+'/rouge/contacts/detail?id=' + id;
		
		xhr.open("GET", url);
		xhr.send(url); //object use to send
		alert("url ="+url);
		
		break;
		
		
		
	case "update":
		alert("update");
		//openNav1();
		
		var windowurl = window.location.href;
		var baseUrl = windowurl.split('://')[1].split('/')[0]; 
		//alert("baseUrl ="+baseUrl);
		
		var xhr = new XMLHttpRequest();
		//var url='http://'+baseUrl+'/contacts/update/' + id;
		var url='http://'+baseUrl+'/rouge/contacts/update?id=' + id;
		
		xhr.open("GET", url);
		xhr.send(url); //object use to send
		alert("url ="+url);
		
		break;
		
		
	case "delete":
		alert("delete");
		openNav1();
		
		var windowurl = window.location.href;
		var baseUrl = windowurl.split('://')[1].split('/')[0]; 
		//alert("baseUrl ="+baseUrl);
		
		var xhr = new XMLHttpRequest();
		//var url='http://'+baseUrl+'/contacts/update/' + id;
		var url='http://'+baseUrl+'/rouge/contacts/delete?id=' + id;
		
		xhr.open("GET", url);
		xhr.send(url); //object use to send
		alert("url ="+url);
		
		break;
		
		
	default:
	   return;
	}
	
	
}


function list_action_employee(value,id){
	//alert("list_action");
	
	switch(value){
	
	case "action": 
		return;
    		
	case "detail":
		alert("detail");
		//openNav();
		
		var windowurl = window.location.href;
		var baseUrl = windowurl.split('://')[1].split('/')[0]; 
		alert("baseUrl ="+baseUrl);
		
		var xhr = new XMLHttpRequest();
		var url='http://'+baseUrl+'/rouge/contacts/detail?id=' + id;
		
		xhr.open("GET", url);
		xhr.send(url); //object use to send
		alert("url ="+url);
		
		break;
		
		
		
	case "update":
		alert("update");
		//openNav1();
		
		var windowurl = window.location.href;
		var baseUrl = windowurl.split('://')[1].split('/')[0]; 
		//alert("baseUrl ="+baseUrl);
		
		var xhr = new XMLHttpRequest();
		//var url='http://'+baseUrl+'/contacts/update/' + id;
		var url='http://'+baseUrl+'/rouge/contacts/update?id=' + id;
		
		xhr.open("GET", url);
		xhr.send(url); //object use to send
		alert("url ="+url);
		
		break;
		
		
	case "delete":
		alert("delete");
		openNav1();
		
		var windowurl = window.location.href;
		var baseUrl = windowurl.split('://')[1].split('/')[0]; 
		//alert("baseUrl ="+baseUrl);
		
		var xhr = new XMLHttpRequest();
		//var url='http://'+baseUrl+'/contacts/update/' + id;
		var url='http://'+baseUrl+'/rouge/contacts/delete?id=' + id;
		
		xhr.open("GET", url);
		xhr.send(url); //object use to send
		alert("url ="+url);
		
		break;
		
		
	default:
	   return;
	}
	
	
}


function list_action_cashier(value,id){
	//alert("list_action");
	
	switch(value){
	
	case "action": 
		return;
    		
	case "detail":
		alert("detail");
		//openNav();
		
		var windowurl = window.location.href;
		var baseUrl = windowurl.split('://')[1].split('/')[0]; 
		alert("baseUrl ="+baseUrl);
		
		var xhr = new XMLHttpRequest();
		var url='http://'+baseUrl+'/rouge/contacts/detail?id=' + id;
		
		xhr.open("GET", url);
		xhr.send(url); //object use to send
		alert("url ="+url);
		
		break;
		
		
		
	case "update":
		alert("update");
		//openNav1();
		
		var windowurl = window.location.href;
		var baseUrl = windowurl.split('://')[1].split('/')[0]; 
		//alert("baseUrl ="+baseUrl);
		
		var xhr = new XMLHttpRequest();
		//var url='http://'+baseUrl+'/contacts/update/' + id;
		var url='http://'+baseUrl+'/rouge/contacts/update?id=' + id;
		
		xhr.open("GET", url);
		xhr.send(url); //object use to send
		alert("url ="+url);
		
		break;
		
		
	case "delete":
		alert("delete");
		openNav1();
		
		var windowurl = window.location.href;
		var baseUrl = windowurl.split('://')[1].split('/')[0]; 
		//alert("baseUrl ="+baseUrl);
		
		var xhr = new XMLHttpRequest();
		//var url='http://'+baseUrl+'/contacts/update/' + id;
		var url='http://'+baseUrl+'/rouge/contacts/delete?id=' + id;
		
		xhr.open("GET", url);
		xhr.send(url); //object use to send
		alert("url ="+url);
		
		break;
		
		
	default:
	   return;
	}
	
	
}


function list_action_patient(value,id){
	//alert("list_action");
	
	switch(value){
	
	case "action": 
		return;
    		
	case "detail":
		alert("detail");
		//openNav();
		
		var windowurl = window.location.href;
		var baseUrl = windowurl.split('://')[1].split('/')[0]; 
		alert("baseUrl ="+baseUrl);
		
		var xhr = new XMLHttpRequest();
		var url='http://'+baseUrl+'/rouge/contacts/detail?id=' + id;
		
		xhr.open("GET", url);
		xhr.send(url); //object use to send
		alert("url ="+url);
		
		break;
		
		
		
	case "update":
		alert("update");
		//openNav1();
		
		var windowurl = window.location.href;
		var baseUrl = windowurl.split('://')[1].split('/')[0]; 
		//alert("baseUrl ="+baseUrl);
		
		var xhr = new XMLHttpRequest();
		//var url='http://'+baseUrl+'/contacts/update/' + id;
		var url='http://'+baseUrl+'/rouge/contacts/update?id=' + id;
		
		xhr.open("GET", url);
		xhr.send(url); //object use to send
		alert("url ="+url);
		
		break;
		
		
	case "delete":
		alert("delete");
		openNav1();
		
		var windowurl = window.location.href;
		var baseUrl = windowurl.split('://')[1].split('/')[0]; 
		//alert("baseUrl ="+baseUrl);
		
		var xhr = new XMLHttpRequest();
		//var url='http://'+baseUrl+'/contacts/update/' + id;
		var url='http://'+baseUrl+'/rouge/contacts/delete?id=' + id;
		
		xhr.open("GET", url);
		xhr.send(url); //object use to send
		alert("url ="+url);
		
		break;
		
		
	default:
	   return;
	}
	
	
}