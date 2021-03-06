package my.tools.codegenerator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;

public class MyCommentGenerator extends DefaultCommentGenerator{

	public MyCommentGenerator() {
	}
	
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
	    if (introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().equals("")) {
	        field.addJavaDocLine("/**");
	        field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
	        addJavadocTag(field, false);
	        field.addJavaDocLine(" */");
	    }
	}
	
}
