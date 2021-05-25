package cn.nayuguo.jw.common.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

/** 自定义http请求异常类
 * @author Tuma_Coder
 */
@Data
public class HttpException extends RuntimeException {
    private int code;
    private String msg;

    public HttpException() {
        super();
        this.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        this.setMsg(this.getMessage());
    }

    public HttpException(String msg) {
        super(msg);
        this.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        this.setMsg(msg);
    }

    public HttpException(int code) {
        super();
        this.setCode(code);
        this.setMsg(this.getMessage());
    }

    public HttpException(int code, String msg) {
        super(msg);
        this.setCode(code);
        this.setMsg(msg);
    }
}
