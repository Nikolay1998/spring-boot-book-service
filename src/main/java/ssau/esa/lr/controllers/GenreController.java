package ssau.esa.lr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ssau.esa.lr.entity.Genre;
import ssau.esa.lr.repos.GenreRepo;

@RestController
public class GenreController {
    private final GenreRepo repo;

    @Autowired
    public GenreController(GenreRepo repo) {
        this.repo = repo;
    }

    @GetMapping(path = "/genres", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Iterable<Genre> findAll(){
        return repo.findAll();
    }

    @GetMapping(path = "/add_genre", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private String add(String name){
        Genre genre = new Genre();
        genre.setName(name);
        repo.save(genre);
        return "ok";
    }
}
