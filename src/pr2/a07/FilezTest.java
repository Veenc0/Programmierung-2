package pr2.a07;

import java.io.File;
import java.io.PrintWriter;
import java.util.Comparator;

public class FilezTest {
	
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter (System.out);
		out.println("LAMBDA AUSDRÜCKE: \n");
		testLA("C:\\pr1\\java.project", out);
		out.print("METHODENREFERENZEN: \n");
		testMR("C:\\pr1\\java.project", out);
		out.println("ABFOLGE VON FILTERN, SORTIEREN UND AUSGEBEN: \n");
		testEL("C:\\pr1\\java.project", out);
		out.flush();
	}
	
	 public static void testLA(String dirname, PrintWriter out) {  //lamda
		 Filez fileztest = Filez.create(new File(dirname));
		 out.println("Print all with alphabetical order: \n");
		 fileztest.printAll(out); //alphabetisch sortiert
		 out.println("--------------------------------------------");
		 out.println("Print all from less to more characters: \n");
		 fileztest.sorted(((first, second) -> first.getName().length() - second.getName().length())).printAll(out);
		 out.println("--------------------------------------------");
		 out.println("Print only Files: \n");
		 fileztest.filter(p -> !(p.isDirectory())).printAll(out); // only !directories (p.isFile)
		 out.println("--------------------------------------------");
		 out.println("Print only Directories: \n");
		 fileztest.dirsOnly().printAll(out); // only directories
		 out.println("----------------------------------------------------------------");

		 
	 }
	 
	 public static void testMR(String dirname, PrintWriter out) {// out.println("Beispiel mit Methodenreferenzen: Die BestAgers:");
		 Filez fileztest = Filez.create(new File(dirname));
		 out.println("Print all with alphabetical order: \n");
		 fileztest.printAll(out);
		 out.println("--------------------------------------------");
		 out.println("Print only Directories: \n");
		 fileztest.filter(File::isDirectory).printAll(out);
		 out.println("--------------------------------------------");
		 out.println("Print only Files: \n");
		 fileztest.filter(File::isFile).printAll(out);
		 out.println("--------------------------------------------");
		 out.println("Comparing all and printing the directories at the beginning of the list: \n");
		 fileztest.sorted(Comparator.comparing(File::isDirectory)).printAll(out);
		 out.println("----------------------------------------------------------------");
	 }
	 
	 public static void testEL(String dirname, PrintWriter out) {
		 Filez fileztest = Filez.create(new File(dirname));
		 out.println("Print all Names with max. 9 characters consisting only of files:  \n");
		 fileztest.shortNamesOnly().filter(p -> !(p.isDirectory())).printAll(out);
		 out.println("--------------------------------------------");
		 out.println("Print all Names with max. 9 characters consisting only of directories:  \n");
		 fileztest.shortNamesOnly().dirsOnly().printAll(out);
		 out.println("--------------------------------------------");
		 out.println("Sort all Names consisting only of directories and print them:  \n");
		 fileztest.nameSorted().filter(File::isDirectory).printAll(out);
		 out.println("--------------------------------------------");
		 out.println("Sort all Names in length-order from shortest to longest consisting only of Files:  \n");
		 fileztest.nameSorted().filter(File::isFile).sorted((first, second) -> first.getName().length() - second.getName().length()).printAll(out);
		 
	 }
}
