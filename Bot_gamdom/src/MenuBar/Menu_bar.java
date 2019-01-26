package MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Dialog.Dialog;
import Display.Display;
import Interface.Crash;
import Window.Window;


public class Menu_bar extends JMenuBar{
	private static final long serialVersionUID = 1L;
	
	public static JMenu menu = new JMenu("Menu");
	public static JMenu help = new JMenu("Help ?");	
	
	public static JMenuItem menu_item_play = new JMenuItem("Play");
	public static JMenuItem menu_item_start = new JMenuItem("Start");
	public static JMenuItem menu_item_reset = new JMenuItem("Reset");
	public static JMenuItem menu_exit = new JMenuItem("Exit");
	public static JMenuItem menu_help = new JMenuItem("Guide");
	
	public static void setup() {
		menu_item_start.addActionListener(new Menu_bar_event());

		menu_item_play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Window.game_start = true;
				menu_item_play.setEnabled(false);
			}
		});
		
		menu_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Crash.end();
			}
		});
		
		menu_item_reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Display.reset();
			}
		});
		
		/*---------------------------------------------------------------------------------------------*/
		
		menu_help.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				Dialog.help();	
			}
		});
		
		help.add(menu_help);
		menu_item_reset.setEnabled(false);
		menu_item_play.setEnabled(false);
		menu_exit.setEnabled(false);
		menu.add(menu_item_start);
		menu.add(menu_item_play);
		menu.add(menu_item_reset);
		menu.add(menu_exit);
		
		Window.menu_bar.add(menu);
		Window.menu_bar.add(help);
			
	}
	
	public static void reset() {
		menu_item_play.setEnabled(false);
		menu_item_start.setEnabled(true);
		menu_item_reset.setEnabled(false);
	}

}
