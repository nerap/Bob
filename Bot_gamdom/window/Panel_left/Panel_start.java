package Panel_left;

import java.awt.CheckboxGroup;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Dialog.Dialog;
import Window.Window;

public class Panel_start extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public static final int const_width_textfield	= 170;
	public static final int const_height_textfield 	= 25;
	

	public static JTextField champs_int 		= new JTextField("Bet : 1000 to 500000");
	public static JTextField champs_bet_greed 	= new JTextField("Greed(Bet) : 1 to 5 (float)");
	public static JTextField champs_multp_greed = new JTextField("Greed(Multp) : 1 to 5 (float)");
	public static JTextField champs_max_profit 	= new JTextField("Max Profit : 10 average (in %)");
	public static JTextField champs_max_loss 	= new JTextField("Max Loss : 15 average (in %)");
	public static JTextField champs_time 		= new JTextField("Time : From 1 to 100 (turn)");

	public static CheckboxGroup bet_greed 	= new CheckboxGroup();
	public static CheckboxGroup multp_greed = new CheckboxGroup();
	
	
	

	public static void setup() {	
		setup_mouse_listener();	
		setup_dimension(const_width_textfield, const_height_textfield);
		setup_add_panel();
		Window.panel_start.repaint();
	}
	
	
	public static void setup_dimension(int x, int y) {
		champs_int.setPreferredSize(new Dimension(x, y));
		champs_bet_greed.setPreferredSize(new Dimension(x, y));
		champs_multp_greed.setPreferredSize(new Dimension(x, y));
		champs_max_profit.setPreferredSize(new Dimension(x, y));
		champs_max_loss.setPreferredSize(new Dimension(x, y));		
		champs_time.setPreferredSize(new Dimension(x, y));
	}
	
	public static void setup_mouse_listener() {
		champs_int.addMouseListener(new Mouse_listener() {});
		champs_bet_greed.addMouseListener(new Mouse_listener() {});
		champs_multp_greed.addMouseListener(new Mouse_listener() {});
		champs_max_profit.addMouseListener(new Mouse_listener() {});
		champs_max_loss.addMouseListener(new Mouse_listener() {});		
		champs_time.addMouseListener(new Mouse_listener() {});
	}
	
	public static void setup_add_panel() {
		Window.panel_start.add(champs_int);
		Window.panel_start.add(champs_bet_greed);
		Window.panel_start.add(champs_multp_greed);
		Window.panel_start.add(champs_max_profit);
		Window.panel_start.add(champs_max_loss);
		Window.panel_start.add(champs_time);
	}


	public static boolean valid_int_total(String text) throws NumberFormatException {
		try {
			Integer temp = Integer.parseInt(text);
			if (temp >= 1000 && temp <= 500000)
				return true;	
		}
		catch (NumberFormatException e) {
			Dialog.display_bet();
			return false;
		}
		Dialog.display_bet();
		return false;
	}
	
	public static boolean valid_percent_max_profit(String text) throws NumberFormatException{
		try {
			Integer temp = Integer.parseInt(text);
			if (temp >= 1 && temp < 100)
				return true;
		}
		catch(NumberFormatException e) {
			Dialog.display_max_profit();
			return false;
		}
		Dialog.display_max_profit();
		return false;
	}
	public static boolean valid_percent_max_loss(String text) throws NumberFormatException{
		try {
			Integer temp = Integer.parseInt(text);
			if (temp >= 1 && temp < 100)
				return true;
		}
		catch(NumberFormatException e) {
			Dialog.display_max_loss();
			return false;
		}
		Dialog.display_max_loss();
		return false;
	}
	
	
	public static boolean valid_int_turn(String text) throws NumberFormatException {
		try {
			Integer temp = Integer.parseInt(text);
			if (temp >= 1 && temp <= 100)
				return true;	
		}
		catch (NumberFormatException e) {
			Dialog.display_turn();
			return false;
		}
		Dialog.display_turn();
		return false;
	}
	
	
	public static boolean valid_float_bet_greed(String text) {
		try {
			Float temp = Float.valueOf(text);
			if (temp >= 1.00f && temp <= 5.00f)
				return true;	
		}
		catch (NumberFormatException e) {
			Dialog.display_float_bet_greed();
			return false;
		}
		Dialog.display_float_bet_greed();
		return false;
	}
	public static boolean valid_float_multp_greed(String text) {
		try {
			Float temp = Float.valueOf(text);
			if (temp >= 1.00f && temp <= 5.00f)
				return true;	
		}
		catch (NumberFormatException e) {
			Dialog.display_float_multp_greed();
			return false;
		}
		Dialog.display_float_multp_greed();
		return false;
	}
	


}
