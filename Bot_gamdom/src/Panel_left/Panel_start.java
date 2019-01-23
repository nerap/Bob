package Panel_left;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Dialog.Dialog;
import Window.Window;

public class Panel_start extends JPanel{
	private static final long serialVersionUID = 1L;

	public static JTextField champs_int = new JTextField("Start Bet");
	public static JTextField champs_max_profit = new JTextField("Maximum Profit");
	public static JTextField champs_max_loss = new JTextField("Maximum Loss");
	public static JTextField champs_time = new JTextField("Time to stay");

	public static CheckboxGroup bet_greed = new CheckboxGroup();
	public static CheckboxGroup multp_greed = new CheckboxGroup();
	
	public static JLabel asc = new JLabel("  1        2        3        4       5   ",JLabel.CENTER);
	public static JLabel dsc = new JLabel("  1        2        3        4       5   ",JLabel.CENTER);
	

	public static void setup() {
		champs_int.setPreferredSize(new Dimension(120,16));
		champs_int.addKeyListener(new Key_listener() {});
		champs_int.addMouseListener(new Mouse_listener() {});
		
		champs_max_profit.setPreferredSize(new Dimension(120,16));
		champs_max_profit.addMouseListener(new Mouse_listener() {});
		
		champs_max_loss.setPreferredSize(new Dimension(120,16));
		champs_max_loss.addMouseListener(new Mouse_listener() {});
		
		champs_time.setPreferredSize(new Dimension(120,16));
		champs_time.addMouseListener(new Mouse_listener() {});
		
		asc.setPreferredSize(new Dimension(200,16));
		dsc.setPreferredSize(new Dimension(200,16));
		

		Checkbox cb1 = new Checkbox("", bet_greed, false);
		cb1.setPreferredSize(new Dimension(30,25));
		Checkbox cb2 = new Checkbox("", bet_greed, false);
		cb2.setPreferredSize(new Dimension(30,25));
		Checkbox cb3 = new Checkbox("", bet_greed, false);
		cb3.setPreferredSize(new Dimension(30,25));
		Checkbox cb4 = new Checkbox("", bet_greed, false);
		cb4.setPreferredSize(new Dimension(30,25));
		Checkbox cb5 = new Checkbox("", bet_greed, false);
		cb5.setPreferredSize(new Dimension(30,25));
		
		Checkbox cz1 = new Checkbox("" ,multp_greed, false);
		cz1.setPreferredSize(new Dimension(25,25));
		Checkbox cz2 = new Checkbox("", multp_greed, false);
		cz2.setPreferredSize(new Dimension(25,25));
		Checkbox cz3 = new Checkbox("", multp_greed, false);
		cz3.setPreferredSize(new Dimension(25,25));
		Checkbox cz4 = new Checkbox("", multp_greed, false);
		cz4.setPreferredSize(new Dimension(25,25));
		Checkbox cz5 = new Checkbox("", multp_greed, false);
		cz5.setPreferredSize(new Dimension(25,25));
	
		//champs_int.setLocation(20,80 );
		//Window.panel_start.setLayout(new GridLayout(6, 1));
		Window.panel_start.add(champs_int);
		Window.panel_start.add(asc);
		Window.panel_start.add(cb1);
		Window.panel_start.add(cb2);
		Window.panel_start.add(cb3);
		Window.panel_start.add(cb4);
		Window.panel_start.add(cb5);
		Window.panel_start.add(dsc);
		Window.panel_start.add(cz1);
		Window.panel_start.add(cz2);
		Window.panel_start.add(cz3);
		Window.panel_start.add(cz4);
		Window.panel_start.add(cz5);
		Window.panel_start.add(champs_max_profit);
		Window.panel_start.add(champs_max_loss);
		Window.panel_start.add(champs_time);
		Window.panel_start.repaint();
	}


	protected static boolean valid_input(String text) throws NumberFormatException {
		try {
			Integer temp = Integer.parseInt(text);
			if (temp >= 10000 && temp <= 100000)
				return true;	
		}
		catch (NumberFormatException e) {
			Dialog.display_bet();
			return false;
		}
		Dialog.display_bet();
		return false;
	}
	
	
}
