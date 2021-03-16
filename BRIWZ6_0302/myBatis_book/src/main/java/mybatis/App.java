package mybatis;

import java.util.List;
import java.util.Random;

public class App {

	public static void main(String[] args) {
		BookDAO bookDAO = new BookDAO();
		Book book = new Book();

		// insert
		Random r = new Random();
		book.setIsbn(String.valueOf(r.nextInt(9000)));
		book.setTitle("K�nyv " + r.nextInt(9000));
		book.setPrice(r.nextInt(15000));
		bookDAO.save(book);
		System.out.println("T�rolva: ISBN: " + book.getIsbn() + ", TITLE: " + book.getTitle() + ", PRICE: "
				+ book.getPrice() + "\n");

		// update (�r m�dos�t�sa megadott ISBN-re)
		Book book1 = new Book();
		book1.setIsbn("A412");
		book1.setPrice(7700);
		bookDAO.update(book1);
		System.out.println("M�dos�tva: ISBN: " + book1.getIsbn() + ", PRICE: " + book1.getPrice() + "\n");

		// delete
		bookDAO.delete("A413");
		System.out.println("Deleted.");

		// select, ahol �r > 5000
		List<Book> selectedBooks = bookDAO.select();
		System.out.println("\n5000 �r feletti k�nyvek: ");
		for (Book b : selectedBooks) {
			System.out.println("ISBN: " + b.getIsbn() + ", TITLE: " + b.getTitle() + ", PRICE: " + b.getPrice());
		}

		// �sszes k�nyv list�z�sa
		System.out.println("\n�sszes k�nyv:");
		List<Book> books = bookDAO.findAllBooks();
		for (Book b : books) {
			System.out.println("ISBN: " + b.getIsbn() + ", TITLE: " + b.getTitle() + ", PRICE: " + b.getPrice());
		}
	}
}
