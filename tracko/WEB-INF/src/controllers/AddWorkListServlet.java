package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import models.*;
import java.util.*;

public class AddWorkListServlet extends HttpServlet{
		public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			HttpSession session = request.getSession();
			Boss boss = (Boss)session.getAttribute("boss"); 
			String work = request.getParameter("work_category");
			WorkList workList = new WorkList(work,boss.getDepartment());
			if(workList.addWorkList()){
				ArrayList<WorkList> workList2 = WorkList.fetchWorkList(boss.getDepartment().getDepartmentId());
				session.setAttribute("workLists",workList2);
			}

			request.getRequestDispatcher("home.jsp").forward(request,response);
		}
}