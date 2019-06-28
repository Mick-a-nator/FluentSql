package io.mikedeakin.fluentsql.clauses;

public interface OnClause extends CanWhere, CanGroupBy, CanOrderBy, TerminatingClause {

    OnClause andOn(String predicate);
}
