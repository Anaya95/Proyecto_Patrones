package logic;

public class CharactersFactory {
	private static CharactersFactory  factory;
   	private CharactersFactory() {}
   	
   	public static CharactersFactory getInstance() {
   		if (factory == null){
   			factory = new CharactersFactory();
    	}
    	return factory;
  	}

   	public CharactersFactory clone(){
		try {
			throw new CloneNotSupportedException();
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		return null; 
	}
   	
   	public Character getCharacter(int characterType, String name, int level, int life) {
   		Character character = null;
   		
   		if (characterType == 1){
   			character = new Player(name,level,life);
    	} else {
    		character = new NPC(name,level,life);
    	}
   		return character;
  	}
}
