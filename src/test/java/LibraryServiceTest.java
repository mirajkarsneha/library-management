import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryServiceTest {

    @Test
    void shouldBorrowABookFromLibrary() throws Exception {
        //given
        Map<String, Integer> books = new HashMap<>();
        books.put("Maths", 2);
        Library library = new Library(books);

        //when
        LibraryService libraryService = new LibraryService(library);
        libraryService.borrow("Maths");

        //then
        assertFalse(libraryService.getBorrowedBooks().isEmpty());
        assertFalse(library.getBooks().isEmpty());
        assertEquals(1, libraryService.getBorrowedBooks().get("Maths"));
        assertEquals(1, library.getBooks().get("Maths"));
    }

    @Test
    void shouldNotBorrowMoreThanTwoBooksFromLibrary() throws Exception {
        //given
        Map<String, Integer> books = new HashMap<>();
        books.put("Maths", 2);
        books.put("Science", 2);
        books.put("Biology", 2);
        Library library = new Library(books);

        //when
        LibraryService libraryService = new LibraryService(library);
        libraryService.borrow("Maths");
        libraryService.borrow("Science");
        Exception exception = assertThrows(Exception.class, () -> libraryService.borrow("Biology"));

        //then
        assertEquals("can not borrow more than 2 books", exception.getMessage());
    }

    @Test
    void shouldReturnABookToLibrary() {
        //given
        Map<String, Integer> libraryBooks = new HashMap<>();
        libraryBooks.put("Maths", 1);
        libraryBooks.put("Science", 1);
        Library library = new Library(libraryBooks);

        //when
        LibraryService libraryService = new LibraryService(library);
        libraryService.returnBook("Science");

        //then
        assertEquals(2, library.getBooks().get("Science"));
    }
}
