import java.util.Scanner;

public class SpesaMaster {
	public static void main (String[] args) {

		Scanner t = new Scanner(System.in);
		System.out.println ("Benvenuti in Spesa Master - Lorena Edition!");

		String name = "";
		String pswd = "";
		String sessionID = "";
		String date = "";
		String value = "";
		String date_beg = "";
		String date_end = "";

		// Accedi o crea account
		System.out.println ("Desidera creare un utenza (1) , o accedere usandone una pre esistente (2) ?");
		int answer = t.nextInt();
		switch (answer) {
			case 1:
				do {
					System.out.println ("Inserisci il nome dell'utente:");
					name = t.next();
					System.out.println ("Inserisci la password dell'utente:");
					pswd = t.next();
					if(name.length() < 3 || pswd.length() < 3) {
						System.out.println ("Per favore inserire nome e password con almeno tre lettere!");
					}
				} 
				while(name.length() < 3 || pswd.length() < 3);

				sessionID = SpesaMethods.createUser(name, pswd);
				break;
			case 2:
				System.out.println ("Inserisci il nome dell'utente:");
				name = t.next();
				System.out.println ("Inserisci la password dell'utente:");
				pswd = t.next();
				sessionID = SpesaMethods.login(name, pswd);
				break;
		}
		
		// Operazioni sui dati
		boolean close = false;
		while (!close) {
			System.out.println ("Ora cosa desidera fare?\n");
			System.out.println ("1 - Inserire un dato\n2 - Effettuare un calcolo\n0 - Chiudere il programma");
			int user_answer = t.nextInt();
			switch (user_answer) {
				case 0:
					System.out.println ("Grazie per aver utilizzato Spesa Master - Lorena Edition!");
					close = true;
					break;
				case 1:
					System.out.println ("Inserisci una data nel formato aaaa/mm/gg");
					date = t.next();
					System.out.println ("Inserisci un valore nel formato cc,dd");
					value = t.next();
					SpesaMethods.insert(date, value, sessionID);
					break;
				case 2:
					System.out.println ("Inserisci la data di partenza:");
					date_beg = t.next();
					System.out.println ("Inserisci la data di fine:");
					date_end = t.next();
					SpesaMethods.calculate(date_beg, date_end);
					break;
			}
		}

		System.exit(0);
	}
}





/*
L'utente deve avere la possibilità di inserire data e spesa effettuata.
Questi due valori devono essere salvati su di un csv, e possono essere recuperati in qualunque momento.
L'utente deve avere la possibilità di eseguire calcoli sui valori di spesa, in base alla data
settando ad esempio data di inizio e fine, per ottenere la spesa totale.
L'utente deve poter cancellare i dati salvati che non gli servono più.
L'utente deve poter vedere a schermo i dati di un certo periodo di tempo.
*/