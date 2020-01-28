package com.weaver.codemaker.base;

import com.weaver.codemaker.tools.baseTools.BaseTools;
import com.weaver.codemaker.tools.TableTools;

import java.io.IOException;

public class OutDao extends OutBase {

    public void outDaoCode(TableTools tableTools,String outUrl) throws IOException {

        String packageName = BaseTools.toLowerCaseFirstOne(tableTools.getModelName());

        String modelName = BaseTools.toUpperCaseFirstOne(tableTools.getModelName());

        this.createBufferWrite(this.createFile(tableTools,"dao",outUrl));

        this.write("package " + this.PROJECTNAME + "." + packageName + ".dao;");

        this.write("import " + this.PROJECTNAME + "." + packageName + ".model." + modelName + ";");

        this.write("import com.weaverboot.frame.dao.BaseDao;");

        this.write("public class " + modelName + "Dao extends BaseDao<" + modelName + ">{");

        this.write("}");

        this.close();

    }

}
