package models;

import java.sql.*;


public class Room{
	private Integer roomId;
	private String roomName;
	private String floor;
	Department department;
	Traco traco;


	//constructors/////////

	public Room(String roomName,String floor,Department department){
		this.roomName=roomName;
		this.floor=floor;
		this.department=department;
	}

	public Room(){

	}


	//Other methods/////////////
	public static int countRooms(Integer tracoId){
		int result =0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=false&useSSL=false","root","1234");
			String query = "select room,floor,rooms.department_id,department_name from rooms,departments where rooms.department_id = departments.department_id and traco_id =" +tracoId;
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				rs.last();
				result = rs.getRow();
			}
			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}



///////////////////////////////////////
	public boolean addRooms(){
		boolean flag = false;
		Integer departmentId = null; 

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=true&useSSL=false","root","1234");
			String query = "insert into rooms(room,floor,department_id) value (?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1,roomName);
			pst.setString(2,floor);
			departmentId = department.getDepartmentId();
			pst.setInt(3,departmentId);
	
			int res = pst.executeUpdate();
			if(res == 1)
				flag = true;
			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return flag;
	}

	//getter Setter

	public void setRoomId(Integer roomId){
		this.roomId = roomId;
	}

	public Integer getRoomId(){
		return roomId;
	}

	public void setRoomName(String room){
		this.roomName = roomName;
	}

	public String getRoomName(){
		return roomName;
	}

	public void setFloor(String floor){
		this.floor = floor;
	}

	public String getFloor(){
		return floor;
	}

	public void setDepartment(Department department){
		this.department = department;
	}

	public Department getDepartment(){
		return department;
	}
}