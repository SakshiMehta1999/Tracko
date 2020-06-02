package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

import models.*;

public class AddRoomsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		String roomName = request.getParameter("room");
		String floor = request.getParameter("floor");
		Traco traco = (Traco)session.getAttribute("traco");
		Integer tracoId = traco.getTracoId();

		Department department = new Department();
		department.setDepartmentId(Integer.parseInt(request.getParameter("dept_id")));

		Room room = new Room(roomName,floor,department);

		if(room.addRooms()){
			request.setAttribute("room_succ","Room Added Successfully");
			Integer countRooms = Room.countRooms(tracoId);
			session.setAttribute("countrooms",countRooms);

		}

		request.getRequestDispatcher("home.jsp").forward(request,response);
	}
}