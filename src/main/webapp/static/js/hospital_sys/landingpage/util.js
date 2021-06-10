
function doGet(url, idResultContener){
    var xmlHttp     =   new XMLHttpRequest();
    xmlHttp.open("GET", url, false);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    xmlHttp.setRequestHeader("X-Requested-With", "XMLHttpRequest");
    xmlHttp.onreadystatechange = function(){
      if(xmlHttp.status !== 200){
      	$("#"+idResultContener).html(xmlHttp.responseText);      	
          return;
      }
      if(xmlHttp.readyState === 4 && xmlHttp.status === 200){
      	$("#"+idResultContener).html(xmlHttp.responseText);
      }else{
    	  $("#"+idResultContener).html("ERROR 202");
      }
  };
  xmlHttp.send(null);
}



/**
 * DoGet for all GET ajax
 */
/*function doGet(url){
    //function doGet(url, idResultContener){
	//displayLoading(idResultContener)
    var xmlHttp     =   new XMLHttpRequest();
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
*/
