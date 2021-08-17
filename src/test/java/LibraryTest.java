import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    void shouldGetNoBooksInEmptyLibrary() {
        //given
        Library library = new Library(emptyMap());

        //when
        Map<String, Integer> books = library.getBooks();

        //then
        assertTrue(books.isEmpty());
    }

    @Test
    void shouldGetBooksInLibrary() {
        //given
        Map<String, Integer> books = new HashMap<>();
        books.put("Maths", 2);
        Library library = new Library(books);

        //when
        Map<String, Integer> libraryBooks = library.getBooks();

        //then
        assertFalse(libraryBooks.isEmpty());
    }

    @Test
    void shouldUpdateBookCountInLibrary() {
        //given
        Map<String, Integer> books = new HashMap<>();
        books.put("Maths", 2);
        Library library = new Library(books);

        //when
        library.borrow("Maths");

        //then
        assertEquals(1, library.getBooks().size());
        assertEquals(1, library.getBooks().get("Maths"));
    }

    @Test
    void shouldRemoveBookFromLibraryIfThereIsOnlyOneCopy() {
        //given
        Map<String, Integer> books = new HashMap<>();
        books.put("Maths", 1);
        Library library = new Library(books);

        //when
        library.borrow("Maths");

        //then
        assertTrue(library.getBooks().isEmpty());
    }
}
