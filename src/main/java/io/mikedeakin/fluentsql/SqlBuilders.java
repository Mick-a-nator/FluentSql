package io.mikedeakin.fluentsql;

import io.mikedeakin.fluentsql.clauses.select.SelectClause;

public class SqlBuilders {

    private SqlBuilders() {}

    public static SelectClause select(String column) {
        return SelectBuilder.select(column);
    }
}
