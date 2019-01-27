package Dialog;
import javax.swing.JOptionPane;

public class Dialog extends JOptionPane{
	private static final long serialVersionUID = 1L;
	
	public static JOptionPane helping 		= new JOptionPane();
	public static JOptionPane invalid_input = new JOptionPane();
	
	public static final String title_help_text 		= new String("How it works");
	public static final String help_text 			= new String("	-First of all, enter the amount of money you want let to Bob 5 000 to 500 000\n\n"
																+"	-Next(Bet Greed), enter how Bob should be greedy with your money (Means that Bob will increase the bet rather wait a bigger mutliplicator\n\n"
																+"	-Like Bet Greed, Mutliplicator Greed will wait for bigger multiplicator instead betting more \n\n"
																+"	-Maximum Profit will tell when Bob should stop the game \n\n"
																+"	-Maximum Loss will tell when Bob should stop the game \n\n"
																+"	-Time after certains number of game, Bob will stop\n\n"
																+"	-Then go in the menu and press start \n\n"
																+"	-After that press play when you want Bob to start simulating the bet\n\n"
																+"	-Now wait, Bob will simulate the session and will give an output where we can see is bet and when he will go out \n\n "
																+"	-Go in menu and press exit to leave");
	
	
	
	
	
	
	public static final String invalid_input_int_bet 	= new String("Invalid Bet");
	public static final String input_error_int_bet 		= new String("	Make sur that your input is an Integer\n"
																	+ "	The minimum input is 1 000 to 500 000");
	
	
	public static final String invalid_input_int_max_profit = new String("Invalid Max Profit");
	public static final String input_error_int_max_profit 	= new String("Make sur that your input is an Integer\n"
																		+ "	The minimum input is 1 to 100");
	
	
	
	public static final String invalid_input_int_max_loss 	= new String("Invalid Max Loss");
	public static final String input_error_int_max_loss 	= new String("Make sur that your input is an Integer\n"
																		+ "	The minimum input is 1 to 100");
	
	
	public static final String invalid_input_float_bet_greed = new String("Invalid Bet Greed");
	public static final String input_error_float_bet_greed 	= new String("	Make sure that your input is a float with this format (\"###.##\")_\n"
																		+ "	The minimum input is 1.00 to 5.00");
	
	
	public static final String invalid_input_float_multp_greed 	= new String("Invalid Multp Greed");
	public static final String input_error_float_multp_greed 	= new String("Make sure that your input is a float with this format (\"###.##\")_\n" 
																			+ "The minimum input is 1.00 to 5.00");
	
	public static final String invalid_input_int_turn 	= new String("Invalid Multp Greed");
	public static final String input_error_int_turn	= new String("	Make sur that your input is an Integer\n"
																+ "	The minimum input is 1 to 100");
	
	
	
	public static final String invalid_input_title 	= new String("Invalid input");
	
	
	public static void help() {
		JOptionPane.showMessageDialog(null, help_text, title_help_text, JOptionPane.INFORMATION_MESSAGE);	
	}
	

	public static void display_bet() {
		Dialog.showMessageDialog(null, input_error_int_bet, invalid_input_int_bet, JOptionPane.ERROR_MESSAGE);
	}

	public static void display_max_profit() {
		Dialog.showMessageDialog(null, input_error_int_max_profit, invalid_input_int_max_loss, JOptionPane.ERROR_MESSAGE);
		
	}

	public static void display_max_loss() {
		Dialog.showMessageDialog(null, input_error_int_max_loss, invalid_input_int_max_loss, JOptionPane.ERROR_MESSAGE);
		
	}

	public static void display_turn() {
		Dialog.showMessageDialog(null, input_error_int_turn , invalid_input_int_turn, JOptionPane.ERROR_MESSAGE);
		
	}

	public static void display_float_bet_greed() {
		Dialog.showMessageDialog(null, input_error_float_bet_greed, invalid_input_float_bet_greed, JOptionPane.ERROR_MESSAGE);
		
	}

	public static void display_float_multp_greed() {
		Dialog.showMessageDialog(null, input_error_float_multp_greed, invalid_input_float_multp_greed, JOptionPane.ERROR_MESSAGE);
		
	}
}
