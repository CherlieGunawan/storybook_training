package id.co.nds.storybook.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ms_book")
public class BookEntity {
    @Id
    @GenericGenerator(name = "book_id_seq", strategy = "id.co.nds.storybook.generators.BookIdGenerator")
    @GeneratedValue(generator = "book_id_seq")
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book", fetch = FetchType.EAGER)
	private List<StoryEntity> storyList = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StoryEntity> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<StoryEntity> storyList) {
        this.storyList = storyList;
    }
}
