package io.mikedeakin.fluentsql.clauses;

public interface WhereClause extends CanGroupBy, CanOrderBy, TerminatingClause {

    WhereClause andWhere(String predicate);
}
