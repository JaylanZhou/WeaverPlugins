package com.weaver.codemaker.base;

import com.weaver.codemaker.tools.baseTools.BaseTools;
import com.weaver.codemaker.tools.TableTools;

import java.io.*;

public class OutBase {

    private final static String BASEURL = System.getProperty("user.dir") + "/codemaker/src/com";

    public static String PROJECTNAME = "";

    private static BufferedWriter BUFFERWRITER;

    private static OutputStreamWriter WRITE;

    static String PACKAGENAME = "";

    static String MODELNAME = "";

    static String FILENAME = "";

    public void write(String content) throws IOException {

        this.BUFFERWRITER.write(content);

        BUFFERWRITER.newLine();

        BUFFERWRITER.newLine();

    }

    public File createFile(TableTools tableTools, String type,String outUrl) throws IOException {

        this.PACKAGENAME = BaseTools.toLowerCaseFirstOne(tableTools.getModelName());

        this.MODELNAME = BaseTools.toUpperCaseFirstOne(tableTools.getModelName());

        if (type.equals("dao")) {

            this.FILENAME = this.MODELNAME + "Dao.java";

        }else if (type.equals("service/impl")){

            this.FILENAME = this.MODELNAME + "ServiceImpl.java";

        }else if (type.equals("service/inte")){

            this.FILENAME = this.MODELNAME + "ServiceInte.java";

        }else{

            this.FILENAME = this.MODELNAME + ".java";

        }

        OutBase outBase = new OutBase();

        File modelFile = new File(outUrl + "/" + PACKAGENAME + "/" + type +"/" + this.FILENAME);

        if(!modelFile.getParentFile().exists()){

            modelFile.getParentFile().mkdirs();

            modelFile.createNewFile();

        }

        return modelFile;

    }

    public void createBufferWrite(File file) throws FileNotFoundException {

        this.WRITE = new OutputStreamWriter(new FileOutputStream(file));

        this.BUFFERWRITER = new BufferedWriter(this.WRITE);

    }

    public void close() throws IOException {

        this.BUFFERWRITER.flush();

        this.BUFFERWRITER.close();

        this.WRITE.close();

    }


}
