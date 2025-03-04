package org.contourgara.application;

import lombok.RequiredArgsConstructor;
import org.contourgara.domain.AuthorRepository;
import org.contourgara.domain.BookRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookQueryUseCase {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookDto findBookById(String id) {
        return BookDto.of(bookRepository.findById(id));
    }

    public AuthorDto findAuthorById(String id) {
        return AuthorDto.of(authorRepository.findById(id));
    }
}
