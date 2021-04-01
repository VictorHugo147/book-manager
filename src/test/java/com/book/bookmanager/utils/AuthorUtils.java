package com.book.bookmanager.utils;

import com.github.javafaker.Faker;
import com.book.bookmanager.dto.AuthorDTO;
import com.book.bookmanager.entity.Author;

public class AuthorUtils {

    private static final Faker faker = Faker.instance();

    public static AuthorDTO createFakeAuthorDTO() {
        return AuthorDTO.builder()
                .id(faker.number().randomNumber())
                .nomeAutor(faker.book().author())
                .idade(faker.number().numberBetween(0, 100))
                .build();
    }

    public static Author createFakeAuthor() {
        return Author.builder()
                .id(faker.number().randomNumber())
                .nomeAutor(faker.book().author())
                .idade(faker.number().numberBetween(0, 100))
                .build();
    }

    public static Author createFakeAuthorFrom(AuthorDTO authorDTO) {
        return Author.builder()
                .id(authorDTO.getId())
                .nomeAutor(authorDTO.getNomeAutor())
                .idade(authorDTO.getIdade())
                .build();
    }
}
