package com.weaver.codemaker.base;

import b.f.a.S;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.weaver.codemaker.plugin.outCustom.gui.OutCustom;
import com.weaver.codemaker.tools.GetTools;
import com.weaver.codemaker.tools.TableTools;
import com.weaver.codemaker.tools.baseTools.BaseTools;
import com.weaver.pluginsTools.CheckSourceDirectoryTools;
import com.weaver.pluginsTools.IdeaPluginTools;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.sql.Connection;
import java.util.List;

public class OutMain {

    private OutMain(){



    }

    public static void codeMaker(AnActionEvent anActionEvent, OutCustom outCustom){

        try {

            Project project = anActionEvent.getProject();

            VirtualFile virtualFile = IdeaPluginTools.getFileExtension(anActionEvent.getDataContext());

            String virtualFilePath = virtualFile.getPath();

            String basicPath = CheckSourceDirectoryTools.checkIsSourceDirectory(anActionEvent,virtualFilePath);

            PropertiesComponent propertiesComponent = PropertiesComponent.getInstance(project);

            String outUrl = virtualFilePath;

            Connection connection = GetTools.getConnection(propertiesComponent);

            TableTools tableTools = new TableTools();

            tableTools.setTableName(outCustom.getGenerateTableNameValue().getText()); //表名

            tableTools.setModelName(outCustom.getBeanNameValue().getText()); //对应的类名

            tableTools.setColumnToolsList(GetTools.getColumnTools(connection,tableTools,propertiesComponent.getValue("dataBaseName"),propertiesComponent));

            String projectNameNoFormat = virtualFilePath.substring(virtualFilePath.lastIndexOf(basicPath) + basicPath.length());

            String projectName = projectNameNoFormat.replaceAll("/",".");

            OutBase.PROJECTNAME = BaseTools.notNullString(projectName) ? projectName + "." : ""; //项目名

            OutModel outModel = new OutModel();

            OutDao outDao = new OutDao();

            OutServiceInte outServiceInte = new OutServiceInte();

            OutServiceImpl outServiceImpl = new OutServiceImpl();

            outModel.outModelCode(tableTools,outUrl);

            outDao.outDaoCode(tableTools,outUrl);

            outServiceInte.outServiceCode(tableTools,outUrl);

            outServiceImpl.outServiceCode(tableTools,outUrl);

            virtualFile.refresh(false,true);

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
