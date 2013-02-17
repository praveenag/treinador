package com.treinador.domain;

import android.provider.BaseColumns;
import com.treinador.db.ColumnDataType;
import com.treinador.db.Constants;

import java.util.ArrayList;
import java.util.List;

public abstract class Rule implements BaseColumns {
    public static final String TABLE_NAME = "rules";
    public static final String RULE = "rule";
    private static List<ColumnDataType> columnDataTypes;

    private Rule() {
    }

    public static List<ColumnDataType> initializeColumns() {
        columnDataTypes = new ArrayList<ColumnDataType>();
        columnDataTypes.add(new ColumnDataType(Rule._ID, Constants.INTEGER, true));
        columnDataTypes.add(new ColumnDataType(Rule.RULE, Constants.TEXT, false));
        return columnDataTypes;
    }
}
