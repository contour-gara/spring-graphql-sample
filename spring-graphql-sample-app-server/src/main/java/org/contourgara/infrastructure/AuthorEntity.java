package org.contourgara.infrastructure;

import org.contourgara.domain.Author;

public record AuthorEntity(String id, String firstName, String lastName) {
    public Author toModel() {
        return new Author(id, firstName, lastName);
    }
}
