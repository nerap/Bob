package Panel_left;
import java.awt.Dimension;

import Bob.Bob;

import javax.swing.JLabel;
import javax.swing.JPanel;
import Window.Window;

public class Panel_game extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public static JLabel stat = new JLabel("Statistic", JLabel.CENTER);
	public static JLabel gain;
	public static JLabel total;
	public static JLabel max_profit;
	public static JLabel max_loss;
	public static JLabel turn;

	
	public static void setup() {
		gain = new JLabel("0", JLabel.CENTER);
		total = new JLabel(String.valueOf(Bob.getTotal()), JLabel.CENTER);
		max_profit = new JLabel(String.valueOf(Bob.getMax_gain()), JLabel.CENTER);
		max_loss = new JLabel(String.valueOf(Bob.getMax_loss()), JLabel.CENTER);
		turn = new JLabel("0", JLabel.CENTER);
		stat.setPreferredSize(new Dimension(150,20));
		total.setPreferredSize(new Dimension(150,20));
		gain.setPreferredSize(new Dimension(150,20));
		max_profit.setPreferredSize(new Dimension(150,20));
		max_loss.setPreferredSize(new Dimension(150,20));
		turn.setPreferredSize(new Dimension(150,20));
		Window.panel_game.add(stat);
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
