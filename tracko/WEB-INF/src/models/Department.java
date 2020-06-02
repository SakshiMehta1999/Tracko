package models;

import java.util.ArrayList;
import java.sql.*;



public class Department{

	private Integer departmentId;
	private String departmentName;
	private Traco traco; 

	public Department(Integer departmentId,String departmentName){
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	public Department(String departmentName,Traco traco){
		this.departmentName = departmentName;
		this.traco = traco;
	}

	public Department(Integer departmentId){
		this.departmentId = departmentId; 
	}

	public Department(){
	
	}

	//Other methods////////////
	public boolean addDepartment(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=true&useSSL=false","root","1234");
			String query = "insert into departments(department_name,traco_id) value(?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,departmentName);
			System.out.println(traco.getTracoId()+"-----");
			pst.setInt(2,traco.getTracoId());
			int x = pst.executeUpdate();
			if(x == 1)
				flag = true;
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return flag;
	}

	public static ArrayList<Department> collectDepartment(Integer tracoId){
		ArrayList<Department> departments = new ArrayList<Department>();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=true&useSSL=false","root","1234");
			String query = "select department_id,department_name from departments where traco_id="+tracoId;
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet result = pst.executeQuery();
			while(result.next()){
				departments.add(new Department(result.getInt(1),result.getString(2)));
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return departments;
	}

/////////////////////////////////////////
public static int countDepartments(Integer tracoId){
		int result =0;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=false&useSSL=false","root","1234");
			String query = "select * from departments where traco_id="+tracoId;
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
	////////getter-setter////////
	
	public void setDepartmentId(Integer departmentId){
		this.departmentId = departmentId;
	}

	public Integer getDepartmentId(){
		return departmentId;
	}

	public void setDepartmentName(String departmentName){
		this.departmentName = departmentName;
	}

	public String getDepartmentName(){
		return departmentName;
	}

	public void setTraco(Traco traco){
		this.traco = traco;
	}

	public Traco getTraco(){
		return traco;
	}
}