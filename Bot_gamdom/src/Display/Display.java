package Display;
import Bob.Bob;
import Main.Main;
import Historique.Histo_pan;
import Panel_left.Panel_game;
import Panel_output.Output;
import Window.Window;

public abstract class Display {
 
	public static void reset () {
		display_update();
	}
	

	public static void display_update() {
		display_panel();
		display_output();
		display_stat();
		Histo_pan.update_hist();
	}
	
	public static void display_stat() {
		if (Bob.getGain() >= 0)
			Panel_game.gain.setForeground(Window.green);
		else
			Panel_game.gain.setForeground(Window.red);
		
		if (Bob.getTotal() >= Bob.temp_total)
			Panel_game.gain.setForeground(Window.green);
		else
			Panel_game.gain.setForeground(Window.red);
		return;
	}
	
	public static void display_panel() {
		Panel_game.total.setText(String.valueOf(Bob.getTotal()));
		Panel_game.gain.setText(String.valueOf(Bob.getGain()));
		Panel_game.max_profit.setText(String.valueOf(Bob.getMax_gain()));
		Panel_game.max_loss.setText(String.valueOf(Bob.getMax_loss()));
		Panel_game.turn.setText(String.valueOf(Main.turny));
	}
	
	public static void display_output() {
		Output.bet.setText(String.valueOf(Bob.getBet()));
		Output.multp.setText(Window.df.format(Bob.getMultp()));
		return;
	}
}
