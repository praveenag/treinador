package com.treinador.db;

import java.util.List;

public class DatabaseUtil {

    private static final String CREATE_TABLE = "CREATE TABLE ";
    private static final String DROP_TABLE_IF_EXISTS = "DROP TABLE IF EXISTS ";

    public String createTableSql(String tableName, List<ColumnDataType> columnDataTypeList) {
        String createTableQuery = CREATE_TABLE.concat(tableName).concat("( ");

        int size = columnDataTypeList.size();
        if(size > 0){
            ColumnDataType firstColumn = columnDataTypeList.get(0);
            createTableQuery.concat(firstColumn.columnStatement()).concat(Constants.CLOSING_BRACES);
            if(size == 1){
                return createTableQuery.concat(Constants.CLOSING_BRACES);

            } else {
                for (int index = 1; index < size; index++) {
                    ColumnDataType columnDataType = columnDataTypeList.get(index);
                    createTableQuery.concat(columnDataType.columnStatement());
                }
                return createTableQuery.concat(Constants.CLOSING_BRACES);
            }
        }

        throw new RuntimeException("Cannot instantiate table with no columns");
    }

    public String deleteTableSql(String tableName) {
        return DROP_TABLE_IF_EXISTS.concat(tableName);
    }
}
