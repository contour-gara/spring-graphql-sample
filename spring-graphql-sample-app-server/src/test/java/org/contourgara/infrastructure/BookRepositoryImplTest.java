package org.contourgara.infrastructure;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.junit5.api.DBRider;
import org.contourgara.domain.Book;
import org.contourgara.domain.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@DBUnit
@DBRider
class BookRepositoryImplTest {
    @Autowired
    BookRepository sut;

    @Test
    @DataSet(value = {"datasets/setup/book.yml", "datasets/setup/author.yml"})
    @ExpectedDataSet(value = {"datasets/expected/book.yml", "datasets/expected/author.yml"})
    void 本をID検索できる() {
        // execute
        Book actual = sut.findById("book-1");

        // assert
        Book expected = new Book("book-1", "Effective Java", 416, "author-1");
        assertThat(actual).isEqualTo(expected);
    }
}
