package com.treinador.domain;

import android.provider.BaseColumns;
import com.treinador.db.ColumnDataType;
import com.treinador.db.Constants;

import java.util.ArrayList;
import java.util.List;

public abstract class Verb implements BaseColumns {
    public static final String TABLE_NAME = "verbs";
    public static final String VERB = "verb";
    private static List<ColumnDataType> columnDataTypes;

    private Verb() {
    }

    public static List<ColumnDataType> initializeColumns() {
        columnDataTypes = new ArrayList<ColumnDataType>();
        columnDataTypes.add(new ColumnDataType(Verb._ID, Constants.INTEGER, true));
        columnDataTypes.add(new ColumnDataType(Verb.VERB, Constants.TEXT, false));
        return columnDataTypes;
    }
}
