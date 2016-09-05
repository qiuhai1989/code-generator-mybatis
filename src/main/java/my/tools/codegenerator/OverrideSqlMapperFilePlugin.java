package my.tools.codegenerator;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Document;

import java.io.File;
import java.util.List;

public class OverrideSqlMapperFilePlugin extends PluginAdapter {

    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        if (introspectedTable != null) {
            String path = getContext().getSqlMapGeneratorConfiguration().getTargetProject();
            String pack = getContext().getSqlMapGeneratorConfiguration().getTargetPackage();
            pack = pack.replaceAll("\\.", "/");
            String name = introspectedTable.getMyBatis3XmlMapperFileName();
            File file = new File(path + File.separator + pack + File.separator + name);
            if (file.exists()) {
                // 删除 SQL Mapper 文件。
                file.delete();
            }
        }
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

}
