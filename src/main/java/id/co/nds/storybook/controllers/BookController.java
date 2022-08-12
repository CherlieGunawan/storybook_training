package id.co.nds.storybook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.nds.storybook.controllers.ControllerGroup.PostingNew;
import id.co.nds.storybook.entities.BookEntity;
import id.co.nds.storybook.exceptions.ClientException;
import id.co.nds.storybook.models.BookModel;
import id.co.nds.storybook.models.ResponseModel;
import id.co.nds.storybook.services.BookService;

@RestController
@Validated
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<ResponseModel> addNew(@Validated(PostingNew.class) @RequestBody BookModel bookModel) throws ClientException {
        BookEntity book = bookService.addNew(bookModel);

        ResponseModel response = new ResponseModel();
        response.setMsg("New book is successfully added");
        response.setData(book);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseModel> getAll() {
        List<BookEntity> book = bookService.getAll();

        ResponseModel response = new ResponseModel();
        response.setMsg("Request successful");
        response.setData(book);
        return ResponseEntity.ok(response);
    }
}
