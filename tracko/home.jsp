<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="models.*"%>

<!doctype html>
<html lang="en">
 <head>
  
  <title>home</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script type= "text/javascript" src = "js/home.js"></script>
  <link rel="stylesheet" href="css/home.css"/>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  
 </head>
<!-- for background image //////////////////////-->
<% String radio = (String)session.getAttribute("radio");
   Boss boss = (Boss)session.getAttribute("boss");
   Employee employee = (Employee)session.getAttribute("employee");
   
	   if (radio.equals("0")) { %>
              <body  background="images/ceo.jpg">
	    <% } else if(radio.equals("1")) { %>
              <body  background="images/BOSS.jpg">
		<% } else if(radio.equals("2")){ %>
              <body  background="images/BOSS.jpg">
		<% } %> 
 <!--//////////////////////////////////////////////////////////-->
 <nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">TRAC-O</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="#">Home</a></li>
      <li id ="log"><a href="Logout.do">logout</a></li>
    </ul>
  </div>
</nav>


 <!-- CEO/////////////////////////////////////////-->
    <% if (radio.equals("0")) { %>
    

   <div id="cmpnm">${traco.companyName}</div>

    <div id="mySidenav" class="sidenav">

		<a id="ab">ADD BOSS</a>
		   <div id="abreg">
			&nbsp&nbsp&nbsp&nbsp<strong>Add employee..</strong><span id ="X">&times</span>
			 <form action="RegisterBoss.do"><br>
			  &nbsp<i class="faa fa fa-user"></i> <input type="text" class="area" placeholder="boss name" name = "boss_name"><br>
			  &nbsp<i class="faa fa fa-envelope"></i><input type="text" class="area" placeholder="email" name = "email"><br>
			  &nbsp<i class="faa fa fa-building"></i> <select class="area" name = "dept_id">
				<option value = "0">--select--</option>
				<c:forEach var = "department" items="${sessionScope.departments}" >
				<option value = '${department.departmentId}'>${department.departmentName}</option>
				</c:forEach>
              </select><br>
			  &nbsp<i class="faa fa fa-money"></i><input type="text" class="area" placeholder="salary" name="salary"><br>
			  <input type="submit" value="Add" id="sub"><br><br>
             </form>
           </div>
	    <a  href="DeleteAccess.do" id="aj">DELETE BOSS</a>
		<a  id="in">ADD DEPARTMENT</a>
	        <div id="abreg1">
			&nbsp&nbsp&nbsp&nbsp<strong>Add department..</strong><span id ="X1">&times</span>
			 <form action="AddDepartment.do"><br>
			  &nbsp<i class="faa fa fa-building"></i> <input type="text" class="area" placeholder="department name" name = "dept_name"><br>
			  <input type="submit" value="Add" id="sub"><br><br>
             </form>
           </div>
		<a  id="db">ADD ROOMS</a>
		   <div id="abreg2">
			&nbsp&nbsp&nbsp&nbsp<strong>Add room...</strong><span id ="X2">&times</span>
			 <form action="AddRooms.do"><br>
			  &nbsp<i class="faa fa fa-close-door"></i> <input type="text" class="area" placeholder="Room no." name = "room"><br>
			  &nbsp<i class="faa fa fa-"></i> <select class="area" name = "dept_id" >
				<option value = "0">select--Department</option>
				<c:forEach var = "department" items="${sessionScope.departments}" >
				<option value = '${department.departmentId}'>${department.departmentName}</option>
				</c:forEach>
              </select><br>
			  &nbsp<i class="faa fa fa-steps"></i> <input type="text" class="area" placeholder="floor" name = "floor"><br>
			  <input type="submit" value="Add" id="sub"><br><br>
             </form>
           </div>
    </div> 

	<div id ="right_side_bar">
		<h3>No. of Departments : ${countdepartments}</h3>
		<h3>No. of Rooms : ${countrooms}</h3>
		<h3>No. of Boss :${countbosses}</h3>
	</div>
	 
    <!--//////////////////////////////////boss//////////////////////-->

     <% } else if(radio.equals("1")) { %>

    <!-- change password for boss/////////////////-->

     <%	if(boss.getPassword().equals("12345")){ %>
		<div class="register">
		  <h4>&nbsp&nbsp&nbsp&nbsp;Change your password...</h4>
		  <form action="ChangePassword.do">
			 <i class="fa fa-key" ></i><input type="password" class="reg" placeholder="new  password" name="new_password"><br>
			 <i class="fa fa-key" ></i><input type="password" class="reg" placeholder="confirm   password"name="re_password"><br>
			 <input type="submit" value="submit" id="subbt">
 
          </form>
        </div>

    <% }else { %>
	<div id="cmpnm">${boss.traco.companyName}</div>

	<div id="mySidenav" class="sidenav">

		<a id="ab">ADD EMPLOYEE</a>
		   <div id="abreg">
			&nbsp&nbsp&nbsp&nbsp<strong>Add employee..</strong><span id ="X">&times</span>
			 <form action="RegisterEmployee.do"><br>
			  &nbsp<i class="faa fa fa-user"></i> <input type="text" class="area" placeholder="employee name" name = "empl_name" ><br>
			  &nbsp<i class="faa fa fa-envelope"></i><input type="text" class="area" placeholder="email" name = "email"><br>
			  &nbsp<i class="faa fa fa-money"></i><input type="text" class="area" placeholder="salary" name = "salary"><br>
			  &nbsp<i class="faa fa fa-users"></i><input type="text" class="area" placeholder="cubicle no." name = "cubicle_no" ><br>
			  <input type="submit" value="Add" id="sub"><br><br>
             </form>
           </div>
	    <a  href="DeleteAccessEmployee.do" id="aj">DELETE EMPLOYEE</a>

		<a  id="db">ASSIGN TASK</a>
		   <div id="abreg2">
			&nbsp&nbsp&nbsp&nbsp<strong>assign task...</strong><span id ="X2">&times</span>
			 <form action="AssignTask.do"><br>
			  &nbsp&nbsp<i class="faa fa fa-user">&nbsp</i><select class="area" name = "employee_id" >
				<option value = "0">--employee name--</option>
				<c:forEach var = "employee" items="${sessionScope.fetchEmpl}" >
				<option value = '${employee.employeeId}'>${employee.employeeName}</option>
				</c:forEach>
              </select><br>
			  &nbsp<i class="faa fa fa-tags"></i> <select class="area" name = "work_list_id" >
				<option value = "0">--category--</option>
				<c:forEach var = "worklist" items="${sessionScope.workLists}" >
				<option value = '${worklist.workListId}'>${worklist.work}</option>
				</c:forEach>
              </select><br>
			  &nbsp<i class="faa fa fa-newspaper-o"></i> <input type="text" class="area" placeholder="description" name = "description"><br>
			  <input type="submit" value="Assign" id="sub"><br><br>
             </form>
           </div>

        <a  id="in">ADD WORKLIST</a>
		   <div id="abreg1">
			&nbsp&nbsp&nbsp&nbsp<strong>Worklist ...</strong><span id ="X1">&times</span>
			 <form action="WorkList.do"><br>
			  &nbsp&nbsp<i class="faa fa fa-user">&nbsp</i> <input type="text" class="area" placeholder="work category" name="work_category"><br>
			  <input type="submit" value="Add" id="sub"><br><br>
             </form>
           </div>
    </div> 

	<a href = "#" id= "btn" >TRACK</a>
		   <div id="abreg3">
			&nbsp&nbsp&nbsp&nbsp<strong>Worklist ...</strong><span id ="X3">&times</span>
			 <form action="TrackEmployee.do"><br>
			  &nbsp&nbsp<i class="faa fa fa-user"></i>&nbsp<select class="area" name = "employee_id" >
				<option value = "0">--employee--</option>
				<c:forEach var = "employee" items="${sessionScope.fetchEmpl}" >
				<option value = '${employee.employeeId}'>${employee.employeeName}</option>
				</c:forEach>
              </select><br>
			  <input type="submit" value="Track" id="sub"><br><br>
             </form>
           </div>

	<div id ="right_side_bar">
	    <h2 style = "color:blue">STRUCTURE</h2>
		<h3>No. of Departments : ${countdepartments}</h3>
		<h3>No. of Rooms :${countrooms} </h3>
		<h3>No. of Cubicles :</h3>
	</div>
    
	<% } %>


<% } else if(radio.equals("2")){ %> 

<!-- change password for employee///////////////////-->
   <% if(employee.getPassword().equals("12345")) { %>

		<div class="register">
		  <h4>&nbsp&nbsp&nbsp&nbsp;Change your password...</h4>
		  <form action="ChangePassword.do">
			 <i class="fa fa-key" ></i><input type="password" class="reg" placeholder="new  password" name= "new_password"><br>
			 <i class="fa fa-key" ></i><input type="password" class="reg" placeholder="confirm   password" name = "re_password"><br>
			 <input type="submit" value="submit" id="subbt">
 
          </form>
        </div>



		<%} else { %>

    <table id ="table" border="1px solid black" width="60%">
          <tr>
            <th>S.no</th>
            <th>Subject</th>
            <th>Alloted time</th>
            <th>Description</th>
            <th>Eligible</th>
          </tr>

			<c:forEach var = "records" items="${sessionScope.record}" varStatus="loop">
            <tr>
              <td>${loop.index}</td>
              <td>${records.workList.work}</td>
              <td>${records.allotingTime}</td>
			  <td><button id="button">show</button></td>
			   <td>${sessionScope.eligible[loop.index]}</td>
			  
			  </tr>
			  </c:forEach>
	
            
         
        </table>
		<c:forEach var = "records" items="${sessionScope.record}" >

		 <div id="abreg">
			<p>${records.description}</p>
         </div>
		</c:forEach>
       <% } %>
<% } %>
   
 </body>
</html>




