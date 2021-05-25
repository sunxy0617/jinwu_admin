package cn.nayuguo.jw.service;

import cn.nayuguo.jw.dto.user.UserIdentifyDto;
import cn.nayuguo.jw.model.UserIdentify;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 * @author Tuma_Coder
 */
public interface UserIdentifyService extends IService<UserIdentify> {
    /** 创建用户
     * @param userIdentifyDto 用户信息
     * @return 是否成功
     */
    boolean createUser(UserIdentifyDto userIdentifyDto);

    /**
     * 登录
     * @param userIdentifyDto
     * @return token
     */
    String login(UserIdentifyDto userIdentifyDto);
}
