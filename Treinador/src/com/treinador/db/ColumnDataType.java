package com.treinador.db;

public class ColumnDataType {
    public String column;
    public String dataType;
    private boolean primary;

    public ColumnDataType(String column, String dataType, boolean isPrimary) {
        this.column = column;
        this.dataType = dataType;
        primary = isPrimary;
    }

    String columnStatement() {
        String statement = column.concat(Constants.SPACE).concat(dataType);
        return primary ? statement.concat(Constants.PRIMARY_KEY) : statement ;
    }
}
