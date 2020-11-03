package DB_User;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class DBUserInfo {
	private Connection con;
	private Statement st;
	private int rs;
	
	public DBUserInfo() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userInfo_DOK?serverTimezone=Asia/Seoul","root","mirim2");
			st = con.createStatement();
		}catch (Exception e) {
			System.out.println("데이터 베이스 연결 오류:"+e.getMessage());
		}
	}
	//데이터 베이스에 user정보 추가
	public boolean addUser(String userID, String userPassword, String userName, String useryymmdd, String userGender, String userPhone , String userTaste1, String userTaste2 ) {
		try {
			//String SQL = "SELECT * FROM ADMIN WHERE adminID = '" + adminID+ "' and adminPassword = '" +adminPassword+"'";
			String SQL = "INSERT INTO USER (userID, userPassword, userName, useryymmdd, userGender,userPhone, userTaste1, userTaste2) "
					+ "VALUES(\""+userID+"\"," +"\""+ userPassword+"\"," + "\""+userName+"\",\"" + useryymmdd+"\",\""+userGender +"\","+ "\""+userPhone +"\","+ "\""+userTaste1+"\"," +  "\""+userTaste2+"\""+");";
		
			int success = st.executeUpdate(SQL);
			
			//성공
			if(success == 1) {
				return true;
			//실패
			}else {
				return false;
			}
			
			/*
			 * if(rs.next()) { return 1; }else { return 2; }
			 */
		}catch(Exception e) {
			System.out.println("데이터베이스 검색 오류:"+ e.getMessage());
		}
		return false;
	}
	
	
}
