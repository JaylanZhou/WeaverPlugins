package com.weaver.ecodeTools.plugin.generateModule.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.weaver.pluginsTools.JFrameInitTools;
import org.jetbrains.annotations.NotNull;

public class GenerateModuleAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {

        JFrameInitTools.initGenerateModule(anActionEvent);

    }
}
