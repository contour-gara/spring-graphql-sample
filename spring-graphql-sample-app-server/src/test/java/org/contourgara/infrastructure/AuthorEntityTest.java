package org.contourgara.infrastructure;

import org.contourgara.domain.Author;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AuthorEntityTest {
    @Test
    void ドメインモデルに変換できる() {
        // setup
        AuthorEntity sut = new AuthorEntity("author-1", "Joshua", "Bloch");

        // execute
        Author actual = sut.toModel();

        // assert
        Author expected = new Author("author-1", "Joshua", "Bloch");
        assertThat(actual).isEqualTo(expected);
    }
}
