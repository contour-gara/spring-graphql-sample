package org.contourgara.infrastructure;

import org.contourgara.domain.Book;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BookEntityTest {
    @Test
    void モデルに変換できる() {
        // setup
        BookEntity sut = new BookEntity("book-1", "Effective Java", 416, "author-1");

        // execute
        Book actual = sut.toModel();

        // assert
        Book expected = new Book("book-1", "Effective Java", 416, "author-1");
        assertThat(actual).isEqualTo(expected);
    }
}
