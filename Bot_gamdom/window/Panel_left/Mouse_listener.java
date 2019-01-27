package Panel_left;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse_listener implements MouseListener{
	public void mouseReleased(MouseEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int getY = e.getClickCount();
		System.out.println(e.getClickCount());
		if (getY == 8) {
			Panel_start.champs_int.setText("");
			Panel_start.champs_bet_greed.setText("");
			Panel_start.champs_multp_greed.setText("");
			Panel_start.champs_max_profit.setText("");
			Panel_start.champs_max_loss.setText("");
			Panel_start.champs_time.setText("");
		}
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
}
