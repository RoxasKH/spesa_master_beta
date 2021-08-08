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
		if (name.length() < 3 || pswd.length() < 3) {
			System.out.println ("Per favore inserire nome e password con almeno tre lettere!");
		}
		else {
			id = name.substring(0, 3) + pswd.substring(0, 3);
			user = name + "|" + pswd + "|" + id;
			writeUser(user);
		}
		return id;
	}

// Scrive uno user nel file users.
	public static void writeUser (String user) {
		PrintWriter outstream_user = null;

		try {
			outstream_user = new PrintWriter (new FileOutputStream ("C:/Users/Matteo/Desktop/spesa_master/spesa_master_beta/users.txt", true));
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
			outstream_value = new PrintWriter (new FileOutputStream ("C:/Users/Matteo/Desktop/spesa_master/spesa_master_beta/spesa.txt", true));
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
			inputstream = new Scanner (new File ("C:/Users/Matteo/Desktop/spesa_master/users.txt"));
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

	public static String cleanDate (String date) {
		return (date.substring(0, 3) + date.substring(5, 6) + date.substring(8, 9));
	}
}