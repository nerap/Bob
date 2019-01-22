import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		FileReader read = new FileReader("C:\\Users\\Michel.LA-BÊTE\\eclipse-workspace\\Analyze\\texte.txt");
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(read);
		
		
		long debut = System.currentTimeMillis();
		ArrayList<Integer> tab = new ArrayList<Integer>();
		ArrayList<Float> text = new ArrayList<Float>();
		float tampy = 1.00f;
		DecimalFormat df = new DecimalFormat("###.##");
		int index_tab = 0;
		String temp = reader.readLine();
		for (int i = 0; i < 205; i++){
			tab.add(0);
		}
		
		while (temp != null) {
			//temp = temp.replace(temp.substring(temp.length()-1), "");
			temp = temp.toString();
			text.add(Float.parseFloat(temp));
			temp = reader.readLine();
		}
		while (tampy < 3.04f) {
			for (int index = 0; index < text.size(); index++) {
				if (text.get(index) == Math.round(((index_tab/100.00f) + 1.00f)*100.00f)/100.00f) {
					tab.set(index_tab, tab.get(index_tab) + 1);
				}
				else if (text.get(index) >= 3.00f && text.get(index) < 5.00f) {
					tab.set(tab.size() - 5, tab.get(tab.size() - 5) + 1);
				}
				else if (text.get(index) >= 5.00f && text.get(index) < 7.50f) {
					tab.set(tab.size() - 4, tab.get(tab.size() - 4) + 1);
				}
				else if (text.get(index) >= 7.50f && text.get(index) < 10.00f) {
					tab.set(tab.size() - 3, tab.get(tab.size() - 3) + 1);
				}
				else if (text.get(index) >= 10.00f && text.get(index) < 20.00f) {
					tab.set(tab.size() - 2, tab.get(tab.size() - 2) + 1);
				}
				else if (text.get(index) >= 20.00f) {
					tab.set(tab.size() - 1, tab.get(tab.size() - 1) + 1);
				}	
			}
			tampy += 0.01f;
			index_tab++;
		}
		tab.set(tab.size() - 5, tab.get(tab.size() - 5) / 205);
		tab.set(tab.size() - 4, tab.get(tab.size() - 4) / 205);
		tab.set(tab.size() - 3, tab.get(tab.size() - 3) / 205);
		tab.set(tab.size() - 2, tab.get(tab.size() - 2) / 205);
		tab.set(tab.size() - 1, tab.get(tab.size() - 1) / 205);
		
		
		for (int i = 0; i < tab.size() - 5; i++) {
			System.out.println("-" + (df.format((float)(i/100.00f) + 1.00f)) + " : " + (String.valueOf( df.format((float)((tab.get(i) * 100.00f)/text.size())))) + " %");
		}
		System.out.println(" [3.00 - 4.99]   = " + (String.valueOf( df.format((float)((tab.get(tab.size() - 5) * 100.00f)/text.size())))) + " %");
		System.out.println(" [5.00 - 7.49]   = " + (String.valueOf( df.format((float)((tab.get(tab.size() - 4) * 100.00f)/text.size())))) + " %");
		System.out.println(" [7.50 - 9.99]   = " + (String.valueOf( df.format((float)((tab.get(tab.size() - 3) * 100.00f)/text.size())))) + " %");
		System.out.println("[10.00 - 19.99]  = " + (String.valueOf( df.format((float)((tab.get(tab.size() - 2) * 100.00f)/text.size())))) + " %");
		System.out.println("[20.00 - ++.++]  = " + (String.valueOf( df.format((float)((tab.get(tab.size() - 1) * 100.00f)/text.size())))) + " %");
		System.out.println("Size of element : " + text.size());
		System.out.println("Time to execute : " + String.valueOf(System.currentTimeMillis()-debut) + "ms");
	}
}
