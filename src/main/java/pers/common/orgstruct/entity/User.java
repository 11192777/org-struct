package pers.common.orgstruct.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.common.orgstruct.config.typehandler.UUIDTypeHandler;

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
    private LocalDateTime activatedDate;

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