package ssau.esa.lr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ssau.esa.lr.entity.Author;
import ssau.esa.lr.entity.Book;
import ssau.esa.lr.entity.Genre;
import ssau.esa.lr.notifications.JmsSenderService;
import ssau.esa.lr.repos.AuthorRepo;
import ssau.esa.lr.repos.BookRepo;
import ssau.esa.lr.repos.GenreRepo;

@RestController
public class BookController {
    private final BookRepo  repo;
    private final AuthorRepo authorRepo;
    private final GenreRepo genreRepo;
    private final JmsSenderService jmsSenderService;

    @Autowired
    public BookController(BookRepo repo, AuthorRepo authorRepo, GenreRepo genreRepo, JmsSenderService jmsSenderService) {
        this.repo = repo;
        this.authorRepo = authorRepo;
        this.genreRepo = genreRepo;
        this.jmsSenderService = jmsSenderService;
    }

    @GetMapping(path = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Iterable<Book> findAll(){
        return repo.findAll();
    }

    @GetMapping(path = "/add_book", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private String add(String name, int count, long genreId, long authorId){
        Book book = new Book();
        book.setName(name);
        book.setCount(count);
        Author author = authorRepo.findById(authorId).orElse(null);
        if(author == null){return "error";}
        Genre genre = genreRepo.findById(genreId).orElse(null);
        if(genre == null){return "error";}
        book.setAuthor(author);
        book.setGenre(genre);
        repo.save(book);
        jmsSenderService.sendBookCreate(book, "Create");
        jmsSenderService.sendEvent(Book.class, book, "Create");
        return "ok";
    }
}
