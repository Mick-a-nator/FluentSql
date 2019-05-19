package io.mikedeakin.fluentsql.clauses;

public interface WhereClause extends TerminatingClause {

    WhereClause andWhere(String predicate);
}
