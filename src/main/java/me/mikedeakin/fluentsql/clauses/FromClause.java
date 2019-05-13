package me.mikedeakin.fluentsql.clauses;

public interface FromClause extends TerminatingClause {

    WhereClause where(String predicate);
    InnerJoinClause innerJoin(String table);
}
