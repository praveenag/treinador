package com.treinador.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class DatabaseUtilTest {
    @Test
    public void createTableSqlWithMultipleColumns() throws Exception {
        ArrayList<ColumnDataType> columnDataTypeList = new ArrayList<ColumnDataType>();
        columnDataTypeList.add(new ColumnDataType("col1", "dataType1", true));
        columnDataTypeList.add(new ColumnDataType("col2", "dataType2", false));
        String createTableSql = new DatabaseUtil().createTableSql("table_name", columnDataTypeList);
        assertEquals("CREATE TABLE table_name( col1 dataType1 PRIMARY KEY, col2 dataType2)", createTableSql);
    }

    @Test
    public void createTableSqlWithSingleColumns() throws Exception {
        ArrayList<ColumnDataType> columnDataTypeList = new ArrayList<ColumnDataType>();
        columnDataTypeList.add(new ColumnDataType("col1", "dataType1", false));
        String createTableSql = new DatabaseUtil().createTableSql("table_name", columnDataTypeList);
        assertEquals("CREATE TABLE table_name( col1 dataType1)", createTableSql);
    }
}
