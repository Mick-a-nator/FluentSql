package me.mikedeakin.fluentsql.clauses;

public interface LeftOuterJoinClause {

    OnClause on(String predicate);
}
