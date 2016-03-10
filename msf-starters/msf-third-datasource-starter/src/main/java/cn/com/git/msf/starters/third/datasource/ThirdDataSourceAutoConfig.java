package cn.com.git.msf.starters.third.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


/**
 * @author serj
 * @version 1.0  , 2016/3/4
 */
@Configuration
@EnableConfigurationProperties(ThirdDataSourceProperties.class)
public class ThirdDataSourceAutoConfig implements ImportBeanDefinitionRegistrar {
    private final static Logger logger = LoggerFactory.getLogger(ThirdDataSourceAutoConfig.class);
    @Autowired
    private ThirdDataSourceProperties properties;


    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        GenericBeanDefinition beanDefinition = createBeanDefinition(DriverManagerDataSource.class);
        for (int i = 0; i < properties.getName().size(); i++) {
            beanDefinition.getPropertyValues().addPropertyValue("url", properties.getUrl().get(i));
            beanDefinition.getPropertyValues().addPropertyValue("username", properties.getUsername().get(i));
            beanDefinition.getPropertyValues().addPropertyValue("password", properties.getPassword().get(i));
            beanDefinition.getPropertyValues().addPropertyValue("driverClassName", properties.getDriverClassName().get(i));
            beanDefinitionRegistry.registerBeanDefinition(properties.getName().get(i), beanDefinition);
        }

    }

    private GenericBeanDefinition createBeanDefinition(Class<?> beanClass) {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_NO);
        return beanDefinition;
    }
}
