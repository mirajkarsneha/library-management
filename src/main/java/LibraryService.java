import java.util.HashMap;
import java.util.Map;

public class LibraryService {

    private final Map<String, Integer> borrowedBooks = new HashMap<>(2);
    private final Library library;

    public LibraryService(Library library) {
        this.library = library;
    }

    public void borrow(String book) throws Exception {
        if (borrowedBooks.size() == 2) {
           throw new Exception("can not borrow more than 2 books");
        }
        borrowedBooks.put(book, 1);
        library.borrow(book);
    }

    public Map<String, Integer> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void returnBook(String bookName) {
        library.add(bookName);
    }
}
