package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;

import models.*;

	public class DeleteAccessServlet extends HttpServlet{
		public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			HttpSession session = request.getSession();
			String radio = (String)session.getAttribute("radio");
			if(radio.equals("0")){
				Traco traco=(Traco)session.getAttribute("traco");
				Integer tracoId = traco.getTracoId();
				ArrayList<Boss> bosses =Boss.fetchBosses(tracoId);
				session.setAttribute("bosses",bosses);
			}
			else if(radio.equals(1)){
				Boss boss = (Boss)session.getAttribute("boss");
				ArrayList<Employee> fetchEmpl = Employee.fetchEmployees(boss.getDepartment().getDepartmentId());
				session.setAttribute("fetchEmpl",fetchEmpl);
			}

			request.getRequestDispatcher("delete_access.jsp").forward(request,response);
		}
	}
			

