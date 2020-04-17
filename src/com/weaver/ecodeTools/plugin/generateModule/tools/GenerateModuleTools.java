package com.weaver.ecodeTools.plugin.generateModule.tools;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.module.Module;
import com.weaver.pluginsTools.IdeaPluginTools;

import java.io.File;

public class GenerateModuleTools {

    private GenerateModuleTools(){



    }

    public static void generateModuleDirectory(AnActionEvent anActionEvent,String moduleName){

        Module module = anActionEvent.getData(LangDataKeys.MODULE);

        String modulePath = formatModulePath(module);

        buildDirectory(modulePath,moduleName);

    }

    private static String formatModulePath(Module module){

        StringBuilder formatString = new StringBuilder("/").append(module.getName()).append("\\.iml");

        String formatModulePath = module.getModuleFilePath().replaceAll(formatString.toString(),"");

        return formatModulePath;

    }

    private static void buildDirectory(String modulePath,String moduleName){

        StringBuilder generateDirectory = new StringBuilder(modulePath).append("/src/main/java/com/cloudstore/app/").append(moduleName).append("_").append(IdeaPluginTools.getUnixTime());

        File file = new File(generateDirectory.toString());

        if(!file.getParentFile().exists()){

            file.getParentFile().mkdirs();

        }

        if(!file.exists()){

            file.mkdirs();

        }

    }



}
