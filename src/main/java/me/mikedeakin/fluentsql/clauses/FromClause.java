package me.mikedeakin.fluentsql.clauses;

public interface FromClause extends CanWhere, TerminatingClause {

    InnerJoinClause innerJoin(String table);
}
