package MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Main.Main;
import Dialog.Dialog;
import Interface.Crash;
import Window.Window;


public class Menu_bar extends JMenuBar{
	private static final long serialVersionUID = 1L;
	public static JMenu menu = new JMenu("Menu");
	public static JMenu help = new JMenu("Help ?");	
	
	public static JMenuItem menu_item_play	= new JMenuItem("Play");
	public static JMenuItem menu_item_start	= new JMenuItem("Start");
	public static JMenuItem menu_item_reset = new JMenuItem("Reset");
	public static JMenuItem menu_exit 		= new JMenuItem("Exit");
	
	
	public static JMenuItem menu_help 		= new JMenuItem("Guide");
	
	public static void setup() {
		setup_add_listener();
		setup_enabled();
		setup_add_menu_item();
		setup_add_help_item();
		setup_add_menu_bar();
	}
	
	public static void setup_add_menu_item() {
		menu.add(menu_item_start);
		menu.add(menu_item_play);
		menu.add(menu_item_reset);
		menu.add(menu_exit);
	}
	
	public static void setup_add_help_item() {
		help.add(menu_help);
	}
	
	public static void setup_add_menu_bar() {
		Window.menu_bar.add(menu);
		Window.menu_bar.add(help);
	}
	
	public static void setup_enabled() {
		menu_item_reset.setEnabled(false);
		menu_item_play.setEnabled(false);
		menu_exit.setEnabled(false);
	}
	
	public static void setup_add_listener() {
		menu_item_start.addActionListener(new Menu_bar_event());

		menu_item_play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Window.game_start = true;
				menu_item_play.setEnabled(false);
			}
		});
		
	
		menu_item_reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Window.reset();
			}
		});
		
		menu_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.fenetre.removeAll();
				Crash.end();
			}
		});
		
		menu_help.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				Dialog.help();	
			}
		});
	}
	
	public static void reset() {
		reset_enabled();
		
	}
	
	public static void reset_enabled() {
		menu_item_play.setEnabled(false);
		menu_item_start.setEnabled(true);
		menu_item_reset.setEnabled(false);
	}

}
