package pr2.a02;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class SuA {
	
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter (System.out);
		out.println(gesperrt("SPIELER"));
		out.println();
		printGesperrt(out, (createTestStrings(10)));
		out.println();
		out.println("Min und Max Werte von 1D Array: ");
		int[] numbers = {1,-2,12,15,18,85,99,10,45,73};
		out.println("Min " + minMax(numbers)[0]);
		out.println("Max " + minMax(numbers)[1]);
		out.println();
		out.println("Min und Max Werte von 2D Array: ");
		int[][] othernumbers = {{9,-50,77,58,189} ,{85,302,10,45,73}};
		out.println("Min " + minMax(othernumbers)[0]);
		out.println("Max " + minMax(othernumbers)[1]);
		out.println();
		out.println("Min und Max Werte von 1D Testarray mit 10, 2, 10: ");
		printtest(out, minMax(createMinMaxTest(10, 2, 10)));
		out.println();
		out.println("Min und Max Werte von 1D Testarray mit 2000, 23, 998: ");
		printtest(out, minMax(createMinMaxTest(2000, 23, 998)));
		out.println();
		out.println("Min und Max Werte von 1D Testarray mit 10000, 1500, 3855: ");
		printtest(out, minMax(createMinMaxTest(10000, 1500, 3855)));
		out.println();
		out.println("2D Testarray mit 8x12 Elemente: ");
		printtest(out,  createMinMaxTest2dim());
		out.println();
		out.println("Min und Max Werte von 2D TestArray mit 8x12 Elemente");
		printtest(out, minMax(createMinMaxTest2dim()));
		out.flush();	
	}
	
	public static String gesperrt(String normal) {
		StringBuilder sb = new StringBuilder();	
		for (int i =0; i < normal.length(); i++) {
			char a = normal.charAt(i);
			sb.append(a);
			if (i < normal.length() -1) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}
	
	public static String[] createTestStrings(int anzahl) {
		String strings [] = {"PRINTER", "MOTHERBOARD", "MOUSE","KEYBOARD", "GRAPHIC-CARD","PROCESSOR", "RAM", "HARD-DRIVE","PSU", "MONITOR"};
		if (anzahl< 0) {
			anzahl = 0;
		}
		if (anzahl > 10) {
			anzahl = 10;
		}
		return strings;	
	}
	
	public static void printGesperrt(PrintWriter out, String[] values) {
		for (int i =0; i < values.length; i++) {
			out.println(gesperrt(values[i]));
		}	
	}
	
	public static int[] minMax(int[] values) {
		if ( values == null || values.length ==0) {
			return new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < values.length; i++) {
		if(values[i] < min) {
                	min = values[i];
           	}
           	if(values[i] > max) {
               		max = values[i];
           	}	
	     }
        	int [] minmax = {min, max};
       		return minmax;	
	}	

	
	public static int[] minMax(int[][] values) {
		if ( values == null || values.length ==0) {
			return new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};
		}
		int min= Integer.MAX_VALUE;
		int max= Integer.MIN_VALUE;;
		for (int i = 0; i < values.length; i++){
			for (int x = 1; x < values[0].length; x++) {
				if(values[i][x] < min) {
	                min = values[i][x];
	            }
	            if(values[i][x] > max) {
	                max = values[i][x];
	            }
	          }
		}
		int[] output = {min,max};
        	return output;	
	}
	
	public static int[] createMinMaxTest(int count, int min, int max) {
		int[] testArray = new int[count];
		Random random = new Random();
		for (int i = 0; i < testArray.length; i++) {
			testArray[i] = random.nextInt(max + 1 - min) + min;
		}
		Arrays.sort(testArray);
		return testArray;
	}

	public static void printtest(PrintWriter out, int[] values) {
		for (int i = 0; i < values.length; i++) {
			out.println(values[i]);
		}
	}

	public static int[][] createMinMaxTest2dim() {
		int[][] test = new int[8][12];
		Random random = new Random();
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j <test[0].length; j++) {
				test[i][j] = random.nextInt(100);
				
			}
		}	
		return test;	
	} 
	
	public static void printtest(PrintWriter out, int[][] values) {
		for (int i = 0; i < values.length; i++) {
			out.println(Arrays.toString(values[i]));
		}
	}
}