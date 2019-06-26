package io.mikedeakin.fluentsql.clauses;

public interface OnClause extends CanWhere, CanGroupBy, TerminatingClause {

    OnClause andOn(String predicate);
}
