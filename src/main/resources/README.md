# code-generator-mybatis

工作中用到的代码生成器，基于Mybatis官方的代码生成器，额外增加了几个实用的小插件。  
达到任何表结构的修改，只需要直接运行代码生成器即可。

### 功能列表

1. 生成的Model继承`BaseModel`，忽略`BaseMode`中的字段和getter、setter方法（需配置）。
2. 采用覆盖式生成SQL Mapper文件，即生成前删除原来的文件。  
    默认不是覆盖，多次生成，就会导致项目编译出错。
3. 生成Java接口文件时，自动添加Spring注解： `org.springframework.stereotype.Component`。

### 如何使用
1. 修改config.properties，指定包名、生成目录和数据库连接
2. 修改generatorConfig.xml，增加需要生成的表配置。
2. 运行`mvn test`。

### 参考文档
+ [MyBatis Generator (MBG)](https://github.com/mybatis/generator)
+ [MyBatis Generator Quick Start Guide](http://mybatis.github.io/generator/quickstart.html)
+ [Implementing Plugins](http://mybatis.github.io/generator/reference/pluggingIn.html)
