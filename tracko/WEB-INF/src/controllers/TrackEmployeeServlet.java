package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import models.*;
import java.util.ArrayList;

public class TrackEmployeeServlet extends HttpServlet{
		public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			HttpSession session = request.getSession();
			Boss boss = (Boss)session.getAttribute("boss");

			Integer employeeId = Integer.parseInt(request.getParameter("employee_id"));
			ArrayList trackEmpl = boss.trackEmployee(employeeId);
			session.setAttribute("trackEmpl",trackEmpl);


			request.getRequestDispatcher("trackdetails.jsp").forward(request,response);
		}
}