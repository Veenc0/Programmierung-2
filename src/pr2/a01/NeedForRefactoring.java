package pr2.a01;

import java.io.PrintWriter;

public class NeedForRefactoring {
	
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);
		printTime(out,8,15);
		out.printf("%n");
		printTime(out,12,5);
		out.printf("%n");
		ifElse01(out,3);
		ifElse01(out,7);
		out.flush();
	}

	public static void printTime(PrintWriter out, int hour, int min) {
		if(hour <= 9) {
			if(min <= 9) {
				out.print("0" + hour + ":" + "0" + min + " Uhr");
			}
			if(min >= 10) {
				out.print("0" + hour + ":" + min + " Uhr");
			}
		}
		if(hour >= 10) {
			if(min <= 9) {
				out.print(hour + ":" + "0" + min + " Uhr");
			}
			if(min >= 10) {
				out.print(hour + ":" + min + " Uhr");
			}
		}
	}

	public static void ifElse01(PrintWriter out, int r18d){
		int yy3GB = 0; 
		if (r18d == 1) {
			yy3GB = 13; 
		} else if (r18d == 2) {
			yy3GB = 111; 
		} else if (r18d == 3) {
			yy3GB = 4;
		} else if (r18d == 4) {
			yy3GB = 208; 
		} else if (r18d == 5) {
			yy3GB = 159; 
		} else if (r18d == 6) {
			yy3GB = 2; 
		} else if (r18d == 7) {
			yy3GB = 922; 
		} else if (r18d == 8) {
			yy3GB = 23; 
		} else if (r18d == 9) {
			yy3GB = 77; 
		} else {
			yy3GB = -1; 
		} 
		out.println(yy3GB);
	}
}
