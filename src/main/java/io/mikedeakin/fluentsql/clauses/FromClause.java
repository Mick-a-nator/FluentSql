package io.mikedeakin.fluentsql.clauses;

public interface FromClause extends CanWhere, CanGroupBy, CanOrderBy, TerminatingClause {

    JoinClause innerJoin(String table);
    JoinClause leftJoin(String table);
    JoinClause rightJoin(String table);
}
