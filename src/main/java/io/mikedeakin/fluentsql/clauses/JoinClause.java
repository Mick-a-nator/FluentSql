package io.mikedeakin.fluentsql.clauses;

public interface JoinClause {

    OnClause on(String predicate);
}
