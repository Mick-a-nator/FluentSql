package io.mikedeakin.fluentsql.clauses.update;

public interface UpdateClause {

    SetClause set(String column, String value);
}
