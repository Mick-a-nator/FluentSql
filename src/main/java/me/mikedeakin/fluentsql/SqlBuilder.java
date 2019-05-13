package me.mikedeakin.fluentsql;

import me.mikedeakin.fluentsql.clauses.*;

public class SqlBuilder implements
    SelectClause,
    FromClause,
    WhereClause,
    InnerJoinClause,
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
    public InnerJoinClause innerJoin(String table) {
        stringBuilder.append(" INNER JOIN ")
            .append(table);

        return this;
    }

    @Override
    public FromClause on(String predicate) {
        stringBuilder.append(" ON ")
            .append(predicate);

        return this;
    }
}
