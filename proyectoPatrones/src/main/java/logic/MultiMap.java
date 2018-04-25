package logic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MultiMap {
	static DBConnection conn = DBConnection.getInstance();
	
	public static String getMapName(int userID) {
		String mapName = "";
		String sql = "SELECT mapName "+
					 "FROM gameforuser "+
					 "JOIN game on(gameforuser.gameID = game.gameID) "+
					 "JOIN map on (game.mapID = map.mapID) "+
					 "WHERE userID = "+userID+";";
		
		
		ResultSet rs;
		try {
			rs = conn.executeSQL(sql,true);
			
			if (rs.next()){
				mapName = rs.getString("mapName");
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapName;
	}
}
