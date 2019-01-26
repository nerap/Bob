package Window;
import Main.Main;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Bob.Bob;
import Historique.Histo_pan;
import MenuBar.Menu_bar;
import Panel_left.Panel_game;
import Panel_left.Panel_start;
import Panel_output.Output;


public class Window extends JFrame{
	
	public static boolean game_start = false;
	public static Color red =  new Color(167,61,61);
	public static Color green =  new Color(61,167,61);
	private static final long serialVersionUID = 1L;
	public static DecimalFormat df = new DecimalFormat("###.##");
	
	public static JPanel parent = new JPanel();
	public static Output panel_output = new Output();
	public static Histo_pan panel_hist = new Histo_pan();
	public static Panel_start panel_start = new Panel_start();
	public static Panel_game panel_game = new Panel_game();
	
	public static Menu_bar menu_bar = new Menu_bar();
	
	public static ArrayList<Float> input;
	public static ArrayList<Float> output;
	public static ArrayList<Integer> profit;
	
	
	
	public Window(String str){
		setTitle(str);
	}
	
	public static void setup() {
		input = new ArrayList<Float>();
		output = new ArrayList<Float>();
		profit = new ArrayList<Integer>();
		
		Main.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main.fenetre.setSize(400, 250);
		
		Menu_bar.setup();
		Output.setup();
		Panel_start.setup();
		Histo_pan.setup();
		
		Main.fenetre.setJMenuBar(menu_bar);
		
		parent.setLayout(new GridLayout(2, 1));
		parent.add(panel_output);
		parent.add(panel_hist);
		
		Main.fenetre.setLayout(new GridLayout(1,2));
		Main.fenetre.add(panel_start);
		Main.fenetre.add(parent);
		
		Main.fenetre.setLocationRelativeTo(null);
		Main.fenetre.setVisible(true);
		//Main.fenetre.pack();
		
		launch();
	}
	

	public static void reset () {
		input.removeAll((Collection<Float>) input);
		output.removeAll((Collection<Float>) output);
		Output.bet.setText("0");
		Output.multp.setText("1.00");
		Bob.reset();
		game_start = false;
	}
	
	public static void launch() {
		Main.fenetre.remove(panel_start);
		Panel_game.setup();
		Main.fenetre.add(panel_game, 0);
		Main.fenetre.repaint();
		Main.fenetre.revalidate();
	} 

}
