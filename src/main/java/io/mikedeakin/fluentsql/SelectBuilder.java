package io.mikedeakin.fluentsql;

import io.mikedeakin.fluentsql.clauses.TerminatingClause;
import io.mikedeakin.fluentsql.clauses.select.*;

public class SelectBuilder implements
    SelectClause,
    FromClause,
    WhereClause,
    JoinClause,
    OnClause,
    GroupByClause,
    OrderByClause,
    TerminatingClause
{
    private final StringBuilder statement;

    private SelectBuilder() {
        statement = new StringBuilder();
    }

    private SelectBuilder append(String value) {
        this.statement.append(value);
        return this;
    }

    protected static SelectClause select(String... columnNames) {
        return new SelectBuilder()
            .append("SELECT ")
            .append(String.join(", ", columnNames));
    }

    @Override
    public FromClause from(String tableName) {
        return this.append(" FROM ")
            .append(tableName);
    }

    @Override
    public WhereClause where(String predicate) {
        return this.append(" WHERE ")
            .append(predicate);
    }

    @Override
    public WhereClause andWhere(String predicate) {
        return this.append(" AND ")
            .append(predicate);
    }

    @Override
    public JoinClause innerJoin(String table) {
        return this.append(" INNER JOIN ")
            .append(table);
    }

    @Override
    public JoinClause leftJoin(String table) {
        return this.append(" LEFT OUTER JOIN ")
            .append(table);
    }

    @Override
    public JoinClause rightJoin(String table) {
        return this.append(" RIGHT OUTER JOIN ")
            .append(table);
    }

    @Override
    public OnClause on(String predicate) {
        return this.append(" ON ")
            .append(predicate);
    }

    @Override
    public OnClause andOn(String predicate) {
        return this.append(" AND")
            .on(predicate);
    }

    @Override
    public GroupByClause groupBy(String... columns) {
        return this.append(" GROUP BY ")
            .append(String.join(", ", columns));
    }

    @Override
    public OrderByClause orderBy(String... columns) {
        return this.append(" ORDER BY ")
            .append(String.join(", ", columns));
    }

    @Override
    public String build() {
        return statement.toString();
    }
}
