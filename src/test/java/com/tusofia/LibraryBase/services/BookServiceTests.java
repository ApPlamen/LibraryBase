package com.tusofia.LibraryBase.services;

import com.tusofia.LibraryBase.entities.Book;
import com.tusofia.LibraryBase.infrastructure.BookRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTests {
    @Mock
    private BookRepo mockRepo;
    @Mock
    private RentActiveService mockRentActiveService;
    @InjectMocks
    private BookService bookService;

    @Test
    @DisplayName("Get By Id Should Return Book")
    public void getByIdShouldReturnBook(){
        int bookId = 1;
        Book book = new Book();
        book.setId(bookId);
        Optional<Book> expected = Optional.of(book);

        when(mockRepo.findById(bookId))
                .thenReturn(expected);

        Optional<Book> result = bookService.getById(bookId);

        assertEquals(result, expected);
        verify(mockRepo, times(1)).findById(bookId);
        verifyNoMoreInteractions(mockRepo);
        verifyNoMoreInteractions(mockRentActiveService);
    }

    @Test
    @DisplayName("Get All Should Return List Of Books")
    public void getAllShouldReturnListOfBooks(){
        Book book1 = new Book();
        book1.setId(1);
        Book book2 = new Book();
        book1.setId(2);
        List<Book> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);

        when(mockRepo.findAll())
                .thenReturn(expected);

        List<Book> result = bookService.getAll();

        assertEquals(result, expected);
        verify(mockRepo, times(1)).findAll();
        verifyNoMoreInteractions(mockRepo);
        verifyNoMoreInteractions(mockRentActiveService);
    }
}
