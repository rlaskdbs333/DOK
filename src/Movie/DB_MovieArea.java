package Movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_MovieArea {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private MovieArea[] movieArea;
	
	public DB_MovieArea() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DOK?serverTimezone=Asia/Seoul","root","mirim2");
			st = con.createStatement();
		}catch (Exception e) {
			System.out.println("데이터 베이스 연결 오류:"+e.getMessage());
		}
		movieArea = new MovieArea[30];
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
	
	public MovieArea[] getMovieArea(int movie_key){
		try {
			String SQL = "select* from moviearea where movieKey like "+movie_key+";";
			//System.out.println(SQL);
			rs = st.executeQuery(SQL);
			int n=0;
			while(rs.next()) {
				/*
				 * System.out.println(rs.getString("m_name"));
				 * System.out.println(rs.getString("genre"));
				 * System.out.println(rs.getString("open_day"));
				 * System.out.println(rs.getInt("audience"));
				 * System.out.println(rs.getDouble("rating"));
				 */
				
				movieArea[n] = new MovieArea();
				movieArea[n].set_key(rs.getInt("_key"));
				movieArea[n].setArea_key(rs.getInt("area_key"));
				movieArea[n].setHall(rs.getString("hall"));
				movieArea[n].setWeeks(rs.getInt("weeks"));
				movieArea[n].setMovieKey(rs.getInt("movieKey"));
				movieArea[n].setVacantSeat(rs.getInt("vacantSeat"));
				movieArea[n].setSeatState(rs.getString("seatState"));
				
				n++;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("DBMovieInfo데이터베이스 검색 오류:"+ e.getLocalizedMessage());
		}
		
		return movieArea;
		
	}

}
