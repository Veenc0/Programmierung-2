package pr2.a01;

public class Person {
	
	protected String Vorname;
	protected String Nachname;
	protected int Geburtsjahr;

	public Person(String vorname, String nachname, int geburtsjahr) {
		this.Vorname = vorname;
		this.Nachname = nachname;
		this.Geburtsjahr = geburtsjahr; 
	}

	public String getVorname() {
		return Vorname;
	}

	public String getNachname() {
		return Nachname;
	}

	public int getGeburtsjahr() {
		return Geburtsjahr;
	}

	public String toString() {
		return Vorname + " " + Nachname + "," + Geburtsjahr;
	}
}

