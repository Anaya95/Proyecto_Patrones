package logic;

public class User {
	private String nombre;
	private String apell1;
	private String apell2;
	
	public User() {
		this.nombre = "User";
		this.apell1 = "Lastname1";
		this.apell2 = "Lastname2";
	}
	
	public User(String nombre, String apell1, String apell2) {
		this.nombre = nombre;
		this.apell1 = apell1;
		this.apell2 = apell2;
	}
}
