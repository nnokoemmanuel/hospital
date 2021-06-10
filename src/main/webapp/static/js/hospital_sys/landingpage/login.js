
const loginForm = document.getElementById("login-form");
const loginButton = document.getElementById("login-form-submit");
const loginErrorMsg = document.getElementById("login-error-msg");

loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    const username = loginForm.username.value;
    const password = loginForm.password.value;

    if (username === "ubstudent" && password === "ub123") {
        alert("You have successfully logged in.");
        location.reload();
    } else {
        loginErrorMsg.style.opacity = 1;
    }
})


function callAuthentication(){ 

var userName=document.getElementById('userName').value;
var userPassword=document.getElementById('userPassword').value;

var userLoginForm = "userName="+userName;
userLoginForm+="&userPassword="+userPassword;
//var formData = new FormData(); //collect values from jsp
//formData.append('userName', userName);
//formData.append('userPassword', userPassword);

var windowurl = window.location.href;
var baseUrl = windowurl.split('://')[1].split('/')[0]; 
var url='http://'+baseUrl+'/hospital/checkLoginUser';
var xmlHttp     =   new XMLHttpRequest();
xmlHttp.open("POST", url, false);
xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
xmlHttp.setRequestHeader("X-Requested-With", "XMLHttpRequest");
xmlHttp.onreadystatechange = function(){
  //return error page if status code is not 200
  if(xmlHttp.status !== 200){
  	console.log("ERROR!");  	
      return;
  }
  if(xmlHttp.readyState === 4 && xmlHttp.status === 200){
  
	    //console.log("SUCCESS!");
	     var serverResponse = xmlHttp.responseText;
  	     if(serverResponse == "connection.deny.user.not.having.role"){
  	    	 alert( "you can not login because you don't have role");
  	    	 return false;//function stop
  	     }
  	     
  	     if(serverResponse == "connection.denied.wrong.password"){
	    	 alert( "bad credentials");
	    	 return false;//function stop
	     }
  	     
  	     if(serverResponse == "connection.deny.user.not.exist"){
	    	 alert( "bad credentials");
	    	 return false;//function stop
	     }
  	     
  	     if(serverResponse.indexOf("connection.granted")>-1){
  	       if(serverResponse.indexOf("ROLE_ADMINISTRATOR")>-1){
  	    	var userName = serverResponse.split("@")[2]+" "+serverResponse.split("@")[3]; 
  	    	var url='http://'+baseUrl+'/hospital/homeAdmin'; 
  	    	var xhr = new XMLHttpRequest();
  	    	xhr.open("GET", url);
  	    	xhr.onreadystatechange = function(){
	  	        if(xhr.readyState === 4 && xhr.status === 200){
	  	        	var serverResponse = xhr.responseText;
	                document.open(); 
	  	        	document.write(serverResponse);
	  	        	document.getElementById("userName").innerHtml=userName;
	  	        	document.close();
	  	        	
	  	        }
  	    	};
  	    	
  	    	xhr.send(null);
  	      }
	     }
  }
};
xmlHttp.send(userLoginForm); //object use to send

}







