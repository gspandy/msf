# The shiro starter module of msf project #
这个模块是msf框架快速启动shiro功能

## 使用说明 ##

1. Maven 依赖中添加：

            <dependency>
                <groupId>cn.com.git.msf</groupId>
                <artifactId>msf-shiro-starter</artifactId>
            </dependency>

2. 配置属性文件 application.properties

            #shiro options
            msf.shiro.realm = cn.com.git.msf.samples.shiro.MyShiroRealm
            msf.shiro.loginUrl = /login
            msf.shiro.successUrl = /success
            msf.shiro.unauthorizedUrl = /403
            msf.shiro.filterChainDefinitions[/login] = anon
            msf.shiro.filterChainDefinitions[/logout] = logout
            msf.shiro.filterChainDefinitions[/static/**] = anon
            msf.shiro.filterChainDefinitions[/**] = authc

## 示例 ##

见 `msf-samples-shiro` 模块