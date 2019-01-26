package Bob;
import java.util.Random;

import Window.Window;

public class Bob {
	
	private static int total;
	private static int gain;
	private static int bet;
	private static float multp;
	private static int bet_add;
	private static float multp_add;
	private static float bet_greed;
	private static float multp_greed;
	private static float temp_percent;
	public static int temp_total;
	private static int max_gain;
	private static int max_loss;
	private static int time;
	
	
	public static Random rd = new Random();
	
	
	public Bob(int total, float bet_greed, float multp_greed,int max_profit , int max_loss , int time){
		setTotal(total);
		temp_total = total;
		setGain(0);
		setBet(bet_start(total));
		setMultp(multp_start());
		setBet_add(1);
		setMultp_add(1.02f);
		setMax_gain(max_profit);
		setMax_loss(max_loss);
		setTime(time);
		Window.output.add(getMultp());
	}

	public static int getTotal() {
		return total;
	}

	public static void setTotal(int temp) {
		total = temp;
	}

	public static int getGain() {
		return gain;
	}

	public static void setGain(int temp) {
		gain = temp;
	}

	public static int getBet() {
		return bet;
	}

	public static void setBet(int temp) {
		bet = temp;
	}

	public static float getMultp() {
		return multp;
	}

	public static void setMultp(Float temp) {
		multp = temp;
	}

	public static float getMultp_add() {
		return multp_add;
	}

	public static void setMultp_add(float multp_add) {
		Bob.multp_add = multp_add;
	}

	public static int getBet_add() {
		return bet_add;
	}

	public static void setBet_add(int bet_add) {
		Bob.bet_add = bet_add;
	}
	
	public static float getTemp_percent() {
		return temp_percent;
	}

	public static void setTemp_percent(float temp_percent) {
		Bob.temp_percent = temp_percent;
	}
	
	public static int getMax_gain() {
		return max_gain;
	}

	public static void setMax_gain(int max_gain) {
		Bob.max_gain = max_gain;
	}

	public static int getMax_loss() {
		return max_loss;
	}

	public static void setMax_loss(int max_loss) {
		Bob.max_loss = max_loss;
	}

	public static int getTime() {
		return time;
	}

	public static void setTime(int time) {
		Bob.time = time;
	}

	public static float getBet_greed() {
		return bet_greed;
	}

	public static void setBet_greed(float bet_greed) {
		Bob.bet_greed = bet_greed;
	}

	public static float getMultp_greed() {
		return multp_greed;
	}

	public static void setMultp_greed(float multp_greed) {
		Bob.multp_greed = multp_greed;
	}

	
	public static void update(Float value) {
		Window.input.add(value);
		if (is_win(value)) 
			update_win();
		else
			update_lose();
	}
	
	public static boolean is_win(Float value) {
		if (value >= getMultp()) 
			return true;
		return false;
	}
	
	public static int bet_start(int bet) {
		return (int)bet/97;
	}
	
	public static float multp_start() {

		return (float)rd.nextFloat() + 1.00f;
	}
	
	public static void update_output_start() {
		setBet(bet_start(total));	
		setMultp(multp_start());
	}
	
	
	public static void update_win() {
		setTotal((int)((getTotal() - getBet()) + (getBet() * getMultp())));
		Window.profit.add((int)(-getBet() + (getBet() * getMultp())));
		setGain(getTotal() - temp_total);
		update_deep();
		setBet((int)(bet_return_win()));
		setMultp((float)(multp_return()));
		Window.output.add(getMultp());

	}
	
	public static void update_lose() {
		setTotal((int)((getTotal()) - getBet()));
		Window.profit.add(-getBet());
		setGain(getTotal() - temp_total);
		update_deep();
		setBet((int)(bet_return_lose()));
		setMultp((float)(multp_return()));
		Window.output.add(getMultp());
	}
	

	private static void update_deep() {
		if (is_win(Window.input.get(Window.input.size() - 1))) {
			if (getBet_add() - 1 > 0) {
				setBet_add(getBet_add() - 1);
			}
			else if (getMultp() > 1.75f) {
				setMultp_add(getMultp() - 0.50f);
			}
		}
		else {
			if (getMultp_add() < 3.50f) {
				setMultp_add(getMultp_add() + 0.50f);
			}
			else {
				setBet_add(getBet_add() + 1);
				setMultp_add(1.05f);
			}
		}
	}	

	public static int bet_return_lose() {
		int temp = (int)((Window.profit.get(Window.profit.size() - 1)));
		if (temp < 0)
			temp *= -1;
		float percent_temp = calcul_percent_bet(temp);
		int add = (int)((float)(percent_temp/100) * temp);
		setTemp_percent((float)(100.00f + (float)(5 *(getMultp_greed() * rd.nextFloat())) - percent_temp));	
		return temp + add;
	}
	
	public static int bet_return_win() {
		return bet_start(total);
	}
	
	private static float calcul_percent_bet(int temp) {
		float percent_deep = (float)((20 + (getBet_greed() * rd.nextFloat())) + getBet_add());
		return percent_deep;
	}

	public static float multp_return() {
		float temp_percent = getTemp_percent();
		float add = (float)calcul_percent_profit(temp_percent);
		return add;
	}

	private static float calcul_percent_profit(float f) {
		f = (float)((float)(f / 100.00f) + (1.00f + (float)(rd.nextFloat()*getMultp_add())));
		return f;
	}
	

	public static void reset() {
		setTotal(0);
		setGain(0);
		setBet(0);
		setMultp(1.00f);
		
	}

	
	
	

	
}
