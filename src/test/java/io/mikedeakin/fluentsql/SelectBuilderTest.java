package io.mikedeakin.fluentsql;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SelectBuilderTest {

    @Test
    void shouldBuildSimpleSelectStatement() {
        assertThat(SelectBuilder
            .select("*")
            .from("table_name")
            .build()
        ).isEqualTo("SELECT * FROM table_name");
    }

    @Test
    void shouldBuildSelectStatementWithColumnNames() {
        assertThat(SelectBuilder
            .select("column1", "column2", "column3")
            .from("table_name")
            .build()
        ).isEqualTo("SELECT column1, column2, column3 FROM table_name");
    }

    @Test
    void shouldBuildSelectStatementWithWhereClause() {
        assertThat(SelectBuilder
            .select("column1", "column2")
            .from("table_name")
            .where("column1 > 6")
            .build()
        ).isEqualTo("SELECT column1, column2 FROM table_name WHERE column1 > 6");
    }

    @Test
    void shouldBuildSelectStatementWithAdditionalWhereClauses() {
        assertThat(SelectBuilder
            .select("column1", "column2")
            .from("table_name")
            .where("column1 > 6")
            .andWhere("column2 < 32")
            .andWhere("column2 > 0")
            .build()
        ).isEqualTo("SELECT column1, column2 FROM table_name WHERE column1 > 6 AND column2 < 32 AND column2 > 0");
    }

    @Nested
    class InnerJoins {

        @Test
        void shouldBuildSelectStatementWithInnerJoin() {
            assertThat(SelectBuilder
                .select("*")
                .from("some_table")
                .innerJoin("another_table")
                .on("some_table.col1 = another_table.col1")
                .build()
            ).isEqualTo(
                "SELECT *" +
                    " FROM some_table" +
                    " INNER JOIN another_table" +
                    " ON some_table.col1 = another_table.col1"
            );
        }

        @Test
        void shouldBuildSelectStatementWithInnerJoinAndMultipleJoinConditions() {
            assertThat(SelectBuilder
                .select("*")
                .from("some_table")
                .innerJoin("another_table")
                .on("some_table.col1 = another_table.col1")
                .andOn("some_table.col2 = another_table.col2")
                .build()
            ).isEqualTo(
                "SELECT *" +
                    " FROM some_table" +
                    " INNER JOIN another_table" +
                    " ON some_table.col1 = another_table.col1" +
                    " AND ON some_table.col2 = another_table.col2"
            );
        }

        @Test
        void shouldAllowWhereClausesAfterInnerJoins() {
            assertThat(SelectBuilder
                .select("*")
                .from("some_table")
                .innerJoin("another_table")
                .on("some_table.col1 = another_table.col1")
                .where("some_table.col2 = another_table.col2")
                .build()
            ).isEqualTo(
                "SELECT *" +
                    " FROM some_table" +
                    " INNER JOIN another_table" +
                    " ON some_table.col1 = another_table.col1" +
                    " WHERE some_table.col2 = another_table.col2"
            );
        }
    }
    
    @Nested
    class LeftOuterJoins {

        @Test
        void shouldBuildSelectStatementWithLeftOuterJoin() {
            assertThat(SelectBuilder
                .select("*")
                .from("some_table")
                .leftJoin("another_table")
                .on("some_table.col1 = another_table.col1")
                .build()
            ).isEqualTo(
                "SELECT *" +
                    " FROM some_table" +
                    " LEFT OUTER JOIN another_table" +
                    " ON some_table.col1 = another_table.col1"
            );
        }

        @Test
        void shouldBuildSelectStatementWithLeftOuterJoinAndMultipleJoinConditions() {
            assertThat(SelectBuilder
                .select("*")
                .from("some_table")
                .leftJoin("another_table")
                .on("some_table.col1 = another_table.col1")
                .andOn("some_table.col2 = another_table.col2")
                .build()
            ).isEqualTo(
                "SELECT *" +
                    " FROM some_table" +
                    " LEFT OUTER JOIN another_table" +
                    " ON some_table.col1 = another_table.col1" +
                    " AND ON some_table.col2 = another_table.col2"
            );
        }

        @Test
        void shouldAllowWhereClausesAfterLeftOuterJoins() {
            assertThat(SelectBuilder
                .select("*")
                .from("some_table")
                .leftJoin("another_table")
                .on("some_table.col1 = another_table.col1")
                .where("some_table.col2 = another_table.col2")
                .build()
            ).isEqualTo(
                "SELECT *" +
                    " FROM some_table" +
                    " LEFT OUTER JOIN another_table" +
                    " ON some_table.col1 = another_table.col1" +
                    " WHERE some_table.col2 = another_table.col2"
            );
        }
    }
    
    @Nested
    class RightOuterJoins {

        @Test
        void shouldBuildSelectStatementWithRightOuterJoin() {
            assertThat(SelectBuilder
                .select("*")
                .from("some_table")
                .rightJoin("another_table")
                .on("some_table.col1 = another_table.col1")
                .build()
            ).isEqualTo(
                "SELECT *" +
                    " FROM some_table" +
                    " RIGHT OUTER JOIN another_table" +
                    " ON some_table.col1 = another_table.col1"
            );
        }

        @Test
        void shouldBuildSelectStatementWithRightOuterJoinAndMultipleJoinConditions() {
            assertThat(SelectBuilder
                .select("*")
                .from("some_table")
                .rightJoin("another_table")
                .on("some_table.col1 = another_table.col1")
                .andOn("some_table.col2 = another_table.col2")
                .build()
            ).isEqualTo(
                "SELECT *" +
                    " FROM some_table" +
                    " RIGHT OUTER JOIN another_table" +
                    " ON some_table.col1 = another_table.col1" +
                    " AND ON some_table.col2 = another_table.col2"
            );
        }

        @Test
        void shouldAllowWhereClausesAfterRightOuterJoins() {
            assertThat(SelectBuilder
                .select("*")
                .from("some_table")
                .rightJoin("another_table")
                .on("some_table.col1 = another_table.col1")
                .where("some_table.col2 = another_table.col2")
                .build()
            ).isEqualTo(
                "SELECT *" +
                    " FROM some_table" +
                    " RIGHT OUTER JOIN another_table" +
                    " ON some_table.col1 = another_table.col1" +
                    " WHERE some_table.col2 = another_table.col2"
            );
        }
    }

    @Nested
    class GroupByClauses {

       @Test
       void shouldAllowGroupByClauseAfterFromClause() {
          assertThat(SelectBuilder
              .select("*")
              .from("some_table")
              .groupBy("column1", "column2")
              .build()
          ).isEqualTo(
              "SELECT *" +
                  " FROM some_table" +
                  " GROUP BY column1, column2"
          );
       }

        @Test
        void shouldAllowGroupByClauseAfterWhereClause() {
            assertThat(SelectBuilder
                .select("*")
                .from("some_table")
                .where("column1 IN (1, 2, 3)")
                .groupBy("column1", "column2")
                .build()
            ).isEqualTo(
                "SELECT *" +
                    " FROM some_table" +
                    " WHERE column1 IN (1, 2, 3)" +
                    " GROUP BY column1, column2"
            );
        }

        @Test
        void shouldAllowGroupByClauseAfterJoinClause() {
            assertThat(SelectBuilder
                .select("*")
                .from("some_table")
                .innerJoin("other_table")
                .on("some_table.column1 = other_table.column1")
                .groupBy("column1", "column2")
                .build()
            ).isEqualTo(
                "SELECT *" +
                    " FROM some_table" +
                    " INNER JOIN other_table" +
                    " ON some_table.column1 = other_table.column1" +
                    " GROUP BY column1, column2"
            );
        }
    }

    @Nested
    class OrderByClauses {

        @Test
        void shouldAllowOrderByClauseAfterFromClause() {
            assertThat(SelectBuilder
                .select("*")
                .from("some_table")
                .orderBy("column1", "column2")
                .build()
            ).isEqualTo(
                "SELECT *" +
                    " FROM some_table" +
                    " ORDER BY column1, column2"
            );
        }

        @Test
        void shouldAllowOrderByClauseAfterWhereClause() {
            assertThat(SelectBuilder
                .select("*")
                .from("some_table")
                .where("column1 IN (1, 2, 3)")
                .orderBy("column1", "column2")
                .build()
            ).isEqualTo(
                "SELECT *" +
                    " FROM some_table" +
                    " WHERE column1 IN (1, 2, 3)" +
                    " ORDER BY column1, column2"
            );
        }

        @Test
        void shouldAllowOrderByClauseAfterJoinClause() {
            assertThat(SelectBuilder
                .select("*")
                .from("some_table")
                .innerJoin("other_table")
                .on("some_table.column1 = other_table.column1")
                .orderBy("column1", "column2")
                .build()
            ).isEqualTo(
                "SELECT *" +
                    " FROM some_table" +
                    " INNER JOIN other_table" +
                    " ON some_table.column1 = other_table.column1" +
                    " ORDER BY column1, column2"
            );
        }

        @Test
        void shouldAllowOrderByClauseAfterGroupByClause() {
            assertThat(SelectBuilder
                .select("*")
                .from("some_table")
                .groupBy("column1")
                .orderBy("column2")
                .build()
            ).isEqualTo(
                "SELECT *" +
                    " FROM some_table" +
                    " GROUP BY column1" +
                    " ORDER BY column2"
            );
        }
    }
}
