package uz.pdp.mapper;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.dto.BookCreateDto;
import uz.pdp.dto.BookDto;
import uz.pdp.dto.BookUpdateDto;
import uz.pdp.entity.Book;

import java.util.List;
@Component
@Mapper(componentModel = "spring")
public interface BookMapper extends BaseMapper<
        Book,
        BookDto,
        BookCreateDto,
        BookUpdateDto> {
    @Override
    BookDto toDto(Book book);

    @Override
    List<BookDto> toDto(List<Book> e);

    @Override
    Book fromCreateDto(BookCreateDto bookCreateDto);

    @Override
    Book fromUpdateDto(BookUpdateDto bookUpdateDto);
}
