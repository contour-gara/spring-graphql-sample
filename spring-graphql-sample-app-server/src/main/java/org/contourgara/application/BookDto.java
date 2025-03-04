package org.contourgara.application;

import org.contourgara.domain.Book;

public record BookDto(String id, String name, int pageCount, String authorId) {
    public static BookDto of(Book book) {
        return new BookDto(book.id(), book.name(), book.pageCount(), book.authorId());
    }
}
