package pers.common.orgstruct.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

/**
 *
 * 租户视图
 *
 * @Author Qingyu
 * @Date 2021/2/8 21:14
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TenantVO {

	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 租户名称
	 */
	private String name;

}
