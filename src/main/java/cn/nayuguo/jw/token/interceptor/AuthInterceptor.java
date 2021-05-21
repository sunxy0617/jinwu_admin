package cn.nayuguo.jw.token.interceptor;


import cn.nayuguo.jw.token.TokenUtil;
import cn.nayuguo.jw.token.annotation.PassLogin;
import cn.nayuguo.jw.token.annotation.RequireLogin;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author Tuma_Coder
 */
@Component
public class AuthInterceptor  implements HandlerInterceptor {
    private final TokenUtil tokenUtil;

    public AuthInterceptor(TokenUtil tokenUtil) {
        this.tokenUtil = tokenUtil;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 不是Controller方法，直接放行
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        String token= request.getHeader("token");
        // 请求中未发现token
        if (token == null||token.length()==0) {
            throw new RuntimeException("请求中发现先有效token");
        }

        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        //开发时测试接口比较方便，直接跳过验证
        if(method.isAnnotationPresent(PassLogin.class)){
            return true;
        }

        if(method.isAnnotationPresent(RequireLogin.class)){
            RequireLogin requireLogin=method.getAnnotation(RequireLogin.class);
            if(!requireLogin.required()){
                return true;
            }
            try {
                boolean state = tokenUtil.decodeToken(token);
            }
            catch (RuntimeException e){
                throw e;
            }
        }
        return true;
    }
}
