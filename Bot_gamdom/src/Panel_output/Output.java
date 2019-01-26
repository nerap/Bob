package Panel_output;

import javax.swing.border.Border;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Window.Window;

public class Output extends JPanel{
	private static final long serialVersionUID = 1L;
	public static JLabel bet = new JLabel("0", JLabel.CENTER);
	public static JLabel multp = new JLabel("1.00", JLabel.CENTER);
	
	public static void setup() {
		Border border;
		border = BorderFactory.createLineBorder(Color.blue, 1, true);
		Window.panel_output.setBorder(border);
		Window.panel_output.setLayout(new GridLayout(4,1));
		Window.panel_output.add(new JLabel("Bet", JLabel.CENTER));
		Window.panel_output.add(bet);
		Window.panel_output.add(new JLabel("Out", JLabel.CENTER));
		Window.panel_output.add(multp);
	}

}
