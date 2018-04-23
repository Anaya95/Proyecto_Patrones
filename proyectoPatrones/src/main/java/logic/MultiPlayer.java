package logic;

import java.util.ArrayList;

public class MultiPlayer {
	
	public static Player loadData(){
		CharactersFactory factory = CharactersFactory.getInstance();
		
		ArrayList <Items> items = new ArrayList <Items> ();
		Skills skills = new Skills(20,30,10);
		
		Player player = (Player) factory.getCharacter(1,"Erick", 1, 80);
		player.setSkills(skills);
		player.setItems(items);
		player.setXCoord(8);
		player.setYCoord(12);
		
		return player;
	}
}
