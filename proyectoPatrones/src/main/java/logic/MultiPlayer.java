package logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MultiPlayer {
	static DBConnection conn = DBConnection.getInstance();
	
	public static Player loadData(int gameID) {
		CharactersFactory factory = CharactersFactory.getInstance();
		Player player = null;
		Skills skills = null;
		String sql = "SELECT name,level,life,climber,swimmer,visibility,xCoord,yCoord "+
					 "FROM Avatar "+
					 "WHERE gameID = '"+gameID+"';";
		ResultSet rs;
		try {
			rs = conn.executeSQL(sql,true);
			
			if (rs.next()){
				player = (Player) factory.getCharacter(1,rs.getString("name"),
					    							     rs.getInt("level"),
					    							     rs.getInt("life"));
				
				skills = new Skills(rs.getInt("climber"),
					     			rs.getInt("swimmer"),
					     			rs.getInt("visibility"));
				
				player.setSkills(skills);
				//ArrayList <Items> items = new ArrayList <Items> ();
				//player.setItems(items);
				player.setXCoord(rs.getInt("xCoord"));
				player.setYCoord(rs.getInt("yCoord"));
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return player;
	}
}
