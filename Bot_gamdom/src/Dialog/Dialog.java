package Dialog;
import javax.swing.JOptionPane;

public class Dialog extends JOptionPane{
	private static final long serialVersionUID = 1L;
	
	public static JOptionPane helping = new JOptionPane();
	public static JOptionPane invalid_input = new JOptionPane();
	public static final String title_help_text = new String("How it works");
	public static final String help_text = new String("-First of all, enter the amount of money you want let to Bob\n -Go in the menu and click on start \n -After that Bob will give u you an output(the number that you have to stop) \n -When the crash is done enter the result and depend on it bob will give the amount to pay and when to stop each round \n ! IMPORTANT : THE CRASH ORDER IS REALLY IMPORTANT DO NOT BREAK IT");
	public static final String input_error_float = new String("Make sure that you input is a float with this format (\"###.##\")_\n The minimum input is 1.00 ");
	public static final String input_error_bet = new String("Make sure that you input is an unsigned integer \n The minimum input is 10 000 and the maximum is 100 000");
	public static final String invalid_input_title = new String("Invalid input");
	
	
	public static void help() {
		JOptionPane.showMessageDialog(null, help_text, title_help_text, JOptionPane.INFORMATION_MESSAGE);	
	}
	
	public static void display_float() {
		Dialog.showMessageDialog(null, "Make sure that you input is a float with this format (\"###.##\")_\n The minimum input is 1.00 ", "Invalid input", JOptionPane.ERROR_MESSAGE);
	}

	public static void display_bet() {
		Dialog.showMessageDialog(null, "Make sure that you input is an unsigned integer \n The minimum input is 10 000 and the maximum is 100 000", "Invalid input", JOptionPane.ERROR_MESSAGE);
	}
}
