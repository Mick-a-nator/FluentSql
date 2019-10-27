package io.mikedeakin.fluentsql.clauses.update;

import io.mikedeakin.fluentsql.clauses.TerminatingClause;

public interface SetClause extends TerminatingClause {

    WhereClause where(String predicate);
}
