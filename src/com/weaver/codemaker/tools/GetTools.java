package com.weaver.codemaker.tools;

import com.intellij.ide.util.PropertiesComponent;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetTools {

    private GetTools(){

    }

    public static List<TableTools> getTableTools(Connection connection) throws Exception {

        DatabaseMetaData metaData = connection.getMetaData();

        ResultSet tableRet = metaData.getTables(null, "%","%",new String[]{"TABLE"});

        String tableName;

        TableTools tableTools = null;

        List<TableTools> tableToolsList = new ArrayList<>();

        while(tableRet.next())

        {

            tableTools = new TableTools();

            tableName = tableRet.getString("TABLE_NAME");

            tableTools.setTableName(tableName);

            tableToolsList.add(tableTools);

        }

        return tableToolsList;

    }

    public static List<ColumnTools> getColumnTools(Connection connection,TableTools tableTools,String dataBaseName,PropertiesComponent propertiesComponent) throws Exception {

        String columnName;

        String columnType;

        ColumnTools columnTools = null;

        List<ColumnTools> columnToolsList = new ArrayList<>();

        DatabaseMetaData metaData = connection.getMetaData();

        String DriverClassIndex = propertiesComponent.getValue("DriverClass");

        ConnectionEnum connectionEnum = GetTools.getConnectionEnum(DriverClassIndex);

        String tableName = tableTools.getTableName();

        if (connectionEnum.toString().equals(ConnectionEnum.OracleDriver.toString())) {

            tableName = tableName.toUpperCase();

        }

        ResultSet colRet = metaData.getColumns(dataBaseName,"%", tableName,"%");

        while(colRet.next()) {

            columnTools = new ColumnTools();

            columnName = colRet.getString("COLUMN_NAME");

            columnType = colRet.getString("TYPE_NAME");

            columnTools.setColumnName(columnName);

            columnTools.setColumnType(columnType);

            // int datasize = colRet.getInt("COLUMN_SIZE");

            // int digits = colRet.getInt("DECIMAL_DIGITS");

            // int nullable = colRet.getInt("NULLABLE");

            columnToolsList.add(columnTools);


        }

        return columnToolsList;

    }

    public static String getURL(String ip,String port,String databaseName,GetUrlEnum getUrlEnum){

        String url = "";

        switch (getUrlEnum){

            case MySQL:

                url = "jdbc:mysql://" + ip + ":" + port + "/" + databaseName + "?serverTimezone=GMT%2B8";

                break;

            case OracleSID:

                url = "jdbc:oracle:thin:@" + ip + ":" + port + ":" + databaseName;

                break;

            case SQLServer:

                url = "jdbc:sqlserver://" + ip + ":" + port + ";DatabaseName=" + databaseName;

                break;

            case OracleService:

                url = "jdbc:oracle:thin:@//" + ip + ":" + port + "/" + databaseName;

                break;

            case OracleTNS:

                url = "jdbc:oracle:thin:@(DESCRIPTION = (ADDRESS_LIST = (ADDRESS = (PROTOCOL = TCP)(HOST = " + ip + ")(PORT = " + port + ")))(CONNECT_DATA = (SERVICE_NAME = " + databaseName + ")))";

                break;

            default:

                url = "";

                break;

        }

        return url;

    }

    public static String getStringOfGetUrlEnum(GetUrlEnum getUrlEnum){

        String result = "";

        switch (getUrlEnum){

            case MySQL:

                result = "MySQL";

                break;

            case OracleSID:

                result = "Oracle";

                break;

            case SQLServer:

                result = "SQL Server";

                break;

            case OracleService:

                result = "Oracle";

                break;

            default:

                result = "无";

                break;

        }

        return result;

    }

    public static GetUrlEnum getGetUrlEnum(String value){

        GetUrlEnum getUrlEnum;

        switch (value){

            case "0" :

                getUrlEnum = GetUrlEnum.SQLServer;

                break;

            case "1" :

                getUrlEnum = GetUrlEnum.MySQL;

                break;

            case "2" :

                getUrlEnum = GetUrlEnum.OracleSID;

                break;

            case "3" :

                getUrlEnum = GetUrlEnum.OracleService;

                break;

            case "4" :

                getUrlEnum = GetUrlEnum.OracleTNS;

                break;

            default :

                throw new RuntimeException("获取数据库类型不匹配");

        }

        return getUrlEnum;

    }

    public static ConnectionEnum getConnectionEnum(String value){

        ConnectionEnum connectionEnum;

        switch (value){

            case "0" :

                connectionEnum = ConnectionEnum.SQLServerDriver;

                break;

            case "1" :

                connectionEnum = ConnectionEnum.MySqlDriver;

                break;

            case "2" :

                connectionEnum = ConnectionEnum.MySqlDriver8;

                break;

            case "3" :

                connectionEnum = ConnectionEnum.OracleDriver;

                break;

            default :

                throw new RuntimeException("获取数据库驱动类型不匹配");

        }

        return connectionEnum;

    }

    public static Connection getConnection(PropertiesComponent propertiesComponent) throws Exception {

        String ip = propertiesComponent.getValue("IP");

        String port = propertiesComponent.getValue("port");

        String database = propertiesComponent.getValue("dataBaseName");

        String userName = propertiesComponent.getValue("userName");

        String password = propertiesComponent.getValue("password");

        String SQLDriverIndex = propertiesComponent.getValue("SQLDriver");

        GetUrlEnum getUrlEnum = GetTools.getGetUrlEnum(SQLDriverIndex);

        String DriverClassIndex = propertiesComponent.getValue("DriverClass");

        ConnectionEnum connectionEnum = GetTools.getConnectionEnum(DriverClassIndex);

        String url = GetTools.getURL(ip,port,database,getUrlEnum);

        Connection connection = ConnectionTools.getConnection(url,userName,password,connectionEnum);

        return connection;

    }

}
