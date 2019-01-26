package MenuBar;

import Main.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Bob.Bob;
import Dialog.Dialog;
import Display.Display;
import Panel_left.Panel_start;
import Window.Window;

public class Menu_bar_event implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		String total = Panel_start.champs_int.getText();
		String bet_greed = Panel_start.champs_bet_greed.getText();
		String multp_greed = Panel_start.champs_multp_greed.getText();
		String max_profit = Panel_start.champs_max_profit.getText();
		String max_loss = Panel_start.champs_max_loss.getText();
		String time = Panel_start.champs_time.getText();
		if (Panel_start.valid_int(total) == true && Panel_start.valid_int(max_profit) == true
		&& Panel_start.valid_int(max_loss) == true && Panel_start.valid_int(time) == true
		&& Panel_start.valid_float(bet_greed) == true &&  Panel_start.valid_float(multp_greed)) {
			Menu_bar.menu_item_start.setEnabled(false);
			Menu_bar.menu_item_reset.setEnabled(true);
			
			
			Panel_start.champs_int.setEnabled(false);
			Panel_start.champs_bet_greed.setEnabled(false);
			Panel_start.champs_multp_greed.setEnabled(false);
			Panel_start.champs_max_profit.setEnabled(false);
			Panel_start.champs_max_loss.setEnabled(false);
			Panel_start.champs_time.setEnabled(false);
			

	    	Main.bot = new Bob(Integer.valueOf(total), Float.valueOf(bet_greed), Float.valueOf(multp_greed),Integer.valueOf(max_profit),Integer.valueOf(max_loss),Integer.valueOf(time));
	    	Display.display_update();
	    	Window.game_start = true;
	    	Window.launch();
		}
		else
			Dialog.help();
	}
}
