package io.mikedeakin.fluentsql.clauses.select;

public interface JoinClause {

    OnClause on(String predicate);
}
