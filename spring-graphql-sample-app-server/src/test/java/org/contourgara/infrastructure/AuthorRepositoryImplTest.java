package org.contourgara.infrastructure;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.junit5.api.DBRider;
import org.contourgara.domain.Author;
import org.contourgara.domain.AuthorRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@DBUnit
@DBRider
class AuthorRepositoryImplTest {
    @Autowired
    private AuthorRepository sut;

    @BeforeAll
    @DataSet(value = "datasets/setup/empty.yml")
    static void setUpAll() {}

    @Test
    @DataSet(value = "datasets/setup/author.yml")
    @ExpectedDataSet(value = "datasets/expected/author.yml")
    void 著者をID検索できる() {
        // execute
        Author actual = sut.findById("author-1");

        // assert
        Author expected = new Author("author-1", "Joshua", "Bloch");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DataSet(value = "datasets/setup/author.yml")
    @ExpectedDataSet(value = "datasets/expected/author.yml")
    void IDが存在しない場合例外が返る() {
        // execute & assert
        assertThatThrownBy(() -> sut.findById("author-2"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("No author found with id: author-2");
    }
}
