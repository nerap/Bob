package Historique;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Window.Window;

public class Histo_pan extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public static JLabel temp_1 = new JLabel("",JLabel.CENTER);
	public static JLabel temp_2 = new JLabel("",JLabel.CENTER);
	public static JLabel temp_3 = new JLabel("",JLabel.CENTER);
	public static JLabel temp_4 = new JLabel("",JLabel.CENTER);
	public static JLabel temp_5 = new JLabel("",JLabel.CENTER);

	
	public static void setup() {
		Border border= BorderFactory.createTitledBorder("History");
		Window.panel_hist.setBorder(border);
		Window.panel_hist.setLayout(new GridLayout(5,1));
		Window.panel_hist.add(temp_1);
		Window.panel_hist.add(temp_2);
		Window.panel_hist.add(temp_3);
		Window.panel_hist.add(temp_4);
		Window.panel_hist.add(temp_5);
	}
	
	public static void update_hist(){
		if (Window.profit.size() >= 1) {		
			temp_1.setText(Window.df.format(Window.input.get(Window.profit.size() - 1)) + " -v- " + Window.df.format(Window.output.get(Window.profit.size()  - 1)) +  "   [ Earn ] = " + Window.profit.get(Window.profit.size() - 1));
			if (Window.input.get(Window.profit.size() - 1) < Window.output.get(Window.profit.size() - 1))
				temp_1.setForeground(Window.red);
			else
				temp_1.setForeground(Window.green);
		
		}
		if (Window.profit.size() >= 2) {		
			temp_2.setText(Window.df.format(Window.input.get(Window.profit.size() - 2)) + " -v- " + Window.df.format(Window.output.get(Window.profit.size()  - 2)) +  "   [ Earn ] = " + Window.profit.get(Window.profit.size() - 2));
			if (Window.input.get(Window.profit.size() - 2) < Window.output.get(Window.profit.size() - 2))
				temp_2.setForeground(Window.red);
			else
				temp_2.setForeground(Window.green);
		
		}
		if (Window.profit.size() >= 3) {		
			temp_3.setText(Window.df.format(Window.input.get(Window.profit.size() - 3)) + " -v- " + Window.df.format(Window.output.get(Window.profit.size()  - 3)) +  "   [ Earn ] = " + Window.profit.get(Window.profit.size() - 3));
			if (Window.input.get(Window.profit.size() - 3) < Window.output.get(Window.profit.size() - 3))
				temp_3.setForeground(Window.red);
			else
				temp_3.setForeground(Window.green);
		
		}
		if (Window.profit.size() >= 4) {		
			temp_4.setText(Window.df.format(Window.input.get(Window.profit.size() - 4)) + " -v- " + Window.df.format(Window.output.get(Window.profit.size()  - 4)) +  "   [ Earn ] = " + Window.profit.get(Window.profit.size() - 4));
			if (Window.input.get(Window.profit.size() - 4) < Window.output.get(Window.profit.size() - 4))
				temp_4.setForeground(Window.red);
			else
				temp_4.setForeground(Window.green);
		
		}
		if (Window.profit.size() >= 5) {		
			temp_5.setText(Window.df.format(Window.input.get(Window.profit.size() - 5)) + " -v- " + Window.df.format(Window.output.get(Window.profit.size()  - 5)) +  "   [ Earn ] = " + Window.profit.get(Window.profit.size() - 5));
			if (Window.input.get(Window.profit.size() - 5) < Window.output.get(Window.profit.size() - 5))
				temp_5.setForeground(Window.red);
			else
				temp_5.setForeground(Window.green);
		
		}
	}
}
