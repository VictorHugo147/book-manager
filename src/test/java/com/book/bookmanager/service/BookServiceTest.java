package com.book.bookmanager.service;

import com.book.bookmanager.dto.BookDTO;
import com.book.bookmanager.entity.Book;
import com.book.bookmanager.exception.BookNotFoundException;
import com.book.bookmanager.repository.BookRepository;
import com.book.bookmanager.utils.BookUtils;
import org.aspectj.weaver.ast.Var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.book.bookmanager.utils.BookUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void whenGivenExistingIdThenReturnThisBook() throws BookNotFoundException {
        Book expectedFoundBook = createFakeBook();

        when(bookRepository.findById(expectedFoundBook.getId())).thenReturn(Optional.of(expectedFoundBook));

        BookDTO bookDTO = bookService.findById(expectedFoundBook.getId());

        assertEquals(expectedFoundBook.getTitulo(),bookDTO.getTitulo());
        assertEquals(expectedFoundBook.getIsbn(),bookDTO.getIsbn());
        assertEquals(expectedFoundBook.getNomePublicador(),bookDTO.getNomePublicador());
    }

    @Test
    void whenGivenUnexistingIdThenNotFindThrowAnException() {
        Long invalidId = 10L;

        when(bookRepository.findById(invalidId)).thenReturn(Optional.ofNullable(any(Book.class)));

        assertThrows(BookNotFoundException.class, () -> bookService.findById(invalidId));
    }
}
