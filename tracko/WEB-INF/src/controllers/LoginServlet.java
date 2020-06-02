package controllers;

import javax.servlet.http.*;
import javax.servlet.*;

import java.util.*;
import java.util.Date;
import java.sql.Timestamp;
import java.io.*;

import models.*;

	public class LoginServlet extends HttpServlet
	{
		public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
		{
			HttpSession session = request.getSession();
			String nextPage = "index.jsp";
			Long deadLine = null;

			String email = request.getParameter("email");
			String userPassword = request.getParameter("user_password");
			String radio = request.getParameter("radio");
			String companyName = request.getParameter("company");
			if(radio.equals("0")){
				Traco traco = new Traco(email,userPassword);
		
				if(traco.loginCEO()){
					System.out.println("555555");
					session.setAttribute("traco",traco);
					Integer tracoId = traco.getTracoId();
					Integer countRooms = Room.countRooms(tracoId);
					session.setAttribute("countrooms",countRooms);
					Integer countDepartments = Department.countDepartments(tracoId);
					session.setAttribute("countdepartments",countDepartments);
					Integer countBosses = Boss.countBosses(tracoId);
					session.setAttribute("countbosses",countBosses);
					ArrayList<Department> departments = Department.collectDepartment(tracoId);
					session.setAttribute("departments",departments);
					session.setAttribute("radio",radio);
					
					nextPage ="home.jsp"; 
				}
			}
				else if(radio.equals("1")){
				Boss boss = new Boss(email,userPassword,companyName);
				if(boss.loginBoss()){
					session.setAttribute("boss",boss);
					System.out.println(boss.getDepartment());

					session.setAttribute("radio",radio);
					ArrayList<Employee> fetchEmpl = Employee.fetchEmployees(boss.getDepartment().getDepartmentId());
					session.setAttribute("fetchEmpl",fetchEmpl);
					ArrayList<WorkList> workList = WorkList.fetchWorkList(boss.getDepartment().getDepartmentId());
					session.setAttribute("workLists",workList);
					Integer countRooms = Room.countRooms(boss.getTraco().getTracoId());
					session.setAttribute("countrooms",countRooms);
					Integer countDepartments = Department.countDepartments(boss.getTraco().getTracoId());
					session.setAttribute("countdepartments",countDepartments);
					nextPage = "home.jsp";
				}
			}
			else if(radio.equals("2")){
				Employee employee = new Employee(email,userPassword);
				System.out.println("inside empl login");
				if(employee.loginEmployee()){
					System.out.println("Employee Login Succeed");
					DailyRecord dailyRecord = new DailyRecord();
					ArrayList<DailyRecord> record = dailyRecord.getRecord(employee.getEmployeeId());
					System.out.println("######"+employee.getEmployeeId());
					session.setAttribute("record",record);					
					ArrayList<String> eligible = new ArrayList<String>();
					for(DailyRecord element:record){
						Date currentTime = new Date(System.currentTimeMillis());
						Timestamp recordTime = element.getAllotingTime();
						System.out.println("##########3"+currentTime.getTime()+"#####"+recordTime.getTime());
					    deadLine = (((currentTime.getTime() - recordTime.getTime())/1000)/3600);				
						
					if(deadLine<12L){
						eligible.add("YES");
					}
						
					else{
						eligible.add("NO");
					}
					}
					session.setAttribute("eligible",eligible);
					System.out.println("@"+eligible);
					session.setAttribute("record",record);
					System.out.println("##"+record);
					//System.out.println();
					
					session.setAttribute("employee",employee);
					System.out.println("!!!"+employee);
					//System.out.println();
					
					session.setAttribute("radio",radio);

					nextPage = "home.jsp";
				}
			}
			else{
				String msg2 = "Invalid User choice";
				request.setAttribute("msg2",msg2);
			}

			if(nextPage=="index.jsp"){
				String msg = "Invalid email or Incorrect Password";
				request.setAttribute("msg",msg);
			}
			

			request.getRequestDispatcher(nextPage).forward(request,response);
		}
	}
