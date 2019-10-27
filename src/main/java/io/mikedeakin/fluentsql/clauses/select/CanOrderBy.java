package io.mikedeakin.fluentsql.clauses.select;

public interface CanOrderBy {

    OrderByClause orderBy(String... columns);
}
