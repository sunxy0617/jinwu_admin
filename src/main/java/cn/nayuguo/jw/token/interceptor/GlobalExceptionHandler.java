package cn.nayuguo.jw.token.interceptor;

import cn.nayuguo.jw.common.exception.HttpException;
import cn.nayuguo.jw.common.result.ApiResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/** 全局请求异常处理
 * @author Tuma_Coder
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(HttpException.class)
    public ApiResult<String> handleException(HttpException e){

        return  new ApiResult<>(false, e.getCode(), e.getMsg(),e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApiResult<String> handleException(Exception e){

        return  new ApiResult<>(false, 401, e.getMessage(),e.getMessage());
    }
}
