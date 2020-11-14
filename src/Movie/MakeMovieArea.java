package Movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import theater.Theater;
import theater.DB_Theater;

public class MakeMovieArea {
	
	public static int THEATER_NUM;
	public static int MOVIE_NUM;
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
				
			
	String[] hallNum;
	String[] hallName = {"1관", "2관", "3관", "4관", "5관"};
	//2,4
	String[][] hall_time = {{"11:50","14:35", "17:20 ","22:20"},
						{"10:00", "16:30", "18:50" ,"21:10"},
						{"12:10 ","16:55" ,"19:15 " ,"22:40"},
						{"12:10", "16:50 ", "21:40 ", "23:00 "},
						{"12:30 ", "14:40 ", "17:05 ", "19:45 "}};
	
	//String[] hall2_time = ;
	/*
	 * String[] hall3_time = ; String[] hall4_time = {"12:10", "16:50 ", "21:40 ",
	 * "23:00 "}; String[] hall5_time = {"12:30 ", "14:40 ", "17:05 ", "19:45 "};
	 */
	
	int seat = 216; //24*9
	String seatState = "000000000000000000000000/"	
			+"000000000000000000000000/"
			+"000000000000000000000000/"
			+"000000000000000000000000/"
			+"000000000000000000000000/"
			+"000000000000000000000000/"
			+"000000000000000000000000/"
			+"000000000000000000000000/"
			+"000000000000000000000000";
	
	int random;
	
	public MakeMovieArea() {
		
		
		DB_MovieInfo movieInfo_connect = new DB_MovieInfo();
		DB_MovieArea movieArea_connect = new DB_MovieArea();
		DB_Theater theater_connect = new DB_Theater();
		
		THEATER_NUM = theater_connect.countTheater();	//극장 수
		MOVIE_NUM = movieInfo_connect.countMovie();	//영화 수
		
		//객체생성
		Movie[] movie = new Movie[MOVIE_NUM];
		Theater[] theterinfo = new Theater[THEATER_NUM];
		
		//정보 불러오기
		movie = movieInfo_connect.getMovieInfoAll("open_day");
		theterinfo = theater_connect.getTheater();
		
		for(int i=0; i<THEATER_NUM; i++) {
			for(int j=0; j<5; j++) {
				random = (int)(Math.random()*70);
				for(int l=0; l<4; l++) {
					//System.out.println(theterinfo[i].get_key()+","+hallName[j]+","+hall_time[j][l]+","+movie[random].get_key());
					movieArea_connect.makeMovie_Area(theterinfo[i].get_key(),hallName[j],4, hall_time[j][l],movie[random].get_key(),seat,seatState);
				}
			}
		}
	
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MakeMovieArea();
	}

}
