package me.mikedeakin.fluentsql.clauses;

public interface SelectClause {

    FromClause from(String tableName);
}
