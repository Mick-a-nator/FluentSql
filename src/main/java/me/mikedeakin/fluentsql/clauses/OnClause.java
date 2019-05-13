package me.mikedeakin.fluentsql.clauses;

public interface OnClause extends TerminatingClause {

    OnClause andOn(String predicate);
}
