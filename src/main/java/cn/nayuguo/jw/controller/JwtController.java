package cn.nayuguo.jw.controller;

import cn.nayuguo.jw.common.result.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tuma_Coder
 */
@RestController
public class JwtController {


    @GetMapping("/")
    public ApiResult<String> index(){
        return new ApiResult<String>("index return");
//        String[] arr={"123","456","789"};
//        return new ApiResult(arr);
    }

    public ApiResult<String> login(){
        return null;
    }
}
