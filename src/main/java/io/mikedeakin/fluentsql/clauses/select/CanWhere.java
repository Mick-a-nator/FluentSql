package io.mikedeakin.fluentsql.clauses.select;

public interface CanWhere {

    WhereClause where(String predicate);
}
