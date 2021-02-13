package pers.common.orgstruct.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.modeler.BaseModelMBean;

/**
 * os_phone_token
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("os_phone_token")
public class PhoneToken extends Model<PhoneToken> {
    private Long id;

    /**
     * 验证码
     */
    private String tokenValue;

    /**
     * 验证码有效截止时间
     */
    private LocalDateTime expireTime;

    /**
     * 验证人
     */
    private String toUser;

}