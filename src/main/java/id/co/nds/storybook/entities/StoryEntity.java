package id.co.nds.storybook.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ms_story")
public class StoryEntity {
    @Id
    @GenericGenerator(name = "story_id_seq", strategy = "id.co.nds.storybook.generators.StoryIdGenerator")
    @GeneratedValue(generator = "story_id_seq")
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.PERSIST)
    @JoinTable(name = "book_story", joinColumns =
            @JoinColumn(name = "story_id", referencedColumnName = "id", nullable = true), inverseJoinColumns = 
            @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = true))
    @JsonIgnoreProperties("storyList")
    private BookEntity book;

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

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }
}
