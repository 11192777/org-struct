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
 * os_company
 * @author 
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@TableName("os_department")
public class Department extends Model<Department> {
    private Long id;

    private String oid;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 公司编码
     */
    private String code;

    /**
     * 公司地址
     */
    private String address;

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