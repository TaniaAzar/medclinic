package com.training;

import com.training.config.WorkerConfig;
import com.training.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class MainWorker {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WorkerConfig.class);
//        StateMapper stateMapper = context.getBean(StateMapper.class);
//        SaleMapper  saleMapper  = context.getBean(SaleMapper.class);
//
//        State state = stateMapper.getStateById(1);
//        ProductSale sale = saleMapper.getSale(1);
//
//        List<ProductSale> saleList = saleMapper.getSaleList();
//
//        System.out.println(state);
//        System.out.println(sale);
//
//        saleList.forEach(System.out::println);
//
//        SaleReport report = context.getBean(SaleReport.class);
//        report.doReport();

//        Jedis jedis = new Jedis("localhost", 6379);
//
//        jedis.lpush("queue_name", "value");
//
//        String value = jedis.rpop("queue_name");
//
//        System.out.println(value);

        UserService userService = context.getBean(UserService.class);
        userService.doReport();
    }
}
