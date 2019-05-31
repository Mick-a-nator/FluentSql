package io.mikedeakin.fluentsql.clauses;

public interface CanGroupBy {

    GroupByClause groupBy(String... columns);
}
