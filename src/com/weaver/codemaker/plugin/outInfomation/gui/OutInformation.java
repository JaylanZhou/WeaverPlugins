package com.weaver.codemaker.plugin.outInfomation.gui;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.weaver.codemaker.plugin.outInfomation.tools.OutInfomationTools;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OutInformation extends JDialog{

    private JComboBox SQLDriver;
    private JPanel panel1;
    private JComboBox DriverClass;
    private JTextField IP;
    private JButton OK;
    private JButton cancelButton;
    private JTextField port;
    private JTextField dataBaseName;
    private JTextField userName;
    private JTextField password;
    private JLabel connectionStatus;
    private JLabel connectionStatusValue;

    public JComboBox getSQLDriver() {
        return SQLDriver;
    }

    public void setSQLDriver(JComboBox SQLDriver) {
        this.SQLDriver = SQLDriver;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JComboBox getDriverClass() {
        return DriverClass;
    }

    public void setDriverClass(JComboBox driverClass) {
        DriverClass = driverClass;
    }

    public JTextField getIP() {
        return IP;
    }

    public void setIP(JTextField IP) {
        this.IP = IP;
    }

    public JButton getOK() {
        return OK;
    }

    public void setOK(JButton OK) {
        this.OK = OK;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public JTextField getPort() {
        return port;
    }

    public void setPort(JTextField port) {
        this.port = port;
    }

    public JTextField getDataBaseName() {
        return dataBaseName;
    }

    public void setDataBaseName(JTextField dataBaseName) {
        this.dataBaseName = dataBaseName;
    }

    public JTextField getUserName() {
        return userName;
    }

    public void setUserName(JTextField userName) {
        this.userName = userName;
    }

    public JTextField getPassword() {
        return password;
    }

    public void setPassword(JTextField password) {
        this.password = password;
    }


    public JLabel getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(JLabel connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public JLabel getConnectionStatusValue() {
        return connectionStatusValue;
    }

    public void setConnectionStatusValue(JLabel connectionStatusValue) {
        this.connectionStatusValue = connectionStatusValue;
    }

    public OutInformation(JFrame jFrame, AnActionEvent anActionEvent) {

        Project project = anActionEvent.getProject();

        PropertiesComponent propertiesComponent = PropertiesComponent.getInstance(project);

        OutInformation outInformation = OutInfomationTools.getInfo(this,propertiesComponent);

        OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                outInformation.getOK().setEnabled(false);

                try {

                    OutInfomationTools.checkConnectionAndSave(outInformation,jFrame,propertiesComponent);

                } catch (Exception ex) {

                    ex.printStackTrace();

                }


            }

        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jFrame.dispose();

            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

