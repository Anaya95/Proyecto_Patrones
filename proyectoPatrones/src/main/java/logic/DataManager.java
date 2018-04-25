package logic;

import java.io.IOException;
import java.util.Iterator;

public class DataManager {
	
	private static User user;
	private static Game currentGame;
	
	public static boolean login(String email, String pass) {
		boolean exist = false;
		user = MultiUser.login(email,pass);
		
		if(user != null) {
			currentGame = new Game(user.getID());
			exist = true;
		}
		return exist;
	}
	
	public static Iterator<char[]> getMap() {
		return currentGame.getMap();
	}
	
	public static String movePlayer(char moveTo) throws IOException {
		return currentGame.movePlayer(moveTo);
	}
}
