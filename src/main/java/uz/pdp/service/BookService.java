package uz.pdp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.dto.BookCreateDto;
import uz.pdp.dto.BookDto;
import uz.pdp.dto.BookUpdateDto;
import uz.pdp.entity.Book;
import uz.pdp.mapper.BookMapper;
import uz.pdp.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;
    private final BookMapper mapper;


    public Long create(BookCreateDto createDto) {
        Book book = mapper.fromCreateDto(createDto);
        book.setName(createDto.getName());
        book.setAuthor(createDto.getAuthor());
        book.setPrice(createDto.getPrice());
        book.setSize(createDto.getSize());
        return repository.save(book).getId();
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }


    public void update(BookUpdateDto updateDto) {
        Book book = mapper.fromUpdateDto(updateDto);
        repository.save(book);

    }


    public List<BookDto> getAll() {
        return mapper.toDto(repository.getAllBooks());
    }


    public BookDto get(Long id) {
        Book book = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Topilmadi");
        });
        return mapper.toDto(book);
    }

}
