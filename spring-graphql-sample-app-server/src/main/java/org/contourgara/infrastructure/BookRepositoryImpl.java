package org.contourgara.infrastructure;

import org.contourgara.domain.Book;
import org.contourgara.domain.BookRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @Override
    public Book findById(String id) {
        return null;
    }
}
