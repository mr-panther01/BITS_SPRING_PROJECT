package com.example.library.component;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private LibraryService libraryService;

    @Override
    public void run(String... args) throws Exception {
        // Populate Authors
        for (int i = 1; i <= 10; i++) {
            Author author = Author.builder()
                    .name("Author " + i)
                    .email("author" + i + "@example.com")
                    .build();
            author = libraryService.saveAuthor(author);

            // Populate Books for each author
            Book book = Book.builder()
                    .title("Book Title " + i)
                    .isbn("ISBN-000" + i)
                    .author(author)
                    .build();
            libraryService.saveBook(book);
        }
    }
}
