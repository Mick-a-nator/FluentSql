package me.mikedeakin.fluentsql.clauses;

public interface FromClause extends CanWhere, TerminatingClause {

    JoinClause innerJoin(String table);
    JoinClause leftJoin(String table);
}
