package Panel_left;

import java.awt.CheckboxGroup;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Dialog.Dialog;
import Window.Window;

public class Panel_start extends JPanel{
	private static final long serialVersionUID = 1L;

	public static JTextField champs_int = new JTextField("Start Bet");
	public static JTextField champs_bet_greed = new JTextField("Bet Greed");
	public static JTextField champs_multp_greed = new JTextField("Multp Greed");
	public static JTextField champs_max_profit = new JTextField("Maximum Profit");
	public static JTextField champs_max_loss = new JTextField("Maximum Loss");
	public static JTextField champs_time = new JTextField("Time to stay");

	public static CheckboxGroup bet_greed = new CheckboxGroup();
	public static CheckboxGroup multp_greed = new CheckboxGroup();
	
	
	

	public static void setup() {
		champs_int.setPreferredSize(new Dimension(120,20));
		champs_int.addKeyListener(new Key_listener() {});
		champs_int.addMouseListener(new Mouse_listener() {});
		

		champs_bet_greed.setPreferredSize(new Dimension(120,20));
		champs_bet_greed.addKeyListener(new Key_listener() {});
		champs_bet_greed.addMouseListener(new Mouse_listener() {});
		
		
		champs_multp_greed.setPreferredSize(new Dimension(120,20));
		champs_multp_greed.addKeyListener(new Key_listener() {});
		champs_multp_greed.addMouseListener(new Mouse_listener() {});
			
		
		champs_max_profit.setPreferredSize(new Dimension(120,20));
		champs_max_profit.addKeyListener(new Key_listener() {});
		champs_max_profit.addMouseListener(new Mouse_listener() {});
		
		champs_max_loss.setPreferredSize(new Dimension(120,20));
		champs_max_loss.addKeyListener(new Key_listener() {});
		champs_max_loss.addMouseListener(new Mouse_listener() {});
		
		champs_time.setPreferredSize(new Dimension(120,20));
		champs_time.addKeyListener(new Key_listener() {});
		champs_time.addMouseListener(new Mouse_listener() {});
		
		

	
	
		Window.panel_start.add(champs_int);
		Window.panel_start.add(champs_bet_greed);
		Window.panel_start.add(champs_multp_greed);
		Window.panel_start.add(champs_max_profit);
		Window.panel_start.add(champs_max_loss);
		Window.panel_start.add(champs_time);
		Window.panel_start.repaint();
	}


	public static boolean valid_int(String text) throws NumberFormatException {
		try {
			Integer temp = Integer.parseInt(text);
			if (temp >= 500 && temp <= 500000)
				return true;	
		}
		catch (NumberFormatException e) {
			Dialog.display_bet();
			return false;
		}
		Dialog.display_bet();
		return false;
	}


	
	
	public static boolean valid_float(String text) {
		try {
			Float temp = Float.valueOf(text);
			if (temp >= 1.00f && temp <= 5.00f)
				return true;	
		}
		catch (NumberFormatException e) {
			Dialog.display_float();
			return false;
		}
		Dialog.display_float();
		return false;
	}
	


}
