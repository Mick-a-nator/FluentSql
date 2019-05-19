package io.mikedeakin.fluentsql.clauses;

public interface SelectClause {

    FromClause from(String tableName);
}
