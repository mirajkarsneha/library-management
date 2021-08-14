import java.util.List;

public class Library {

    private final List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void remove(Book book) {
        books.remove(book);
    }
}
