package com.book.bookmanager.repository;

import com.book.bookmanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitulo(String titulo);

    List<Book> findByTituloContainingIgnoreCase(String titulo);
}
