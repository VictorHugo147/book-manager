package com.book.bookmanager.mapper;

import com.book.bookmanager.dto.BookDTO;
import com.book.bookmanager.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    public static final BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    public Book toModel(BookDTO bookDTO);

    BookDTO toDTO(Book book);
}
