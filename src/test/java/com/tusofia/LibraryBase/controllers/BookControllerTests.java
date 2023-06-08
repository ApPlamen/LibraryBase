package com.tusofia.LibraryBase.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tusofia.LibraryBase.entities.Book;
import com.tusofia.LibraryBase.services.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@WebMvcTest(BookController.class)
public class BookControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService mockBookService;

    @Test
    @DisplayName("Get Should Return Book")
    public void getShouldReturnBook() throws Exception {
        int bookId = 1;
        Book book = new Book();
        book.setId(bookId);
        Optional<Book> expected = Optional.of(book);

        Mockito.when(mockBookService.getById(bookId))
                .thenReturn(expected);

        ObjectMapper objectMapper = new ObjectMapper();
        String bookJson = objectMapper.writeValueAsString(expected.get());

        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/book/get/" + bookId)
                .contentType("application/json");

        MvcResult result = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();

        assertEquals(bookJson, content);
        Mockito.verify(mockBookService, Mockito.times(1)).getById(bookId);
    }

    @Test
    @DisplayName("Get All Should Return List Of Books")
    public void getAllShouldReturnListOfBooks() throws Exception {
        Book book1 = new Book();
        book1.setId(1);
        Book book2 = new Book();
        book1.setId(2);
        List<Book> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);

        Mockito.when(mockBookService.getAll())
                .thenReturn(expected);

        ObjectMapper objectMapper = new ObjectMapper();
        String bookListJson = objectMapper.writeValueAsString(expected);

        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/book/get-all")
                .contentType("application/json");

        MvcResult result = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();

        assertEquals(bookListJson, content);
        Mockito.verify(mockBookService, Mockito.times(1)).getAll();
    }
}
