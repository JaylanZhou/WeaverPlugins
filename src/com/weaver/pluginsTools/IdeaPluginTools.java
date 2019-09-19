package com.weaver.pluginsTools;

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.vfs.VirtualFile;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IdeaPluginTools {

    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static VirtualFile getFileExtension(DataContext dataContext) {

        VirtualFile file = DataKeys.VIRTUAL_FILE.getData(dataContext);

        return file;

    }

    /**
     *
     * 获取Unix时间戳
     *
     * @return
     */

    public static String getUnixTime() {

        long epoch = System.currentTimeMillis()/1000;

        return String.valueOf(epoch);

    }

    private IdeaPluginTools(){

    }











}
