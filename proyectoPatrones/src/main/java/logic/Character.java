package logic;

import java.util.ArrayList;

public class Character implements IInteract{
	private String name;
	private int level;
	private int life;
	private ArrayList<String> missionsDialogs = new ArrayList<String>();
	
	public Character() {
		this.name = "Jugador";
		this.level = 1;
		this.life = 100;
	}
	
	public Character(String name, int level, int life) {
		this.name = name;
		this.level = level;
		this.life = life;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLife() {
		return this.life;
	}
	
	public void setLife(int life) {
		this.life = life;
	}
	
	public void setMissionsDialogs(ArrayList<String> dialogs) {
		this.missionsDialogs = dialogs;
	}
	
	public String react() {
		String mssg = "Esta es una misión";
		return mssg;
	}
}

