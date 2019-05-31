package io.mikedeakin.fluentsql.clauses;

public interface WhereClause extends CanGroupBy, TerminatingClause {

    WhereClause andWhere(String predicate);
}
