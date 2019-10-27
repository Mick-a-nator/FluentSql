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
    private final StringBuilder stringBuilder;

    private SelectBuilder() {
        stringBuilder = new StringBuilder();
    }

    protected static SelectClause select(String... columnNames) {
        SelectBuilder selectBuilder = new SelectBuilder();

        selectBuilder.stringBuilder.append("SELECT ")
            .append(String.join(", ", columnNames));

        return selectBuilder;
    }

    @Override
    public FromClause from(String tableName) {
        stringBuilder.append(" FROM ")
            .append(tableName);

        return this;
    }

    @Override
    public WhereClause where(String predicate) {
        stringBuilder.append(" WHERE ")
            .append(predicate);

        return this;
    }

    @Override
    public WhereClause andWhere(String predicate) {
        stringBuilder.append(" AND ")
            .append(predicate);

        return this;
    }

    @Override
    public JoinClause innerJoin(String table) {
        stringBuilder.append(" INNER JOIN ")
            .append(table);

        return this;
    }

    @Override
    public JoinClause leftJoin(String table) {
        stringBuilder.append(" LEFT OUTER JOIN ")
            .append(table);

        return this;
    }

    @Override
    public JoinClause rightJoin(String table) {
        stringBuilder.append(" RIGHT OUTER JOIN ")
            .append(table);

        return this;
    }

    @Override
    public OnClause on(String predicate) {
        stringBuilder.append(" ON ")
            .append(predicate);

        return this;
    }

    @Override
    public OnClause andOn(String predicate) {
        stringBuilder.append(" AND");
        return this.on(predicate);
    }

    @Override
    public GroupByClause groupBy(String... columns) {
        stringBuilder.append(" GROUP BY ");
        stringBuilder.append(String.join(", ", columns));
        return this;
    }

    @Override
    public OrderByClause orderBy(String... columns) {
        stringBuilder.append(" ORDER BY ");
        stringBuilder.append(String.join(", ", columns));
        return this;
    }

    @Override
    public String build() {
        return stringBuilder.toString();
    }
}
