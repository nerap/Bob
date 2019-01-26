package Panel_left;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse_listener implements MouseListener{
	public void mouseReleased(MouseEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int getY = e.getYOnScreen();
		if (getY > 470 && getY < 490)
			Panel_start.champs_int.setText("");
		else if (getY > 500 && getY < 520)
			Panel_start.champs_bet_greed.setText("");
		else if (getY > 525 && getY < 545)
			Panel_start.champs_multp_greed.setText("");
		else if (getY > 545 && getY < 570)
			Panel_start.champs_max_profit.setText("");
		else if (getY > 575 && getY < 595)
			Panel_start.champs_max_loss.setText("");
		else if (getY > 600 && getY < 615)
			Panel_start.champs_time.setText("");
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
