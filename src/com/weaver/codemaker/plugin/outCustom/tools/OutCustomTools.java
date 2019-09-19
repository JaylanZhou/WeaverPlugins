package com.weaver.codemaker.plugin.outCustom.tools;

import com.intellij.ide.util.PropertiesComponent;
import com.weaver.codemaker.plugin.outCustom.gui.OutCustom;
import com.weaver.pluginsTools.IdeaPluginTools;
import com.weaver.codemaker.tools.GetTools;
import com.weaver.codemaker.tools.GetUrlEnum;

import java.awt.*;
import java.sql.Connection;

public class OutCustomTools {

    private OutCustomTools(){



    }


    public static OutCustom getAndCheckOutCustomInfo(OutCustom outCustom, PropertiesComponent propertiesComponent){

        String getUrlEnumIndex = propertiesComponent.getValue("SQLDriver");

        if(getUrlEnumIndex != null && !getUrlEnumIndex.equals("")) {

            GetUrlEnum getUrlEnum = GetTools.getGetUrlEnum(getUrlEnumIndex);

            outCustom.getSQLTypeValue().setText(GetTools.getStringOfGetUrlEnum(getUrlEnum));

        }

        Dimension dimension = new Dimension();

        dimension.setSize(600,400);

        String isSaved = propertiesComponent.getValue("isSaved");

        outCustom.getOKButton().setEnabled(false);

        if(isSaved != null && !isSaved.equals("")){

            outCustom.getOutCustomPanel().setPreferredSize(dimension);

            outCustom.getNowAddressValue().setText(propertiesComponent.getValue("IP") + ":" + propertiesComponent.getValue("port"));

            outCustom.getNowDataBaseValue().setText(propertiesComponent.getValue("dataBaseName"));

            outCustom.getConnectionStatusValue().setText("连接中");

            outCustom.getConnectionStatusValue().setForeground(new Color(187,179,23));

            outCustom = OutCustomTools.checkOutCustomConnection(outCustom,propertiesComponent);

        }

        return outCustom;

    }

    public static OutCustom checkOutCustomConnection(OutCustom outCustom,PropertiesComponent propertiesComponent){



        IdeaPluginTools.threadPool.execute(new Runnable() {

            @Override
            public void run() {

                try {

                    Connection connection = GetTools.getConnection(propertiesComponent);

                    outCustom.getConnectionStatusValue().setText("成功");

                    outCustom.getConnectionStatusValue().setForeground(new Color(28,168,76));

                    outCustom.getOKButton().setEnabled(true);

                    connection.close();

                } catch (Exception e) {

                    outCustom.getConnectionStatusValue().setText("失败");

                    outCustom.getConnectionStatusValue().setForeground(new Color(187,35,27));

                    e.printStackTrace();
                }

            }

        });

        return outCustom;

    }

}
