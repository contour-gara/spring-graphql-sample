package org.contourgara.presentation;

import org.contourgara.application.AuthorDto;

public record AuthorResponse(String id, String firstName, String lastName) {
    public static AuthorResponse of(AuthorDto authorDto) {
        return new AuthorResponse(authorDto.id(), authorDto.firstName(), authorDto.lastName());
    }
}
