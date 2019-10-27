package io.mikedeakin.fluentsql.clauses.select;

public interface SelectClause {

    FromClause from(String tableName);
}
