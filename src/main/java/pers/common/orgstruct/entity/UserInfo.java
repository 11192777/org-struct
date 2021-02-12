package pers.common.orgstruct.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String oid;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 手机号
     */
    private String phoneNumber;

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
    private Date createdDate;

    /**
     * 创建人
     */
    private Long createdBy;

    /**
     * 最后更新日期
     */
    private Date lastModifiedDate;

    /**
     * 更新人
     */
    private Long lastModifiedBy;

    private static final long serialVersionUID = 1L;
}