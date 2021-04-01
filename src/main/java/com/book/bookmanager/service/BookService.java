package com.book.bookmanager.service;

import com.book.bookmanager.dto.BookDTO;
import com.book.bookmanager.dto.MessageResponseDTO;
import com.book.bookmanager.entity.Book;
import com.book.bookmanager.exception.BookNotFoundException;
import com.book.bookmanager.mapper.BookMapper;
import com.book.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO) {
        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created by ID " + savedBook.getId())
                .build();
    }

    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    public BookDTO findById(long id) throws BookNotFoundException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        return bookMapper.toDTO(book);
    }

    public BookDTO findByTitulo(String name) throws Exception {
        Book book = bookRepository.findByTitulo(name)
                .orElseThrow(() -> new Exception(name));

        return bookMapper.toDTO(book);
    }

    public List<BookDTO> findAll(String query) {
        List<Book> listOfBooks = new ArrayList<>();

        if (query != null && !query.isEmpty()) {
            listOfBooks = bookRepository.findByTituloContainingIgnoreCase(query);
        } else {
            listOfBooks = bookRepository.findAll();
        }

        return listOfBooks
                .stream()
                .map(book -> bookMapper.toDTO(book))
                .collect(Collectors.toList());
    }

}
