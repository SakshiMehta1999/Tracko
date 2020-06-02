<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
	<title>Login</title>

	<link rel="stylesheet" href="css/common.css"/>
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

   <!--//////////////////////////////info///////////////////////-->
   <div id= "info">
	<p>In today’s world, man struggles to make his life easier. The needfor tracking has assumed high importance because of varied and diverseresources, then be it a product of a company being shipped from thecompany to consumer, be it the assets, and be it in the supply chainmanagement or for that matter even the man-power. In large organizational buildings, where the man-power is high, people are not always in their cabins.
	</p>
	<p>They have to wander from room to room, floor to floor to performtheir work. In such cases, it becomes extremely difficult to keep a track of people and find them when they are needed.
	</p>
	<p>Solution for the above problem is as further a tracking system whichcan track an individual when they enter a room would suffice the need. This process should take place in a hassle free manner and therefore a wirelesssystem would be advantageous. 
	</p>
   </div>
 
  
	   <button id= "btn"  onclick="openNav()">LOGIN</button>
	   <button id= "btn1"  onclick="openNav1()">REGISTER</button>
  

  <!--//////////////////////////////side navigation-login///////////////////////-->
		<div id="mySidenav" class="sidenav">
	        <i class="closebtn" onclick="closeNav()">&times;</i>
			<i id="usericon" class="fa fa-user" ></i>	
			<form action="Login.do" >
				<i class="faa fa fa-user"></i><input class="form" type="text" placeholder="Email" name = "email"><br>
				<i class="faa fa fa-key" ></i><input class="form" type="password" placeholder="password" name = "user_password"><br>
				<br>
				<label class="container">CEO
				  <input type="radio" checked="checked" name="radio" value="0">
				  <span class="checkmark"></span>
				</label>
				<label class="container">BOSS
				  <input type="radio" name="radio" value="1">
				  <span class="checkmark"></span>
				</label>
				<label class="container">EMPLOYEE
				  <input type="radio" name="radio" value="2">
				  <span class="checkmark"></span>
				</label><br><br>

				
				<input class="subbtn" type="submit" value="login">
			</form>
			
	   </div>
  
<!--//////////////////////////////side naviation-register///////////////////////-->

       <div id="mySidenav1" class="sidenav">
	        <i class="closebtn" onclick="closeNav1()">&times;</i>
					
			<form action="Register.do" >
				<i class="faa fa fa-building"></i><input required="required" id= "comnm" class="form" type="text" placeholder="Company Name" name="company_name"><br><p class ="error1"></p>

				<i class="faa fa fa-user"></i>&nbsp<input required="required" id="ceonm" class="form" type="text" placeholder="CEO Name" name="user_name"><br><p class ="error2"></p>

				<i class="faa fa fa-envelope"></i><input required="required" id="email" class="form" type="text" placeholder="Email" name="email"><br><p class="error3"></p>

				<i class="faa fa fa-key" ></i><input required="required" id="passval" class="form" type="password" placeholder="password" name="user_password"><br><p class ="error4"></p>

				<i class="faa fa fa-key" ></i><input required="required" id="repass" class="form" type="password" placeholder="Re-password"name= "re_password"><br><p class="error5"></p>

				<input id="reg" class="subbtn" type="submit" value="Register">
			</form>
	   </div>
   

  </body>
</html>