package MenuBar;

import Main.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Bob.Bob;
import Dialog.Dialog;
import Panel_left.Panel_start;
import Window.Window;

public class Menu_bar_event implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		
		String	total 		= 	Panel_start.champs_int.getText();
		String	bet_greed 	= 	Panel_start.champs_bet_greed.getText();
		String	multp_greed = 	Panel_start.champs_multp_greed.getText();
		String	max_profit 	= 	Panel_start.champs_max_profit.getText();
		String	max_loss 	= 	Panel_start.champs_max_loss.getText();
		String	time 		= 	Panel_start.champs_time.getText();
		
		
		if(Panel_start.valid_int_turn(time) && Integer.valueOf(time) == 1){
			unset_menu_item_enable();
			unset_text_enable();
			
	    	Main.bot = new Bob(
	    			45000,
	    			3.00f,
	    			3.00f,
	    			3000,
	    			4500,
	    			15
	    			);
	    	Window.launch();
		}
		else if (Panel_start.valid_int_total(total) 
			&&  Panel_start.valid_percent_max_profit(max_profit)
			&& Panel_start.valid_percent_max_loss(max_loss) 
			&& Panel_start.valid_float_bet_greed(bet_greed) 
			&&  Panel_start.valid_float_multp_greed(multp_greed)
			&&  Panel_start.valid_int_turn(time)) {
			
			int 	tmp_total 			=	Integer.valueOf(total);
			float 	tmp_bet_greed 		=	Float.valueOf(bet_greed);
			float 	tmp_multp_greed		=	Float.valueOf(multp_greed);
			int 	tmp_max_profit 		= 	Integer.valueOf(max_profit);;
			int 	tmp_max_loss 		=	Integer.valueOf(max_loss);
			int 	tmp_time 			=	Integer.valueOf(time);
			
			
			unset_menu_item_enable();
			unset_text_enable();
			
	    	Main.bot = new Bob(
	    			tmp_total,
	    			tmp_bet_greed,
	    			tmp_multp_greed,
	    			(int)((tmp_max_profit * tmp_total)/100),
	    			(int)((tmp_max_loss * tmp_total)/100),
	    			tmp_time
	    			);
	    	Window.launch();
	    	return;
		}
		else
			Dialog.help();
			
	}
	
	public void unset_menu_item_enable() {
		Menu_bar.menu_item_start.setEnabled(false);
		Menu_bar.menu_item_reset.setEnabled(true);
		Menu_bar.menu_item_play.setEnabled(true);
		Menu_bar.menu_exit.setEnabled(true);
	}
	
	public void unset_text_enable() {
		Panel_start.champs_int.setEnabled(false);
		Panel_start.champs_bet_greed.setEnabled(false);
		Panel_start.champs_multp_greed.setEnabled(false);
		Panel_start.champs_max_profit.setEnabled(false);
		Panel_start.champs_max_loss.setEnabled(false);
		Panel_start.champs_time.setEnabled(false);
	} 
}
