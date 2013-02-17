package com.treinador.db;

import com.treinador.domain.Tense;
import com.treinador.rules.ERPresentTenseRule;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {

    private static final String CREATE_TABLE = "CREATE TABLE ";
    private static final String DROP_TABLE_IF_EXISTS = "DROP TABLE IF EXISTS ";

    public static String[] getColumns(List<ColumnDataType> columnDataTypes) {
        List<String> columns = new ArrayList<String>();
        for (ColumnDataType columnDataType : columnDataTypes) {
            columns.add(columnDataType.getColumn());
        }
        return (String[]) columns.toArray();
    }

    public String createTableSql(String tableName, List<ColumnDataType> columnDataTypeList) {
        String createTableQuery = CREATE_TABLE.concat(tableName).concat("(");

        int size = columnDataTypeList.size();
        if(size > 0){
            ColumnDataType firstColumn = columnDataTypeList.get(0);
            createTableQuery = createTableQuery.concat(firstColumn.columnStatement());
            if(size == 1){
                return createTableQuery.concat(Constants.CLOSING_BRACES);

            } else {
                for (int index = 1; index < size; index++) {
                    ColumnDataType columnDataType = columnDataTypeList.get(index);
                    createTableQuery = createTableQuery.concat(Constants.COMMA).concat(columnDataType.columnStatement());
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
