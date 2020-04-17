package com.weaver.pluginsTools;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.module.Module;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * @Author : Jaylan Zhou
 * @Date : 2020/4/17 1:36 下午
 * @Version : 1.0
 */
public class CheckSourceDirectoryTools {

    private static final String PREFIX = "$MODULE_DIR$";

    private static final String PATH_SPLIT = "/";

    private CheckSourceDirectoryTools(){


    }

    public static String checkIsSourceDirectory(AnActionEvent anActionEvent,String clickDirectoryPath){

        SAXReader reader = new SAXReader();

        Document document = null;

        Module module = anActionEvent.getData(LangDataKeys.MODULE);

        String moduleFilePath = module.getModuleFilePath();

        clickDirectoryPath = clickDirectoryPath + PATH_SPLIT;

        String modulePath = moduleFilePath.substring(0,moduleFilePath.lastIndexOf(PATH_SPLIT));

        try {

            document = reader.read(new File(moduleFilePath));

            Element root = document.getRootElement();

            List<Node> list = root.selectNodes("//sourceFolder[@isTestSource='false']");

            for (Node node : list
            ) {

                String url = ((Element)node).attributeValue("url");

                String urlFormat = url.substring(url.lastIndexOf(PREFIX) + PREFIX.length());

                String urlComplete = modulePath + urlFormat + PATH_SPLIT;

                if (clickDirectoryPath.contains(urlComplete)){

                    return urlComplete;

                }

            }

            return null;

        } catch (DocumentException e) {

            e.printStackTrace();

            return null;

        }

    }

}
