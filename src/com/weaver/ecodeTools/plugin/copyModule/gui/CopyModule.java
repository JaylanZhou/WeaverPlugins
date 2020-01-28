package com.weaver.ecodeTools.plugin.copyModule.gui;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import com.weaver.ecodeTools.plugin.copyModule.tools.CopyModuleTools;
import com.weaver.pluginsTools.IdeaPluginTools;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

public class CopyModule {

    private JTextField moduleName;

    private JButton OKButton;

    private JButton cancelButton;

    private JPanel copyModulePanel;

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

    public JPanel getCopyModulePanel() {
        return copyModulePanel;
    }

    public void setCopyModulePanel(JPanel copyModulePanel) {
        this.copyModulePanel = copyModulePanel;
    }

    public CopyModule(JFrame jFrame, AnActionEvent anActionEvent) {

        CopyModule copyModule = this;

        cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                jFrame.dispose();

            }
        });

        OKButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String moduleName = copyModule.getModuleName().getText();

                VirtualFile virtualFile = IdeaPluginTools.getFileExtension(anActionEvent.getDataContext());

                String virtualFilePath = virtualFile.getPath();

                String virtualFileName = virtualFile.getName();

                StringBuilder moduleNameBuilder = new StringBuilder(moduleName).append("_").append(IdeaPluginTools.getUnixTime());

                File file = new File(virtualFilePath);

                try {

                    CopyModuleTools.copyModule(file,moduleNameBuilder.toString(),virtualFileName);

                    Messages.showMessageDialog("项目复制成功", "成功", Messages.getInformationIcon());

                    jFrame.dispose();

                } catch (Exception ex) {

                    Messages.showMessageDialog("项目复制失败", "失败", Messages.getErrorIcon());

                    ex.printStackTrace();

                }

                anActionEvent.getProject().getBaseDir().refresh(false,true);

            }
        });

        moduleName.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                JTextField moduleName = copyModule.getModuleName();

                if(!moduleName.getText().equals("")){

                    copyModule.getOKButton().setEnabled(true);

                } else {

                    copyModule.getOKButton().setEnabled(false);

                }

            }
        });
    }

}
