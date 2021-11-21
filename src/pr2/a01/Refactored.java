package pr2.a01;

import java.io.PrintWriter;

public class Refactored {
	
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		printTime(out, 8, 15);
		out.println();
		printTime(out, 12, 5);
		out.println();
		printFromArray(out, 10);
		printFromArray(out, 7);
		out.flush();
	}

	public static void printTime(PrintWriter out, int hour, int min) {
		out.printf("%02d:%02d Uhr", hour, min);	
	}
	/*
	 * Ich habe die If-Schleifen komplett rausgelassen. So kann man die Werten in
	 * der Main-Methode ändern und die werden formatiert und ausgegeben. Mit %02d
	 * wird eine "0" davor gesetzt, wenn die Zahl einstellig ist.
	 */
	public static void printFromArray(PrintWriter out, int i) {
		int array[] = { -1, 13, 111, 4, 208, 159, 2, 922, 23, 77 };
		if (i >= 1 && i <= 9) {
			out.println(array[i]);
		} else {
			out.println(array[0]);
		}
	}
	/*
	 * Bei der Methode kann man die unterschiedlichen Werten in ein Array speichern
	 * und die if/else Schleife definiert die "Grenzen". Die -1 kommt bei dem Index
	 * 0 und die wird dann ausgegeben wenn in der Main 0 oder >=10 eingegeben wird.
	 */
}

/*	 THEORIEFRAGEN
 * - 3 Hauptbestandteile einer Klasse: Methoden, Variablen und Attributen 
 * - Aufgabe eines Kostruktors: Objekte zu initialisieren
 * - Vollständige-, Kopier- und Stardard - Konstruktoren
 * - 1) (allg.) Konstruktor variablenname = new Kostruktor (Parameter) 2) "this" (Aufruf Konstruktor in der Klasse) 
 *   3) "super" (Aufruf Konstruktor eine andere (Super)klasse)
 * - 1) Main-Methode 2) Klassenmethode 
 * - Ausgabe: System Klasse, PrintWriter Klasse, FileWriter Klasse
 * - Eingabe: Scanner Klasse
 */ 
