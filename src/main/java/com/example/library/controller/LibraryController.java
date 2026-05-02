package com.example.library.controller;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("authors", libraryService.getAllAuthors());
        model.addAttribute("books", libraryService.getAllBooks());
        return "index";
    }

    // CREATE Author
    @GetMapping("/add-author")
    public String showAddAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "add-author";
    }

    @PostMapping("/save-author")
    public String saveAuthor(@ModelAttribute("author") Author author, Model model) {
        try {
            libraryService.saveAuthor(author);
            return "redirect:/";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Error: Duplicate email or integrity violation!");
            return "add-author";
        }
    }

    // CREATE Book
    @GetMapping("/add-book")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", libraryService.getAllAuthors());
        return "add-book";
    }

    @PostMapping("/save-book")
    public String saveBook(@ModelAttribute("book") Book book, Model model) {
        try {
            libraryService.saveBook(book);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", "Error saving book: " + e.getMessage());
            model.addAttribute("authors", libraryService.getAllAuthors());
            return "add-book";
        }
    }

    // READ Operations (Listings are in home, but let's add a specific join view)
    @GetMapping("/authors-with-books")
    public String authorsWithBooks(Model model) {
        model.addAttribute("authors", libraryService.getAuthorsWithBooks());
        return "authors-list";
    }

    // UPDATE Author
    @GetMapping("/edit-author/{id}")
    public String showEditAuthorForm(@PathVariable("id") Long id, Model model) {
        Author author = libraryService.getAuthorById(id).orElseThrow(() -> new IllegalArgumentException("Invalid author Id:" + id));
        model.addAttribute("author", author);
        return "edit-author";
    }

    @PostMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable("id") Long id, @ModelAttribute("author") Author author, Model model) {
        try {
            author.setId(id);
            libraryService.saveAuthor(author);
            return "redirect:/";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Error: Integrity violation during update!");
            return "edit-author";
        }
    }
}
