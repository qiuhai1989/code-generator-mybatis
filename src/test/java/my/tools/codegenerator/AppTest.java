package my.tools.codegenerator;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class AppTest {

    @Test
    public void testCodeGenerator(){
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            URI generatorConfigURI = getClass().getClassLoader().getResource("generatorConfig.xml").toURI();

            ConfigurationParser parser = new ConfigurationParser(warnings);
            Configuration config = parser.parseConfiguration(new File(generatorConfigURI));
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator generator = new MyBatisGenerator(config, callback, warnings);
            generator.generate(null);
        }catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

}
