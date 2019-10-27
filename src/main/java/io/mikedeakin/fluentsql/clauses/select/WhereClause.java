package io.mikedeakin.fluentsql.clauses.select;

import io.mikedeakin.fluentsql.clauses.TerminatingClause;

public interface WhereClause extends CanGroupBy, CanOrderBy, TerminatingClause {

    WhereClause andWhere(String predicate);
}
