package models;

import java.util.*;
import java.sql.*;
import org.jasypt.util.password.StrongPasswordEncryptor;

public class Traco{
	//Fields

	private Integer tracoId;
	private String userName;
	private String userPassword;
	private String companyName;
	private String officeId;
	private String email;
	

	//Constructors//////////

	public  Traco(){

	}
	public Traco(Integer tracoId){
		this.tracoId = tracoId;
	}
	public Traco(String email,String userPassword){
		this.email = email;
		this.userPassword = userPassword;
	}
	public Traco(Integer tracoId,String companyName){
		this.tracoId=tracoId;
		this.companyName = companyName;
	}

	public Traco(String userName,String companyName,String email,String officeId,String userPassword){
		this.userName = userName;
		this.companyName = companyName;
		this.email = email;
		this.officeId = officeId;
		this.userPassword = userPassword;
	}

	//Other methods/////////

	public boolean loginCEO(){
		boolean flag = false;
		Connection con =null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=false&useSSL=false","root","1234");
			String query ="select traco_id,office_id,user_name,user_password,email,company_name from traco where email = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,email);
			ResultSet rs = pst.executeQuery();
			//rs.next();
			//String encPassword = rs.getString(4);
			/*StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
			if(spe.checkPassword(userPassword,encPassword)){
				this.tracoId = rs.getInt(1);
				this.officeId = rs.getString(2);
				this.userName = rs.getString(3);
				this.userPassword = null;
				this.email = rs.getString(5);
				this.companyName = rs.getString(6);
				flag = true;
			}*/
			if(rs.next()){
				this.tracoId = rs.getInt(2);
				this.officeId = rs.getString(3);
				this.userName = rs.getString(4);
				this.userPassword = null;
				this.email = rs.getString(5);
				this.companyName = rs.getString(6);
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
	public static boolean changePassword(String password,String email,String table){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=true&useSSL=false","root","1234");
			String query = "update"+table+ "set password =? where email=?";
			PreparedStatement pst = con.prepareStatement(query);
			//StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
			//String encPassword = spe.encryptPassword(password);
			pst.setString(1,password);
			pst.setString(2,email);

			if(pst.executeUpdate() == 1)
				flag = true;

			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return flag;
	}


	//Count
	public static int count(String table){
		int result =0;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=false&useSSL=false","root","1234");
			String query = "select * from "+table;
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

	//registration////////
	public boolean registerCompany(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=true&useSSL=false","root","1234");
			String query = "insert into traco(office_id,user_name,email,user_password,company_name) value (?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);

			//StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
			//String encPassword = spe.encryptPassword(userPassword);

			pst.setString(1,officeId);
			pst.setString(2,userName);
			pst.setString(3,email);
			pst.setString(4,userPassword);
			pst.setString(5,companyName);

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






	//companies collection/////////
	public static ArrayList<String> collectCompanies(){
		ArrayList<String> companies = new ArrayList<String>();
		companies.add("choice from below");
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?user=root&password=1234");

			String query = "select company_name from traco  order by company_name";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				companies.add(rs.getString(1));
			}
			con.close();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
		    }catch(SQLException e){
				e.printStackTrace();
		    }
			
			return companies;
	}

	
	
	//Getter Setter

	public void setTracoId(Integer tracoId){
		this.tracoId = tracoId;
	}

	public Integer getTracoId(){
		return tracoId;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}

	public String getUserPassword(){
		return userPassword;
	}

	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}

	public String getCompanyName(){
		return companyName;
	}

	public void setOfficeId(String officeId){
		this.officeId = officeId;
	}

	public String getOfficeId(){
		return officeId;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}