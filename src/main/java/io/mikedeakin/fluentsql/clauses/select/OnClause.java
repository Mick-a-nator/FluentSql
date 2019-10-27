package io.mikedeakin.fluentsql.clauses.select;

import io.mikedeakin.fluentsql.clauses.TerminatingClause;

public interface OnClause extends CanWhere, CanGroupBy, CanOrderBy, TerminatingClause {

    OnClause andOn(String predicate);
}
