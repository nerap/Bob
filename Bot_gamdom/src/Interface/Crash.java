package Interface;


public interface Crash {
	public static String source = "https://gamdom.com/crash/";
	public static String xPath = "//*[@id=\"router-container\"]/div/div[2]/div[2]/div[1]/div[4]/div/a[1]";
	
	
	public static void setup() {
		Chrome.setup();
	}
	
	public static void end() {
		Chrome.end();
	}
	
	public static float update() {
		Chrome.driver.get(source);
		float tmp_tmp;
		float tmp;
		tmp_tmp = Chrome.xPathToFloat(xPath);
		tmp = tmp_tmp;
		try {
			while (tmp == tmp_tmp) {
				tmp = Chrome.xPathToFloat(xPath);
				Thread.sleep(100);
			}
		}
		catch(Exception e) {
			System.out.println("hi");
		}
		return tmp;
	}
}
