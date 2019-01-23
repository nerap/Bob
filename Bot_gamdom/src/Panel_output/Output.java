package Panel_output;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Window.Window;

public class Output extends JPanel{
	private static final long serialVersionUID = 1L;
	public static JLabel bet = new JLabel("0", JLabel.CENTER);
	public static JLabel multp = new JLabel("1.00", JLabel.CENTER);
	
public static void setup() {
	Window.panel_output.setLayout(new GridLayout(4,1));
	Window.panel_output.add(new JLabel("Bet", JLabel.CENTER));
	Window.panel_output.add(bet);
	Window.panel_output.add(new JLabel("Out", JLabel.CENTER));
	Window.panel_output.add(multp);
}

}
