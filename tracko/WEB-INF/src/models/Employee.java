package models;

import java.sql.*;
import org.jasypt.util.password.StrongPasswordEncryptor;
import java.util.*;




public class Employee{
	private Integer employeeId;
	private String employeeOfficeId;
	private String employeeName;
	private String password;
	private String email;
	private Integer salary;
	private Department department;
	private Cubicle cubicle;


	public Employee(String email,String password){
		this.email = email;
		this.password = password;
	}
	public Employee(/*String employeeOfficeId,*/String employeeName,String password,String email,Integer salary,Department department,Cubicle cubicle){
		//this.employeeOfficeId = employeeOfficeId;
		this.employeeName = employeeName;
		this.password = password;
		this.email = email;
		this.salary = salary;
		this.department = department;
		this.cubicle = cubicle;
	}
	public Employee(Integer employeeId,String employeeName,String employeeOfficeId){
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeOfficeId = employeeOfficeId;
	}

	public Employee(String employeeOfficeId){
		this.employeeOfficeId = employeeOfficeId;
	}

	public Employee(){

	}


	//Other Methods
	public boolean removeEmployee(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");	
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?user=root&password=1234");
			String query = "delete from employees where employee_office_id = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,employeeOfficeId);

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



	public static ArrayList<Employee> fetchEmployees(Integer departmentId){
		ArrayList<Employee> fetchEmpl = new ArrayList<Employee>();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=true&useSSL=false","root","1234");
			String query = "select employee_id,employee_name,employee_office_id from employees where department_id="+departmentId;
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				fetchEmpl.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return fetchEmpl;
	}






	public boolean registerEmployee(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=true&useSSL=false","root","1234");
			String query = "insert into employees (employee_office_id,employee_name,password,email,Salary,department_id,cubicles_id) values (?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,employeeOfficeId);
			pst.setString(2,employeeName);
			
			pst.setString(3,password);
			pst.setString(4,email);
			pst.setInt(5,salary);
			pst.setInt(6,department.getDepartmentId());
			pst.setInt(7,cubicle.getCubicleId());

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

	public boolean loginEmployee(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=true&useSSL=false","root","1234");
			//String query = "select employee_id,employee_office_id,employee_name,employees.password,employees.salary,employees.department_id,department_name,employees.cubicles_id,cubicle_no from employees,departments,bosses,cubicles where employees.department_id = departments.department_id and employees.cubicles_id = cubicles.cubicles_id and employees.email = ?";
			String query = "select employee_id,employee_office_id,employee_name,department_id,cubicles_id from employees where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			//rs.next();
			//String encPassword = rs.getString(4);
			//StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
				//if(spe.checkPassword(password,encPassword)){
			if(rs.next()){
				this.employeeId = rs.getInt(1);
				this.employeeOfficeId = rs.getString(2);
				this.employeeName = rs.getString(3);
				//this.password = password;
				//this.salary = rs.getInt(5);
				this.department = new Department(rs.getInt(4));
				this.cubicle = new Cubicle(rs.getInt(5));
				flag = true;
			}

			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return flag;
	}
	//Getter Setter

	public void setEmployeeId(Integer employeeId){
		this.employeeId = employeeId;
	}

	public Integer	getEmployeeId(){
		return employeeId;
	}

	public void setEmployeeOfficeId(String employeeOfficeId){
		this.employeeOfficeId = employeeOfficeId;
	}

	public String getEmployeeOfficeId(){
		return employeeOfficeId;
	}

	public void setEmployeeName(String employeeName){
		this.employeeName = employeeName;
	}

	public String getEmployeeName(){
		return employeeName;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setSalary(Integer salary){
		this.salary = salary;
	}

	public Integer getSalary(){
		return salary;
	}

	public void setDepartment(Department department){
		this.department = department;
	}

	public Department getDepartment(){
		return department;
	}

	public void setCubicle(Cubicle cubicle){
		this.cubicle = cubicle;
	}

	public Cubicle getCubicle(){
		return cubicle;
	}
}