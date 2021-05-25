package cn.nayuguo.jw.controller.result;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/** 用于统一封装api返回值
 * @author Rain Sun
 * @param <T> 返回结果的类型
 */
@Data
public class ApiResult<T> {
    @Value("true")
    private boolean state;
    @Value("200")
    private Integer code;

    private String msg;

    private T data;

    public ApiResult(){
        this(null);
    }
    public ApiResult(T data){
        this(true,200,"success",data);
    }
    public ApiResult(boolean state, Integer code, String msg){
        this(state,code, msg,null);
    }
    public ApiResult(boolean state, Integer code, String msg, T data){
        this.state = state;
        this.code = code;
        this.msg = msg;
        this.data=data;
    }
}
