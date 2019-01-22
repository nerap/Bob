import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;

public abstract class Bot implements KeyListener{
	
	public static JFrame fenetre = new JFrame("Bob");
	public static Color red =  new Color(167,61,61);
	public static Color green =  new Color(61,167,61);
	
	
	/*---------------------------------------------------------------------------------------------*/
	/*---------------------------------------------------------------------------------------------*/
	
	
	public static JTextField champs = new JTextField("Start Bet");
	public static JLabel gain = new JLabel("0", JLabel.CENTER);
	public static JLabel total = new JLabel("0", JLabel.CENTER);
	public static JLabel bet = new JLabel("0", JLabel.CENTER);
	public static JLabel multp = new JLabel("1.00", JLabel.CENTER);
	
	
	/*---------------------------------------------------------------------------------------------*/
	
	public static JLabel temp_1 = new JLabel("1 - ", JLabel.CENTER);
	public static JLabel temp_2 = new JLabel("2 - ", JLabel.CENTER);
	public static JLabel temp_3 = new JLabel("3 - ", JLabel.CENTER);
	public static JLabel temp_4 = new JLabel("4 - ", JLabel.CENTER);
	public static JLabel temp_5 = new JLabel("5 - ", JLabel.CENTER);
	
	
	/*---------------------------------------------------------------------------------------------*/
	
	
	
	public static JPanel panel_parent = new JPanel();
	
	public static JPanel panel_parent_output = new JPanel();
	public static JPanel panel_parent_money = new JPanel();
	public static JPanel panel_parent_histo = new JPanel();
	
	
	public static JPanel panel_parent_output_bet = new JPanel();
	public static JPanel panel_parent_output_multp = new JPanel();
	
	public static JPanel panel_parent_money_total = new JPanel();
	public static JPanel panel_parent_money_gain = new JPanel();
	
	
	
	/*---------------------------------------------------------------------------------------------*/
	/*---------------------------------------------------------------------------------------------*/
	
	
	public static JMenuBar menu_bar = new JMenuBar();
	
	/*---------------------------------------------------------------------------------------------*/
	
	public static JMenu menu = new JMenu("Menu");
	public static JMenu help = new JMenu("Help ?");	
	
	/*---------------------------------------------------------------------------------------------*/
	
	
	public static JMenuItem menu_item_start = new JMenuItem("Start");
	public static JMenuItem menu_item_reset = new JMenuItem("Reset");
	public static JMenuItem menu_help = new JMenuItem("Guide");
	
	/*---------------------------------------------------------------------------------------------*/
	
	public static JOptionPane helping = new JOptionPane();
	public static JOptionPane invalid_input = new JOptionPane();
	
	
	/*---------------------------------------------------------------------------------------------*/
	/*---------------------------------------------------------------------------------------------*/
	
	public static Bob bot;
	public static boolean game_start = false;
	public static ArrayList<Float> input = new ArrayList<Float>();
	public static ArrayList<Float> output = new ArrayList<Float>();
	public static ArrayList<Integer> profit = new ArrayList<Integer>();
	
	/*---------------------------------------------------------------------------------------------*/
	
	public static DecimalFormat df = new DecimalFormat("###.##");
	
	/*---------------------------------------------------------------------------------------------*/
	
	public static final String title_help_text = new String("How it works");
	public static final String help_text = new String("-First of all, enter the amount of money you want let to Bob\n -Go in the menu and click on start \n -After that Bob will give u you an output(the number that you have to stop) \n -When the crash is done enter the result and depend on it bob will give the amount to pay and when to stop each round \n ! IMPORTANT : THE CRASH ORDER IS REALLY IMPORTANT DO NOT BREAK IT");
	
	
	/*---------------------------------------------------------------------------------------------*/
	/*---------------------------------------------------------------------------------------------*/
    
 
	public static void setup() {
				
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(400, 230);
				
		/*---------------------------------------------------------------------------------------------*/
		/*---------------------------------------------------------------------------------------------*/
			
			
		menu_item_start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Bot.valid_input(Bot.champs.getText()) == true) {
					Bot.total.setText(Bot.champs.getText());
					Bot.champs.setText("Multiplicator");
					Bot.menu_item_start.setEnabled(false);
					Bot.menu_item_reset.setEnabled(true);
					game_start = true;
				}
			}
		});
			
		menu_item_reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Bot.reset();
			}
		});
		
		/*---------------------------------------------------------------------------------------------*/
		
		menu_help.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, Bot.help_text, Bot.title_help_text, JOptionPane.INFORMATION_MESSAGE);		
			}
		});
		
		
		/*---------------------------------------------------------------------------------------------*/
		/*---------------------------------------------------------------------------------------------*/
		
		
		champs.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {							
			}

			@Override
			public void keyTyped(KeyEvent e) {				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				 if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				     if (game_start == false && Bot.valid_input(Bot.champs.getText()) == true) {
				    	 champs.setEnabled(false);
				    	 bot = new Bob(Integer.valueOf(Bot.champs.getText()));
				    	 Bot.display_update();
				    	 game_start = true;
				    	 Bot.champs.setText("");
				    	 champs.setEnabled(true);
				     }
				     else if (game_start == true && Bot.valid_float(Bot.champs.getText()) == true) {
				    	 champs.setEnabled(false);
				    	 Bob.update(Float.valueOf((Bot.champs.getText())));
				    	 Bot.display_update();
				    	 Bot.champs.setText("");
				    	 champs.setEnabled(true);
				     }
				}
			}
		});
		
		/*---------------------------------------------------------------------------------------------*/
		
		champs.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Bot.champs.setText("");			
			}
			
			@Override
			public void mouseExited(MouseEvent e) {	
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {		
			}
		});
		
		
		/*---------------------------------------------------------------------------------------------*/
		/*---------------------------------------------------------------------------------------------*/
		
		panel_parent_money_total.setLayout(new GridLayout(2,1));	
		panel_parent_money_total.add(new JLabel("Total", JLabel.CENTER));
		panel_parent_money_total.add(total);
		
		panel_parent_money_gain.setLayout(new GridLayout(2,1));
		panel_parent_money_gain.add(new JLabel("Gain", JLabel.CENTER));
		panel_parent_money_gain.add(gain);		
		
		panel_parent_money.setLayout(new GridLayout(2,1));		
		panel_parent_money.add(panel_parent_money_total);
		panel_parent_money.add(panel_parent_money_gain);
		
		/*---------------------------------------------------------------------------------------------*/
		
		panel_parent_output_bet.setLayout(new GridLayout(2,1));
		panel_parent_output_bet.add(new JLabel("Bet", JLabel.CENTER));
		panel_parent_output_bet.add(bet);
		
		
		panel_parent_output_multp.setLayout(new GridLayout(2,1));
		panel_parent_output_multp.add(new JLabel("Mutlp", JLabel.CENTER));
		panel_parent_output_multp.add(multp);
		
		panel_parent_output.setLayout(new GridLayout(2,1));
		panel_parent_output.add(panel_parent_output_bet);
		panel_parent_output.add(panel_parent_output_multp);
		
		/*---------------------------------------------------------------------------------------------*/
		
		panel_parent_histo.setLayout(new GridLayout(5,1));
		panel_parent_histo.add(temp_1);
		panel_parent_histo.add(temp_2);
		panel_parent_histo.add(temp_3);
		panel_parent_histo.add(temp_4);
		panel_parent_histo.add(temp_5);
		
		/*---------------------------------------------------------------------------------------------*/
		
		help.add(menu_help);

		/*---------------------------------------------------------------------------------------------*/
		
		champs.setPreferredSize(new Dimension(100, 40));
		
		/*---------------------------------------------------------------------------------------------*/		

		menu_item_reset.setEnabled(false);
		
		/*---------------------------------------------------------------------------------------------*/
					
		menu.add(menu_item_start);
		menu.add(menu_item_reset);
		
		/*---------------------------------------------------------------------------------------------*/
		
		menu_bar.add(menu);
		menu_bar.add(help);
		
		/*---------------------------------------------------------------------------------------------*/
		
		fenetre.setJMenuBar(menu_bar);
		fenetre.setLayout(new GridLayout(2,2));
		
		fenetre.add(panel_parent_money);
		fenetre.add(panel_parent_output);
		fenetre.add(champs);
		fenetre.add(panel_parent_histo);
		
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
	}
	

	/*---------------------------------------------------------------------------------------------*/
	

	public static void reset () {
		menu_item_start.setEnabled(true);
		menu_item_reset.setEnabled(false);
		input.removeAll((Collection<Float>) input);
		output.removeAll((Collection<Float>) output);
		bet.setText("0");
		multp.setText("1.00");
		total.setText("0");
		gain.setText("0");
		Bob.setTotal(0);
		Bob.setGain(0);
		Bob.setBet(0);
		Bob.setMultp(1.00f);
		display_update();
		game_start = false;
	}
	
	
	/*---------------------------------------------------------------------------------------------*/
	
	protected static boolean valid_float(String text) throws NumberFormatException{
		try {
			float boat = Float.parseFloat(text);
			if (boat >= 1.00f)
				return true;
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Make sure that you input is a float with this format (\"###.##\")_\n The minimum input is 1.00 ", "Invalid input", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		JOptionPane.showMessageDialog(null, "Make sure that you input is a float with this format (\"###.##\")_\n The minimum input is 1.00 ", "Invalid input", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	
	/*---------------------------------------------------------------------------------------------*/

	protected static boolean valid_input(String text) throws NumberFormatException {
		try {
			Integer temp = Integer.parseInt(text);
			if (temp >= 10000 && temp <= 100000)
				return true;
			
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Make sure that you input is an unsigned integer \n The minimum input is 10 000 and the maximum is 100 000", "Invalid input", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		JOptionPane.showMessageDialog(null, "Make sure that you input is an unsigned integer \n The minimum input is 10 000 and the maximum is 100 000", "Invalid input", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	
	/*---------------------------------------------------------------------------------------------*/

	
	protected static void display_histo() {
		
		if (input.size() >= 1) {		
			temp_1.setText("[1] - " + df.format(input.get(input.size() - 1)) + " vs " + df.format(output.get(input.size() - 1)) +  "   [ Earn ] = " + profit.get(input.size() - 1));
			if (input.get(input.size() - 1) < output.get(input.size() - 1))
				temp_1.setForeground(red);
			else
				temp_1.setForeground(green);
		
		}
		
		if (input.size() >= 2) {
			temp_2.setText("[2] - " + df.format(input.get(input.size() - 2)) + " vs " + df.format(output.get(input.size() - 2)) +  "   [ Earn ] = " + profit.get(input.size() - 2));
			if (input.get(input.size() - 2) < output.get(input.size() - 2))
				temp_2.setForeground(red);
			else
				temp_2.setForeground(green);
		}
		
		if (input.size() >= 3) {
			temp_3.setText("[3] - " + df.format(input.get(input.size() - 3)) + " vs " + df.format(output.get(input.size() - 3)) +  "   [ Earn ] = " + profit.get(input.size() - 3));
			if (input.get(input.size() - 3) < output.get(input.size() - 3))
				temp_3.setForeground(red);
			else
				temp_3.setForeground(green);
		}
		
		if (input.size() >= 4) {
			temp_4.setText("[4] - " + df.format(input.get(input.size() - 4)) + " vs " + df.format(output.get(input.size() - 4)) +  "   [ Earn ] = " + profit.get(input.size() - 4));
			if (input.get(input.size() - 4) < output.get(input.size() - 4))
				temp_4.setForeground(red);
			else
				temp_4.setForeground(green);
		}
		
		if (input.size() >= 5) {
			temp_5.setText("[5] - " + df.format(input.get(input.size() - 5)) + " vs " + df.format(output.get(input.size() - 5)) + "   [ Earn ] = " + profit.get(input.size() - 5));
			if (input.get(input.size() - 5) <= output.get(input.size() - 5))
				temp_5.setForeground(red);
			else
				temp_5.setForeground(green);
		}
	}

	/*---------------------------------------------------------------------------------------------*/
	
	public static void display_update() {
		total.setText(String.valueOf(Bob.getTotal()));
		gain.setText(String.valueOf(Bob.getGain()));
		bet.setText(String.valueOf(Bob.getBet()));
		multp.setText(df.format(Bob.getMultp()));
		display_stat();
		display_histo();
	}
	
	public static void display_stat() {
		if (Bob.getGain() >= 0)
			gain.setForeground(green);
		else
			gain.setForeground(red);
		
		if (Bob.getTotal() >= Bob.temp_total)
			gain.setForeground(green);
		else
			gain.setForeground(red);
		return;
	}
}
