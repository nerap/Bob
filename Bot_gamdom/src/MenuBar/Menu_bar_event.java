package MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Main.java;

import Bob.Bob;
import Display.Display;
import Panel_left.Panel_start;
import Window.Window;

public class Menu_bar_event implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		if (Panel_start.valid_input(Panel_start.champs_int.getText()) == true) {
			Menu_bar.menu_item_start.setEnabled(false);
			Menu_bar.menu_item_reset.setEnabled(true);
			Panel_start.champs_int.setEnabled(false);
	    	Main.bot = new Bob(Integer.valueOf(Panel_start.champs_int.getText()));
	    	Display.display_update();
	    	Window.game_start = true;
	    	Panel_start.champs_int.setText("");
	    	Panel_start.champs_int.setEnabled(true);
	    	Window.launch();
		}
	}
}
