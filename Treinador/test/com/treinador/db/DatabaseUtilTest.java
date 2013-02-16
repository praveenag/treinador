package com.treinador.db;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;

@RunWith(Parameterized.class)
public class DatabaseUtilTest {
    @org.junit.Test
    public void testCreateTableSql() throws Exception {
        ArrayList<ColumnDataType> columnDataTypeList = new ArrayList<ColumnDataType>();
        columnDataTypeList.add(new ColumnDataType("col", "data", true));
        columnDataTypeList.add(new ColumnDataType("col1", "data1", false));
        String asdasd = new DatabaseUtil().createTableSql("asdasd", columnDataTypeList);
        System.out.println(asdasd);

    }
}
