package cn.nayuguo.jw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author Tuma_Coder
 */

@EnableWebSecurity
@SpringBootApplication
@MapperScan(basePackages = "cn.nayuguo.jw.mapper")
public class JinwuAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(JinwuAdminApplication.class, args);
    }

}
