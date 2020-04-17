package com.weaver.codemaker.base;

import com.weaver.codemaker.tools.TableTools;
import com.weaver.codemaker.tools.baseTools.BaseTools;

import java.io.IOException;

public class OutServiceInte extends OutBase {

    public void outServiceCode(TableTools tableTools,String outUrl) throws IOException {

        String packageName = BaseTools.toLowerCaseFirstOne(tableTools.getModelName());

        String modelName = BaseTools.toUpperCaseFirstOne(tableTools.getModelName());

        this.createBufferWrite(this.createFile(tableTools,"service/inte",outUrl));

        this.write("package " + this.PROJECTNAME + packageName + ".service.inte;");

        this.write("public interface " + modelName + "ServiceInte {");

        this.write("}");

        this.close();

    }

}
