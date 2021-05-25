package cn.nayuguo.jw.model;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录校验
 * @author Tuma_Coder
 * @TableName jw_user_identify
 */
@TableName(value ="jw_user_identify")
@Data
@Builder
public class UserIdentify implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户自己设计的id，不许重复
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 加密后的密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 
     */
    @TableField(value = "update_time",fill=FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}