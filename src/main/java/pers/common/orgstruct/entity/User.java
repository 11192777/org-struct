package pers.common.orgstruct.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * os_user
 * @author 
 */
@Data
@TableName("os_user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends Model<User> {
    private Long id;

    /**
     * 用户oid
     */
    private String oid;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 用户信息表关联
     */
    private Long concatId;

    /**
     * 用户激活状态
     */
    private Boolean isActivated;

    /**
     * 激活时间
     */
    private Date activatedDate;

    /**
     * 启用标记
     */
    private Boolean isEnabled;

    /**
     * 删除标记
     */
    private Boolean isDeleted;

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