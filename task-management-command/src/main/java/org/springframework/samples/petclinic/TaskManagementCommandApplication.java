package org.springframework.samples.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication(proxyBeanMethods = false)
public class TaskManagementCommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagementCommandApplication.class, args);
    }

}
