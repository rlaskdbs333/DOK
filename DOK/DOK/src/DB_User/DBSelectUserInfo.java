package DB_User;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DBSelectUserInfo {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DBSelectUserInfo() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userInfo_DOK?serverTimezone=Asia/Seoul","root","mirim2");
			st = con.createStatement();
		}catch (Exception e) {
			System.out.println("데이터 베이스 연결 오류:"+e.getMessage());
		}
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
		}
		return false;
	}
}
