package com.weaver.codemaker.tools;

public enum ConnectionEnum {

    SQLServerDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver"),OracleDriver("oracle.jdbc.driver.OracleDriver"),MySqlDriver8("com.mysql.cj.jdbc.Driver"),MySqlDriver("com.mysql.jdbc.Driver");

    private String result;

    private ConnectionEnum(String result){

        this.result = result;

    }

    @Override
    public String toString(){

        return this.result;

    }

}
