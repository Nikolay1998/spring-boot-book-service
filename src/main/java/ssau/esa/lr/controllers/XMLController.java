package ssau.esa.lr.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ssau.esa.lr.entity.Author;
import ssau.esa.lr.entity.Book;
import ssau.esa.lr.entity.Genre;
import ssau.esa.lr.repos.AuthorRepo;
import ssau.esa.lr.repos.BookRepo;
import ssau.esa.lr.repos.GenreRepo;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

@Controller
@RequestMapping("/xml")
public class XMLController {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final GenreRepo genreRepo;

    @Autowired
    public XMLController(AuthorRepo authorRepo, BookRepo bookRepo, GenreRepo genreRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.genreRepo = genreRepo;
    }

    @ResponseBody
    @GetMapping(path = "/authors", produces = MediaType.APPLICATION_XML_VALUE)
    private ModelAndView getAuthors() throws JsonProcessingException {
        Iterable<Author> list =  authorRepo.findAll();
        return getModelAndView(list, "authorXSL");
    }

    @ResponseBody
    @GetMapping(path = "/books", produces = MediaType.APPLICATION_XML_VALUE)
    private ModelAndView getBooks() throws JsonProcessingException{
        Iterable<Book> list =  bookRepo.findAll();
        return getModelAndView(list, "bookXSL");
    }

    @ResponseBody
    @GetMapping(path = "/genres", produces = MediaType.APPLICATION_XML_VALUE)
    private ModelAndView getGenres() throws JsonProcessingException{
        Iterable<Genre> list =  genreRepo.findAll();
        return getModelAndView(list, "genreXSL");
    }

    private ModelAndView getModelAndView(Iterable<?> list, String viewName) throws JsonProcessingException {
        String str = new XmlMapper().writeValueAsString(list);
        ModelAndView mod = new ModelAndView(viewName);
        Source src = new StreamSource(new StringReader(str));
        mod.addObject("ArrayList", src);
        return mod;
    }
}