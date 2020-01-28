package com.weaver.ecodeTools.plugin.generateModule.gui;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import com.weaver.ecodeTools.plugin.generateModule.tools.GenerateModuleTools;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GenerateModule {

    private JTextField moduleName;

    private JButton OKButton;

    private JButton cancelButton;

    private JPanel generateModulePanel;

    public JPanel getGenerateModulePanel() {
        return generateModulePanel;
    }

    public void setGenerateModulePanel(JPanel generateModulePanel) {
        this.generateModulePanel = generateModulePanel;
    }

    public JTextField getModuleName() {
        return moduleName;
    }

    public void setModuleName(JTextField moduleName) {
        this.moduleName = moduleName;
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


    public GenerateModule(JFrame jFrame, AnActionEvent anActionEvent) {

        this.OKButton.setEnabled(false);

        GenerateModule generateModule = this;

        OKButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String moduleName = generateModule.getModuleName().getText();

                try {

                    GenerateModuleTools.generateModuleDirectory(anActionEvent,moduleName);

                    Messages.showMessageDialog("项目结构已生成", "成功", Messages.getInformationIcon());

                    jFrame.dispose();

                    anActionEvent.getProject().getBaseDir().refresh(false,true);

                } catch (Exception ex){

                    Messages.showMessageDialog("项目结构生成失败", "失败", Messages.getErrorIcon());

                }

            }
        });

        cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                jFrame.dispose();

            }
        });
        moduleName.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                JTextField moduleName = generateModule.getModuleName();

                if(!moduleName.getText().equals("")){

                    generateModule.getOKButton().setEnabled(true);

                } else {

                    generateModule.getOKButton().setEnabled(false);

                }

            }

        });
    }

}
