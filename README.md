# The MSF Project #
这是一个基于Spring Boot的微服务框架

## 安装说明 ##

    mvn clean install

## 使用说明 ##

类似Spring Boot的 starter parent,在项目的主module直接依赖：

    <!-- Inherit defaults from msf -->
    <parent>
        <groupId>cn.com.git.msf</groupId>
        <artifactId>msf</artifactId>
        <version>1.0</version>
    </parent>

