package mmt.mmt;

public class LibraryTest {

	public static void main(String args[]) {
		Library.addBook("Harry Potter", 1);
		Library.getBookCount("Harry Potter");
		Library.addBook("Harry Potter");
		Library.getBookCount("Harry Potter");
		Library.issueBook("Harry Potter");
		Library.getBookCount("Harry Potter");
		Library.addBook("Harry Potter", 7);
		Library.getBookCount("Harry Potter");
		Library.removeBook("Harry Potter");
		Library.getBookCount("Harry Potter");
	}
}
