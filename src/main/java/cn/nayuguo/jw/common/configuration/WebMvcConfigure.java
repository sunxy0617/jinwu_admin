package cn.nayuguo.jw.common.configuration;

import cn.nayuguo.jw.token.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Tuma_Coder
 */

@Configuration
public class WebMvcConfigure implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(initAuthInterceptor())
                .addPathPatterns("/**");
    }

    @Bean
    public AuthInterceptor initAuthInterceptor(){
        return new AuthInterceptor();
    }
}
