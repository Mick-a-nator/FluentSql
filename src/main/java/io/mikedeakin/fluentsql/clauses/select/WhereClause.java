package io.mikedeakin.fluentsql.clauses.select;

public interface WhereClause extends CanGroupBy, CanOrderBy, TerminatingClause {

    WhereClause andWhere(String predicate);
}
