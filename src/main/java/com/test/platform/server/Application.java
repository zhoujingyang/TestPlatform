package com.test.platform.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by zjy on 17/2/14.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//       SpringApplication.run(Application.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        for (String str : context.getEnvironment().getActiveProfiles()) {
            System.out.println(str);
        }
    }
}
