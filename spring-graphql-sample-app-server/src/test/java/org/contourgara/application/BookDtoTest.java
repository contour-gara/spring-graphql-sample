package org.contourgara.application;

import org.contourgara.domain.Book;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BookDtoTest {
    @Test
    void モデルから変換できる() {
        // setup
        Book book = new Book("book-1", "Effective Java", 416, "author-1");

        // execute
        BookDto actual = BookDto.of(book);

        // assert
        BookDto expected = new BookDto("book-1", "Effective Java", 416, "author-1");
        assertThat(actual).isEqualTo(expected);
    }
}
