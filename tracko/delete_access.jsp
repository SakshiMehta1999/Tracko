<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  
			<script src="js/delete_access.js"> </script>
			<link rel="stylesheet" href="css/common.css"/>

      <title>Index :: Page</title>

    </head>
    <body   background="images/TABLE.jpeg">
	<div id ="header" >
     <a href="#" id="webnm">TRAC-O</a>
     &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<i class="fa fa-home" ></i><a href="#" class="nav1">Home</a>
     &nbsp<i class="fa fa-info" ></i><a href="Logout.do"  class="nav1" >logout</a>
	    
   </div>

        <% String radio = (String)session.getAttribute("radio");
			if(radio.equals("0")) { %>
        <h1>List of all the bosses </h1>
        <%@page import="java.util.ArrayList"%>
        <%
          ArrayList bosses = (ArrayList)application.getAttribute("bosses") ;
		  ArrayList employees = (ArrayList)application.getAttribute("employees");
		  
        %>
        <table  id="table" border="1px solid black" width="50%">
          <tr>
            <th>Office_ID</th>
            <th>Name</th>
            <th>Navigation</th>
          </tr>

          <c:forEach var = "boss" items="${bosses}"  varStatus="val">
            <tr >
              <td>${boss.bossOfficeId}</td>
              <td>${boss.bossName}</td>
              <td><button  class="delete" id = "${boss.bossOfficeId}" onClick="del(this)">Delete</button></td>
            </tr>
          </c:forEach>
        </table>

		 <% } else if(radio.equals("1")){ %>
             
			 <h1>List of all the bosses </h1>
        <%@page import="java.util.ArrayList"%>
        <%
          ArrayList bosses = (ArrayList)application.getAttribute("bosses") ;
		  ArrayList employees = (ArrayList)application.getAttribute("employees");
		  
        %>
        <table  id="table" border="1px solid black" width="50%">
          <tr>
            <th>Office_ID</th>
            <th>Name</th>
            <th>Navigation</th>
          </tr>

          <c:forEach var = "Empl" items="${fetchEmpl}"  varStatus="val">
            <tr >
              <td>${Empl.employeeOfficeId}</td>
              <td>${Empl.employeeName}</td>
              <td><button  class="delete" id = "${Empl.employeeOfficeId}" onClick="del2(this)">Delete</button></td>
            </tr>
          </c:forEach>
        </table>

		<% } %>
    </body>

    <h1></h1>
</html>
