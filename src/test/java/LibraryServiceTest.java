import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryServiceTest {

    @Test
    void shouldBorrowABookFromLibrary() throws Exception {
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

    @Test
    void shouldNotBorrowMoreThanTwoBooksFromLibrary() throws Exception {
        //given
        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        books.add(book1);
        Book book2 = new Book();
        books.add(book2);
        Book book3 = new Book();
        books.add(book3);
        Library library = new Library(books);

        //when
        LibraryService libraryService = new LibraryService(library);
        libraryService.borrow(book1);
        libraryService.borrow(book2);
        Exception exception = assertThrows(Exception.class, () -> libraryService.borrow(book3));

        //then
        assertEquals("can not borrow more than 2 books", exception.getMessage());
    }
}
