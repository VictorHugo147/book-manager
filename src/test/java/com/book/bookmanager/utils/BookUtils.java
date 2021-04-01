package com.book.bookmanager.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import com.book.bookmanager.dto.BookDTO;
import com.book.bookmanager.entity.Book;

import static com.book.bookmanager.utils.AuthorUtils.createFakeAuthor;
import static com.book.bookmanager.utils.AuthorUtils.createFakeAuthorDTO;
import static com.book.bookmanager.utils.AuthorUtils.createFakeAuthorFrom;

public class BookUtils {

    private static final Faker faker = Faker.instance();

    public static BookDTO createFakeBookDTO() {
        return BookDTO.builder()
                .id(faker.number().randomNumber())
                .titulo(faker.book().title())
                .pag(faker.number().numberBetween(0, 200))
                .cap(faker.number().numberBetween(1, 20))
                .isbn("0-596-52068-9")
                .nomePublicador(faker.book().publisher())
                .autor(createFakeAuthorDTO())
                .build();
    }

    public static Book createFakeBook() {
        return Book.builder()
                .id(faker.number().randomNumber())
                .titulo(faker.book().title())
                .pag(faker.number().numberBetween(0, 200))
                .cap(faker.number().numberBetween(1, 20))
                .isbn("0-596-52068-9")
                .nomePublicador(faker.book().publisher())
                .autor(createFakeAuthor())
                .build();
    }

    public static Book createFakeBookFrom(BookDTO bookDTO) {
        return Book.builder()
                .id(bookDTO.getId())
                .titulo(bookDTO.getTitulo())
                .pag(bookDTO.getPag())
                .cap(bookDTO.getCap())
                .isbn(bookDTO.getIsbn())
                .nomePublicador(bookDTO.getNomePublicador())
                .autor(createFakeAuthorFrom(bookDTO.getAutor()))
                .build();
    }

    public static String asJsonString(BookDTO bookDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModules(new JavaTimeModule());

            return objectMapper.writeValueAsString(bookDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
