package cn.nayuguo.jw.controller;

import cn.nayuguo.jw.controller.result.ApiResult;
import cn.nayuguo.jw.model.UserIdentify;
import cn.nayuguo.jw.service.UserIdentifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tuma_Coder
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserIdentifyService userIdentifyService;
    @PostMapping("/register")
    public ApiResult register(@RequestBody @Validated UserIdentify userIdentify){
        boolean save = userIdentifyService.save(userIdentify);
        if(save) {
            return new ApiResult<>(true,200,"注册成功");
        } else {
            return new ApiResult<>(true,401,"注册失败");
        }
    }
}
