package io.mikedeakin.fluentsql;

import io.mikedeakin.fluentsql.clauses.select.SelectClause;
import io.mikedeakin.fluentsql.clauses.update.UpdateClause;

public class SqlBuilders {

    private SqlBuilders() {}

    public static SelectClause select(String... column) {
        return SelectBuilder.select(column);
    }

    public static UpdateClause update(String tableName) {
        return UpdateBuilder.update(tableName);
    }
}
