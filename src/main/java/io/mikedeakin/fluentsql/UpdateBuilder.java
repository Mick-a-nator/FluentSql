package io.mikedeakin.fluentsql;

import io.mikedeakin.fluentsql.clauses.update.SetClause;
import io.mikedeakin.fluentsql.clauses.update.UpdateClause;
import io.mikedeakin.fluentsql.clauses.update.WhereClause;

public class UpdateBuilder implements UpdateClause, SetClause, WhereClause {

    private final StringBuilder statement;

    private UpdateBuilder() {
        statement = new StringBuilder();
    }

    private UpdateBuilder append(String value) {
        statement.append(value);
        return this;
    }

    public static UpdateClause update(String tableName) {
        return new UpdateBuilder()
            .append("UPDATE ")
            .append(tableName);
    }

    @Override
    public SetClause set(String column, String value) {
        return this.append(" SET ")
            .append(column)
            .append(" = ")
            .append(value);
    }

    @Override
    public WhereClause where(String predicate) {
        return this.append(" WHERE ")
            .append(predicate);
    }

    @Override
    public String build() {
        return statement.toString();
    }
}
