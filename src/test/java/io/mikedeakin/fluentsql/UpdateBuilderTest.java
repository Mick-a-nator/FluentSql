package io.mikedeakin.fluentsql;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UpdateBuilderTest {

    @Test
    void shouldCreateSimpleUpdateStatement() {
        assertThat(UpdateBuilder.update("table_name")
            .set("column_name", "'New Value'")
            .build()
        ).isEqualTo("UPDATE table_name SET column_name = 'New Value'");
    }

    @Test
    void shouldCreateUpdateStatementWithWhereClause() {
        assertThat(UpdateBuilder.update("table_name")
            .set("column_name", "'New Value'")
            .where("column2 = 2")
            .build()
        ).isEqualTo("UPDATE table_name SET column_name = 'New Value' WHERE column2 = 2");
    }
}