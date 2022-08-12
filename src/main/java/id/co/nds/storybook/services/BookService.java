package id.co.nds.storybook.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.nds.storybook.Exceptions.ClientException;
import id.co.nds.storybook.entities.BookEntity;
import id.co.nds.storybook.models.BookModel;
import id.co.nds.storybook.repos.BookRepo;
import id.co.nds.storybook.validators.ObjectValidator;

@Service
public class BookService implements Serializable {
    @Autowired
    BookRepo bookRepo;

    ObjectValidator objectValidator = new ObjectValidator();

    public BookEntity addNew(BookModel bookModel) throws ClientException {
        Long count = bookRepo.countByName(bookModel.getName());
        if(count > 0) {
            throw new ClientException("Book name already exists");
        }

        BookEntity book = new BookEntity();
        book.setName(bookModel.getName());

        return bookRepo.save(book);
    }

    public List<BookEntity> getAll() {
        return bookRepo.findAll();
    }
}
