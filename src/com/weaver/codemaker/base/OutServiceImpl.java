package com.weaver.codemaker.base;

import com.weaver.codemaker.tools.baseTools.BaseTools;
import com.weaver.codemaker.tools.TableTools;

import java.io.IOException;

public class OutServiceImpl extends OutBase {

    public void outServiceCode(TableTools tableTools,String outUrl) throws IOException {

        String packageName = BaseTools.toLowerCaseFirstOne(tableTools.getModelName());

        String modelName = BaseTools.toUpperCaseFirstOne(tableTools.getModelName());

        this.createBufferWrite(this.createFile(tableTools,"service/impl",outUrl));

        this.write("package " + this.PROJECTNAME + "." + packageName + ".service.impl;");

        this.write("import " + this.PROJECTNAME + "." + packageName + ".dao." + modelName + "Dao;");

        this.write("import " + this.PROJECTNAME + "." + packageName + ".service.inte." + modelName + "ServiceInte;");

        this.write("import com.weaverboot.frame.dao.BaseCustomDao;");

        this.write("public class " + modelName + "ServiceImpl implements " + modelName + "ServiceInte {");

        this.write("    private BaseCustomDao customDao = new BaseCustomDao();");

        this.write("    private " + modelName + "Dao " + packageName + "Dao = new " + modelName + "Dao();");

        this.write("}");

        this.close();

    }

}
