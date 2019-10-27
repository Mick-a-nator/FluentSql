package io.mikedeakin.fluentsql.clauses.select;

public interface FromClause extends CanWhere, CanGroupBy, CanOrderBy, TerminatingClause {

    JoinClause innerJoin(String table);
    JoinClause leftJoin(String table);
    JoinClause rightJoin(String table);
}
