package pers.common.orgstruct.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.common.orgstruct.config.typehandler.UUIDTypeHandler;

/**
 * os_user_info
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("os_user_info")
public class UserInfo implements Serializable {
    private Long id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 登陆账号
     */
    private String loginAccount;

    /**
     * 登陆密码
     */
    private String loginPassword;

    /**
     * 创建时间
     */
    private LocalDateTime createdDate;

    /**
     * 创建人
     */
    private Long createdBy;

    /**
     * 最后更新日期
     */
    private LocalDateTime lastModifiedDate;

    /**
     * 更新人
     */
    private Long lastModifiedBy;

    private static final long serialVersionUID = 1L;
}