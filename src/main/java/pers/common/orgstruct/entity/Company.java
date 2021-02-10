package pers.common.orgstruct.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * os_company
 * @author 
 */
@Data
@TableName("os_company")
public class Company extends Model<Company> {
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