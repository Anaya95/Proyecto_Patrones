package logic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MultiUser {
	static DBConnection conn = DBConnection.getInstance();
	
	public static User login(String email, String pass) {
		User user = null;
		String sql = "SELECT userID,name,lastName1,lastName2,email "+
					 "FROM User "+
					 "WHERE pass = '"+pass+"';"; // and email = '"+email+"';";
		ResultSet rs;
		try {
			rs = conn.executeSQL(sql,true);
			
			if (rs.next()){
				user = new User(rs.getInt("userID"),
								rs.getString("name"),
								rs.getString("lastName1"),
								rs.getString("lastName2"),
								rs.getString("email"));
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
