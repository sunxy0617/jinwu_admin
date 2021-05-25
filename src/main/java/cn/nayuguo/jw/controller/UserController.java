package cn.nayuguo.jw.controller;

import cn.nayuguo.jw.controller.result.ApiResult;
import cn.nayuguo.jw.dto.user.UserIdentifyDto;
import cn.nayuguo.jw.model.UserIdentify;
import cn.nayuguo.jw.model.UserInfo;
import cn.nayuguo.jw.service.UserIdentifyService;
import cn.nayuguo.jw.token.annotation.RequireLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Tuma_Coder
 */

//跨域注解
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserIdentifyService userIdentifyService;

    @PostMapping("/register")
    public ApiResult register(@RequestBody @Validated UserIdentifyDto userIdentifyDto){
        boolean save = userIdentifyService.createUser(userIdentifyDto);
        if(save) {
            return new ApiResult<>(true,200,"注册成功");
        } else {
            return new ApiResult<>(true,401,"注册失败");
        }
    }
    @PostMapping("/login")
    public ApiResult<String> login(@RequestBody @Validated UserIdentifyDto userIdentifyDto){
        String token = userIdentifyService.login(userIdentifyDto);
        return new ApiResult<>(token);
    }

    @RequireLogin
    @GetMapping("/info")
    public ApiResult<UserInfo>getInfo(){
        return new ApiResult<>(true,200,"用户信息");
    }
}
