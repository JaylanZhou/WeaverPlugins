package com.weaver.codemaker.tools;

import java.util.List;

public class TableTools {

    private String tableName;

    private String modelName;

    private List<ColumnTools> columnToolsList;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnTools> getColumnToolsList() {
        return columnToolsList;
    }

    public void setColumnToolsList(List<ColumnTools> columnToolsList) {
        this.columnToolsList = columnToolsList;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
