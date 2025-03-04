package org.contourgara.presentation;

import org.contourgara.application.BookDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BookResponseTest {
    @Test
    void DTOから変換できる() {
        // setup
        BookDto bookDto = new BookDto("book-1", "Effective Java", 416, "author-1");

        // execute
        BookResponse actual = BookResponse.of(bookDto);

        // assert
        BookResponse expected = new BookResponse("book-1", "Effective Java", 416, "author-1");
        assertThat(actual).isEqualTo(expected);
    }
}
