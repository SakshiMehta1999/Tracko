package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import models.*;

	public class DeleteBossServlet extends HttpServlet{
		public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			String msg = "Invalid Entry";
			String officeId = request.getParameter("del_office_id");
			System.out.println(officeId);
			HttpSession session = request.getSession();
			Traco traco=(Traco)session.getAttribute("traco");
			Integer tracoId = traco.getTracoId();
			Boss boss = new Boss(officeId);
			if(boss.removeBoss()){
				msg = "deleted successfully";
				ArrayList<Boss> bosses =Boss.fetchBosses(tracoId);
				session.setAttribute("bosses",bosses);
			}
			response.setContentType("text/html");
			response.getWriter().write(msg);
			


		}
	}