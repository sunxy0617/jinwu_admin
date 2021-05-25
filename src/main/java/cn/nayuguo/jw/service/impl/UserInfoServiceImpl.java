package cn.nayuguo.jw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.nayuguo.jw.model.UserInfo;
import cn.nayuguo.jw.service.UserInfoService;
import cn.nayuguo.jw.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
implements UserInfoService{

}




