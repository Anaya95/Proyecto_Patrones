package game;

import java.io.*;
import java.util.Iterator;

import logic.*;

/*import org.springframework.boot.SpringApplication;*/
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
	
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out; 

	public static void main(String[] args) throws IOException {
		login();
	}
	
	public static void login() throws IOException {
		String email ="";
		String pass ="";
		
		System.out.println("Escribe tu correo: ");
		email = in.readLine();
		System.out.println("Escribe tu contraseña: ");
		pass = in.readLine();
		
		if(DataManager.login(email,pass)) {
			System.out.println("\n▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
			System.out.println("• Bienvenido! •");
			System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
			printMap();
		} else {
			System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("+ No se encontraron usuarios, por favor ingrese de nuevo los datos +");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
			login();
		}
	}
	
	public static void printMap() throws IOException {
		Iterator<char[]> map = DataManager.getMap();
		
		while(map.hasNext()) {
			for(char tile: map.next()) {
				System.out.print(tile);
			}
			System.out.print("\n");
		}

		start();
	}
	
	public static void start() throws IOException {
		char moveTo = '-';
		String mssg = "";
		
		System.out.println("\n▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
		System.out.println("• Hacia dónde quieres moverte? •");
		System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬\n");
		System.out.println("              ▲");
		System.out.println("              w");
		System.out.println("         ◄ a     d ►");
		System.out.println("              s");
		System.out.println("              ▼\n");
		System.out.println("• Escribe \"i\" para ver la información del mapa o \"x\" para salir");
		moveTo = in.readLine().toLowerCase().charAt(0);
		
		if(moveTo != 'x') {
			clearScreen();
			mssg = DataManager.movePlayer(moveTo);
				
			if(mssg != "" && mssg != null) {
				System.out.print(mssg);
			}
			printMap();
		}
	}
	
	public static void clearScreen() {  
		for (int i = 0; i < 50; ++i) System.out.println();
	}
}
