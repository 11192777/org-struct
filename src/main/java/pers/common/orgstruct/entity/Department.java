package pers.common.orgstruct.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

/**
 * os_department
 * @author 
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@TableName("os_department")
public class Department extends Model<Department> {
    private Long id;

    private UUID oid;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门编码
     */
    private String code;

    /**
     * 所属公司Id
     */
    private Long companyId;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 删除状态
     */
    private Boolean isDeleted;

    /**
     * 创建人
     */
    private Long createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdDate;

    /**
     * 最后更新时间
     */
    private LocalDateTime lastModifiedDate;

    /**
     * 修改人
     */
    private Long lastModifiedBy;

    /**
     * 排序字段
     */
    private Integer sequenceNumber;

}