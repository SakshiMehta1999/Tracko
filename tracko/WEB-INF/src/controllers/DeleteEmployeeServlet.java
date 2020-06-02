package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import models.*;

	public class DeleteEmployeeServlet extends HttpServlet{
		public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			String msg = "Invalid Entry";
			String officeId = request.getParameter("del_office_id");
			HttpSession session = request.getSession();
			Boss boss=(Boss)session.getAttribute("boss");
			Integer departmentId = boss.getDepartment().getDepartmentId();
			Employee employee = new Employee(officeId);
			if(employee.removeEmployee()){
				msg = "deleted successfully";
				ArrayList<Employee> fetchEmpl =Employee.fetchEmployees(departmentId);
				session.setAttribute("fetchEmpl",fetchEmpl);
			}
			response.setContentType("text/html");
			response.getWriter().write(msg);
			


		}
	}