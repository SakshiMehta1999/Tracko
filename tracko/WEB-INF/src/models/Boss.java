package models;

import java.sql.*;
import org.jasypt.util.password.StrongPasswordEncryptor;
import java.util.*;


public class Boss{
	private Integer bossId;
	private String bossOfficeId;
	private String bossName;
	private String password;
	private Department department;
	private String email;
	private Traco traco;
	private Integer salary;


	//Constructor

	public Boss(){

	}

	public Boss(String bossOfficeId){
		this.bossOfficeId = bossOfficeId;
	}

	public Boss(Integer bossId,String bossOfficeId,String bossName){
		this.bossId = bossId;
		this.bossOfficeId = bossOfficeId;
		this.bossName = bossName;
	}

	public Boss(String bossOfficeId,String bossName,Department department,String email,Traco traco,Integer salary){
		this.bossOfficeId = bossOfficeId;
		this.bossName = bossName;
		this.department = department;
		this.email = email;
		this.traco = traco;
		this.salary = salary;
		
	}
	public Boss(String bossOfficeId, String bossName){
		this.bossOfficeId = bossOfficeId;
		this.bossName = bossName;
	}

	public Boss(String email,String password,String companyName){
		this.email = email;
		this.password = password;

	}


	//Other methods////////////////////////////
	public ArrayList<String> trackEmployee(Integer employeeId){
		ArrayList<String> trackEmpl = new ArrayList<String>();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=true&useSSL=false","root","1234");
			String query = "select employee_name,employee_office_id,email,cubicle_no,floor,room,salary from employees,cubicles,rooms where employees.department_id = rooms.department_id and cubicles.room_id = rooms.room_id and employee_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,employeeId);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				trackEmpl.add(rs.getString(1));
				trackEmpl.add(rs.getString(2));
				trackEmpl.add(rs.getString(3));
				//trackEmpl.add(rs.getInt(4));
				trackEmpl.add(rs.getString(5));
				trackEmpl.add(rs.getString(6));
				//trackEmpl.add(rs.getInt(7));
			}
			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return trackEmpl;
	}


	public static ArrayList<Boss> fetchBosses(Integer tracoId){
		ArrayList<Boss> bosses = new ArrayList<Boss>();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=true&useSSL=false","root","1234");
			String query = "select boss_office_id ,boss_name from bosses where traco_id="+tracoId;
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				bosses.add(new Boss(rs.getString(1),rs.getString(2)));
			}
			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return bosses;
	}



	public boolean loginBoss(){
		boolean flag = false;
		Connection con = null;
		try{ 
			Class.forName("com.mysql.jdbc.Driver");	
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=true&useSSL=false","root","1234");
			//String query = "select boss_id,boss_office_id,boss_name,password,bosses.department_id,department_name,traco.traco_id,traco.company_name,salary  from bosses,departments,traco where departments.department_id = bosses.department_id  and traco.traco_id = bosses.traco_id and bosses.email = ?";
			String query = "select boss_id,boss_office_id,boss_name,department_id,traco_id from bosses where email=? and password=? ";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,email);
			pst.setString(2,password);

			ResultSet rs = pst.executeQuery();
			//result.next();
			//String encPassword = result.getString(4);
			//StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
			//if(spe.checkPassword(password,encPassword)){
			if(rs.next()){
				flag = true;
				//this.password = password;
				this.bossId = rs.getInt(1);
				this.bossOfficeId = rs.getString(2);
				this.bossName = rs.getString(3);
				this.department = new Department(rs.getInt(4));
				this.traco = new Traco(rs.getInt(5));
				//this.salary = result.getInt(9);
		}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return flag;
	}

	public boolean removeBoss(){
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");	
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=true&useSSL=false","root","1234");
			String query = "delete from bosses where boss_office_id = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,bossOfficeId);

			int result = pst.executeUpdate();
			if(result == 1)
				flag = true;
		}catch(SQLException e){
			e.printStackTrace();	
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return flag;
	}

	public boolean registerBoss(){
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=true&useSSL=false","root","1234");
			String query = "insert into bosses(boss_office_id,boss_name,password,department_id,email,traco_id,salary) values(?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,bossOfficeId);
			pst.setString(2,bossName);
			StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
			String encPassword = spe.encryptPassword("12345");
			pst.setString(3,encPassword);
			pst.setInt(4,department.getDepartmentId());
			pst.setString(5,email);
			pst.setInt(6,traco.getTracoId());
			pst.setInt(7,salary);

			int result = pst.executeUpdate();
			if(result == 1)
				flag = true;

			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return flag;
	}
	///////////////////////////

	public static int countBosses(Integer tracoId){
		int result =0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=false&useSSL=false","root","1234");
			String query = "select * from bosses where traco_id ="+tracoId;
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
///getter-setter//////////////
	public void setBossId(Integer bossId){
		this.bossId = bossId;
	}

	public Integer	getBossId(){
		return bossId;
	}

	public void setBossOfficeId(String bossOfficeId){
		this.bossOfficeId = bossOfficeId;
	}

	public String getBossOfficeId(){
		return bossOfficeId;
	}

	public void setBossName(String bossName){
		this.bossName = bossName;
	}

	public String getBossName(){
		return bossName;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setDepartment(Department department){
		this.department = department;
	}

	public Department getDepartment(){
		return department;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setTraco(Traco traco){
		this.traco = traco;
	}

	public Traco getTraco(){
		return traco;
	}

	public void setSalary(Integer salary){
		this.salary = salary;
	}

	public Integer getSalary(){
		return salary;
	}
}
