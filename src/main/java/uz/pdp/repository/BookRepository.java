package uz.pdp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.pdp.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    @Query(value = "select * from Book s order by s.id asc ", nativeQuery = true)
    List<Book> getAllBooks();
}
