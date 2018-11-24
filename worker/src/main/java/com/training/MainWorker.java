package com.training;

import com.training.config.WorkerConfig;
import com.training.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class MainWorker {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WorkerConfig.class);

        UserService userService = context.getBean(UserService.class);
        userService.doReport();
    }
}
