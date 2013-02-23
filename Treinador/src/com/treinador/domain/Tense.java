package com.treinador.domain;

import android.provider.BaseColumns;
import com.treinador.db.ColumnDataType;
import com.treinador.db.Constants;

import java.util.ArrayList;
import java.util.List;

public enum Tense implements BaseColumns{
    PAST("1"),
    PRESENT("2"),
    FUTURE("3");
    public static final String TENSE = "tense";
    public static final String TABLE_NAME ="tenses";
    private final String id;

    Tense(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static List<ColumnDataType> initializeColumns() {
        List<ColumnDataType> columnDataTypes = new ArrayList<ColumnDataType>();
        columnDataTypes.add(new ColumnDataType(_ID, Constants.INTEGER, true));
        columnDataTypes.add(new ColumnDataType(TENSE, Constants.TEXT, false));
        return columnDataTypes;
    }
}
