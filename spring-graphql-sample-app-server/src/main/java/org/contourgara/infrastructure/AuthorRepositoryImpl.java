package org.contourgara.infrastructure;

import lombok.RequiredArgsConstructor;
import org.contourgara.domain.Author;
import org.contourgara.domain.AuthorRepository;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {
    private final JdbcClient jdbcClient;

    @Override
    public Author findById(String id) {
        return jdbcClient.sql("SELECT id, first_name, last_name FROM author WHERE id = ?")
                .param(id)
                .query(new DataClassRowMapper<>(AuthorEntity.class))
                .optional()
                .get()
                .toModel();
    }
}
