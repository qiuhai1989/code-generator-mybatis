package my.tools.codegenerator;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

public class AddSpringComponentAnnotationPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // 引入注解
        FullyQualifiedJavaType type = new FullyQualifiedJavaType("org.springframework.stereotype.Component");
        interfaze.addImportedType(type);
        // 添加注解
        interfaze.addAnnotation("@Component");
        return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
    }

}
