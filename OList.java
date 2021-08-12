// Classe che implementa una lista ordinata
public class OList {

// Classe privata che implementa un singolo nodo della lista
	private class Node {
		private int date;
		private double value;
		private String id;

		private Node next;
		// Constructor
		public Node (int date, double value, String id) {
			this.setDate(date);
			this.setValue(value);
			this.setId(id);
		}
		// Getter
		public int getDate () {return this.date;}
		public double getValue () {return this.value;}
		public String getId () {return this.id;}
		public Node getNext () {return this.next;}
		// Setter
		public void setDate (int date) {this.date = date;}
		public void setValue (double value) {this.value = value;}
		public void setId (String id) {this.id = id;}
		public void setNext (Node next) {this.next = next;}
	}

	private Node head;

// Costruttori
	public OList () {
		this.head = null;
	}
	public OList (int date, double value, String id) {
		this.head = new Node(date, value, id);
	}

// Metodo che aggiunge un elemento in testa alla lista
	public void add (int date, double value, String id) {
		if (this.head == null) {
			this.head = new Node(date, value, id);
		}
		else {
			Node tmp = this.head;
			this.head = new Node(date, value, id);
			this.head.setNext(tmp);
		}
	}

// Metodo che ordina la stringa.
	public void sort () {
		// TODO
	}
}