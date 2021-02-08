package pers.common.orgstruct.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@TableName("os_user")
public class User extends Model<User> {
    private Long id;

    private String oid;

    /**
     * 租户Id
     */
    private Long tenantId;

    /**
     * 所属公司id
     */
    private Long companyId;

    /**
     * 用户关联信息
     */
    private Long contactId;

    /**
     * 激活状态
     */
    private Boolean activated;

    /**
     * 创建人
     */
    private Long createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdDate;

    /**
     * 最后修改人
     */
    private Long lastModifiedBy;

    /**
     * 最后修改时间
     */
    private LocalDateTime lastModifiedDate;

    /**
     * 激活时间
     */
    private LocalDateTime activatedDate;

    /**
     * 删除状态
     */
    private Boolean isDeleted;

}