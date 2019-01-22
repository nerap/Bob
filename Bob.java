import java.util.Random;

public class Bob {
	
	private static int total;
	private static int gain = 0;
	private static int bet;
	private static float multp;
	public static int temp_total;
	
	public static Random rd = new Random();
	
	
	Bob(int total){
		setTotal(total);
		temp_total = total;
		setBet(total/70);
		setMultp(1.40f);
		Bot.output.add(getMultp());
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

	public static void setMultp(float temp) {
		multp = temp;
	}

	public static void update(Float value) {
		Bot.input.add(value);
		if (value > getMultp()) {
			if (rd.nextInt(100) > 67) {
				setTotal((int)((getTotal() - getBet()) + (getBet() * getMultp())));
				Bot.profit.add((int)(-getBet() + (getBet() * getMultp())));
				setGain(getTotal() - temp_total);
				setBet(getTotal()/70);
				setMultp(rd.nextFloat() + 1.00f);
			}
			else {
				setTotal((int)((getTotal() - getBet()) + (getBet() * getMultp())));
				Bot.profit.add((int)(-getBet() + (getBet() * getMultp())));
				setGain(getTotal() - temp_total);
				setBet((int)(getBet() * 1.60));
				setMultp((float)((rd.nextFloat() + rd.nextFloat() + rd.nextFloat() + rd.nextFloat() + rd.nextFloat() + rd.nextFloat() + rd.nextFloat() + rd.nextFloat())/6.50f) + 1.00f);
			}
		}
		else {
			setTotal((int)((getTotal()) - getBet()));
			Bot.profit.add(-getBet());
			setGain(getTotal() - temp_total);
			setBet((int)(getBet() * 1.60));
			setMultp((float)((rd.nextFloat() + rd.nextFloat() + rd.nextFloat() + rd.nextFloat() + rd.nextFloat() + rd.nextFloat() + rd.nextFloat() + rd.nextFloat())/6.50f) + 1.00f);
		}
		Bot.output.add(getMultp());
		return;
	}
	
}
