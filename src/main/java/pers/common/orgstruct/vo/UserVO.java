package pers.common.orgstruct.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.common.orgstruct.entity.UserInfo;

/**
 * @Author Qingyu
 * @Date 2021/2/10 10:43
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserVO {
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 用户名称
	 */
	private String name;

	/**
	 * 租户id
	 */
	private Long tenantId;

	/**
	 * 用户详细信息
	 */
	private UserInfo userInfo;

}
