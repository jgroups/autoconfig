# autoconfig
autoconfig使用一套配置模板，为不同的环境生成相应的具体配置。

利用Maven打包,运行命令
```
mvn clean package
```
在target目录下生成一个jar包autoconfig-1.0-SNAPSHOT.jar,运行这个jar包,命令如下:
```
java -jar target/autoconfig-1.0-SNAPSHOT.jar
```

在配置文件的模板 config.properties.vm 中有一个配置变量 ${me_lbing_value} 在执行autoconfig的时候需要被替换，那怎么给这个配置项赋值呢？autoconfig提供了两种方式来给配置变量赋值第一从java属性文件中读取第二是交互式地编辑。autoconfig首先读取当前工作目录的antx.properties文件，如果没有则读取${user.home}/antx.properties文件，如果这个文件也不存在，autoconfig就会启动交互式编辑器请求用户输入配置变量的值，如果配置变量的值是不完整的autoconfig则会立即停止配置并抛出一个异常。如果java属性文件的位置不在autoconfig默认的位置可以通过参数autoconfig.userProperties进行配置。处于简单其间，我们在当前目录新建一个java属性文件antx.properties，这个文件中定义了配置变量${me_lbing_value}的值。antx.properties 文件的内容如下。 

##注: 
1,autoconfig依赖于Maven
2,有人或许会感觉迷惑，在模板文件config.properties.vm中，需要被替换的明明是me_lbing_value，为什么在auto-config.xml文件中会定义属性 me.lbing.value 呢？现在只需要记住属性名中的点在autoconfig执行的时候会被替换成下划线。
