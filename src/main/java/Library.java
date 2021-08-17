import java.util.Map;

public class Library {

    private final Map<String, Integer> books;

    public Library(Map<String, Integer> books) {
        this.books = books;
    }

    public Map<String, Integer> getBooks() {
        return books;
    }

    public void borrow(String bookName) {
        Integer bookCount = books.get(bookName);
        if (bookCount > 1) {
            books.put(bookName, bookCount - 1);
        } else {
            books.remove(bookName);
        }
    }

    public void add(String bookName) {
        books.merge(bookName, 1, Integer::sum);
    }
}
