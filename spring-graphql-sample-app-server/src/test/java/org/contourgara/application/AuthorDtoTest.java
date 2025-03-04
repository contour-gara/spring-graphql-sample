package org.contourgara.application;

import org.contourgara.domain.Author;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AuthorDtoTest {
    @Test
    void モデルから変換できる() {
        // setup
        Author author = new Author("author-1", "Joshua", "Bloch");

        // execute
        AuthorDto actual = AuthorDto.of(author);

        // assert
        AuthorDto expected = new AuthorDto("author-1", "Joshua", "Bloch");
        assertThat(actual).isEqualTo(expected);
    }
}
