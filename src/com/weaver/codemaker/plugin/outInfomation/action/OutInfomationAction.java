package com.weaver.codemaker.plugin.outInfomation.action;

import com.intellij.openapi.actionSystem.*;
import com.weaver.pluginsTools.JFrameInitTools;

public class OutInfomationAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        JFrameInitTools.initOutCodeInfo(e);

    }

}
