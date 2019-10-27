package io.mikedeakin.fluentsql;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SqlBuildersTest {

    @Test
    void shouldCreateSelectBuilder() {
        assertThat(SqlBuilders.select("column1", "column2"))
            .isEqualToComparingFieldByFieldRecursively(SelectBuilder.select("column1", "column2"));
    }

    @Test
    void shouldCreateUpdateBuilder() {
        assertThat(SqlBuilders.update("table_name"))
            .isEqualToComparingFieldByFieldRecursively(UpdateBuilder.update("table_name"));
    }
}