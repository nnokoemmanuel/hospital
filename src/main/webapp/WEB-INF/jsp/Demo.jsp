<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">
			<title>EXAMPLE</title>
	</head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<body>
		
			<div class="w3-sidebar w3-bar-block w3-green" style="width:150px">
				  <h5 class="w3-bar-item">Menu</h5>
				  <button class="w3-bar-item w3-button tablink" onclick="openLink(event, 'Fade')"><i class="fa fa-home"></i> Home</button>
				  <button class="w3-bar-item w3-button tablink" onclick="openLink(event, 'Left')"><i class="fa fa-search"></i> Search</button>
				  <button class="w3-bar-item w3-button tablink" onclick="openLink(event, 'Right')"> <i class="fa fa-envelope"></i> Envelope</button>
				  <button class="w3-bar-item w3-button tablink" onclick="openLink(event, 'Top')">Top</button>
				  <button class="w3-bar-item w3-button tablink" onclick="openLink(event, 'Bottom')">Bottom</button>
				  <button class="w3-bar-item w3-button tablink" onclick="openLink(event, 'Zoom')"> <i class="fa fa-trash"></i> Trash</button>
			</div>

			<div  class="w3-main" style="margin-left:310px;margin-right:40px">
			  <div class="w3-padding">So basically this is what it does.</div>
			
			  <div id="Fade" class="w3-container city w3-animate-opacity" style="display:none">
			    <h2>Kuroko's Basketball</h2>
			    <p>Top Players:Click to sort </p>
			    
			   <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
			    <table id="myTable"  class="sortable w3-table-all w3-hoverable">
					  <tr >
					    <th onclick="sortTable(0)" >Players's Name</th>
					    <th onclick="sortTable(1)" >Team</th>
					    <th onclick="sortTable(2)" >Special skill</th>
					    <th onclick="sortTable(3)">Build level</th>
					  </tr >
					  <tr>
					    <td>Tetsuya kuroko</td>
					    <td>Seirin</td>
					    <td>Phantom sixth man</td>
					    <td>50%++</td>
					  <tr>
					    <td>Taiga Kagami</td>
					    <td>Seirin</td>
					    <td>Enters two zones</td>
					    <td>99%</td>
					  </tr>
					  <tr >
					    <td>Ryota kise</td>
					    <td>idk</td>
					    <td>Perfect Copy</td>
					    <td>50%/50%</td>
					  </tr>
					  <tr>
					    <td>Shintaro Midorima</td>
					    <td>Shutou</td>
					    <td>3-points throw</td>
					    <td>89%</td>
					  </tr>
					  <tr >
					    <td>Atushi Marasakibara</td>
					    <td>idk</td>
					    <td>Lazy but gifted</td>
					    <td>70%</td>
					  </tr>
					  <tr>
					    <td>Daiki Aomine</td>
					    <td>idk</td>
					    <td>really gifted</td>
					    <td>98%</td>
					  </tr>
					   <tr>
					    <td>Seijuro Akashi </td>
					    <td>idk</td>
					    <td>Emperor's eye</td>
					    <td>100%</td>
					  </tr>
				</table>

    		 </div>

		  <div id="Left" class="w3-container city w3-animate-left" style="display:none">
		    <h2>Slide in from left</h2>
		    <p>this tab slides in from left.</p> 
		  </div>

		  <div id="Top" class="w3-container city w3-animate-top" style="display:none">
		    <h2>Slide in from top</h2>
		    <p>This tab slides from the top.</p>
		  </div>

		  <div id="Right" class="w3-container city w3-animate-right" style="display:none">
		    <h2>Slide in from right</h2>
		    <p>This tab slides from the right.</p>
		   </div>

		  <div id="Bottom" class="w3-container ci w3-animate-bottom" style="display:none">
		    <h2>Slide in from bottom</h2>
		    <p>This tab slides form the bottom.</p> 
		 </div>

		  <div id="Trash" class="w3-container city w3-animate-zoom" style="display:none">
		    <h2>Zoom in</h2>
		    <p>This tab zooms in.</p>
		 </div>

		</div>
 	
 	
 	
 				<script src="${pageContext.request.contextPath}/js/custom.js"></script>
		</body>
</html>