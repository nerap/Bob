package Panel_left;
import java.awt.Dimension;
import java.awt.GridLayout;

import Bob.Bob;

import javax.swing.JLabel;
import javax.swing.JPanel;
import Window.Window;

public class Panel_game extends JPanel {
	private static final long serialVersionUID = 1L;
	public static final int const_width_textfield	= 150;
	public static final int const_height_textfield 	= 20;
	public static JLabel stat = new JLabel("Statistic", JLabel.CENTER);
	public static JLabel gain;
	public static JLabel total;
	public static JLabel max_profit;
	public static JLabel max_loss;
	public static JLabel turn;

	
	public static void setup() {
		setup_set_text();
		setup_resize(const_width_textfield, const_height_textfield);
		setup_add_panel();
	}
	
	public static void setup_set_text() {
		gain 		= new JLabel("0", JLabel.CENTER);
		total 		= new JLabel(String.valueOf(Bob.getTotal()), JLabel.CENTER);
		max_profit 	= new JLabel(String.valueOf(Bob.getMax_gain()), JLabel.CENTER);
		max_loss 	= new JLabel(String.valueOf(Bob.getMax_loss()), JLabel.CENTER);
		turn 		= new JLabel("0", JLabel.CENTER);
	}
	
	public static void setup_resize(int x, int y) {
		stat.setPreferredSize(new Dimension(x, y));
		total.setPreferredSize(new Dimension(x, y));
		gain.setPreferredSize(new Dimension(x, y));
		max_profit.setPreferredSize(new Dimension(x, y));
		max_loss.setPreferredSize(new Dimension(x, y));
		turn.setPreferredSize(new Dimension(x, y));
	}
	
	public static void setup_add_panel() {
		Window.panel_game.setLayout(new GridLayout(6,2));
		Window.panel_game.add(stat);
		Window.panel_game.add(new JLabel());
		Window.panel_game.add(new JLabel("Total", JLabel.LEFT));
		Window.panel_game.add(total);
		Window.panel_game.add(new JLabel("Gain", JLabel.LEFT));
		Window.panel_game.add(gain);
		Window.panel_game.add(new JLabel("Max Profit", JLabel.LEFT));
		Window.panel_game.add(max_profit);
		Window.panel_game.add(new JLabel("Max Loss", JLabel.LEFT));
		Window.panel_game.add(max_loss);
		Window.panel_game.add(new JLabel("Turn", JLabel.LEFT));
		Window.panel_game.add(turn);
	}

}
