package io.mikedeakin.fluentsql;

import io.mikedeakin.fluentsql.clauses.*;

public class SqlBuilder implements
    SelectClause,
    FromClause,
    WhereClause,
    JoinClause,
    OnClause,
    GroupByClause,
    TerminatingClause
{
    private StringBuilder stringBuilder;

    private SqlBuilder() {
        stringBuilder = new StringBuilder();
    }

    public static SelectClause select(String... columnNames) {
        SqlBuilder sqlBuilder = new SqlBuilder();

        sqlBuilder.stringBuilder.append("SELECT ")
            .append(String.join(", ", columnNames));

        return sqlBuilder;
    }

    @Override
    public FromClause from(String tableName) {
        stringBuilder.append(" FROM ")
            .append(tableName);

        return this;
    }

    @Override
    public String build() {
        return stringBuilder.toString();
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
}
