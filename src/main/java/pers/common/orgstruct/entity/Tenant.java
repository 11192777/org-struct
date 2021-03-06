package pers.common.orgstruct.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * os_tenant
 * @author 
 */
@Data
@TableName("os_tenant")
public class Tenant extends Model<Tenant> {
    private Long id;

    /**
     * 租户名称
     */
    private String name;

    /**
     * 启用状态
     */
    private Boolean isEnabled;

    /**
     * 删除状态
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
     * 最后修改时间
     */
    private Date lastModifiedDate;

    /**
     * 最后修改人
     */
    private Long lastModifiedBy;

}