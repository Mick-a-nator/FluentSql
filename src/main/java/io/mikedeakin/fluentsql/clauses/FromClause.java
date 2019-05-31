package io.mikedeakin.fluentsql.clauses;

public interface FromClause extends CanWhere, CanGroupBy, TerminatingClause {

    JoinClause innerJoin(String table);
    JoinClause leftJoin(String table);
    JoinClause rightJoin(String table);
}
