package controllers;

import javax.servlet.http.*;
import javax.servlet.*;

import java.util.regex.*;
import java.util.*;
import java.io.*;
import models.*;
//import utils.*;

public class AssignTaskServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		Integer employeeId = Integer.parseInt(request.getParameter("employee_id"));
		Integer workListId = Integer.parseInt(request.getParameter("work_list_id"));
		String description = request.getParameter("description");
		System.out.println(description);
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);

		WorkList workList = new WorkList();
		workList.setWorkListId(workListId);

		DailyRecord dailyRecord = new DailyRecord(employee,workList,description);
		if(dailyRecord.addWork()){
			session.setAttribute("assign_work","you successfully assigned the work to employee");
			System.out.println("xxxx");
		}
			request.getRequestDispatcher("home.jsp").forward(request,response);
	}
}