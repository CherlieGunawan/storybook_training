package id.co.nds.storybook.controllers;

import java.util.List;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.nds.storybook.Exceptions.ClientException;
import id.co.nds.storybook.controllers.ControllerGroup.PostingNew;
import id.co.nds.storybook.entities.StoryEntity;
import id.co.nds.storybook.models.ResponseModel;
import id.co.nds.storybook.models.StoryModel;
import id.co.nds.storybook.services.StoryService;

@RestController
@Validated
@RequestMapping("/story")
public class StoryController {
    @Autowired
    StoryService storyService;

    @PostMapping("/add")
    public ResponseEntity<ResponseModel> addNew(@Validated(PostingNew.class) @RequestBody StoryModel storyModel,
            @Pattern(regexp = "^book[0-9]{4}$", message = "Book ID starts with book followed by 4 digits of number")
            @RequestParam String bookId) throws ClientException {
        StoryEntity story = storyService.addNew(storyModel, bookId);

        ResponseModel response = new ResponseModel();
        response.setMsg("New story is successfully added");
        response.setData(story);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseModel> getAll() {
        List<StoryEntity> story = storyService.getAll();

        ResponseModel response = new ResponseModel();
        response.setMsg("Request successful");
        response.setData(story);
        return ResponseEntity.ok(response);
    }
}
