import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryServiceTest {

    @Test
    void shouldBorrowABookFromLibrary() {
        //given
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        books.add(book);
        Library library = new Library(books);

        //when
        LibraryService libraryService = new LibraryService(library);
        List<Book> borrowedBooks = libraryService.borrow(book);

        //then
        assertFalse(borrowedBooks.isEmpty());
        assertTrue(library.getBooks().isEmpty());
    }
}
