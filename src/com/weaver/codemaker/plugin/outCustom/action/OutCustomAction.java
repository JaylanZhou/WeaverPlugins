package com.weaver.codemaker.plugin.outCustom.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.vfs.VirtualFile;
import com.weaver.pluginsTools.IdeaPluginTools;
import com.weaver.pluginsTools.JFrameInitTools;
import org.jetbrains.annotations.NotNull;

public class OutCustomAction extends AnAction {


    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {

        JFrameInitTools.initOutCodeCustom(anActionEvent);

    }

    @Override
    public void update(@NotNull AnActionEvent e) {

        VirtualFile virtualFile = IdeaPluginTools.getFileExtension(e.getDataContext());

        String virtualFilePath = virtualFile.getPath();

        if(virtualFilePath.contains("/src/")){

            e.getPresentation().setEnabledAndVisible(true);

        } else {

            e.getPresentation().setEnabledAndVisible(false);

        }

    }
}
