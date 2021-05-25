package cn.nayuguo.jw.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.nayuguo.jw.model.UserIdentify;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author Tuma_Coder
 * @Entity cn.nayuguo.jw.model.UserIdentify
 */
@Repository
public interface UserIdentifyMapper extends BaseMapper<UserIdentify> {
    /** 返回账户名数量
     * @param userId
     * @return
     */
    int selectCountByUserId(@Param("userId") String userId);
}




