<!DOCTYPE html>
<html lang="en">
<head>

     <title>PresClinic</title>
<link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/assets/images/users/logonew.png">
     <meta charset="UTF-8">
     <meta http-equiv="X-UA-Compatible" content="IE=Edge">
     <meta name="description" content="">
     <meta name="keywords" content="">
     <meta name="author" content="">
     <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">


	<link href="${pageContext.request.contextPath}/css/hospital_sys/landingpage/bootstrap.min.css" rel="stylesheet">
 	<link href="${pageContext.request.contextPath}/css/hospital_sys/landingpage/magnific-popup.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/hospital_sys/landingpage/font-awesome.min.css" rel="stylesheet">
    
     <!-- MAIN CSS -->
     <link href="${pageContext.request.contextPath}/css/hospital_sys/landingpage/templatemo-style.css" rel="stylesheet">
</head>
<body id="all-page-content">

<!--      PRE LOADER  -->
 	<section class="preloader"> 
		<div class="spinner">
		 <span class="spinner-rotate"></span>
          </div> 
	 </section> 


     <!-- MENU -->
     <section class="navbar custom-navbar navbar-fixed-top" role="navigation">
          <div class="container">


                    <!-- lOGO TEXT HERE -->
                   <span> <a href="index.html" class="navbar-brand">PRESCLINIC</a> </span>
               </div>


          </div>
     </section>


     <!-- BLOG HEADER -->
<!--      <section id="blog-header" data-stellar-background-ratio="0.5" > -->
<!--           <div class="overlay"></div> -->
<!--           <div class="container"> -->
<!--                <div class="row"> -->

<!--                     <div class="col-md-offset-1 col-md-5 col-sm-12"> -->

                    		
<!--                     </div> -->
                    
<!--                </div> -->
<!--           </div> -->
<!--      </section> -->
     
     





     <!-- FOOTER -->
     <footer data-stellar-background-ratio="0.5" style="background: url('${pageContext.request.contextPath}/images/loginpage.jpg') no-repeat center center;background-size: 100% 100%;">
          <div class="container">
               <div class="row">

                  <div class="modal-dialog modal-lg ">
               <div class="modal-content modal-popup">

                    <div class="modal-header">
                         <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                              <span aria-hidden="true"></span>
                         </button>
                    </div>

                    <div class="modal-body">
                         <div class="container-fluid">
                              <div class="row">

                                   <div class="col-md-12 col-sm-12">
                                        <div class="modal-title">
                                             <h2> <img width="150" height="120" src="${pageContext.request.contextPath}/assets/images/users/logonew.png" alt="homepage" class="dark-logo" />
</h2>
                                        </div>

                                        <!-- NAV TABS -->
                                        <ul class="nav nav-tabs" role="tablist">
                                            <li class="active"><a href="#sign_in" aria-controls="sign_in" role="tab" data-toggle="tab">Sign In</a></li>
                                        </ul>

                                        <!-- TAB PANES -->
                                        <div class="tab-content">
                                          

                                             <div role="tabpanel" class="tab-pane fade in active" id="sign_in">
                                                  <form>
                                                       <input type="text" class="form-control" id="userName" name="userName" placeholder="USERNAME" required="">
                                                       <input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="PASSWORD" required="">
                                                       <input type="button" style="color: white;background: #ce3232;border-color: transparent;border-radius: 100px" class="form-control" onclick="callAuthentication();" name="submit" value="Login">
                                                       


                                                  </form>
                                             </div>
                                        </div>
                                   </div>

                              </div>
                         </div>
                    </div>

               </div>
          </div>
          <!--end-->

                    <div class="col-md-12 col-sm-12">
                         <div class="footer-bottom">
                              <div class="col-md-6 col-sm-5">
                                   <div class="copyright-text" style="color:black;"> 
                                        <p>Copyright &copy; 2021 Presprint</p>
                                   </div>
                              </div>
                              <div class="col-md-6 col-sm-7">
                                   <div class="phone-contact" style="color:black;"> 
                                        <p>Call us <span>(+237) 680050551</span></p>
                                   </div>
<!--                                    <ul class="social-icon"> -->
<!--                                         <li><a href="#" class="fa fa-facebook-square" attr="facebook icon"></a></li> -->
<!--                                         <li><a href="#" class="fa fa-twitter"></a></li> -->
<!--                                         <li><a href="#" class="fa fa-instagram"></a></li> -->
<!--                                    </ul> -->
                              </div>
                         </div>
                    </div>
                    
               </div>
          </div>
     </footer>
     	
    

     <script src="${pageContext.request.contextPath}/js/hospital_sys/landingpage/login.js"></script>
     <script src="${pageContext.request.contextPath}/js/hospital_sys/landingpage/jquery.js"></script>
     <script src="${pageContext.request.contextPath}/js/hospital_sys/landingpage/bootstrap.min.js"></script>
     <script src="${pageContext.request.contextPath}/js/hospital_sys/landingpage/jquery.stellar.min.js"></script>
     <script src="${pageContext.request.contextPath}/js/hospital_sys/landingpage/jquery.magnific-popup.min.js"></script>
     <script src="${pageContext.request.contextPath}/js/hospital_sys/landingpage/smoothscroll.js"></script>
     <script src="${pageContext.request.contextPath}/js/hospital_sys/landingpage/custom.js"></script>
     <script src="${pageContext.request.contextPath}/js/hospital_sys/landingpage/util.js"></script>
      <script src="${pageContext.request.contextPath}/js/contacts/users/user.js"></script>
     
</body>
</html>