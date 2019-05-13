package me.mikedeakin.fluentsql.clauses;

public interface JoinClause {

    OnClause on(String predicate);
}
