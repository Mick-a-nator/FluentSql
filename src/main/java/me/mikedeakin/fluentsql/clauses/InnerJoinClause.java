package me.mikedeakin.fluentsql.clauses;

public interface InnerJoinClause {

    FromClause on(String predicate);
}
