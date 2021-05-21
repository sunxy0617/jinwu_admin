package cn.nayuguo.jw.token.interceptor;

import cn.nayuguo.jw.controller.result.ApiResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/** 全局请求异常处理
 * @author Tuma_Coder
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApiResult<Object> handleException(Exception e){
        return  new ApiResult<>(false, 401, e.getMessage());
    }
}
