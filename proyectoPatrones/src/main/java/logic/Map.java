package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Map {
	
	private int x; //vertical
	private int y; //Horizontal
	private ArrayList<char[]> map = new ArrayList<char[]>();
	private char restoreTile;
	private ArrayList<Quest> quests = new ArrayList<Quest>();
	private static final char[] itemLetters = new char[]{'♥','ΰ','φ','—','ẅ','Ų'};
	
	public Map(String filePath, int x, int y) {
		this.x = x;
		this.y = y;
		readTxtMap(filePath);
	}
	
	public Iterator<char[]> getMap(){
		return map.iterator();
	}
	
	public char getTile(int coordinateX,int coordinateY) {
		return map.get(coordinateX)[coordinateY];
	}
	
	public int getHorVertSizeMap(char coordinateType) {
		int size = 0;
		if(coordinateType == 'x') {
			size = map.size();
		} else {
			if(!map.isEmpty()) {
				size = map.get(1).length;
			}
		}
		return size;
	}
	
	public Iterator<Quest> getQuests() {
		return quests.iterator();
	}
	
	public String getMapInformation() {
		return "\n————————————————————————————————\n"+
			   "        • S:suelo\n"+
			   "        • B:bosque\n"+
			   "        • M:montaña\n"+
			   "        • A:agua\n"+
			   "        • P:pueblo\n"+
			   "        • E:edificación\n"+
			   "        • c:camino\n"+
			   "        • h:herrería\n"+
			   "        • ♥:vida\n"+
			   "        • ○:item recogido\n"+
			   "        • ●jugador\n"+
			   "————————————————————————————————";
	}
	
	public void readTxtMap(String filePath) {
		try{
			String fileRow = "";
			char[] fileRowToChar;
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			
			while ((fileRow = br.readLine()) != null) {
				fileRowToChar = fileRow.toCharArray();
				map.add(fileRowToChar);
			}
			br.close();
			
		} catch (FileNotFoundException fnfe){
			fnfe.printStackTrace();
		} catch (IOException io){
			io.printStackTrace();
		}
		movePlayer();
	}
	
	public void movePlayer() {
		restoreTile = map.get(x)[y];
		map.get(x)[y] = '●';
	}
	
	public void restoreBackTile(int backTileCoord, int newCoord, char coordType) {
		for(char letter: itemLetters) {
			if(letter == restoreTile) {
				restoreTile = '○';
			}
		}
		
		if(coordType == 'x') {
			x = newCoord;
			map.get(backTileCoord)[y] = restoreTile;
		} else {
			y = newCoord;
			map.get(x)[backTileCoord] = restoreTile;
		}
		movePlayer();
	}
	
	public enum Geography {
		LAKE(20),
		MOUNTAIN(40);
		private final int amountSkill;
		
		Geography(int amountSkill){
			this.amountSkill = amountSkill;
		}
		
		public int getAmountSkill() {
			return amountSkill;
		}
	}
}
