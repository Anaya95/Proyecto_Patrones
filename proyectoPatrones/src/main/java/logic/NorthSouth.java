package logic;

public class NorthSouth implements IMove{
	private Map map;
	private Player player;
	
	public NorthSouth(Map map, Player player) {
		this.map = map;
		this.player = player;
	}
	
	public String move(int newCoord) {
		char tile = '-';
		String[] mssgMove = new String[2]; //0:message 1:move
		
		if(newCoord >= 0 && newCoord < map.getHorVertSizeMap('x')) {
			tile = map.getTile(newCoord,player.getYCoord());
			mssgMove = player.processTile(tile);
			
			if(Boolean.parseBoolean(mssgMove[1])) {
				map.restoreBackTile(player.getXCoord(),newCoord,'x');
				player.setXCoord(newCoord);
			}
		}
		
		return mssgMove[0];
	}
}
