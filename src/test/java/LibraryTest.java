import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTest {

    @Test
    void shouldGetNoBooksInEmptyLibrary() {
        //given
        Library library = new Library();

        //when
        List<Book> books = library.getBooks();

        //then
        assertTrue(books.isEmpty());
    }
}
