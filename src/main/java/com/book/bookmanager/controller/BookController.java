package com.book.bookmanager.controller;

import com.book.bookmanager.dto.BookDTO;
import com.book.bookmanager.dto.MessageResponseDTO;
import com.book.bookmanager.exception.BookNotFoundException;
import com.book.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.create(bookDTO);
    }

    @PutMapping
    public MessageResponseDTO update(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.create(bookDTO);
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable long id) throws BookNotFoundException {
        return bookService.findById(id);
    }

    @GetMapping
    public List<BookDTO> findAll(@RequestParam MultiValueMap<String, String> queryParams) {
        System.out.println(queryParams);
        String query = queryParams.getFirst("q");
        return bookService.findAll(query);
    }

    @GetMapping("/name/{name}")
    public BookDTO findByTitulo(@PathVariable String name) throws Exception {
        return bookService.findByTitulo(name);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        bookService.deleteById(id);
    }

    @GetMapping("/name")
}

