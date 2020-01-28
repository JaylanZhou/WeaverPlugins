package com.weaver.codemaker.base;

import com.weaver.codemaker.tools.baseTools.BaseTools;
import com.weaver.codemaker.tools.ColumnTools;
import com.weaver.codemaker.tools.TableTools;

import java.io.IOException;

public class OutModel extends OutBase{



    public void outModelCode(TableTools tableTools,String outUrl) throws IOException {

        String packageName = BaseTools.toLowerCaseFirstOne(tableTools.getModelName());

        String modelName = BaseTools.toUpperCaseFirstOne(tableTools.getModelName());

        this.createBufferWrite(this.createFile(tableTools,"model",outUrl));

        this.write("package " + this.PROJECTNAME + "." + packageName +  ".model;");

        this.write("import com.weaverboot.frame.model.BaseModel;");

        this.write("public class " + modelName + " extends BaseModel {");

        for (ColumnTools c:tableTools.getColumnToolsList()

             ) {

            this.write("    private String " + c.getColumnName() + ";");

            this.write("    public String get" + BaseTools.toUpperCaseFirstOne(c.getColumnName()) + "() {");

            this.write("        return " + c.getColumnName() + ";");

            this.write("    }");

            this.write("    public void set" + BaseTools.toUpperCaseFirstOne(c.getColumnName()) + "(String " + c.getColumnName() + ") {");

            this.write("        this." + c.getColumnName() + " = " + c.getColumnName() + ";");

            this.write("    }");

        }

        this.write("    @Override");

        this.write("    public String getTableName() {");

        this.write("        return \"" + tableTools.getTableName() + "\";");

        this.write("    }");

        this.write("}");

        this.close();

    }

}
