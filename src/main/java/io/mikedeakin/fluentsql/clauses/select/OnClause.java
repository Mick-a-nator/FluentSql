package io.mikedeakin.fluentsql.clauses.select;

public interface OnClause extends CanWhere, CanGroupBy, CanOrderBy, TerminatingClause {

    OnClause andOn(String predicate);
}
