package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private static DBConnection dbConn;
	private Connection conn;
	private Statement st;
	
   	private DBConnection(String driver) throws SQLException,Exception {
   		Class.forName(driver);
		this.conn = DriverManager.getConnection("jdbc:mysql://localhost/gamedb","root","Polkmn1910");
		this.st = conn.createStatement();
   	}
   	
   	public static DBConnection getInstance() {
   		if (dbConn == null){
   			synchronized (DBConnection.class) {
   				if(dbConn == null) {
   					try {
						dbConn = new DBConnection("com.mysql.jdbc.Driver");
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
   				}
   			}
    	}
    	return dbConn;
  	}

   	public DBConnection clone(){
		try {
			throw new CloneNotSupportedException();
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		return null; 
	}
   	
   	public void executeSQL(String query) throws SQLException,Exception {	
   		st.execute(query);		
   	}
   	
   	public ResultSet executeSQL(String query, boolean returnData) throws SQLException,Exception {
   		ResultSet rs;
   		rs = st.executeQuery(query);
   		return rs;
   	}
}
