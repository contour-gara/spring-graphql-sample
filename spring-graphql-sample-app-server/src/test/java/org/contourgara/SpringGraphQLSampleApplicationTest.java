package org.contourgara;

import org.contourgara.domain.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class SpringGraphQLSampleApplicationTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    void contextLoads() {
        // assert
        assertThat(bookRepository).isNotNull();
    }
}
