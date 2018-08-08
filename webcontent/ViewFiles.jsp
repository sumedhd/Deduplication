<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.connection.DBConnection"%>
<%@page import="java.sql.Connection"%>
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
              <li class="active"><a href="Home.jsp"><b>Home </b><span class="sr-only">(current)</span></a></li>
                <li><a href="Profile.jsp"><b>My Profile</b></a></li>
                 <li><a href="UploadFile.jsp"><b>Upload File</b></a></li>
                 <li><a href="ViewAllFiles.jsp"><b>View Files</b></a></li>
                 <li><a href="SearchFile.jsp"><b>Search File</b></a></li>
              <li><a href="LogoutController"><b>Logout</b></a></li>
            </ul>
          </div><!-- /.navbar-collapse -->
          <hr class="navbar-divider">
        </div><!-- /.container-fluid -->
      </nav>
    </header>
    
    <section id="newsletter" class="padding-top-bottom-120 newsletter">
    
      <div class="container">
        <div class="row">
          <div class="">
            <div class="row">
              <div class="col-md-8 col-md-offset-2 padding-top-bottom-90">
                <div class="subscription-wraper text-center">
                 <h4 class="text-upper col-md-offset-2">File Details Table</h4><br>
                   <form class="subscription-form">
                    <div style="margin-left:20px;margin-right:20px">
                    <table class="table table-bordered " style="color:black">
                    <tr class="danger" style="color:black">
                    
                    <th>File ID</th>
                     <th>File Name</th>
                     <th>File Content</th>
                     <th>Action</th>
                     </tr>
                     <%
                     
                     Connection con=DBConnection.getConnection();
                     Statement st=con.createStatement();
                     String filename=request.getParameter("filename");
                     String filekey=request.getParameter("filekey");
                     ResultSet rs=st.executeQuery("select * from files where filename='"+filename+"' and filekey='"+filekey+"'");
                    
                     
                     while(rs.next())
                     {
                    	 
             	       %>
                    	 <TR>
                    	 <td><%=rs.getString(1) %></td>
                    	 <td><%=rs.getString(2) %></td>
                    	 <td><%=rs.getString(3) %></td>
                    	 
                    	 <td><a href="DownloadFileController?filename=<%=rs.getString(2)%>&file=<%=rs.getString(3)%>">Download</a></td>
                    	 
                    	 </TR>	
                    	
                    	
                    <%} %>
                   
                 
                
                  
                    </table>
              	
                    </div>
                     <BR><br><br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br>        
                  </form>
                 
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
   
   
   
   
          <hr class="footer-divider">
          <div class="copyright-cta">
            <p class="text-uppercase">All rights Reserved </p>
          </div>
        </div>
      </div>
      <div class="footer-end-line"></div>
    </footer>
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
