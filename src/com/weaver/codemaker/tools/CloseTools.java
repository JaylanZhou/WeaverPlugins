package com.weaver.codemaker.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CloseTools {

    private CloseTools(){


    }

    public static void closeResource(Connection connection, ResultSet resultSet, PreparedStatement preparedStatement, Statement statement){

        try {

            if(resultSet !=null){

                resultSet.close();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        try {

            if(statement !=null){

                statement.close();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        try {

            if(preparedStatement !=null){

                preparedStatement.close();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        try {

            if(connection !=null){

                connection.close();
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
