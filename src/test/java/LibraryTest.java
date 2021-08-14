import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTest {

    @Test
    void shouldGetNoBooksInEmptyLibrary() {
        //given
        Library library = new Library(emptyList());

        //when
        List<Book> books = library.getBooks();

        //then
        assertTrue(books.isEmpty());
    }

    @Test
    void shouldGetBooksInLibrary() {
        //given
        List<Book> books = new ArrayList<>();
        books.add(new Book());
        Library library = new Library(books);

        //when
        List<Book> libraryBooks = library.getBooks();

        //then
        assertFalse(libraryBooks.isEmpty());
    }
}
