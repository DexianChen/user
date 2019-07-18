package cn.com.huaruan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"cn.com.huaruan.mapper", "cn.com.huaruan.service", "cn.com.huaruan.controller"})
public class WebApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class);
    }
}
