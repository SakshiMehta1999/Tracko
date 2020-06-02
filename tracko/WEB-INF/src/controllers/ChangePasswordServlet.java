package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import models.*;

public class ChangePasswordServlet extends HttpServlet{
		public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			HttpSession session = request.getSession();
			Boss boss = (Boss)session.getAttribute("boss");
			Employee employee = (Employee)session.getAttribute("employee");
			String radio = (String)session.getAttribute("radio");
			String email = " ";
			String table = " ";
			String nextPage = " ";

			String newPassword = request.getParameter("new_password");
			String rePassword = request.getParameter("re_password");
			if(newPassword.equals(rePassword)){
				if(radio.equals("1")){
					email = boss.getEmail();
					table = " bosses ";
					if(Traco.changePassword(newPassword,email,table)){
						nextPage = "home.jsp";
						boss.setPassword(newPassword);
						session.setAttribute("boss",boss);
					}
				
				}
				if(radio.equals("2")){
					email = employee.getEmail();
					table = " employees ";
					if(Traco.changePassword(newPassword,email,table)){
						nextPage = "home.jsp";
						employee.setPassword(newPassword);
						session.setAttribute("employee",employee);
					}
				}
			}
			else{
					nextPage = "index.jsp";
					session.invalidate();
			}
			request.getRequestDispatcher(nextPage).forward(request,response);
		}
}