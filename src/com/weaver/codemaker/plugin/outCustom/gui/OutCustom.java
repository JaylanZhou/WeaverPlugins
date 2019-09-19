package com.weaver.codemaker.plugin.outCustom.gui;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.weaver.codemaker.base.OutMain;
import com.weaver.codemaker.plugin.outCustom.tools.OutCustomTools;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OutCustom {


    private JTextField generateTableNameValue;
    private JTextField beanNameValue;
    private JButton OKButton;
    private JButton cancelButton;
    private JLabel SQLType;
    private JLabel nowAddress;
    private JLabel nowDataBase;
    private JLabel connectionStatus;
    private JLabel SQLTypeValue;
    private JLabel nowAddressValue;
    private JLabel nowDataBaseValue;
    private JLabel connectionStatusValue;
    private JLabel generateTableName;
    private JLabel beanName;
    private JPanel outCustomPanel;


    public OutCustom(JFrame jFrame, AnActionEvent anActionEvent) {

        Project project = anActionEvent.getProject();

        PropertiesComponent propertiesComponent = PropertiesComponent.getInstance(project);

        OutCustom outCustom = OutCustomTools.getAndCheckOutCustomInfo(this,propertiesComponent);

        OKButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                outCustom.getOKButton().setEnabled(false);

                try {

                    OutMain.codeMaker(anActionEvent,outCustom);

                    Messages.showMessageDialog("代码已生成", "成功", Messages.getInformationIcon());

                    anActionEvent.getProject().getBaseDir().refresh(false,true);

                } catch (Exception ex){

                    Messages.showMessageDialog("代码生成失败", "失败", Messages.getErrorIcon());

                }

                outCustom.getOKButton().setEnabled(true);
            }

        });
        cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                jFrame.dispose();

            }

        });
    }

    public JTextField getGenerateTableNameValue() {
        return generateTableNameValue;
    }

    public void setGenerateTableNameValue(JTextField generateTableNameValue) {
        this.generateTableNameValue = generateTableNameValue;
    }

    public JTextField getBeanNameValue() {
        return beanNameValue;
    }

    public void setBeanNameValue(JTextField beanNameValue) {
        this.beanNameValue = beanNameValue;
    }

    public JButton getOKButton() {
        return OKButton;
    }

    public void setOKButton(JButton OKButton) {
        this.OKButton = OKButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public JLabel getSQLType() {
        return SQLType;
    }

    public void setSQLType(JLabel SQLType) {
        this.SQLType = SQLType;
    }

    public JLabel getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(JLabel nowAddress) {
        this.nowAddress = nowAddress;
    }

    public JLabel getNowDataBase() {
        return nowDataBase;
    }

    public void setNowDataBase(JLabel nowDataBase) {
        this.nowDataBase = nowDataBase;
    }

    public JLabel getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(JLabel connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public JLabel getSQLTypeValue() {
        return SQLTypeValue;
    }

    public void setSQLTypeValue(JLabel SQLTypeValue) {
        this.SQLTypeValue = SQLTypeValue;
    }

    public JLabel getNowAddressValue() {
        return nowAddressValue;
    }

    public void setNowAddressValue(JLabel nowAddressValue) {
        this.nowAddressValue = nowAddressValue;
    }

    public JLabel getNowDataBaseValue() {
        return nowDataBaseValue;
    }

    public void setNowDataBaseValue(JLabel nowDataBaseValue) {
        this.nowDataBaseValue = nowDataBaseValue;
    }

    public JLabel getConnectionStatusValue() {
        return connectionStatusValue;
    }

    public void setConnectionStatusValue(JLabel connectionStatusValue) {
        this.connectionStatusValue = connectionStatusValue;
    }

    public JLabel getGenerateTableName() {
        return generateTableName;
    }

    public void setGenerateTableName(JLabel generateTableName) {
        this.generateTableName = generateTableName;
    }

    public JLabel getBeanName() {
        return beanName;
    }

    public void setBeanName(JLabel beanName) {
        this.beanName = beanName;
    }

    public JPanel getOutCustomPanel() {
        return outCustomPanel;
    }

    public void setOutCustomPanel(JPanel outCustomPanel) {
        this.outCustomPanel = outCustomPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
