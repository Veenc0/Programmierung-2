package pr2.a07;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Filez {
	private List<File> list;
	
	private Filez(List<File> filez) {
		this.list = filez;
	}
	
	public static Filez create(File directory) {
		return new Filez(Arrays.asList(directory.listFiles()));
	}
	
	public void printAll(PrintWriter out) {
		list.forEach(i -> out.println(i));  
	}
	
	// sortiert die Liste mit dem Comparator
	public Filez sorted(Comparator<File> c) {
		list.sort(c);     
		return this;
	}
	
	// sortiert die Liste so, dass alle directories am Anfang der Liste sind 
	public Filez dirsFirst() {    
		return sorted((i, k) -> Boolean.compare(i.isDirectory(), k.isDirectory()));
	}
	
	// sortiert die Liste alphabetisch
	public Filez nameSorted() { 
		return sorted((first, second) -> first.getName().compareTo(second.getName()));
	}
	
	// filtert die Liste mit dem predicate
	public Filez filter(Predicate<File> p) {
		List<File> filez = new ArrayList<File>(list);
		filez.removeIf(p);
		return new Filez(filez);
	}
	
	// filtert die Liste so, daß nur noch Dateien, aber keine Directories mehr enhalten sind
	public Filez dirsOnly() {
		return filter(filez -> filez.isDirectory());
		
	}
	// filtert die Liste so, daß nur noch Files mit Namen, die kürzer als 9 Zeichen sind, enhalten sind
	public Filez shortNamesOnly() {
		return filter(filez -> filez.getName().length() > 9);	
	}
}
