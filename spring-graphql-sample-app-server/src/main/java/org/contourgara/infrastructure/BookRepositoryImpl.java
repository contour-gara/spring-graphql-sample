package org.contourgara.infrastructure;

import lombok.RequiredArgsConstructor;
import org.contourgara.domain.Book;
import org.contourgara.domain.BookRepository;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final JdbcClient jdbcClient;

    @Override
    public Book findById(String id) {
        return jdbcClient.sql("SELECT id, name, page_count, author_id FROM book WHERE id = ?")
                .param(id)
                .query(new DataClassRowMapper<>(BookEntity.class))
                .optional()
                .orElseThrow(() -> new RuntimeException("No book found with id: " + id))
                .toModel();
    }
}
