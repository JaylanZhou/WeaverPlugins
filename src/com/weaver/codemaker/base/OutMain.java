package com.weaver.codemaker.base;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.weaver.codemaker.plugin.outCustom.gui.OutCustom;
import com.weaver.codemaker.tools.GetTools;
import com.weaver.codemaker.tools.TableTools;
import com.weaver.pluginsTools.IdeaPluginTools;

import java.sql.Connection;

public class OutMain {

    private OutMain(){



    }

    public static void codeMaker(AnActionEvent anActionEvent, OutCustom outCustom){

        try {

            Project project = anActionEvent.getProject();

            VirtualFile virtualFile = IdeaPluginTools.getFileExtension(anActionEvent.getDataContext());

            String virtualFilePath = virtualFile.getPath();

            String basicPath = "/src/main/java/";

            PropertiesComponent propertiesComponent = PropertiesComponent.getInstance(project);

            String outUrl = virtualFilePath;

            String projectNameNoFormat = virtualFilePath.substring(virtualFilePath.lastIndexOf(basicPath) + basicPath.length());

            String projectName = projectNameNoFormat.replaceAll("/",".");

            OutBase.PROJECTNAME = projectName; //项目名

            Connection connection = GetTools.getConnection(propertiesComponent);

            TableTools tableTools = new TableTools();

            tableTools.setTableName(outCustom.getGenerateTableNameValue().getText()); //表名

            tableTools.setModelName(outCustom.getBeanNameValue().getText()); //对应的类名

            tableTools.setColumnToolsList(GetTools.getColumnTools(connection,tableTools,propertiesComponent.getValue("dataBaseName"),propertiesComponent));

            OutModel outModel = new OutModel();

            OutDao outDao = new OutDao();

            OutServiceInte outServiceInte = new OutServiceInte();

            OutServiceImpl outServiceImpl = new OutServiceImpl();

            outModel.outModelCode(tableTools,outUrl);

            outDao.outDaoCode(tableTools,outUrl);

            outServiceInte.outServiceCode(tableTools,outUrl);

            outServiceImpl.outServiceCode(tableTools,outUrl);

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
