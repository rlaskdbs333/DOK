package Movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class DB_MovieArea {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private MovieArea movieArea;
	private Vector<MovieArea> movieAreas = new Vector<MovieArea>();
	public DB_MovieArea() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DOK?serverTimezone=Asia/Seoul", "root",
					"mirim2");
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("데이터 베이스 연결 오류:" + e.getMessage());
		}
		//movieArea = new MovieArea[countMovieArea()];
	}

	public void makeMovie_Area(int area_key, String hall, int weeks, String startTime, int movieKey, int vacantSeat,
			String seatState) {
		try {
			String SQL = "INSERT INTO moviearea(area_key, hall , weeks, startTime, movieKey, vacantSeat, seatState)"
					+ "VALUES(\"" + area_key + "\",\"" + hall + "\",\"" + weeks + "\",\"" + startTime + "\",\""
					+ movieKey + "\",\"" + vacantSeat + "\",\"" + seatState + "\");";
			// System.out.println(SQL);

			int success = st.executeUpdate(SQL);

			if (success != 1) {
				System.out.println("error");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public Vector<MovieArea> getMovieArea(int movie_key, int theater_key) {
		try {
			String SQL = "select* from moviearea where movieKey like " + movie_key + " and area_key like " + theater_key + " ;";
			System.out.println(SQL);
			rs = st.executeQuery(SQL);
			
			// int n=0; 
			 while(rs.next()) {
			  
				 movieArea = new MovieArea(); 
				 movieArea.set_key(rs.getInt("_key"));
				 movieArea.setArea_key(rs.getInt("area_key"));
				 movieArea.setHall(rs.getString("hall"));
				 movieArea.setWeeks(rs.getInt("weeks"));
				 movieArea.setMovieKey(rs.getInt("movieKey"));
				 movieArea.setVacantSeat(rs.getInt("vacantSeat"));
				 movieArea.setSeatState(rs.getString("seatState"));
				 movieAreas.add(movieArea);
				// n++;
			 }
			 

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DBMovieInfo데이터베이스 검색 오류:" + e.getLocalizedMessage());
		}

		return movieAreas;

	}
	
	public int countMovieArea() {
		int n = 0;
		try {
			String SQL = " SELECT COUNT(*)  FROM movieArea";
			rs = st.executeQuery(SQL);
			if(rs.next()) {
				n = rs.getInt("COUNT(*)");
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return n;
	}
	
}
