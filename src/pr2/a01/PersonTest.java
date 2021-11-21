package pr2.a01;

import java.io.PrintWriter;
import schimkat.berlin.lernhilfe2021ws.io.DirtyFileWriter;

public class PersonTest {
		
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		persons(out);
		out.flush();
	}

	public static void printPersons(PrintWriter out, Person[] persons) {
		for (int i = 0; i < persons.length; i++) {
			out.println(persons[i]);
		}
	}

	public static void persons(PrintWriter out) {
		PrintWriter fout = new PrintWriter(new DirtyFileWriter("./data/print_persons1.txt"));
		PrintWriter sout = new PrintWriter(new DirtyFileWriter("./data/print_persons2.txt"));
		Person one = new Person("Vasiliki", "Ioannidou", 1994);
		Person two = new Person("Evangelos", "Ioannidis", 1990);
		Person three = new Person("Persefoni", "Papadopoulou", 2004);
		Person four = new Person("Paraskevi", "Vafeiadou", 1973);
		Person five = new Person("Ioannis", "Skopelitis", 1969);
		Person six = new Person("Pavlos", "Georgopoulos", 1993);
		out.println(one);
		out.println(two.toString());
		Person[] persons = { one, two, three, four, five, six };
		printPersons(out, persons);
		printPersons(fout, persons);
		printPersons(sout, persons);
		fout.close();
		sout.close();
	}
}
