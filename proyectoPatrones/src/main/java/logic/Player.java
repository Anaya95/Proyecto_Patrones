package logic;

import java.util.ArrayList;

import logic.Map.Geography;

public class Player extends Character{
	private Skills skills;
	private ArrayList<Items> items = new ArrayList<Items>();
	private int Xcoord; //vertical
	private int Ycoord; //horizontal
	private Map map;
	private IMove direction;
	
	public Player() {
		super();
		this.skills = new Skills();
		this.Xcoord = 0;
		this.Ycoord = 0;
	}
	
	public Player(String name, int level, int life) {
		super(name,level,life);
	}
	
	public Player(String name, int level, int life, Skills skills, ArrayList<Items> items, int x, int y) {
		super(name,level,life);
		this.skills = skills;
		this.items = items;
		this.Xcoord = x;
		this.Ycoord = y;
	}
	
	public int getXCoord() {
		return this.Xcoord;
	}
	
	public int getYCoord() {
		return this.Ycoord;
	}
	
	public void setXCoord(int XCoord) {
		this.Xcoord = XCoord;
	}
	
	public void setYCoord(int YCoord) {
		this.Ycoord = YCoord;
	}
	
	public void setMap(Map map) {
		this.map = map;
	}
	
	public void setItems(ArrayList<Items> items) {
		this.items = items;
	}
	
	public void setSkills(Skills skills) {
		this.skills = skills;
	}
	
	public String move(char moveTo) {
		String mssg = "";
		int newCoord = 0;
		//boolean isXCoord = false;
		
		switch(moveTo) {
			case 'w': //up
				direction = new NorthSouth(map,this);
				newCoord = Xcoord-1;
				//isXCoord = true;
				break;
			
			case 's': //down
				direction = new NorthSouth(map,this);
				newCoord = Xcoord+1;
				//isXCoord = true;
				break;
			
			case 'a': //left
				direction = new EastWest(map,this);
				newCoord = Ycoord-1;
				//isXCoord = false;
				break;
			
			case 'd': //right
				direction = new EastWest(map,this);
				newCoord = Ycoord+1;
				//isXCoord = false;
				break;
		}
		
		mssg = direction.move(newCoord);
		//mssg = processMovement(newCoord, isXCoord);
		return mssg;
	}
	
	/*public String processMovement(int newCoord, boolean isXCoord) {
		char tile = '-';
		String[] mssgMove = new String[2]; //0:message 1:move
		
		if(isXCoord) {
			if(newCoord >= 0 && newCoord < map.getHorVertSizeMap('x')) {
				tile = map.getTile(newCoord,Ycoord);
				mssgMove = processTile(tile);
				
				if(Boolean.parseBoolean(mssgMove[1])) {
					map.restoreBackTile(Xcoord,newCoord,'x');
					Xcoord = newCoord;
				}
			}
		} else {
			if(newCoord >= 0 && newCoord < map.getHorVertSizeMap('y')) {
				tile = map.getTile(Xcoord,newCoord);
				mssgMove = processTile(tile);
				
				if(Boolean.parseBoolean(mssgMove[1])) {
					map.restoreBackTile(Ycoord,newCoord,'y');
					Ycoord = newCoord;
				}
			}
		}
		
		return mssgMove[0];
	}*/
	
	public String[] processTile(char tile) {
		String[] mssgMove = new String[2]; //0:message 1:move
		
		switch(tile) {
			case 'A':
				if(skills.getSwimmer() > Geography.LAKE.getAmountSkill()) {
					mssgMove[0] = "";
					mssgMove[1] = "true";
				} else {
					mssgMove[0] = "\n++++++++++++++++++++++++++++++++++++++++\n" +
							 	  "+ Tu habilidad nadador no es suficinte +" + 
							 	  "\n++++++++++++++++++++++++++++++++++++++++";
					mssgMove[1] = "false";
				}
				break;

			case 'M':
				if(skills.getMountainClimber() > Geography.MOUNTAIN.getAmountSkill()) {
					mssgMove[0] = "";
					mssgMove[1] = "true";
				} else {
					mssgMove[0] = "\n+++++++++++++++++++++++++++++++++++++++++++\n" + 
							 	  "+ Tu habilidad escalador no es suficiente +" + 
							 	  "\n+++++++++++++++++++++++++++++++++++++++++++";
					mssgMove[1] = "false";
				}
				break;
		
			case 'B':
			case 'S':
			case 'P':
			case 'c':
			case 'h':
			case '○':
				mssgMove[0] = "";
				mssgMove[1] = "true";
				break;
		
			case 'E':
				mssgMove[0] = "\n++++++++++++++++++++++++\n" + 
				 		 	  "+ No puedes entrar ahí +" + 
				 		 	  "\n++++++++++++++++++++++++";
				mssgMove[1] = "false";
				break;
				
			default:
				mssgMove = pickItem(tile);
		}
		return mssgMove;
	}
	
	public String[] pickItem(char tile) {
		String[] mssgMove = new String[2]; //0:message 1:move
		Items item = null;
		
		switch(tile) {
			case '♥':
				item = Items.LIFE;
				break;

			case 'ΰ':
				item = Items.BOAT;
				break;
		
			case 'φ':
				item = Items.SWORD;
				break;
				
			case '—':
				item = Items.ROPE;
				break;
				
			case 'ẅ':
				item = Items.CLIMBINGBOOTS;
				break;
				
			case 'Ų':
				item = Items.TORCH;
				break;
					
			default: mssgMove[0] = doMission(tile);
		}
		
		if(item != null) { 
			items.add(item);
		}

		mssgMove[1] = "true";
		return mssgMove;
	}
	
	public String doMission(char tile) {
		//Quest mission = MultiQuest.findMission(tile);
		String mssg = react();
		return mssg;
	}

	public ArrayList<Items> getItems() {
		return items;
	}
}
