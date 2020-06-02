package models;

import java.util.*;
import java.sql.*;

public class WorkList{
	private Integer workListId;
	private String work;
	private Department department;


///////constructors////////

public WorkList(Integer workListId,String work){
	this.workListId = workListId;
	this.work = work;
}
public WorkList(String work,Department department){
	this.work = work;
	this.department = department;
}

public WorkList(){
}

////other methods//////////////
public boolean addWorkList(){
	boolean flag = false;
	try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=true&useSSL=false","root","1234");
			String query = "insert into work_lists(work,department_id) values(?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,work);
			pst.setInt(2,department.getDepartmentId());
			int rs = pst.executeUpdate();
			if(rs==1){
				flag=true;
			}
			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return flag;
	}





public static ArrayList<WorkList> fetchWorkList(Integer departmentId){
	ArrayList<WorkList> workList = new ArrayList<WorkList>();
	try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=true&useSSL=false","root","1234");
			String query = "select work_list_id,work from work_lists where department_id="+departmentId;
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				workList.add(new WorkList(rs.getInt(1),rs.getString(2)));
			}
			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return workList;
	}

	//getter Setter

	public void setWorkListId(Integer workListId){
		this.workListId = workListId;
	}

	public Integer getWorkListId(){
		return workListId;
	}

	public void setWork(String work){
		this.work = work;
	}

	public String getWork(){
		return work;
	}

	public void setDepartment(Department department){
		this.department = department;
	}

	public Department getDepartment(){
		return department;
	}
}