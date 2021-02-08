package pers.common.orgstruct.entity;

import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * os_company
 * @author 
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@TableName("os_company")
public class Company extends Model<Company> {
    private Long id;

    private String companyOid;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 创建人
     */
    private Long createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdDate;

    /**
     * 启用状态
     */
    private Boolean isEnabled;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 公司编码
     */
    private String companyCode;

    /**
     * 地址
     */
    private String address;

}