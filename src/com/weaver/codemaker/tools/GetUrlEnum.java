package com.weaver.codemaker.tools;

public enum GetUrlEnum {

    SQLServer("1"),OracleService("2"),OracleSID("3"),MySQL("4"),OracleTNS("5");

    private String result;

    private GetUrlEnum(String result){

        this.result = result;

    }

    @Override
    public String toString(){

        return this.result;

    }

}
