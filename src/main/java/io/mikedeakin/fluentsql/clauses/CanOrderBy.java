package io.mikedeakin.fluentsql.clauses;

public interface CanOrderBy {

    OrderByClause orderBy(String... columns);
}
