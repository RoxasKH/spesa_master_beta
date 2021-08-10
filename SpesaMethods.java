import java.io.PrintWriter; // Crea e scrive file di testo.
import java.io.FileOutputStream; // Apre e scrive su file già esistenti senza modificarli.
import java.util.Scanner; // Legge file di testo.
import java.io.File; // Rappresenta il percorso del file.
import java.io.ObjectOutputStream; // Crea e scrive file binari.
import java.io.ObjectInputStream; // Legge file binari.
import java.io.FileInputStream; // Serve sempre per leggere i binari.
import java.io.FileNotFoundException; // Gestisce l'eccezione per cui il file richiesto non esiste.
import java.io.IOException; // Gestisce eccezioni di I/O.
import java.io.EOFException; // End Of File.

public class SpesaMethods {

// Crea uno user.
	public static String createUser (String name, String pswd) {

		String id = "";
		String user = "";

		id = name.substring(0, 3) + pswd.substring(0, 3) + (int)(Math.random()*1000000);

		while (findId(id)) {
			id = id.substring(0, 7) + (int)Math.random()*1000000;
		}

		user = id + "|" + name + "|" + pswd;
		writeUser(user);

		return id;
	}

	public static boolean findId(String id) {

		Scanner inputstream = null;
		boolean found = false;

		try {
			inputstream = new Scanner (new File ("users.txt"));
		}
		catch (FileNotFoundException e) {
			System.out.println ("Errore nell'apertura del file...");
			System.exit(0);
		}

		while (inputstream.hasNextLine()) {
			if (id.equals(inputstream.nextLine().substring(0, 13))) {
				found = true;
			}
		}
		inputstream.close();
		return found;
	}

// Scrive uno user nel file users.
	public static void writeUser (String user) {
		PrintWriter outstream_user = null;

		try {
			outstream_user = new PrintWriter (new FileOutputStream ("users.txt", true));
		}
		catch (FileNotFoundException e) {
			System.out.println ("Errore nell'apertura del file...");
			System.exit(0);
		}

		outstream_user.println (user);
		outstream_user.close();
	}

// Scrive un valore nel file spesa.
	public static void writeValue (String spesa) {
		PrintWriter outstream_value = null;

		try {
			outstream_value = new PrintWriter (new FileOutputStream ("spesa.txt", true));
		}
		catch (FileNotFoundException e) {
			System.out.println ("Errore nell'apertura del file...");
			System.exit(0);
		}

		outstream_value.println (spesa);
		outstream_value.close();
	}

// Effettua il login di un utente.
	public static String login (String name, String pswd) {
		String id = name.substring(0, 3) + pswd.substring(0, 3);
		String user = name + "|" + pswd + "|" + id;
		if (findUser(user)) {
			System.out.println ("Login effettuato con successo!");
		}
		else {
			System.exit(0);
		}
		return id;
	}

// Verifica la presenza di uno user nel file.
	public static boolean findUser (String user) {
		Scanner inputstream = null;
		boolean found = false;

		try {
			inputstream = new Scanner (new File ("users.txt"));
		}
		catch (FileNotFoundException e) {
			System.out.println ("Errore nell'apertura del file...");
			System.exit(0);
		}

		while (inputstream.hasNextLine()) {
			if (user.equals(inputstream.nextLine())) {
				found = true;
			}
		}
		inputstream.close();
		return found;
	}

// Inserisci un valore nel file spesa
	public static void insert (String date, String value, String sessionID) {
		String spesa = date + "|" + value + "|" + sessionID;
		writeValue(spesa);
	}

// Esegue calcoli sui valori di spesa da una data ad un altra.
	public static void calculate (String date_beg, String date_end) {
		// TODO
	}

// Ordina i dati in base alla data.
	public static void sort () {
		// TODO
		
	}

// Ripulisce la data 
	public static String cleanDate (String date) {
		// TODO
		return date;
	}

// Crea un file di testo dato il nome
	public static void createTextFile (String name) {

		File table = new File (name);

		if (!table.exists()) {

			PrintWriter outstream = null;

			try {
				outstream = new PrintWriter (name);
			}
			catch (FileNotFoundException e) {
				System.out.println ("Errore nell'apertura del file...");
				System.exit(0);
			}
			outstream.close();
		}
	}
}