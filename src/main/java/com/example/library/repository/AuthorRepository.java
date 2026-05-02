package com.example.library.repository;

import com.example.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    
    // Custom query method performing an inner join between Author and Book
    @Query("SELECT DISTINCT a FROM Author a INNER JOIN a.books b")
    List<Author> findAuthorsWithBooks();
}
