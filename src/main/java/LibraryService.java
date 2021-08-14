import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    private final List<Book> borrowedBooks = new ArrayList<>(2);
    private final Library library;

    public LibraryService(Library library) {
        this.library = library;
    }

    public List<Book> borrow(Book book) throws Exception {
        if (borrowedBooks.size() == 2) {
           throw new Exception("can not borrow more than 2 books");
        }
        borrowedBooks.add(book);
        library.remove(book);
        return borrowedBooks;
    }
}
