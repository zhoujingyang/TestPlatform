package com.test.platform.server.config;

import com.test.platform.server.bean.FileBean;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by zjy on 17/2/17.
 */

@Configuration
@EnableTransactionManagement
public class FileConfig  implements EnvironmentAware {
    private RelaxedPropertyResolver propertyResolver;

    @Bean(name = "fileBean")
    public FileBean fileBeanFactory(){

        FileBean bean = new FileBean();
        bean.setFilePath(propertyResolver.getProperty("path"));

        return  bean;
    }

    @Override
    public void setEnvironment(Environment environment) {
        propertyResolver = new RelaxedPropertyResolver(environment, "file.");
    }
}
