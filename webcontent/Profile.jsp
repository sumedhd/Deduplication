<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.connection.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page import="com.controller.*" %>
<html lang="en">
  <head>
  <title>Data Deduplication</title>
    <!-- Required meta tags always come first -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet">
    <link rel="stylesheet" href="css/ionicons.min.css">
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="css/owl.theme.css">
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
  
    <header id="home" class="gradient-violat">
      <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><span style="background-color:powderblue;" class="logo-wraper logo-white">
                <img src="images/Logo.png" alt="">Data Deduplication
              </span></a>
          </div>

          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul style="background-color:powderblue;" class="nav navbar-nav  navbar-right">
              <li class="active"><a href="UserView.jsp">Back <span class="sr-only">(current)</span></a></li>
              
               
            </ul>
          </div><!-- /.navbar-collapse -->
          <hr class="navbar-divider">
        </div><!-- /.container-fluid -->
      </nav>
    </header>
    <br>
    <% 
    
    HttpSession sessio=request.getSession(); 
    String email=(String)session.getAttribute("email");  
					
                   Connection con=DBConnection.getConnection();
					Statement st=con.createStatement();
					
					
					 ResultSet resultset=st.executeQuery("select * from tbl_dataholder where email = '" + email + "'");
					
					 while(resultset.next())
				     {
				     %>
    <section id="testimonial" class="testimonial-section padding-top-bottom-90 gradient-violat">
      <div class="container">
        <div class="heading-wraper text-center">
          <h4 class="text-white">My Profile</h4>
          <hr class="heading-devider gradient-orange">
        </div>
        <div class="row">
          <div class="col-md-8 col-md-offset-2">
            <div id="testimonial-carousel" class="owl-carousel">
              <div>
                <div class="testimonial-container">
                  <div class="client-details text-center">
                    <img src="images/download.png" alt="">
                    <h5 class="client-name"><%= resultset.getString(2)%></h5>
                    <br><br>
                     <div class="testimonial-content">
                
                    <p class="testimonial-speech">Email: <%= resultset.getString(3)%></p>
                    <p class="testimonial-speech">Mobile No: <%= resultset.getString(5)%></p>
                    <p class="testimonial-speech">Address: <%= resultset.getString(6)%></p>
                    <p class="testimonial-speech">Gender: <%= resultset.getString(7)%></p>
                     <p class="testimonial-speech">Date of Birth: <%= resultset.getString(8)%></p>
                  </div>
                   
                </div></div></div></div></div></div>
			
				   <%
				   } 
				   %>  
	     
    </section>
   
   			  
    <div id="scroll-top-div" class="scroll-top-div">
      <div class="scroll-top-icon-container">
        <i class="ion-ios-arrow-thin-up"></i>
      </div>
    </div>
    <!-- jQuery first, then Tether, then Bootstrap JS. -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/script.js"></script>
  </body>
</html>
