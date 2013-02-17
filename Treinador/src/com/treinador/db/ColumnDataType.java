package com.treinador.db;

public class ColumnDataType {
    private String column;
    private String dataType;
    private boolean primary;

    public ColumnDataType(String column, String dataType, boolean isPrimary) {
        this.column = column;
        this.dataType = dataType;
        primary = isPrimary;
    }

    String columnStatement() {
        String statement = Constants.SPACE.concat(column.concat(Constants.SPACE)).concat(dataType);
        return primary ? statement.concat(Constants.PRIMARY_KEY) : statement;
    }

    public String getColumn() {
        return column;
    }
}
