package controllers;

import javax.servlet.http.*;
import javax.servlet.*;

import java.util.regex.*;
import java.util.*;
import java.io.*;
import models.*;
//import utils.*;

public class RegisterEmployeeServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		Boss boss = (Boss)session.getAttribute("boss");
		System.out.println(boss);

		String employeeName = request.getParameter("empl_name");
		String email = request.getParameter("email");
		Integer salary = Integer.parseInt(request.getParameter("salary"));
		Integer cubicleNo = Integer.parseInt(request.getParameter("cubicle_no"));
		Cubicle cubicle = new Cubicle(cubicleNo);
		System.out.println(boss.getBossName());
		Department department = boss.getDepartment();
		
		Integer count = Traco.count("employees");
		String employeeOfficeId = Integer.toString(++count);

		String password = "12345";

		Employee employee = new Employee(employeeName,password,email,salary,department,cubicle);
		if(employee.registerEmployee()){
			System.out.println("********");
		}

		request.getRequestDispatcher("home.jsp").forward(request,response);

	}

}