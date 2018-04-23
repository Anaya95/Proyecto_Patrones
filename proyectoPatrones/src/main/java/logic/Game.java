package logic;

import java.util.Iterator;

public class Game {
	private Map currentMap;
	private Player player;
	
	public Game() {
		player = MultiPlayer.loadData();
		currentMap = new Map("src/main/java/maps/"+MultiMap.getMapName()+".txt",player.getXCoord(),player.getYCoord());
		player.setMap(currentMap);
	}
	
	public Iterator<char[]> getMap() {
		return currentMap.getMap();
	}
	
	public String movePlayer(char moveTo) {
		String mssg = "";
		if(moveTo == 'i') {
			mssg = currentMap.getMapInformation();
		} else{
			mssg = player.move(moveTo);
		}
		return mssg;
	}
}
