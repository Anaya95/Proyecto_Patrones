package logic;

public class User {
	private int ID;
	private String nombre;
	private String apell1;
	private String apell2;
	private String email;
	
	public User() {
		this.nombre = "User";
		this.apell1 = "Lastname1";
		this.apell2 = "Lastname2";
		this.email = "email";
	}
	
	public User(int ID, String nombre, String apell1, String apell2, String email) {
		this.ID = ID;
		this.nombre = nombre;
		this.apell1 = apell1;
		this.apell2 = apell2;
		this.email = email;
	}

	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApell1() {
		return apell1;
	}

	public void setApell1(String apell1) {
		this.apell1 = apell1;
	}

	public String getApell2() {
		return apell2;
	}

	public void setApell2(String apell2) {
		this.apell2 = apell2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
