package org.contourgara.presentation;

import org.contourgara.application.AuthorDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AuthorResponseTest {
    @Test
    void DTOから変換できる() {
        // setup
        AuthorDto authorDto = new AuthorDto("author-1", "Joshua", "Bloch");

        // execute
        AuthorResponse actual = AuthorResponse.of(authorDto);

        // assert
        AuthorResponse expected = new AuthorResponse("author-1", "Joshua", "Bloch");
        assertThat(actual).isEqualTo(expected);
    }
}
