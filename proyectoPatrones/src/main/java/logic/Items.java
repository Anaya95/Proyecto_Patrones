package logic;

public enum Items {
	LIFE(10),
	SWORD(40),
	BOAT(100),
	ROPE(10),
	CLIMBINGBOOTS(40),
	TORCH(20);
	private final int increaseSkill;
	
	Items(int increaseSkill){
		this.increaseSkill = increaseSkill;
	}
	
	public int getIncreaseSkill() {
		return increaseSkill;
	}
}
