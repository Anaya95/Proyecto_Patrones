package logic;

public class EastWest implements IMove{
	private Map map;
	private Player player;
	
	public EastWest(Map map, Player player) {
		this.map = map;
		this.player = player;
	}
	
	public String move(int newCoord) {
		char tile = '-';
		String[] mssgMove = new String[2]; //0:message 1:move
		
		if(newCoord >= 0 && newCoord < map.getHorVertSizeMap('y')) {
			tile = map.getTile(player.getXCoord(),newCoord);
			mssgMove = player.processTile(tile);
			
			if(Boolean.parseBoolean(mssgMove[1])) {
				map.restoreBackTile(player.getYCoord(),newCoord,'y');
				player.setYCoord(newCoord);
			}
		}
		
		return mssgMove[0];
	}
}
