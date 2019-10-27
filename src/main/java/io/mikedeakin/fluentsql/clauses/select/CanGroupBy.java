package io.mikedeakin.fluentsql.clauses.select;

public interface CanGroupBy {

    GroupByClause groupBy(String... columns);
}
