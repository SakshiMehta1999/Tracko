<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
	<title>Login</title>

	<link rel="stylesheet" href="css/common.css"/>
	<link rel="stylesheet" href="css/Assigntask.css"/>
	 <link rel="stylesheet" href="css/index.css"/>
	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	 <script type= "text/javascript" src = "js/login.js"></script>
	 <meta name="viewport" content="width=device-width, initial-scale=1" />
	
	
	

  </head>
  <body >
  <!--//////////////////////////////header///////////////////////-->
   <div id ="header" >
     <a href="#" id="webnm">TRAC-O</a>
     &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<i class="fa fa-home" ></i><a href="#" class="nav1">Home</a>
     &nbsp<i class="fa fa-info" ></i><a href="#"  class="nav1" >info</a>
     &nbsp<i class="fa fa-group" ></i><a href="#"  class="nav1" >About-us</a>
     &nbsp<i class="fa fa-gears" ></i><a href="#"  class="nav1" >sevices</a>
     &nbsp<i class="fa fa-address-card-o" ></i><a href="#"  class="nav1" >company credentials</a>

	 <a href="#" class="icons"><i class="fa fa-twitter" ></i></a>
	 <a href="#" class="icons"><i class="fa fa-facebook" ></i></a>
	 <a href="#" class="icons"><i class="fa fa-instagram" ></i></a>
   </div>

     <div class="register">
	    
		<h3><i class="fa fa-user"></i>&nbsp Employee Name : &nbsp&nbsp&nbsp&nbsp&nbsp<span >${trackEmpl[0]}</span></h3>
									
		<h3><i class="fa fa-id-card" ></i>&nbsp Office id : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span >${trackEmpl[1]}</span></h3>

		<h3><i class="fa fa-envelope" ></i>&nbsp Email : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span >${trackEmpl[2]}</span></h3>

		<h3><i class="fa fa-users" ></i>&nbsp Cubical no. :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <span >${trackEmpl[3]}</span></h3>	

		<h3><i class="fa fa-building" ></i>&nbsp Floor no. : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span >${trackEmpl[4]}</span></h3>
		
		<h3><i class="fa fa-building" ></i>&nbsp Room no. : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span >${trackEmpl[5]}</span></h3>	

		<h3><i class="fa fa-money" ></i>&nbsp Salary : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span >${trackEmpl[6]}</span></h3>	
		
		  
 
     </div>
   

  </body>
</html>