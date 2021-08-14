import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    private final List<Book> borrowedBooks = new ArrayList<>();
    private final Library library;

    public LibraryService(Library library) {
        this.library = library;
    }

    public List<Book> borrow(Book book) {
        borrowedBooks.add(book);
        library.remove(book);
        return borrowedBooks;
    }
}
