package org.contourgara.presentation;

import org.contourgara.application.BookDto;

public record BookResponse(String id, String name, int pageCount, String authorId) {
    public static BookResponse of(BookDto bookDto) {
        return new BookResponse(bookDto.id(), bookDto.name(), bookDto.pageCount(), bookDto.authorId());
    }
}
