package br.dev.sam.secureresttls.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.sam.secureresttls.domain.Book;
import br.dev.sam.secureresttls.repository.BookRepository;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable<Book> getBooks(){
        return bookRepository.findAll();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable Long bookId){
        return bookRepository.findById(bookId).orElseThrow(RuntimeException::new);
    }

    @DeleteMapping
    public void deleteBook(@PathVariable Long bookId){
        bookRepository.deleteById(bookId);
    }
}
