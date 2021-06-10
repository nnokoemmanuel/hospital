<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords"
        content="wrappixel, admin dashboard, html css dashboard, web dashboard, bootstrap 4 admin, bootstrap 4, css3 dashboard, bootstrap 4 dashboard, AdminWrap lite admin bootstrap 4 dashboard, frontend, responsive bootstrap 4 admin template, AdminWrap lite design, AdminWrap lite dashboard bootstrap 4 dashboard template">
    <meta name="description"
        content="">
    <meta name="robots" content="noindex,nofollow">
    <title>PresClinic/homeAdmin</title>
    <link rel="canonical" href="https://www.wrappixel.com/templates/adminwrap-lite/" />
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/assets/images/users/logonew.png">
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/assets/node_modules/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/node_modules/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet">
    <!-- This page CSS -->
    <!-- chartist CSS -->
    <link href="${pageContext.request.contextPath}/assets/node_modules/morrisjs/morris.css" rel="stylesheet">
    <!--c3 CSS -->
    <link href="${pageContext.request.contextPath}/assets/node_modules/c3-master/c3.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/adminStyle/css/style.css" rel="stylesheet">
    <!-- Dashboard 1 Page CSS -->
    <link href="${pageContext.request.contextPath}/adminStyle/css/pages/dashboard1.css" rel="stylesheet">
    <!-- You can change the theme colors from here -->
    <link href="${pageContext.request.contextPath}/adminStyle/css/colors/default.css" id="theme" rel="stylesheet">
    
     <!-- SweetAlert CSS -->
     <link href="${pageContext.request.contextPath}/assets/sweetalert2/css/sweetalert2.min.css" rel="stylesheet">
     
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body class="fix-header fix-sidebar card-no-border">
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <div class="loader">
            <div class="loader__figure"></div>
            <p class="loader__label">PresClinic</p>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- Main wrapper - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <div id="main-wrapper">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <header class="topbar">
            <nav class="navbar top-navbar navbar-expand-md navbar-light">
                <!-- ============================================================== -->
                <!-- Logo -->
                <!-- ============================================================== -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html">
                        <!-- Logo icon --><b>
                            <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
                            <!-- Dark Logo icon -->
                            <img width="60" height="65" src="${pageContext.request.contextPath}/assets/images/users/logonew.png" alt="homepage" class="dark-logo" />
                            <!-- Light Logo icon -->
                            <img src="${pageContext.request.contextPath}/assets/images/logo-light-icon.png" alt="homepage" class="light-logo" />
                        </b>
                        <!--End Logo icon -->
                        <!-- Logo text --><span>
                            <!-- dark Logo text -->
                            <img width="170" height="120" src="${pageContext.request.contextPath}/assets/images/users/logotext.png" alt="homepage" class="dark-logo" />
                            <!-- Light Logo text -->
                            <img class="waves-effect waves-dark" src="${pageContext.request.contextPath}/assets/images/logo-light-text.png" class="light-logo" alt="homepage" /></span>
                    </a>
                </div>
                <!-- ============================================================== -->
                <!-- End Logo -->
                <!-- ============================================================== -->
                <div class="navbar-collapse">
                    <!-- ============================================================== -->
                    <!-- toggle and nav items -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item"> <a class="nav-link nav-toggler hidden-md-up waves-effect waves-dark"
                                href="javascript:void(0)"><i class="fa fa-bars"></i></a> </li>
                        <!-- ============================================================== -->
                        <!-- Search -->
                        <!-- ============================================================== -->
                        <li class="nav-item hidden-xs-down search-box"> <a
                                class="nav-link hidden-sm-down waves-effect waves-dark" href="javascript:void(0)"><i
                                    class="fa fa-search"></i></a>
                            <form class="app-search">
                                <input type="text" id="myInput" onkeyup="myFunction()" class="form-control" placeholder="Search & enter"> <a
                                    class="srh-btn"><i class="fa fa-times"></i></a></form>
                        </li>
                    </ul>
                    <!-- ============================================================== -->
                    <!-- User profile and search -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav my-lg-0">
                        <!-- ============================================================== -->
                        <!-- Profile -->
                        <!-- ============================================================== -->
                        <li class="nav-item dropdown u-pro">
                            <a class="nav-link dropdown-toggle waves-effect waves-dark profile-pic" href=""
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <div class="dropdown">
                                <img src="${pageContext.request.contextPath}/assets/images/users/IMG-20190401-WA0143.jpg" alt="user" class="" /> <span
                                    class="hidden-md-down" id="userName">Dinga Rose &nbsp;</span> 
                                    
                                     <div class="dropdown-content">
									    <a href="#">My Profile</a>
									    <a href="#">Settings</a>
									    <a href="${contextPath}/hospital/loginpage">Log out</a>
									  </div>
                                      </div>
                               </a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <!-- ============================================================== -->
        <!-- End Topbar header -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <aside class="left-sidebar">
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                 <br>
                    <ul id="sidebarnav">
                    
<!--                         <li> <a class="waves-effect waves-dark" href="index.html" aria-expanded="false"><i -->
<!--                                     class="fa fa-tachometer"></i><span class="hide-menu">Dashboard</span></a> -->
<!--                         </li> -->
<!--                         <li> <a class="waves-effect waves-dark" href="pages-profile.html" aria-expanded="false"><i -->
<!--                                     class="fa fa-user-circle-o"></i><span class="hide-menu">Profile</span></a> -->
<!--                         </li> -->
                        <li onclick="doGet('${pageContext.request.contextPath}/department/list', 'page-content');"> <a class="waves-effect waves-dark"  aria-expanded="false"><i 
                                    class="fa fa-hospital-o"></i><span class="hide-menu">Department Management</span></a>
	                      </li>
                        <li onclick="doGet('${pageContext.request.contextPath}/employee/list', 'page-content');"> <a class="waves-effect waves-dark"  aria-expanded="false"><i 
                                    class="fa fa-user-md"></i><span class="hide-menu">Human Resource Management</span></a>
                        </li> 
                         <li onclick="doGet('${pageContext.request.contextPath}/cashier/list', 'page-content');"> <a class="waves-effect waves-dark" aria-expanded="false"><i 
                                    class="fa fa-money"></i><span class="hide-menu">Cash-in</span></a>
                       </li> 
                        <li onclick="doGet('${pageContext.request.contextPath}/patient/list', 'page-content');"> <a class="waves-effect waves-dark"  aria-expanded="false"><i 
                                    class="fa fa-user-circle"></i><span class="hide-menu">Patient Management</span></a> 
                         </li> 
                         <li onclick="doGet('${pageContext.request.contextPath}/role/list', 'page-content');"> <a class="waves-effect waves-dark"  aria-expanded="false"><i 
                                    class="fa fa-user-circle"></i><span class="hide-menu">Roles Management</span></a> 
                         </li>
<!--                         <li> <a class="waves-effect waves-dark" href="pages-error-404.html" aria-expanded="false"><i -->
<!--                                     class="fa fa-question-circle"></i><span class="hide-menu">404</span></a> -->
<!--                         </li> -->
                        <li> <a class="waves-effect waves-dark"  href="${contextPath}/hospital/homeAdmin" aria-expanded="false"><i
                                    class="fa fa-user"></i><span class="hide-menu" style="color:#20aee3 !important">User Management</span></a>
                        </li>
                    </ul>
<!--                     <div class="text-center m-t-30"> -->
<!--                         <a href="https://wrappixel.com/templates/adminwrap/" -->
<!--                             class="btn waves-effect waves-light btn-info hidden-md-down"> Upgrade to Pro</a> -->
<!--                     </div> -->
                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
        </aside>
        <!-- ============================================================== -->
        <!-- End Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper">
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid" id="page-content">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <p>
                <div class="row page-titles" id="page-content-title">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">Users</h3>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="javascript:void(0)">Home</a></li>
                            <li class="breadcrumb-item active">List Of Users</li>
                        </ol>
                    </div>
                    <div class="col-md-7 align-self-center">
                        <a 
                            class="btn waves-effect waves-light btn btn-info pull-right hidden-sm-down" onclick="doGet('${pageContext.request.contextPath}/user/create', 'page-content-element');">CREATE A USER</a>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Sales Chart and browser state-->
                <!-- ============================================================== -->
                <div class="row" id="page-content-element">
                    <!-- Column -->
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table" id="myTable">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>SURNAME</th>
                                                <th>GIVEN NAME</th>
                                                <th>EMAIL</th>
                                                <th>ADDRESS</th>
                                                <th>DOB</th>
                                                <th>ACTION</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                          <c:set var = "i"  value = "1"/>
                                           <c:forEach var="user"  items="${users}">
                                            <tr>
                                                <td><c:out value = "${i}"/></td>
                                                <td>${user.userSurName}</td>
                                                <td>${user.userGivenName}</td>
                                                <td>${user.userEmail}</td>
                                                <td>${user.userAddress}</td>
                                                <td>${user.userDob}</td>
                                                
						                         <td>
						                          <select onchange="list_action(this.value,'${user.id}');"> 
<%--   onClick="doGet('${pageContext.request.contextPath}/user/detail?id=${user.id}')" --%>
												    
										              <option value="action">Action</option>
										              <option value="detail" 
										           onClick="doGet('${pageContext.request.contextPath}/user/detail?id=${user.id}','page-content-element')"
										                >Detail</option>
						                           
						                               <option value="update" 
						                            				                             
						                                   onClick="doGet('${pageContext.request.contextPath}/user/edit/?id=${user.id}','page-content-element')">Edit</option>
													
													   <option value="delete"
													
													      onClick="doDelete('${user.id}')">Delete</option>	
										           
										   
										           </select> 
                                               </td> 
                                            </tr>
                                             <c:set var = "i"  value = "${i+1}"/>
                                            </c:forEach>
                                            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                
                </div>
                <!-- ============================================================== -->
                <!-- End Sales Chart -->
                <!-- ============================================================== -->
               
                <!-- ============================================================== -->
                <!-- End Page Content -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
            <footer class="footer"> © 2021 PresClinic by <a href="https://www.presprint.cm/">Presprint PLC</a> </footer>
            <!-- ============================================================== -->
            <!-- End footer -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Page wrapper  -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    
    
    <!--  ========================= start overlay ================================== -->
   
		 
		 <!-- The overlay -->
		<div id="myNav" class="overlay">
		
			  <!-- Button to close the overlay navigation -->
			  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
			
			  <!-- Overlay content -->
			  <div class="overlay-content">
			  
			             <%--  <jsp:include page="user_detail.jsp" />  --%>
			            <%--     <%@include file="hospital_sys/users/user_detail.jsp" %>  --%>
			       
			  </div>
		
		</div>
		
     <!--  ========================= end overlay ================================== -->
    
    
    <!-- ============================================================== -->
    <!-- All Jquery -->
    <!-- ============================================================== -->
    <script src="${pageContext.request.contextPath}/assets/node_modules/jquery/jquery.min.js"></script>
    <!-- Bootstrap popper Core JavaScript -->
    <script src="${pageContext.request.contextPath}/assets/node_modules/bootstrap/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/node_modules/bootstrap/js/bootstrap.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="${pageContext.request.contextPath}/adminStyle/js/perfect-scrollbar.jquery.min.js"></script>
    <!--Wave Effects -->
    <script src="${pageContext.request.contextPath}/adminStyle/js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="${pageContext.request.contextPath}/adminStyle/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="${pageContext.request.contextPath}/adminStyle/js/custom.min.js"></script>
    <!-- ============================================================== -->
    <!-- This page plugins -->
    <!-- ============================================================== -->
    <!--morris JavaScript -->
    <script src="${pageContext.request.contextPath}/assets/node_modules/raphael/raphael-min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/node_modules/morrisjs/morris.min.js"></script>
    <!--c3 JavaScript -->
    <script src="${pageContext.request.contextPath}/assets/node_modules/d3/d3.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/node_modules/c3-master/c3.min.js"></script>
    <!-- Chart JS -->
    <script src="${pageContext.request.contextPath}/adminStyle/js/dashboard1.js"></script>
    <script src="${pageContext.request.contextPath}/js/hospital_sys/landingpage/util.js"></script>
    <script src="${pageContext.request.contextPath}/js/contacts/users/user.js"></script>
    
    <script src="${pageContext.request.contextPath}/js/hospital_sys/landingpage/action.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    
    <!-- SweetAlert JS -->
    <script src="${pageContext.request.contextPath}/assets/sweetalert2/js/sweetalert2.min.js"></script>
    
     <!-- Department JS -->
    <script src="${pageContext.request.contextPath}/js/department/department.js"></script>
     <!-- Patient JS -->
    <script src="${pageContext.request.contextPath}/js/patient/patient.js"></script>
      <!-- Patient JS -->
    <script src="${pageContext.request.contextPath}/js/employee/employee.js"></script>
    
</body>

</html>