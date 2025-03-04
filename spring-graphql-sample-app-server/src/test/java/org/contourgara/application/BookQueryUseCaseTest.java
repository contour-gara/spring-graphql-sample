package org.contourgara.application;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.junit5.api.DBRider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@DBUnit
@DBRider
class BookQueryUseCaseTest {
    @Autowired
    BookQueryUseCase sut;

    @Test
    @DataSet(value = "datasets/setup/author.yml")
    @ExpectedDataSet(value = "datasets/expected/author.yml")
    void 著者IDから著者が返る() {
        // execute
        AuthorDto actual = sut.findAuthorById("author-1");

        // assert
        AuthorDto expected = new AuthorDto("author-1", "Joshua", "Bloch");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DataSet(value = {"datasets/setup/book.yml", "datasets/setup/author.yml"})
    @ExpectedDataSet(value = {"datasets/expected/book.yml", "datasets/expected/author.yml"})
    void 本IDから本が返る() {
        // execute
        BookDto actual = sut.findBookById("book-1");

        // assert
        BookDto expected = new BookDto("book-1", "Effective Java", 416, "author-1");
        assertThat(actual).isEqualTo(expected);
    }
}
