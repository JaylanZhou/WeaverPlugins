package com.weaver.codemaker.plugin.outInfomation.tools;

import com.intellij.ide.util.PropertiesComponent;
import com.weaver.codemaker.plugin.outInfomation.gui.OutInformation;
import com.weaver.pluginsTools.IdeaPluginTools;
import com.weaver.codemaker.tools.ConnectionEnum;
import com.weaver.codemaker.tools.ConnectionTools;
import com.weaver.codemaker.tools.GetTools;
import com.weaver.codemaker.tools.GetUrlEnum;
import com.weaver.codemaker.tools.baseTools.BaseTools;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.Connection;

public class OutInfomationTools {



    private OutInfomationTools(){



    }

    public static void checkConnectionAndSave(OutInformation outInformation, JFrame jFrame, PropertiesComponent propertiesComponent) throws Exception {

        String ip = outInformation.getIP().getText();

        String port = outInformation.getPort().getText();

        String database = outInformation.getDataBaseName().getText();

        String userName = outInformation.getUserName().getText();

        String password = outInformation.getPassword().getText();

        String SQLDriverIndex = String.valueOf(outInformation.getSQLDriver().getSelectedIndex());

        GetUrlEnum getUrlEnum = GetTools.getGetUrlEnum(SQLDriverIndex);

        String DriverClassIndex = String.valueOf(outInformation.getDriverClass().getSelectedIndex());

        ConnectionEnum connectionEnum = GetTools.getConnectionEnum(DriverClassIndex);

        String url = GetTools.getURL(ip,port,database,getUrlEnum);

        IdeaPluginTools.threadPool.execute(new Runnable() {

            @Override
            public void run() {


                try {

                    outInformation.getConnectionStatusValue().setText("连接中");

                    outInformation.getConnectionStatusValue().setForeground(new Color(187,179,23));

                        if (!BaseTools.checkServerAndDriver(connectionEnum,getUrlEnum)){

                            outInformation.getConnectionStatusValue().setText("数据库类型与驱动不匹配");

                            outInformation.getConnectionStatusValue().setForeground(new Color(187,35,27));

                        } else {

                            Connection connection = ConnectionTools.getConnection(url, userName, password, connectionEnum);

                            OutInfomationTools.saveInfo(outInformation, propertiesComponent);

                            propertiesComponent.setValue("isSaved", "1");

                            outInformation.getConnectionStatusValue().setText("连接成功，配置已保存");

                            outInformation.getConnectionStatusValue().setForeground(new Color(28, 168, 76));

                            connection.close();

                        }


                } catch (Exception e) {

                    outInformation.getConnectionStatusValue().setText("连接失败，请检查配置和数据库服务器状态");

                    outInformation.getConnectionStatusValue().setForeground(new Color(187,35,27));

                    e.printStackTrace();
                }

                outInformation.getOK().setEnabled(true);

            }

        });

    }

    public static void saveInfo(OutInformation outInformation, PropertiesComponent propertiesComponent){

        propertiesComponent.setValue("IP",outInformation.getIP().getText());

        propertiesComponent.setValue("port",outInformation.getPort().getText());

        propertiesComponent.setValue("dataBaseName",outInformation.getDataBaseName().getText());

        propertiesComponent.setValue("userName", outInformation.getUserName().getText());

        propertiesComponent.setValue("password",outInformation.getPassword().getText());

        JComboBox SQLDriver = outInformation.getSQLDriver();

        JComboBox DriverClass = outInformation.getDriverClass();

        propertiesComponent.setValue("SQLDriver",String.valueOf(SQLDriver.getSelectedIndex()));

        propertiesComponent.setValue("DriverClass",String.valueOf(DriverClass.getSelectedIndex()));

    }

    public static OutInformation getInfo(OutInformation outInformation,PropertiesComponent propertiesComponent){

        Dimension dimension = new Dimension();

        dimension.setSize(800,500);

        outInformation.getPanel1().setPreferredSize(dimension);

        outInformation.getIP().setText(propertiesComponent.getValue("IP"));

        outInformation.getPort().setText(propertiesComponent.getValue("port"));

        outInformation.getDataBaseName().setText(propertiesComponent.getValue("dataBaseName"));

        outInformation.getUserName().setText(propertiesComponent.getValue("userName"));

        outInformation.getPassword().setText(propertiesComponent.getValue("password"));

        String SQLDriverIndex = propertiesComponent.getValue("SQLDriver");

        String DriverClassIndex = propertiesComponent.getValue("DriverClass");

        if(SQLDriverIndex != null && !SQLDriverIndex.equals("")) {

            outInformation.getSQLDriver().setSelectedIndex(Integer.parseInt(SQLDriverIndex));

        }

        if(DriverClassIndex != null && !DriverClassIndex.equals("")) {

            outInformation.getDriverClass().setSelectedIndex(Integer.parseInt(DriverClassIndex));

        }

        return outInformation;

    }

}
