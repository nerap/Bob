package Panel_left;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Dialog.Dialog;
import Window.Window;

public class Panel_game extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public static JLabel gain = new JLabel("0", JLabel.CENTER);
	public static JLabel total = new JLabel("0", JLabel.CENTER);
	public static JTextField champs_float = new JTextField();

	
	public static void setup() {
		champs_float.addKeyListener(new Key_listener() {});
		Window.panel_game.setLayout(new GridLayout(9, 2));
		Window.panel_game.add(champs_float);
		Window.panel_game.add(new JLabel("Total", JLabel.CENTER));
		Window.panel_game.add(total);
		Window.panel_game.add(new JLabel("Gain", JLabel.CENTER));
		Window.panel_game.add(gain);
		Window.panel_game.add(new JLabel("Total", JLabel.CENTER));
		Window.panel_game.add(total);
		Window.panel_game.add(new JLabel("Gain", JLabel.CENTER));
		Window.panel_game.add(gain);
	}
	
	protected static boolean valid_float(String text) throws NumberFormatException{
		try {
			float boat = Float.parseFloat(text);
			if (boat >= 1.00f)
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
