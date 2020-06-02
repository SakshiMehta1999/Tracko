package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LogoutServlet extends HttpServlet{
		public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			HttpSession session = request.getSession();
			session.invalidate();

			request.getRequestDispatcher("index.jsp").forward(request,response);
		}
}