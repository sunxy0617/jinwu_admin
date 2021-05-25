package cn.nayuguo.jw.token;

import cn.nayuguo.jw.common.exception.HttpException;
import cn.nayuguo.jw.common.util.LocalUser;
import cn.nayuguo.jw.model.UserIdentify;
import cn.nayuguo.jw.service.UserIdentifyService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Tuma_Coder
 *
 */

@Service
public class TokenUtil {

    private final UserIdentifyService userIdentifyService;

    @Autowired
    public TokenUtil(UserIdentifyService userIdentifyService) {
        this.userIdentifyService = userIdentifyService;
    }

    public String getToken(UserIdentify userIdentify){
        return JWT.create().withAudience(userIdentify.getId().toString())
                .sign(Algorithm.HMAC256(userIdentify.getPassword()));
    }

    public boolean decodeToken(String token){
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new HttpException(10101,"token无效");
        }
        UserIdentify userIdentify = userIdentifyService.getById(userId);
        if (userIdentify == null) {
            throw new HttpException(10102,"用户不存在，请重新登录");
        }
        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(userIdentify.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new HttpException(10103,"token无效，请重新登录");
        }
        //设置当前线程用户
        LocalUser.set(userIdentify);
        return true;
    }
}
