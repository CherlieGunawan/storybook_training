DROP TABLE IF EXISTS book_story;

CREATE TABLE book_story (
    book_id VARCHAR(8) NOT NULL,
    story_id VARCHAR(10) NOT NULL,
    PRIMARY KEY (book_id, story_id)
);

SELECT * FROM book_story;