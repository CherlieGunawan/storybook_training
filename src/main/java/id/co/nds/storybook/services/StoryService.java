package id.co.nds.storybook.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.nds.storybook.entities.BookEntity;
import id.co.nds.storybook.entities.StoryEntity;
import id.co.nds.storybook.exceptions.ClientException;
import id.co.nds.storybook.models.StoryModel;
import id.co.nds.storybook.repos.BookRepo;
import id.co.nds.storybook.repos.StoryRepo;
import id.co.nds.storybook.validators.ObjectValidator;

@Service
public class StoryService implements Serializable {
    @Autowired
    StoryRepo storyRepo;

    @Autowired
    BookRepo bookRepo;

    ObjectValidator objectValidator = new ObjectValidator();

    public StoryEntity addNew(StoryModel storyModel, String bookId) throws ClientException {
        Long count = storyRepo.countByName(storyModel.getName());
        if(count > 0) {
            throw new ClientException("Story name already exists");
        }

        BookEntity book = bookRepo.findById(bookId).orElse(null);
        objectValidator.nullCheckObject(book);

        StoryEntity story = new StoryEntity();
        story.setName(storyModel.getName());

        List<StoryEntity> storyList = book.getStoryList();
        storyList.add(story);

        story.setBook(book);
        book.setStoryList(storyList);

        return storyRepo.save(story);
    }

    public List<StoryEntity> getAll() {
        return storyRepo.findAll();
    }
}
