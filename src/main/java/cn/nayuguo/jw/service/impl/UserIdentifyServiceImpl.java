package cn.nayuguo.jw.service.impl;

import cn.nayuguo.jw.common.exception.HttpException;
import cn.nayuguo.jw.dto.user.UserIdentifyDto;
import cn.nayuguo.jw.token.TokenUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.nayuguo.jw.model.UserIdentify;
import cn.nayuguo.jw.service.UserIdentifyService;
import cn.nayuguo.jw.mapper.UserIdentifyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tuma_Coder
 */
@Service
public class UserIdentifyServiceImpl extends ServiceImpl<UserIdentifyMapper, UserIdentify>
implements UserIdentifyService{

    @Autowired
    private UserIdentifyMapper userIdentifyMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    TokenUtil tokenUtil;
    @Override
    public boolean createUser(UserIdentifyDto userIdentifyDto) {
        int count = userIdentifyMapper.selectCountByUserId(userIdentifyDto.getUserId());
        if(count>0){
            throw new HttpException(10001,"用户已存在");
        }

        UserIdentify userIdentify=UserIdentify.builder()
                .userId(userIdentifyDto.getUserId())
                .password(bCryptPasswordEncoder.encode(userIdentifyDto.getPassword()))
                .build();

        return userIdentifyMapper.insert(userIdentify)>0;
    }

    @Override
    public String login(UserIdentifyDto userIdentifyDto) {
        QueryWrapper<UserIdentify> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserIdentify::getUserId,userIdentifyDto.getUserId());
        UserIdentify userIdentify = userIdentifyMapper.selectOne(queryWrapper);
        if(userIdentify==null){
            throw new HttpException(10002,"用户不存在");
        }

        boolean match = bCryptPasswordEncoder.matches(userIdentifyDto.getPassword(), userIdentify.getPassword());
        if(!match){
            throw new HttpException(10003,"密码不正确");
        }

        return tokenUtil.getToken(userIdentify);
    }
}




