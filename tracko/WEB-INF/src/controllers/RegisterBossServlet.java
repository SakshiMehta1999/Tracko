package controllers;

import javax.servlet.http.*;
import javax.servlet.*;

import java.util.regex.*;
import java.util.*;
import java.io.*;
import models.*;
//import utils.*;

	public class RegisterBossServlet extends HttpServlet{
		public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			HttpSession session = request.getSession();
			Traco traco = (Traco)session.getAttribute("traco");
			String bossName = request.getParameter("boss_name");
			String email = request.getParameter("email");

			Department department = new Department();
			department.setDepartmentId(Integer.parseInt(request.getParameter("dept_id")));
			Integer salary = Integer.parseInt(request.getParameter("salary"));
			Integer cnt =Traco.count("bosses");

			String bossOfficeId = Integer.toString(++cnt);

			////validation/////////
			boolean flag = true;
			String msg = "";
			int bNLen = bossName.trim().length();
			if(bNLen<2||bNLen>50){
				flag=false;
				msg = msg+"<div>Invalid username</div>";
			}
			String em = email.trim();
			Pattern p1 = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
			Matcher m1 = p1.matcher(em);
			if(!m1.matches()){
				flag = false;
				msg = msg+"<div>Must be the valid email</div>";
			}



			if(flag){
				//if(EmailSender.sendEmail(email)){
					Boss boss = new Boss(bossOfficeId,bossName,department,email,traco,salary);
					if(boss.registerBoss()){
						request.setAttribute("msg_succ","Registered Succesfully");
						System.out.println("srrr");
						Integer tracoId = traco.getTracoId();
						Integer countBosses = Boss.countBosses(tracoId);
						session.setAttribute("countbosses",countBosses);

					}
					else{
						request.setAttribute("msg_err",msg);
					}
				
			}
			request.getRequestDispatcher("home.jsp").forward(request,response);
		}
	}