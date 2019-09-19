package com.weaver.codemaker.tools;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTools {

    private ConnectionTools(){

    }

    public static Connection getConnection(String url,String user,String password,ConnectionEnum connectionEnum) throws Exception {

        Class.forName(String.valueOf(connectionEnum)).newInstance();

        Connection connection = DriverManager.getConnection(url,user,password);

        return connection;

    }

}
