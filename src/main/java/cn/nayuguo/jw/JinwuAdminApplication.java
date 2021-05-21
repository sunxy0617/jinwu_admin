package cn.nayuguo.jw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Tuma_Coder
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.nayuguo.jw.mapper")
public class JinwuAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(JinwuAdminApplication.class, args);
    }

}
