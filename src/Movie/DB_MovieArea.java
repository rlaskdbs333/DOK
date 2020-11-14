package Movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_MovieArea {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private final static int DATA_NUM = 70;
	private Movie[] movies = new Movie[DATA_NUM];
	
	public DB_MovieArea() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DOK?serverTimezone=Asia/Seoul","root","mirim2");
			st = con.createStatement();
		}catch (Exception e) {
			System.out.println("데이터 베이스 연결 오류:"+e.getMessage());
		}
	}
	
	
	
	public void makeMovie_Area(int area_key, String hall, int weeks, String startTime, int movieKey, int vacantSeat, String seatState ) {
		try{
			String SQL = "INSERT INTO moviearea(area_key, hall , weeks, startTime, movieKey, vacantSeat, seatState)"
					+"VALUES(\""+area_key+"\",\""+hall+"\",\""+weeks+"\",\""+startTime+"\",\""+movieKey+"\",\""+vacantSeat+"\",\""+seatState+"\");";
			//System.out.println(SQL);
			
			int success = st.executeUpdate(SQL);
			  
			if(success != 1) { System.out.println("error"); }
			 
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		
	}

}
