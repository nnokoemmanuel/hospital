
function processFormData(){ 

var surName=document.getElementById('surName').value;
var givenName=document.getElementById('givenName').value;
var email=document.getElementById('email').value
var country=document.getElementById('country').value;
var town=document.getElementById('town').value;
var street=document.getElementById('street').value;
var phoneNumber=document.getElementById('phoneNumber1').value;
var phoneNumber2=document.getElementById('phoneNumber2').value;

//var final_person = x1 +""+x2+""+x3+""+x4+""+x5+""+x6+""+x7+""+x8;

//if(("#contactId").value==""){
//	 final_person  += "&id=0";
// }
	
	
	
var formData = new FormData(); //collect values from jsp
formData.append('id', 0);
formData.append('surName', surName);
formData.append('givenName', givenName);
formData.append('email', email);
formData.append('country', country);
formData.append('town', town);
formData.append('street', street);
formData.append('phoneNumber1', phoneNumber);
formData.append('phoneNumber2', phoneNumber2);
alert("formdata"  +formData);

	
/*	var person = "surName="+$('#surName').val();
	person += "&givenName="+$('#givenName').val();
	person += "&email="+$('#email').val();
	person += "&phoneNumber1="+$('#phoneNumber1').val();
	person += "&phoneNumber2="+$('#phoneNumber2').val();
	person += "&country="+$('#country').val();
	person += "&town="+$('#town').val();
	person += "&street="+$('#street').val();
	alert("person"  +person)*/
	
var windowurl = window.location.href;
var baseUrl = windowurl.split('://')[1].split('/')[0]; 
var xhr = new XMLHttpRequest();
var url='http://'+baseUrl+'/rouge/saveContacts';
xhr.open("POST", url);
xhr.send(formData); //object use to send

alert('Contact has been added successfully.')

//alert("surName : "+x1+"\n givenName : "+x2+"\n email : "+x3+"\n phoneNumber : "+x4+"\n alt_phoneNumber : "+x5+"\n country : "+x6+"\n town : "+x7+"\n street : "+x8);  
}

function getTable()  {
	  location.replace("http://localhost:8080/rouge/listContacts")
	}





$("#id_processFormData").on(
		'click',
		function() {
			     alert("validate update fxn");
              update_processFormData();
		});



function update_processFormData(){
	 alert("inside update fxn");
}





function updateFormData(){ 

	var surName=document.getElementById('surName').value;
	var givenName=document.getElementById('givenName').value;
	var email=document.getElementById('email').value
	var country=document.getElementById('country').value;
	var town=document.getElementById('town').value;
	var street=document.getElementById('street').value;
	var phoneNumber=document.getElementById('phoneNumber1').value;
	var phoneNumber2=document.getElementById('phoneNumber2').value;

	//var final_person = x1 +""+x2+""+x3+""+x4+""+x5+""+x6+""+x7+""+x8;

	//if(("#contactId").value==""){
//		 final_person  += "&id=0";
	// }
		
		
		
	var formData = new FormData(); //collect values from jsp
	formData.append('id', 0);
	alert("ha1");
	formData.append('surName', surName);
	formData.append('givenName', givenName);
	formData.append('email', email);
	formData.append('country', country);
	formData.append('town', town);
	formData.append('street', street);
	formData.append('phoneNumber1', phoneNumber);
	formData.append('phoneNumber2', phoneNumber2);
	alert("formdata"  +formData);

		
	/*	var person = "surName="+$('#surName').val();
		person += "&givenName="+$('#givenName').val();
		person += "&email="+$('#email').val();
		person += "&phoneNumber1="+$('#phoneNumber1').val();
		person += "&phoneNumber2="+$('#phoneNumber2').val();
		person += "&country="+$('#country').val();
		person += "&town="+$('#town').val();
		person += "&street="+$('#street').val();
		alert("person"  +person)*/
		
	var windowurl = window.location.href;
	var baseUrl = windowurl.split('://')[1].split('/')[0]; 
	var xhr = new XMLHttpRequest();
	var url='http://'+baseUrl+'/saveContacts';
	xhr.open("POST", url);
	xhr.send(formData); //object use to send
	//emptyForm();
	//alert("emptyForm"+emptyForm());


	//alert("surName : "+x1+"\n givenName : "+x2+"\n email : "+x3+"\n phoneNumber : "+x4+"\n alt_phoneNumber : "+x5+"\n country : "+x6+"\n town : "+x7+"\n street : "+x8);  
	}



























