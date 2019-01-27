package Window;
import Main.Main;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
	private static final long serialVersionUID = 1L;
	
	public static boolean game_start = false;
	
	
	public static Color red 	=	new Color(167,61,61);
	public static Color green	=	new Color(61,167,61);
	
	
	public static DecimalFormat df = new DecimalFormat("###.##");
	
	
	public static JPanel parent = new JPanel();
	
	public static Output		panel_output 	=	new Output();
	public static Histo_pan		panel_hist 		=	new Histo_pan();
	public static Panel_start 	panel_start 	=	new Panel_start();
	public static Panel_game 	panel_game 		=	new Panel_game();
	
	
	
	public static Menu_bar menu_bar = new Menu_bar();
	

	public static ArrayList<Float> input;
	public static ArrayList<Float> output;
	public static ArrayList<Integer> profit;
	
	
	
	public Window(String str){
		setTitle(str);
	}
	
	public static void setup() {
		setup_list();
		setup_frame();
		
	}
	
	public static void setup_frame() {
		Main.fenetre = new Window("Bob");
		
		Menu_bar.setup();
		Output.setup();
		Panel_start.setup();
		Histo_pan.setup();
		setup_menu_bar();
		setup_panel();
	
		setup_param_frame();	
		
	}
	
	public static void setup_param_frame() {
		Main.fenetre.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				Main.end();
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		Main.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main.fenetre.setSize(400, 250);
		Main.fenetre.setLocationRelativeTo(null);
		Main.fenetre.setVisible(true);
	}
	
	public static void setup_list() {
		input = new ArrayList<Float>();
		output = new ArrayList<Float>();
		profit = new ArrayList<Integer>();
	}
	
	public static void setup_menu_bar() {
		Main.fenetre.setJMenuBar(menu_bar);
	}
	
	public static void setup_panel() {
		setup_add_panel_parent();
		setup_add_panel_window();
	}
	
	public static void setup_add_panel_parent() {
		parent.setLayout(new GridLayout(2, 1));
		
		parent.add(panel_output);
		parent.add(panel_hist);
	}
	
	public static void setup_add_panel_window() {
		Main.fenetre.setLayout(new GridLayout(1,2));
		Main.fenetre.add(panel_start);
		Main.fenetre.add(parent);
	}
	

	public static void reset () {
		reset_list();
		Output.bet.setText("0");
		Output.multp.setText("1.00");
		Bob.reset();
		game_start = false;
	}
	
	public static void reset_list() {
		input.removeAll((Collection<Float>) input);
		output.removeAll((Collection<Float>) output);
		profit.removeAll((Collection<Integer>) profit);
	}
	
	public static void launch() {
		Main.fenetre.remove(panel_start);
		Panel_game.setup();
		Main.fenetre.add(panel_game, 0);
		Main.fenetre.repaint();
		Main.fenetre.revalidate();
	} 

}
