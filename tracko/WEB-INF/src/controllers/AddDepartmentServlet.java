package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

import models.*;

public class AddDepartmentServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		String departmentName = request.getParameter("dept_name");
		Traco traco = (Traco)session.getAttribute("traco");
	


		Department department = new Department(departmentName,traco);
		if(department.addDepartment()){
			request.setAttribute("dept_succ","Department Added Successfully");
			Integer tracoId = traco.getTracoId();
			ArrayList<Department> departments = Department.collectDepartment(tracoId);
			session.setAttribute("departments",departments);
			Integer countDepartments = Department.countDepartments(tracoId);
			session.setAttribute("countdepartments",countDepartments);
		}

		request.getRequestDispatcher("home.jsp").forward(request,response);
	}

}