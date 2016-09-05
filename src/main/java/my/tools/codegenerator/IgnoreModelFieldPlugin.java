package my.tools.codegenerator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;
import java.util.Properties;

public class IgnoreModelFieldPlugin extends PluginAdapter {

    private String[] fields;

    public boolean validate(List<String> list) {
        return true;
    }

    public void setProperties(Properties properties) {
        super.setProperties(properties);
        String str = properties.getProperty("ignore", "");
        fields = str.split(",");
    }

    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        for (int i = 0; i < fields.length; i++) {
            String name = fields[i].replaceAll("_", "");
            if (field.getName().equalsIgnoreCase(name)) {
                // 忽略字段生成。
                return false;
            }
        }
        return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        for (int i = 0; i < fields.length; i++) {
            String name = fields[i].replaceAll("_", "");
            if (("set" + name).equalsIgnoreCase(method.getName())) {
                // 忽略setter方法生成。
                return false;
            }
        }
        return super.modelSetterMethodGenerated(method, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        for (int i = 0; i < fields.length; i++) {
            String name = fields[i].replaceAll("_", "");
            if (("get" + name).equalsIgnoreCase(method.getName())) {
                // 忽略getter方法生成。
                return false;
            }
        }
        return super.modelGetterMethodGenerated(method, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }
}
