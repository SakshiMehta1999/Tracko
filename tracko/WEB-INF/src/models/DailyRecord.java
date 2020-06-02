package models;

import java.util.ArrayList;
import java.sql.*;


public class DailyRecord{
	private Integer dailyRecordId;
	private Timestamp allotingTime;
	private Employee employee;
	private WorkList workList;
	private String description;

/////constructors//////

	public DailyRecord(Employee employee,WorkList workList,String description){
		this.employee = employee;
		this.workList = workList;
		this.description = description;
	}
	public DailyRecord(Integer dailyRecordId,Timestamp allotingTime,Employee employee,WorkList workList,String description){
		this.dailyRecordId = dailyRecordId;
		this.allotingTime = allotingTime;
		this.employee = employee;
		this.workList = workList;
		this.description = description;
	}

	public DailyRecord(){
	}


//////other methods//////////
	public ArrayList<DailyRecord> getRecord(Integer employeeId){
		ArrayList<DailyRecord> dailyRecord = new ArrayList<DailyRecord>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=true&useSSL=false","root","1234");
			//String query = "select daily_records_id,alloting_time,employee_id,daily_records.work_list_id,description,work_lists.work from daily_records,work_lists where daily_records.work_list_id=work_lists.work_list_id and employee_id="+employeeId;
			String query = "select daily_records_id,alloting_time,employee_id,work_list_id,description from daily_records";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			System.out.println("try");
			while(rs.next()){
			System.out.println("asdfghjkkzxcvbn");
				WorkList w1 = new WorkList();
				w1.setWorkListId(rs.getInt(4));
				//w1.setWork(rs.getString(6));
				w1.setWork(rs.getString(5));
				Employee e1 = new Employee(); 
				e1.setEmployeeId(rs.getInt(3));
				Date currentTime = new Date(System.currentTimeMillis());
				Timestamp recordTime = rs.getTimestamp(2);
			    Long deadLine = (((currentTime.getTime() - recordTime.getTime())/1000)/3600);
				System.out.println(deadLine);
				if(deadLine<=48){
				dailyRecord.add(new DailyRecord(rs.getInt(1),rs.getTimestamp(2),e1,w1,rs.getString(5)));
				}
			}
			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return dailyRecord;
	}




	public boolean addWork(){
		boolean flag = false;
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=true&useSSL=false","root","1234");
			String query = "insert into daily_records(employee_id,work_list_id,description) values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,employee.getEmployeeId());
			pst.setInt(2,workList.getWorkListId());
			pst.setString(3,description);

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
	//Getter Setter

	public void setDailyRecordId(Integer dailyRecorId){
		this.dailyRecordId = dailyRecordId;
	}	

	public Integer getDailyRecord(){
		return dailyRecordId;
	}

	public void setAllotingTime(Timestamp allotingTime){
		this.allotingTime = allotingTime;
	}

	public Timestamp getAllotingTime(){
		return allotingTime;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setEmployee(Employee employee){
		this.employee = employee;
	}

	public Employee getEmployee(){
		return employee;
	}

	public void setWorkList(WorkList workList){
		this.workList = workList;
	}

	public WorkList getWorkList(){
		return workList;
	}
}