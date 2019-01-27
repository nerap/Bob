package Main;
import Interface.*;
import Bob.Bob;
import Display.Display;
import Window.Window;

public class Main {
	public static Bob bot;
	public static Window fenetre;
	public static int turny = 1;

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
				Thread.sleep(750);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		do {
			Main.update();
			turny += 1;
		} while(Window.game_start == true && turny < 10 && Bob.getGain() < Bob.getMax_gain() && -Bob.getMax_loss() < Bob.getGain());
		end();
	}
	
	public static void update() {
		Bob.update(Crash.update());
		Display.display_update();
	}

}
