package org.contourgara.application;

import org.contourgara.domain.Author;

public record AuthorDto(String id, String firstName, String lastName) {
    public static AuthorDto of(Author author) {
        return new AuthorDto(author.id(), author.firstName(), author.lastName());
    }
}
