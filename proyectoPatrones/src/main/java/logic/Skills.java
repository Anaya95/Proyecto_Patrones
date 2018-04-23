package logic;

public class Skills {
	private int mountainClimber;
	private int swimmer;
	private int visibility;
	
	Skills(){
		this.mountainClimber = 0;
		this.swimmer = 0;
	}
	
	Skills(int mountainClimber, int swimmer, int visibility){
		this.mountainClimber = mountainClimber;
		this.swimmer = swimmer;
		this.visibility = visibility;
	}
	
	public int getMountainClimber() {
		return this.mountainClimber;
	}
	
	public int getSwimmer() {
		return this.swimmer;
	}
	
	public int getVisibility() {
		return this.visibility;
	}
}
