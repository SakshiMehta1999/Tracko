package controllers;

import javax.servlet.http.*;
import javax.servlet.*;

import java.util.*;
import java.io.*;
import java.util.regex.*;


import models.*;

	public class RegisterServlet extends HttpServlet
	{
		public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
		{
			HttpSession session = request.getSession();
			
			
				
			String userName = request.getParameter("user_name");
			String companyName = request.getParameter("company_name");
			String email = request.getParameter("email");
			String userPassword = request.getParameter("user_password");
			String rePassword = request.getParameter("re_password");
			
			//validation/////////
			boolean flag=true;

			String msg="";
/*			int uNLen = userName.trim().length();
			if(uNLen<2||uNLen>50){
				flag=false;
				msg = msg+"<div>Invalid username</div>";
			}
			int CNLen = companyName.trim().length();
			if(CNLen<1||CNLen>50){
				flag=false;
				msg = msg+"<div>Invalid company name</div>";
			}

			String em = email.trim();
			Pattern p1 = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
			Matcher m1 = p1.matcher(em);
			if(!m1.matches()){
				flag = false;
				msg = msg+"<div>Must be the valid email</div>";
			}
			String ps = userPassword.trim();
			Pattern p2 = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,10}");
			Matcher m2 = p2.matcher(ps);
			if(!m1.matches()){
				flag = false;
				msg = msg+"<div>Must be the valid Password</div>";
			}*/
			if(!userPassword.equals(rePassword)){
				flag = false;
				msg = msg+"<div>Password must match</div>";
			}
			
			if(flag){
				//calling of createOfficeId///
				Integer cnt = 1+Traco.count("traco");
				String officeId=Integer.toString(cnt);
				//////////////////////////////
				Traco traco = new Traco(userName,companyName,email,officeId,userPassword);
				if(traco.registerCompany()){
					request.setAttribute("msg_suc","Registered Succesfully");
					ServletContext sc = session.getServletContext();

					/////////////////companies collection////////////
					ArrayList companies = Traco.collectCompanies();
					sc.setAttribute("companies",companies);
				}
			}
			else{
				request.setAttribute("msg_err",msg);
			}

               
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request,response);
		}
			
	}