package me.mikedeakin.fluentsql.clauses;

public interface InnerJoinClause {

    OnClause on(String predicate);
}
