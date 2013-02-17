package com.treinador.domain;

import android.provider.BaseColumns;
import com.treinador.db.ColumnDataType;
import com.treinador.db.Constants;

import java.util.ArrayList;
import java.util.List;

public abstract class VerbTenseRuleMap implements BaseColumns {
    public static final String TABLE_NAME = "verb_tense_rule_mapping";
    public static final String VERB_ID = "verb_id";
    public static final String TENSE_ID = "tense_id";
    public static final String RULE_ID = "rule_id";
    private static List<ColumnDataType> columnDataTypes;


    private VerbTenseRuleMap(){

    }
    public static List<ColumnDataType> initializeColumns(){
        columnDataTypes = new ArrayList<ColumnDataType>();
        columnDataTypes.add(new ColumnDataType(VerbTenseRuleMap._ID, Constants.INTEGER, true));
        columnDataTypes.add(new ColumnDataType(VerbTenseRuleMap.VERB_ID, Constants.INTEGER, false));
        columnDataTypes.add(new ColumnDataType(VerbTenseRuleMap.TENSE_ID, Constants.INTEGER, false));
        columnDataTypes.add(new ColumnDataType(VerbTenseRuleMap.RULE_ID, Constants.INTEGER, false));
        return columnDataTypes;
    }

}
