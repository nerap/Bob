package Panel_left;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Bob.Bob;
import Dialog.Dialog;
import Display.Display;
import Window.Window;

public class Key_listener implements KeyListener{
	@Override
	public void keyReleased(KeyEvent e) {							
	}

	@Override
	public void keyTyped(KeyEvent e) {				
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Panel_game.champs_float.setEnabled(false);
			if (Window.game_start == true) {				   
				Panel_game.valid_float(Panel_game.champs_float.getText());
				Bob.update(Float.valueOf(Panel_game.champs_float.getText()));
				Display.display_update();
			}
			else
				Dialog.help();
			Panel_game.champs_float.setText("");
			Panel_game.champs_float.setEnabled(true);
			}
		}
}
