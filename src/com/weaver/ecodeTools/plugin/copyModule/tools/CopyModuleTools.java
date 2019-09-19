package com.weaver.ecodeTools.plugin.copyModule.tools;

import java.io.*;

public class CopyModuleTools {

    private CopyModuleTools(){



    }

    public static void copyModule(File file, String copyModuleName, String beCopyModuleName) throws Exception {

        File[] files = file.listFiles();

        for (File f : files
        ) {

            if(f.isDirectory()) {

                createDirectory(f,copyModuleName,beCopyModuleName);

            }

            if (f.getName().contains(".java")){

                createJava(f,copyModuleName,beCopyModuleName);

            }

        }

    }

    private static void createDirectory(File f,String copyModuleName,String beCopyModuleName) throws Exception {

        String filePath = f.getPath();

        filePath = filePath.replaceAll(beCopyModuleName, copyModuleName);

        File copyModule = new File(filePath);

        if(!copyModule.getParentFile().exists()){

            copyModule.getParentFile().mkdirs();

        }

        copyModule.mkdirs();

        CopyModuleTools.copyModule(f,copyModuleName,beCopyModuleName);

    }

    private static void createJava(File f,String copyModuleName,String beCopyModuleName) throws Exception {

        Long filelength = f.length();

        byte[] filecontent = new byte[filelength.intValue()];

        FileInputStream in = new FileInputStream(f);

        in.read(filecontent);

        in.close();

        String fileText = new String(filecontent,"UTF-8");

        fileText = fileText.replaceAll(beCopyModuleName,copyModuleName);

        String filePath = f.getPath();

        filePath = filePath.replaceAll(beCopyModuleName, copyModuleName);

        File copyFile = new File(filePath);

        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(copyFile,true)));

        bw.write(fileText);

        bw.close();

    }

}
