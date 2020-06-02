package models;
import java.sql.*;


public class Cubicle{
	private Integer cubicleId;
	private Integer cubicleNo;
	private Room room;

	public Cubicle(){

	}

	 public Cubicle(Integer cubicleId,Integer cubicleNo){
		this.cubicleId = cubicleId;
		this.cubicleNo = cubicleNo;
	}
	
	 public Cubicle(Integer cubicleNo){
		 this.cubicleNo = cubicleNo;
		 this.cubicleId = fetchId(cubicleNo);
	 }
	//getter Setter

	private static int fetchId(Integer cubicleNo){
		int result =0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracko?autoReconnect=false&useSSL=false","root","1234");
			String query = "select cubicles_id from cubicles where cubicle_no ="+cubicleNo;
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				result = rs.getInt(1);
			}
			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
		
	}
	public void setCubicleId(Integer cubicleId){
		this.cubicleId = cubicleId;
	}

	public Integer getCubicleId(){
		return cubicleId;
	}

	public void setCubicleNo(Integer cubicleNo){
		this.cubicleNo = cubicleNo;
	}

	public Integer  getCubicleNo(){
		return cubicleNo;
	}

	public void setRoom(Room room){
		this.room = room;
	}

	public Room getRoom(){
		return room;
	}
}