package org.contourgara.presentation;

import lombok.RequiredArgsConstructor;
import org.contourgara.application.BookQueryUseCase;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookQueryUseCase bookQueryUseCase;

    @QueryMapping
    public BookResponse bookById(@Argument(name = "id") String id) {
        return BookResponse.of(bookQueryUseCase.findBookById(id));
    }

    @SchemaMapping(typeName = "Book", field = "author")
    public AuthorResponse author(BookResponse bookResponse) {
        return AuthorResponse.of(bookQueryUseCase.findAuthorById(bookResponse.authorId()));
    }
}
