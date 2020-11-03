package DB_User;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBuserInfo {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private User user = new User();
	
	//생성자
	public DBuserInfo() {
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
					
				
		}catch(Exception e) {
			System.out.println("데이터베이스 검색 오류:"+ e.getMessage());
		}
		return false;
	}

	
	//userID와 userPasswor가 일치하는지 확인
	public boolean isUser(String userID, String userPassword) {
		try {
			String SQL = "SELECT * FROM user WHERE userID = '" + userID+ "' and userPassword = '" +userPassword+"'";
					   
			rs = st.executeQuery(SQL);
			
			//일치
			if(rs.next()) {
				return true;
			//불일치
			}else {
				return false;
			}
		}catch(Exception e) {
			System.out.println("데이터베이스 검색 오류:"+ e.getMessage());
		}finally {
			/*
			 * if(st!=null)try {st.close();}catch(SQLException sqle) {} if(con!=null)try
			 * {st.close();}catch(SQLException sqle) {}
			 */
		}
		return false;
	}
	
	//데이터베이스에 있는 user정보 가져오기
	public User getUserInfo(String userID) {
		try {
			String SQL = " select* from user where userID =" +"\""+userID+"\"";
					   
			rs = st.executeQuery(SQL);
			//일치
			if(rs.next()) {
				
				user.setUserID(rs.getString("userID"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserName(rs.getString("userName"));
				user.setUseryymmdd(rs.getString("useryymmdd"));
				user.setUserGender(rs.getString("userGender"));
				user.setUserPhone(rs.getString("userPhone"));
				user.setUserTaste1(rs.getString("userTaste1"));
				user.setUserTaste2(rs.getString("userTaste2"));
			//불일치
			}else {
				
			}
		}catch(Exception e) {
			System.out.println("getUserInfo데이터베이스 검색 오류:"+ e.getMessage());
		}finally {
			/*
			 * if(st!=null)try {st.close();}catch(SQLException sqle) {} if(con!=null)try
			 * {st.close();}catch(SQLException sqle) {}
			 */
		}
		//System.out.println(user.getUserID());
		return user;
		
	}
}
