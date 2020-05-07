package mmt.mmt;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Library {

	private static Map<String, Integer> books = new ConcurrentHashMap <String, Integer> ();

	public static int getBookCount(String book) {
		synchronized (books) {
			if(books == null) {
				books = new ConcurrentHashMap <String, Integer> ();
			}
			if(books.containsKey(book))
				System.out.println(book +  " Book count: "+books.get(book));
			else
				System.out.println(book +  " Book count: " + 0 );
			return 1;
		}
	}

	public static int addBook(String book, int count) {
		System.out.println("Books: "+books);
		System.out.println("Books size: "+books.size());
		synchronized (books) {
			if(books == null) {
				books = new ConcurrentHashMap <String, Integer> ();
			}
			books.put(book, count);
			System.out.println(count + " " + book +  " Book(s) added in the library.");
			return 1;
		}
	}

	public static int addBook(String book) {
		synchronized (books) {
			if(books == null) {
				books = new ConcurrentHashMap <String, Integer> ();
			}
			if(books.containsKey(book)) {
				books.replace(book, books.get(book).intValue() + 1);
			} else {
				books.put(book, 1);
			}
			System.out.println("1 "+ book +  " Book has been added in the library.");
		}
		return 1;
	}

	public static int issueBook(String book) {
		synchronized (books) {
			if(books == null) {
				books = new ConcurrentHashMap <String, Integer> ();
			}
			if(books.containsKey(book)) {
				books.replace(book, books.get(book).intValue() - 1);
				System.out.println("1 "+ book +  " Book has been issued from library.");
			} else {
				return -1;
			}
		}
		return 1;
	}

	public static int removeBook(String book) {
		synchronized (books) {
			if(books == null) {
				books = new ConcurrentHashMap <String, Integer> ();
			}
			books.remove(book);
			System.out.println(book +  " Book has been remvoed from library.");
		}
		return 1;
	}

}

