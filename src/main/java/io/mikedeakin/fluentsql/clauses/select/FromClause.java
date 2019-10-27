package io.mikedeakin.fluentsql.clauses.select;

import io.mikedeakin.fluentsql.clauses.TerminatingClause;

public interface FromClause extends CanWhere, CanGroupBy, CanOrderBy, TerminatingClause {

    JoinClause innerJoin(String table);
    JoinClause leftJoin(String table);
    JoinClause rightJoin(String table);
}
