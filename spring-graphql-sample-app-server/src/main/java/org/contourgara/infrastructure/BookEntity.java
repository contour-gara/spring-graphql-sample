package org.contourgara.infrastructure;

import org.contourgara.domain.Book;

public record BookEntity(String id, String name, Integer pageCount, String authorId) {
    public Book toModel() {
        return new Book(id, name, pageCount, authorId);
    }
}
