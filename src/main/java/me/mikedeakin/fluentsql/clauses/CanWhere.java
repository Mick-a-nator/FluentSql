package me.mikedeakin.fluentsql.clauses;

public interface CanWhere {

    WhereClause where(String predicate);
}
