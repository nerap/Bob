package Main;
import Interface.*;
import Bob.Bob;
import Display.Display;
import Window.Window;

public class Main {
	public static Bob bot;
	public static Window fenetre;
	public static int turny = 0;

	public static void main(String[] args) {
		setup();
		game();
	}
	
	public static void setup() {
		Window.setup();
		Crash.setup();
	}
	
	public static void end() {
		Crash.end();
	}
	
	public static void game() {
		while (Window.game_start == false) {
			try {
				Thread.sleep(1500);
			}
			catch(Exception e) {
				System.out.println("hi");
			}
		}
		for (int i= 0; i < Bob.getTime(); i++) {
			Main.update();
			turny++;
		}	
		Main.end();
	}
	
	public static void update() {
		Bob.update(Crash.update());
		Display.display_update();
	}

}
