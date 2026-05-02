package com.example.library.service;

import com.example.library.entity.Author;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LibraryServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private LibraryService libraryService;

    @Test
    public void testGetAllAuthors() {
        Author author1 = Author.builder().id(1L).name("Author 1").build();
        Author author2 = Author.builder().id(2L).name("Author 2").build();
        when(authorRepository.findAll()).thenReturn(Arrays.asList(author1, author2));

        List<Author> authors = libraryService.getAllAuthors();

        assertEquals(2, authors.size());
        verify(authorRepository, times(1)).findAll();
    }

    @Test
    public void testSaveAuthor() {
        Author author = Author.builder().name("New Author").build();
        when(authorRepository.save(author)).thenReturn(author);

        Author savedAuthor = libraryService.saveAuthor(author);

        assertNotNull(savedAuthor);
        assertEquals("New Author", savedAuthor.getName());
        verify(authorRepository, times(1)).save(author);
    }

    @Test
    public void testGetAuthorById() {
        Author author = Author.builder().id(1L).name("Author 1").build();
        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));

        Optional<Author> foundAuthor = libraryService.getAuthorById(1L);

        assertTrue(foundAuthor.isPresent());
        assertEquals("Author 1", foundAuthor.get().getName());
    }
}
