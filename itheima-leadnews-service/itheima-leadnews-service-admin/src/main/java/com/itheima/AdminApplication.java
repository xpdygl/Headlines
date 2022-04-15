package com.itheima;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//启动类默认情况uxa都会扫描类所在的包和子包，确保要扫描的类和启动类是同级的
//也可以自定义扫描，用@ComponentScan这个注解

@SpringBootApplication
@MapperScan(basePackages = "com.itheima.*.mapper")//这个包下的所有的接口都是交给spring容器管理
@EnableDiscoveryClient//启用注册与发现
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class,args);
    }

    //分页插件 交给spring容器
    //mybatisplus分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
