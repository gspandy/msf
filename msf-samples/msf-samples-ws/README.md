# The msf sample ws module #
这个模块是msf框架实现集成`WebService`功能的例子


## 使用说明 ##

1. Maven 依赖中添加：

            <dependency>
                <groupId>cn.com.git.msf</groupId>
                <artifactId>msf-ws-starter</artifactId>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter</artifactId>
            </dependency>

2. 配置属性文件 application.propertiese

            #webservice options
            msf.ws.server.baseAddress = http://localhost:9090/ws/

3. 发布服务类,依赖JAX-WS注解定义接口。
<!--lang:java-->
            @Component
            @WebService(serviceName="UserService")
            public class UserServiceJAXWS {
                @Autowired
                private UserService userService;

                @WebMethod
                public User findUser(@WebParam(name="name")String name){
                    return userService.findUser(name);
                }

                @WebMethod
                public void addUser(String name,String password,List<Address> addressList){
                    userService.addUser(name,password,addressList);
                }
            }
4. 测试WebService WSDL

            http://localhost:9090/ws/UserService?wsdl
