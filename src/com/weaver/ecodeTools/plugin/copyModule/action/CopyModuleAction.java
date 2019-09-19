package com.weaver.ecodeTools.plugin.copyModule.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.vfs.VirtualFile;
import com.weaver.ecodeTools.plugin.copyModule.tools.CopyModuleTools;
import com.weaver.pluginsTools.IdeaPluginTools;
import com.weaver.pluginsTools.JFrameInitTools;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class CopyModuleAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {

        JFrameInitTools.initCopyModule(anActionEvent);

    }



    @Override
    public void update(@NotNull AnActionEvent e) {

        VirtualFile virtualFile = IdeaPluginTools.getFileExtension(e.getDataContext());

        String virtualParentFilePath = virtualFile.getParent().getPath();

        int checkLength = virtualParentFilePath.lastIndexOf("app");

        int pathLength = virtualParentFilePath.length();

        boolean checkResult = checkLength + 3 == pathLength;

        e.getPresentation().setEnabledAndVisible(checkResult);

    }


}
