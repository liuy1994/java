package spring.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 启动Spring 框架
        System.out.println("Hello World!");
        SpringApplication.run(Application.class, args);
    }
}
