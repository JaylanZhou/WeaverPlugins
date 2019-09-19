package com.weaver.pluginsTools;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.weaver.codemaker.plugin.outCustom.gui.OutCustom;
import com.weaver.codemaker.plugin.outInfomation.gui.OutInformation;
import com.weaver.ecodeTools.plugin.copyModule.gui.CopyModule;
import com.weaver.ecodeTools.plugin.generateModule.gui.GenerateModule;

import javax.swing.*;
import java.awt.*;

public class JFrameInitTools {

    private JFrameInitTools(){

    }

    public static void initOutCodeInfo(AnActionEvent e){

        JFrame frame = new JFrame("数据库连接信息");

        frame.setContentPane(new OutInformation(frame,e).getPanel1());

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initLocation(frame);

        frame.pack();

        frame.setVisible(true);

    }

    public static void initOutCodeCustom(AnActionEvent e){

        JFrame frame = new JFrame("代码生成");

        frame.setContentPane(new OutCustom(frame,e).getOutCustomPanel());

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initLocation(frame);

        frame.pack();

        frame.setVisible(true);

    }

    public static void initGenerateModule(AnActionEvent e){

        JFrame frame = new JFrame("项目结构生成");

        frame.setContentPane(new GenerateModule(frame,e).getGenerateModulePanel());

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initLocation(frame);

        frame.pack();

        frame.setVisible(true);

    }

    public static void initCopyModule(AnActionEvent e){

        JFrame frame = new JFrame("项目复制");

        frame.setContentPane(new CopyModule(frame,e).getCopyModulePanel());

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initLocation(frame);

        frame.pack();

        frame.setVisible(true);

    }

    private static void initLocation(JFrame frame){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Dimension compSize = frame.getPreferredSize();

        if (compSize.height > screenSize.height) {

            compSize.height = screenSize.height;

        }

        if (compSize.width > screenSize.width) {

            compSize.width = screenSize.width;

        }

        frame.setLocation((screenSize.width - compSize.width) / 2, (screenSize.height - compSize.height) / 2);

    }

}
